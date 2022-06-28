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
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

WebUI.openBrowser('')

WebUI.navigateToUrl('https://phoenix-imkas.ottodigital.id/portal-imkas/login')

WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/IMKas Portal/input_Email or Username_email'), 'felix.pikatan@ottodigital.id')

WebUI.setEncryptedText(findTestObject('Object Repository/IMKas Portal/input_Password_password'), 'TqRBV6bP9Rw=')

WebUI.click(findTestObject('Object Repository/IMKas Portal/button_Sign in'))

WebUI.click(findTestObject('Object Repository/IMKas Portal/span_Promo Campaign'))

WebUI.click(findTestObject('Object Repository/IMKas Portal/p_Add new data'))

def filePath = RunConfiguration.getProjectDir() + '/tampilkan_gambar.jpeg'
WebUI.uploadFileWithDragAndDrop(findTestObject('Object Repository/IMKas Portal/div_Drop your image here or browseSupport JPG, JPEG, and PNG'),filePath)

def filePath_csv = RunConfiguration.getProjectDir() + '/contoh_upload_doc.csv'
WebUI.uploadFile(findTestObject('Object Repository/IMKas Portal/input_file_doc'), filePath_csv)

WebUI.scrollToElement(findTestObject('Object Repository/IMKas Portal/input_Title_title'), 5)
WebUI.setText(findTestObject('Object Repository/IMKas Portal/input_Title_title'), 'Testing Automation Bisa Ngga Nih yaaa')

WebUI.setText(findTestObject('Object Repository/IMKas Portal/textarea_Testing Automation'), 'Testing Automation Success Cuy')

// Pilih Jam 1
WebUI.click(findTestObject('Object Repository/IMKas Portal/select_waktu'))
String jam="10"
WebUI.click(findTestObject('Object Repository/IMKas Portal/select_waktu_jam', [('jam') :jam] ))
String menit="44"
WebUI.click(findTestObject('Object Repository/IMKas Portal/select_waktu_menit', [('menit') :menit] ))

WebUI.click(findTestObject('Object Repository/IMKas Portal/tutup_select'))

// Pilih Jam 2
WebUI.click(findTestObject('Object Repository/IMKas Portal/select_waktu1'))
String jam1="21"
WebUI.click(findTestObject('Object Repository/IMKas Portal/select_waktu_jam1', [('jam1') :jam1] ))
String menit1="30"
WebUI.click(findTestObject('Object Repository/IMKas Portal/select_waktu_menit1', [('menit1') :menit1] ))

WebUI.click(findTestObject('Object Repository/IMKas Portal/tutup_select2'))

// Pilih Tanggal
String bulan="July"
WebUI.click(findTestObject('Object Repository/IMKas Portal/select_bulan', [('bulan') :bulan] ))
String tahun="2022"
WebUI.click(findTestObject('Object Repository/IMKas Portal/select_tahun', [('tahun') :tahun] ))

String start_date="10"
String end_date="19"
WebUI.click(findTestObject('Object Repository/IMKas Portal/start_date', [('start_date') :start_date] ))
WebUI.click(findTestObject('Object Repository/IMKas Portal/end_date', [('end_date') :end_date] ))

WebUI.click(findTestObject('Object Repository/IMKas Portal/button_Submit'))

WebUI.delay(10)
WebUI.closeBrowser()

