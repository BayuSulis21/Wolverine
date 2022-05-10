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

Mobile.comment('Click Menu Top Up')
Mobile.tap(findTestObject('Menu-OCSDK/Menu - Top Up'), 0)
Mobile.delay(2)

Mobile.comment("Buka Top Up - Transfer Bank")
Mobile.tap(findTestObject('Top Up/Click - Transfer Bank ATM, i-Banking, m-Banking'), 0)
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Via Internet Banking Mobile Banking'), 0)
Mobile.takeScreenshot()
Mobile.delay(1)
Mobile.tap(findTestObject('Object Repository/Top Up/Click- Via ATM'), 0)
Mobile.takeScreenshot()
Mobile.delay(1)
//back
Mobile.tap(findTestObject('Top Up/Click - Transfer Bank ATM, i-Banking, m-Banking'), 0)
Mobile.delay(1)

Mobile.comment("Buka Top Up - Melalui Transfer Via BCA")
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Melalui Transfer VA BCA ATM, i-Banking, m-Banking'), 0)
Mobile.takeScreenshot()
Mobile.delay(1)
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Via MBCA'), 0)
Mobile.takeScreenshot()
Mobile.delay(1)
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Via MBCA'), 0)
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Via ATM BCA'), 0)
Mobile.takeScreenshot()
Mobile.delay(1)
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Via ATM BCA'), 0)
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Via Klik BCA'), 0)
Mobile.takeScreenshot()
Mobile.delay(1)
//back
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Melalui Transfer VA BCA ATM, i-Banking, m-Banking'), 0)
Mobile.delay(1)

Mobile.comment("Buka Top Up - Melalui Transfer Via BNI")
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Melalui Transfer BNI VA ATM, i-Banking, m-Banking'), 0)
Mobile.takeScreenshot()
Mobile.delay(1)
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Via BNI Mobile'), 0)
Mobile.takeScreenshot()
Mobile.delay(1)
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Via BNI Mobile'), 0)
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Via ATM BNI'), 0)
Mobile.takeScreenshot()
Mobile.delay(1)
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Via ATM BNI'), 0)
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Via Internet Banking BNI'), 0)
Mobile.takeScreenshot()
Mobile.delay(1)
//back
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Melalui Transfer BNI VA ATM, i-Banking, m-Banking'), 0)
Mobile.delay(1)

Mobile.comment("Buka Top Up - Melalui Transfer Bank Mandiri")
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Melalui Transfer Bank Mandiri ATM, i-Banking, m-Banking'), 0)
Mobile.takeScreenshot()
Mobile.delay(1)
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Via ATM Bank Mandiri'), 0)
Mobile.takeScreenshot()
Mobile.delay(1)
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Via ATM Bank Mandiri'), 0)
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Via Mobile Banking Bank Mandiri'), 0)
Mobile.takeScreenshot()
Mobile.delay(1)
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Via Mobile Banking Bank Mandiri'), 0)
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Via Internet Banking Bank Mandiri'), 0)
Mobile.takeScreenshot()
Mobile.delay(1)
//back
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Melalui Transfer Bank Mandiri ATM, i-Banking, m-Banking'), 0)
Mobile.delay(1)


Mobile.comment("Buka Top Up - Melalui Transfer VA CIMB")
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Melalui Transfer VA CIMB ATM, i-Banking, m-Banking'), 0)
Mobile.takeScreenshot()
Mobile.delay(1)
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Melalui ATM CIMB'), 0)
Mobile.takeScreenshot()
Mobile.delay(1)
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Melalui ATM CIMB'), 0)
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Octo Mobile CIMB'), 0)
Mobile.takeScreenshot()
Mobile.delay(1)
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Octo Mobile CIMB'), 0)
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Octo Clicks CIMB'), 0)
Mobile.takeScreenshot()
Mobile.delay(1)
//back
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Melalui Transfer VA CIMB ATM, i-Banking, m-Banking'), 0)
Mobile.delay(1)


Mobile.comment("Buka Top Up - Melalui Transfer BANK BRI")
Mobile.tap(findTestObject('Top Up/Click - Transfer Bank BRI'), 0)
Mobile.takeScreenshot()
Mobile.delay(1)
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Melalui ATM BRI'), 0)
Mobile.takeScreenshot()
Mobile.delay(1)
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Melalui ATM BRI'), 0)
Mobile.tap(findTestObject('Object Repository/Top Up/Click - BRI Internet'), 0)
Mobile.takeScreenshot()
Mobile.delay(1)
Mobile.tap(findTestObject('Object Repository/Top Up/Click - BRI Internet'), 0)
Mobile.tap(findTestObject('Object Repository/Top Up/Click - BRI Mobile'), 0)
Mobile.takeScreenshot()
Mobile.delay(1)
//back
Mobile.tap(findTestObject('Top Up/Click - Transfer Bank BRI'), 0)
Mobile.delay(1)


Mobile.comment("Buka Top Up - Melalui Alfamart")
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Melalui Alfamart'), 0)
Mobile.takeScreenshot()
Mobile.delay(1)
Mobile.tap(findTestObject('Object Repository/Top Up/Click - Alfamart'), 0)
Mobile.takeScreenshot()
Mobile.delay(1)

Mobile.comment("Kembali ke Menu Utama")
Mobile.tap(findTestObject('Button - Back Menu Utama'), 0)
Mobile.delay(1)