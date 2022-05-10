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

//get data excel
TestData input = findTestData('08. paket data/paket data XL')
for (int baris = 1; baris <= input.getRowNumbers(); baris++) {

	Mobile.comment('Klik Menu Pulsa dan Paket Data')
	Mobile.tap(findTestObject('Object Repository/Menu-OCSDK/Menu - Pulsa dan Paket Data'), 0)
	Mobile.takeScreenshot()
	Mobile.delay(2)
	
	Mobile.comment('Klik TAB Paket Data')
	Mobile.tap(findTestObject('Object Repository/pulsa/Tab - Paket Data'), 0)
	Mobile.takeScreenshot()
	Mobile.delay(2)
	
	Mobile.comment('Cari No. hp')
	Mobile.setText(findTestObject('Object Repository/pulsa/Ecari_nomor'), input.getValue('no_hp', baris), 0)
	Mobile.takeScreenshot()
	Mobile.delay(2)
	
	String str_paketdata = input.getValue('paket_data', baris)
	Mobile.comment('Klik Pilih Paket Data')
	Mobile.tap(findTestObject('pulsa/Pilih List Paket Data XL',[('paket_data'):str_paketdata]), 0)
	Mobile.takeScreenshot()
	Mobile.delay(2)

	Mobile.comment('Klik button lanjutkan')
	Mobile.tap(findTestObject('Object Repository/pulsa/Button - Lanjutkan'), 0)
	Mobile.takeScreenshot()
	Mobile.delay(2)
	
	Mobile.comment('Klik button bayar')
	Mobile.tap(findTestObject('Object Repository/pulsa/Button - Bayar'), 0)
	Mobile.takeScreenshot()
	Mobile.delay(2)
	
	//pisahkan dan masukkan pin
	Mobile.comment('Input PIN')
	String varPIN = GlobalVariable.pin
	String pin1 = varPIN.substring(0, 1).trim()
	String pin2 = varPIN.substring(1, 2).trim()
	String pin3 = varPIN.substring(2, 3).trim()
	String pin4 = varPIN.substring(3, 4).trim()
	String pin5 = varPIN.substring(4, 5).trim()
	String pin6 = varPIN.substring(5, 6).trim()

	Mobile.setText(findTestObject('aktivasi/Epin1'), pin1, 0)
	Mobile.setText(findTestObject('aktivasi/Epin2'), pin2, 0)
	Mobile.setText(findTestObject('aktivasi/Epin3'), pin3, 0)
	Mobile.setText(findTestObject('aktivasi/Epin4'), pin4, 0)
	Mobile.setText(findTestObject('aktivasi/Epin5'), pin5, 0)
	Mobile.takeScreenshot()
	Mobile.delay(2)
	Mobile.setText(findTestObject('aktivasi/Epin6'), pin6, 0)
	Mobile.delay(2)
	
	//cek kondisi jika langsung ke menu utama
	if (Mobile.verifyElementVisible(findTestObject('Object Repository/pulsa/View - detail transaksi'), 10, FailureHandling.OPTIONAL)) {
		Mobile.tap(findTestObject('Object Repository/pulsa/View - detail transaksi'), 0)
		Mobile.takeScreenshot()
		Mobile.delay(2)
	}
	
	Mobile.comment('Kembali ke menu utama')
	Mobile.tap(findTestObject('Object Repository/pulsa/Btn - close'), 0)
	Mobile.delay(2)
	
}





