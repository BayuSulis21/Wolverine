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

for (int baris = 1; baris <= 10; baris++) {
	WebUI.openBrowser(GlobalVariable.url_CIMBcashout+'/?subAccountNo='+GlobalVariable.hp+'&appName='+GlobalVariable.appName+'#/amount')
	WebUI.maximizeWindow()
	WebUI.delay(2)
	WebUI.takeScreenshot()
	
	WebUI.click(findTestObject('Object Repository/CIMB cashout/select_Pilih Penerima'))
	WebUI.click(findTestObject('Object Repository/CIMB cashout/select-beneficiary'))
	WebUI.takeScreenshot()
	WebUI.delay(2)
	
	WebUI.setText(findTestObject('Object Repository/CIMB cashout/input_amount'), '1000'+baris)
	WebUI.takeScreenshot()
	WebUI.delay(2)
	
	WebUI.click(findTestObject('Object Repository/CIMB cashout/button_Lanjutkan'))
	WebUI.takeScreenshot()
	WebUI.delay(2)
	
	WebUI.click(findTestObject('Object Repository/CIMB cashout/button_Kirim'))
	WebUI.takeScreenshot()
	WebUI.delay(2)
	
	WebUI.setText(findTestObject('Object Repository/CIMB cashout/input_PIN_o'), '191164')
	WebUI.takeScreenshot()
	WebUI.delay(2)
	
	WebUI.click(findTestObject('Object Repository/CIMB cashout/button_Lihat Bukti Bayar'))
	WebUI.takeScreenshot()
	WebUI.delay(2)
	
	WebUI.click(findTestObject('Object Repository/CIMB cashout/button_close'))
	WebUI.takeScreenshot()
	WebUI.delay(2)
	
	WebUI.click(findTestObject('Object Repository/CIMB cashout/button_Tutup'))
	WebUI.takeScreenshot()
	WebUI.delay(2)
	
	WebUI.closeBrowser()
}
