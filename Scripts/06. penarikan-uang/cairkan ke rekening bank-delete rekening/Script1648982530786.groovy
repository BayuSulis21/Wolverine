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

Mobile.comment('Klik Menu Penarikan Uang')
Mobile.tap(findTestObject('Object Repository/Menu-OCSDK/Menu - Penarikan Uang'), 0)
Mobile.takeScreenshot()
Mobile.delay(2)

Mobile.comment('Klik Menu Cairkan Ke Rekening Bank')
Mobile.tap(findTestObject('Object Repository/Penarikan Uang/Menu - Cairkan ke Rekening Bank'), 0)
Mobile.takeScreenshot()
Mobile.delay(2)

Mobile.comment('Klik Pilih Penerima')
Mobile.tap(findTestObject('Object Repository/Penarikan Uang/Tambah Rekening/Click - Pilih Penerima'), 0)
Mobile.takeScreenshot()
Mobile.delay(2)

Mobile.comment('Hapus Rekening')
Mobile.tap(findTestObject('Object Repository/Penarikan Uang/Hapus Rekening/Button - trash'), 0)
Mobile.takeScreenshot()
Mobile.delay(2)
	
Mobile.comment('Klik Tombol Hapus')
Mobile.tap(findTestObject('Object Repository/Penarikan Uang/Hapus Rekening/Button Pop Up - Hapus'), 0)
Mobile.takeScreenshot()
Mobile.delay(2)
	

Mobile.tap(findTestObject('Button - Back Menu Utama'), 0)
Mobile.delay(2)
Mobile.tap(findTestObject('Button - Back Menu Utama'), 0)
Mobile.delay(2)
Mobile.tap(findTestObject('Button - Back Menu Utama'), 0)
Mobile.delay(2)





