import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.builtin.VerifyElementTextKeyword
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.thoughtworks.selenium.webdriven.commands.RemoveAllSelections
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
//untuk test service api
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.RestRequestObjectBuilder
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import groovy.json.JsonSlurper
//untuk Signature Data using HMAC-SHA256 method with secret key
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Signature

import org.apache.commons.codec.binary.Base64;
 
//PEMBAYARAN
	RequestObject Inquiry=findTestObject('Object Repository/Secure page/Inquiry')
	
	//set secretkey
	String secretKey=GlobalVariable.secretKey_MOAJA
	
	//set httpheader
	String Timestamp = GlobalVariable.Timestamp
	String AppsID = GlobalVariable.AppsID
	String Signature = ""
	String requestMethod = GlobalVariable.requestMethod
	String authHeader = GlobalVariable.authHeader
	
	//set httpbody
	String merchantId=GlobalVariable.merchantId
	String merchantName=GlobalVariable.merchantName
	String phoneNumber=GlobalVariable.hp
	String amount=25000
	GlobalVariable.amount_securepage=amount
	//random trxID
	String trxID="AA1610000"+Math.abs(new Random().nextInt() % 999999)
	System.out.println(trxID)
	String merchantURL=GlobalVariable.merchantURL
	String successURL=GlobalVariable.successURL
	String failedURL=GlobalVariable.failedURL
	
	String jsonbody = '{"merchantId": "'+merchantId+'","merchantName": "'+merchantName+'","phoneNumber": "'+phoneNumber+'","trxId": "'+trxID+'","amount": '+amount+',"merchantURL": "'+merchantURL+'","successURL": "'+successURL+'","failedURL": "'+failedURL+'"}'
	String jsonbody_replace = '{merchantId:'+merchantId.replaceAll(";","")+',merchantName:'+merchantName.replaceAll("\\s","")+',phoneNumber:'+phoneNumber+',trxId:'+trxID+',amount:'+amount+',merchantURL:'+merchantURL.replaceAll("/","").replaceAll("-","")+',successURL:'+successURL.replaceAll("/","").replaceAll("-","")+',failedURL:'+failedURL.replaceAll("/","").replaceAll("-","")+'}'
	String jsonbody_uppercase= jsonbody_replace.toUpperCase()
	String TextHash=jsonbody_uppercase+":"+Timestamp
	System.out.println(TextHash)
	WebUI.comment(TextHash.toString())
	
	//function Signature Data using HMAC-SHA256 method with secret key
	def hmac_sha256(String secretKey, String data) {
		try {
		   Mac mac = Mac.getInstance("HmacSHA256")
		   SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), "HmacSHA256")
		   mac.init(secretKeySpec)
		   byte[] digest = mac.doFinal(data.getBytes())
		   return digest
		  } catch (InvalidKeyException e) {
		   throw new RuntimeException("Invalid key exception while converting to HMac SHA256")
		 }
	   }
	   
	def hash = hmac_sha256(secretKey, TextHash)
	Signature = Base64.encodeBase64String(hash);
	System.out.println(Signature);
	WebUI.comment(Signature.toString())
	   
	Inquiry.setBodyContent(new HttpTextBodyContent(jsonbody, "UTF-8", "application/json"))
	
	//set httpheader
	ArrayList HTTPHeader = new ArrayList()	
	HTTPHeader.add(new TestObjectProperty('Content-Type', ConditionType.EQUALS,'application/json'))
	HTTPHeader.add(new TestObjectProperty('Timestamp', ConditionType.EQUALS,Timestamp))
	HTTPHeader.add(new TestObjectProperty('Apps-ID', ConditionType.EQUALS,AppsID))
	HTTPHeader.add(new TestObjectProperty('Signature', ConditionType.EQUALS,Signature))
	HTTPHeader.add(new TestObjectProperty('Authorization', ConditionType.EQUALS,authHeader))
	Inquiry.setHttpHeaderProperties(HTTPHeader)
	
	def responseObj = WS.sendRequest(Inquiry)
	if (WS.verifyResponseStatusCode(responseObj, 200)==true)
	{
	 System.out.println('Inquiry Success')
	 
	 JsonSlurper slurper = new JsonSlurper()
	 Map parsedJson = slurper.parseText(responseObj.getResponseText())
	 System.out.println(parsedJson)
	 WebUI.comment(parsedJson.toString())
	 
	 //ambil link secure page
	 String referenceNumber = parsedJson.get("referenceNumber")
	 String link = parsedJson.get("securePage")
	 System.out.println(referenceNumber)
	 GlobalVariable.referenceNumber=referenceNumber
	 System.out.println(GlobalVariable.referenceNumber)
	 System.out.println(link)
	
	//Test Automatic 		
	WebUI.openBrowser(link)
	WebUI.maximizeWindow()
	WebUI.delay(2)
	WebUI.takeScreenshot()
	WebUI.scrollToElement(findTestObject('Object Repository/Secure page/div_LANJUTKAN'),0)
	WebUI.click(findTestObject('Object Repository/Secure page/div_LANJUTKAN'))
	WebUI.delay(2)
	WebUI.setText(findTestObject('Secure page/Epin1'), '999999')
	
	if (WebUI.verifyElementVisible(findTestObject('Object Repository/Secure page/Notification - PIN Tidak Valid')))
		{	
			WebUI.takeScreenshot()
			WebUI.delay(3)
			WebUI.closeBrowser()
		}
	
	}else {
	 System.out.println('Inquiry Gagal')
	}
	

