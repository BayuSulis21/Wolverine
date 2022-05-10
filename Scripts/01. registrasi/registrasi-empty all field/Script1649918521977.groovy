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
import groovy.json.JsonSlurper as JsonSlurper

Mobile.comment('Isi nama sesuai KTP')
Mobile.setText(findTestObject('Registrasi/Enama'), GlobalVariable.nama_empty, 0)
Mobile.takeScreenshot()
//Mobile.takeScreenshot('Reports//Registrasi//regis1.png')
Mobile.delay(2)

Mobile.comment('Isi email')
Mobile.setText(findTestObject('Registrasi/Eemail'), GlobalVariable.email_empty, 0)
Mobile.takeScreenshot()
//Mobile.takeScreenshot('Reports//Registrasi//regis2.png')
Mobile.delay(2)

Mobile.comment('Checklist persetujuan')
Mobile.tap(findTestObject('Registrasi/check_setuju_daftar'), 0)
Mobile.takeScreenshot()
//Mobile.takeScreenshot('Reports//Registrasi//regis3.png')
Mobile.delay(2)

Mobile.comment('Klik Daftarkan')
Mobile.tap(findTestObject('Registrasi/Daftarkan'), 0)
Mobile.takeScreenshot()
//Mobile.takeScreenshot('Reports//Registrasi//regis4.png')
Mobile.delay(2)

if ( (Mobile.verifyElementAttributeValue(findTestObject('Object Repository/Registrasi/Message - Nama Sesuai KTP harus diisi'),'class','android.widget.TextView', 5)) &&
	(Mobile.verifyElementAttributeValue(findTestObject('Object Repository/Registrasi/Message - Email Aktif harus diisi'),'class','android.widget.TextView', 5)) )
	{
		Mobile.comment('Wajib mengisi Nama & Email')
	}




