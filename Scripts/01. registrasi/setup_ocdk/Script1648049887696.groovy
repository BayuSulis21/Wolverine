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
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

Mobile.startApplication('/Users/bayusulistyo/Downloads/'+GlobalVariable.apk, true)


Mobile.comment('Set Link Otto Cash')
Mobile.setText(findTestObject('Setup/EUrl'), GlobalVariable.baseUrl, 0)
Mobile.delay(1)

Mobile.comment('Set Hp Customer')
Mobile.setText(findTestObject('Setup/EPhone'), GlobalVariable.hp, 0)
Mobile.delay(1)

//get cliendID & secretID
String appID=GlobalVariable.app_id
String ClientID=""
String SecretID=""
switch (appID) {
	case 'BOGASARI':
		 ClientID=GlobalVariable.ClientID_BOGASARI
		 SecretID=GlobalVariable.SecretID_BOGASARI
	break
	case 'INDOLIFE':
		 ClientID=GlobalVariable.ClientID_INDOLIFE
		 SecretID=GlobalVariable.SecretID_INDOLIFE
	break
	case 'JOB2GO':
		 ClientID=GlobalVariable.ClienID_JOB2GO
		 SecretID=GlobalVariable.SecretID_JOB2GO
	break
	case 'OTTOSTAMP':
		 ClientID=GlobalVariable.ClientID_OTTOSTAMP
		 SecretID=GlobalVariable.SecretID_OTTOSTAMP
	break
	case 'MOAJA':
		 ClientID=GlobalVariable.ClientID_MOAJA
		 SecretID=GlobalVariable.SecretID_MOAJA
	break
	case 'PARANJE':
		 ClientID=GlobalVariable.ClientID_PARANJE
		 SecretID=GlobalVariable.SecretID_PARANJE
	break
default:
	break
}

Mobile.comment('Set AppID')
Mobile.setText(findTestObject('Setup/EappID'), appID, 0)
Mobile.delay(1)

Mobile.comment('Set ClientID')
Mobile.setText(findTestObject('Setup/EClientID'), ClientID, 0)
Mobile.delay(1)

Mobile.comment('Set SecretID')
Mobile.setText(findTestObject('Setup/EClientSecret'), SecretID, 0)
Mobile.delay(1)

Mobile.comment('Save Setup')
Mobile.tap(findTestObject('Setup/SaveSetup'), 0)
Mobile.takeScreenshot()
//Mobile.takeScreenshot('Reports//Setup//setup3.png')
Mobile.delay(1)



