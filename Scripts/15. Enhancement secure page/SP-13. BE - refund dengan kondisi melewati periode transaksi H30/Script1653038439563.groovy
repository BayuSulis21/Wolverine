import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
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

	RequestObject Refund=findTestObject('Object Repository/Secure page/refund')
	
	//set secretkey
	String secretKey=GlobalVariable.secretKey_MOAJA
	
	//set httpheader
	String Timestamp = GlobalVariable.Timestamp
	String AppsID = GlobalVariable.AppsID
	String Signature_refund = ""
	String authHeader = GlobalVariable.authHeader
	
	//set httpbody
	String phoneNumber='081300031125'
	String referenceNumber='C31400002038'
	String partnerRefundId='RF'+Math.abs(new Random().nextInt() % 9999)
	String amount=5000
	
	String jsonbody_refund = '{"phoneNumber": "'+phoneNumber+'","referenceNumber": "'+referenceNumber+'","partnerRefundId": "'+partnerRefundId+'","amount": '+amount+'}'
	WebUI.comment(jsonbody_refund)
	String jsonbody_replace_refund = '{phoneNumber:'+phoneNumber+',referenceNumber:'+referenceNumber+',partnerRefundId:'+partnerRefundId+',amount:'+amount+'}'
	String jsonbody_uppercase_refund= jsonbody_replace_refund.toUpperCase()
	String TextHash_refund=jsonbody_uppercase_refund+":"+Timestamp
	System.out.println(TextHash_refund)
	
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
	   
	def hash_refund = hmac_sha256(secretKey, TextHash_refund)
	Signature_refund = Base64.encodeBase64String(hash_refund);
	System.out.println(Signature_refund)
	WebUI.comment(Signature_refund.toString())
	   
	Refund.setBodyContent(new HttpTextBodyContent(jsonbody_refund, "UTF-8", "application/json"))
	//set httpheader
	ArrayList HTTPHeader = new ArrayList()	
	HTTPHeader.add(new TestObjectProperty('Content-Type', ConditionType.EQUALS,'application/json'))
	HTTPHeader.add(new TestObjectProperty('Timestamp', ConditionType.EQUALS,Timestamp))
	HTTPHeader.add(new TestObjectProperty('Apps-ID', ConditionType.EQUALS,AppsID))
	HTTPHeader.add(new TestObjectProperty('Signature', ConditionType.EQUALS,Signature_refund))
	HTTPHeader.add(new TestObjectProperty('Authorization', ConditionType.EQUALS,authHeader))
	Refund.setHttpHeaderProperties(HTTPHeader)
	
	def responseObj = WS.sendRequest(Refund)
	WS.verifyResponseStatusCode(responseObj, 200)
	JsonSlurper slurper = new JsonSlurper()
	Map parsedJson = slurper.parseText(responseObj.getResponseText())
	WebUI.comment(parsedJson.toString())
	

