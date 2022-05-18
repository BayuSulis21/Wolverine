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
 
	String phoneNumber=''
	String startDate='2022-04-27'
	String endDate='2022-04-29'
	String appsID=''
	String partnerRefundId=''
	String refferenceNumber=''
	String status=''
	String MerchantName='BAYU'
	
	WebUI.comment('parameter: '+'\n'+'phoneNumber: '+phoneNumber+'\n'+'Periode: ' + startDate+' s/d '+endDate+'\n'+'appsID: '+appsID+'\n'+'partnerRefundId: '+partnerRefundId+'\n'+'refferenceNumber: '+refferenceNumber+'\n'+'status: '+status+'\n'+'MerchantName: '+MerchantName)
	
	RequestObject RefundDetail=findTestObject('Object Repository/secure page-optima/RefundDetail',[('phoneNumber'): phoneNumber,('startdate'): startDate,('enddate'): endDate,('AppID'): appsID,('partnerRefundID'): partnerRefundId,('reffNo'): refferenceNumber,('status'): status,('merchantName'): MerchantName])
	
	def responseObj = WS.sendRequest(RefundDetail)
	WS.verifyResponseStatusCode(responseObj, 200)
	WS.verifyElementPropertyValue(responseObj, 'status', "SUCCESS")
	responseCode = responseObj.getStatusCode()
	JsonSlurper slurper = new JsonSlurper()
	Map parsedJson = slurper.parseText(responseObj.getResponseText())
	
	WebUI.comment('response Code: ' + responseCode)
	WebUI.comment(parsedJson.toString())
	

