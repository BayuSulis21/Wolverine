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

 
	String location_id=1
	String code="GR9999"
	String payment_type="payment-channel"
	String refnum="BAYU1001"
	String issuer="ottocash"
	String issued_at="2022-06-15 09:00:00"
	String posted_at="2022-06-15 09:00:00"
	String amount="2500,00"
	RequestObject Payment=findTestObject('Object Repository/Retribusi - Globalindo/Payment by Location ID', [('location_id') :location_id])
	
	WS.callTestCase(findTestCase('16. Retribusi - Globalindo/RE-33. BE-Run API Authorization get access_token'), null)
	
	//set httpheader
	String Authorization = "Bearer "+GlobalVariable.access_token
	
	String jsonbody = '{"code": "'+code+'","payment_type": "'+payment_type+'","refnum": "'+refnum+'","issuer": "'+issuer+'","issued_at": "'+issued_at+'","posted_at": "'+posted_at+'","amount": "'+amount+'"}'
	WebUI.comment(jsonbody)
	
	//post httpbody
	Payment.setBodyContent(new HttpTextBodyContent(jsonbody, "UTF-8", "application/json"))
	//post httpheader
	ArrayList HTTPHeader = new ArrayList()
	HTTPHeader.add(new TestObjectProperty('Content-Type', ConditionType.EQUALS,'application/json'))
	HTTPHeader.add(new TestObjectProperty('Authorization', ConditionType.EQUALS,Authorization))
	Payment.setHttpHeaderProperties(HTTPHeader)
	
	def responseObj = WS.sendRequest(Payment)
	WS.verifyResponseStatusCode(responseObj, 400)
	JsonSlurper slurper = new JsonSlurper()
	Map parsedJson = slurper.parseText(responseObj.getResponseText())
	WebUI.comment(parsedJson.toString())
