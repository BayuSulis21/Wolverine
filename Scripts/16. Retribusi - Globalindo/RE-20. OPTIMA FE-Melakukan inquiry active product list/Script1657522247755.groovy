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

WebUI.openBrowser(GlobalVariable.url_Optima)
WebUI.maximizeWindow()
WebUI.delay(2)
WebUI.takeScreenshot()

WebUI.setText(findTestObject('Object Repository/secure page-optima/input_Username_email'), 'admin@ottodigital.id')
WebUI.delay(2)
WebUI.setText(findTestObject('Object Repository/secure page-optima/input_Password_password'), 'admin')
WebUI.takeScreenshot()
WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/secure page-optima/input_Password_submit'))
WebUI.takeScreenshot()
WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/optima/optima-dashboard/menu_Biller Management'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/optima/optima-dashboard/menu_sub_Active Product List'))
WebUI.takeScreenshot()
WebUI.delay(3)

WebUI.selectOptionByValue(findTestObject('Object Repository/optima/optima-dashboard/select_aggregator'), GlobalVariable.appID_retribusi, false)
WebUI.delay(1)

WebUI.click(findTestObject('Object Repository/optima/optima-dashboard/button_Search'))
WebUI.takeScreenshot()
WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/optima/optima-dashboard/select_inquiry'))
WebUI.takeScreenshot()
WebUI.delay(3)

WebUI.closeBrowser()


