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
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL
import java.security.InvalidKeyException;
import java.security.Signature

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
 
	RequestObject Inquiry=findTestObject('Object Repository/Secure page/callback')
	
	//set httpheader
	String Timestamp = GlobalVariable.Timestamp
	String AppsID = GlobalVariable.AppsID
	String Signature = ""
	String requestMethod = GlobalVariable.requestMethod
	String authHeader = GlobalVariable.authHeader
	
	//set httpbody
	String trxRef="MOBAYU100003500077"
	String issuer="OTTOCASH"
	String issuerRefNo="C50600000012"
	String responseCode="00"
	String responseDescription="success"
	
	String jsonbody = '{"issuer": "'+issuer+'","issuerRefNo": "'+issuerRefNo+'","responseCode": "'+responseCode+'","responseDescription": "'+responseDescription+'","trxRef": "'+trxRef+'"}'
	WebUI.comment(jsonbody)
	String jsonbody_replace = '{issuer:'+issuer+',issuerRefNo:'+issuerRefNo+',responseCode:'+responseCode+',responseDescription:'+responseDescription+',trxRef:'+trxRef+'}'
	String jsonbody_lowercase= jsonbody_replace.toLowerCase()
	String TextHash=jsonbody_lowercase+"&"+Timestamp+"&"+GlobalVariable.Api_Key
	System.out.println(TextHash)
	
	//function Signature Data using HMAC-SHA256 method with secret key
	def hmac_sha512(String ApiKey, String data) {
		try {
		   Mac mac = Mac.getInstance("HmacSHA512")
		   SecretKeySpec ApiKeySpec = new SecretKeySpec(ApiKey.getBytes(), "HmacSHA512")
		   mac.init(ApiKeySpec)
		   byte[] digest = mac.doFinal(data.getBytes())
		   return digest
		  } catch (InvalidKeyException e) {
		   throw new RuntimeException("Invalid key exception while converting to HMac HmacSHA512")
		 }
	   }
	   
	def hash = hmac_sha512(GlobalVariable.Api_Key, TextHash)
	Signature = Hex.encodeHexString(hash);
	System.out.println(Signature)
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
	WS.verifyResponseStatusCode(responseObj, 200)
	JsonSlurper slurper = new JsonSlurper()
	Map parsedJson = slurper.parseText(responseObj.getResponseText())
	WebUI.comment(parsedJson.toString())

