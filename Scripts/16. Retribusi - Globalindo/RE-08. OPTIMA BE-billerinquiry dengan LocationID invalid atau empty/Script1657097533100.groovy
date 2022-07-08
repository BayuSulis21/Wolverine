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
import groovy.json.JsonSlurper
import groovy.json.JsonOutput
//untuk Signature Data using HMAC-SHA256 method with secret key
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL

import java.security.InvalidKeyException;
import java.security.Signature
import org.apache.commons.codec.binary.Base64;

import com.kms.katalon.core.testobject.impl.HttpTextBodyContent //for text in body
import com.kms.katalon.core.testobject.impl.HttpFileBodyContent //for file in body
import com.kms.katalon.core.testobject.impl.HttpFormDataBodyContent //for form data body
import com.kms.katalon.core.testobject.impl.HttpUrlEncodedBodyContent //for URL encoded text body

	

	//Get Signature
	WS.callTestCase(findTestCase('16. Retribusi - Globalindo/RE-02. OPTIMA BE-generate signature type RETRIBUSI'), null)
	
	RequestObject billerInquiry=findTestObject('Object Repository/optima/billerInquiry')
		
	//set httpheader
	String appName = GlobalVariable.appID_retribusi
	String dateTimeRequest = GlobalVariable.datetime_retribusi
	
	//set httpbody
	String userApiKey=GlobalVariable.userApiKey_retribusi
	WebUI.comment(userApiKey)
	String type="RETRIBUSI"
	String productName="RETRIBUSI GLOBALINDO"
	String customerId=GlobalVariable.customerID_retribusi
	String locationId=10
	String signature_retribusi=GlobalVariable.signature_retribusi
	WebUI.comment(signature_retribusi)
	
	String jsonbody = '{"userApiKey": "'+userApiKey+
					  '","type": "'+type+
					  '","productName": "'+productName+
					  '","customerId": "'+customerId+
					  '","locationId": '+locationId+
					  '}'
	WebUI.comment(jsonbody)
	
	//post httpbody
	billerInquiry.setBodyContent(new HttpTextBodyContent(jsonbody, "UTF-8", "application/json"))
	//post httpheader
	ArrayList HTTPHeader = new ArrayList()
	HTTPHeader.add(new TestObjectProperty('Content-Type', ConditionType.EQUALS,'application/json'))
	HTTPHeader.add(new TestObjectProperty('appName', ConditionType.EQUALS,appName))
	HTTPHeader.add(new TestObjectProperty('dateTimeRequest', ConditionType.EQUALS,dateTimeRequest))
	HTTPHeader.add(new TestObjectProperty('signature', ConditionType.EQUALS,signature_retribusi))
	billerInquiry.setHttpHeaderProperties(HTTPHeader)
	
	def responseObj = WS.sendRequest(billerInquiry)
	WS.verifyResponseStatusCode(responseObj, 200)
	JsonSlurper slurper = new JsonSlurper()
	Map parsedJson = slurper.parseText(responseObj.getResponseText())
	WebUI.comment(parsedJson.toString())
	
	
