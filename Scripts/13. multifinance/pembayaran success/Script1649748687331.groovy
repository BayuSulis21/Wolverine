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
TestData input = findTestData('13. multifinance/multifinance-success')
for (int baris = 1; baris <= input.getRowNumbers(); baris++) {

	Mobile.comment('Klik Menu Multifinance')
	Mobile.tap(findTestObject('Object Repository/Menu-OCSDK/Menu - Multifinance'), 0)
	Mobile.takeScreenshot()
	Mobile.delay(2)
	
	Mobile.comment('Cari nama MULTIFINANCE')
	// contoh FIF GROUP
	String str_multifinance = input.getValue('multifinance', baris)
	Mobile.tap(findTestObject('multifinance/Pilih Nama Multifinance',[('multifinance'):str_multifinance]), 0)
	Mobile.takeScreenshot()
	Mobile.delay(2)
	
	Mobile.comment('Cari No. Pelanggan')
	Mobile.setText(findTestObject('Object Repository/multifinance/Eno_pelanggan'), input.getValue('no_pelanggan', baris), 0)
	Mobile.takeScreenshot()
	Mobile.delay(2)
	
	Mobile.comment('Klik button Lanjutkan')
	Mobile.tap(findTestObject('Object Repository/multifinance/Button - Lanjutkan'), 0)
	Mobile.takeScreenshot()
	Mobile.delay(2)
	
	if (Mobile.verifyElementAttributeValue(findTestObject('Object Repository/multifinance/message - Tagihan sudah terbayar'),'class','android.widget.TextView', 10)) {
		//if (Mobile.verifyElementVisible(findTestObject('Object Repository/multifinance/message - Tagihan sudah terbayar'), 5, FailureHandling.OPTIONAL)){
			Mobile.comment('Kembali ke menu utama')
			Mobile.tap(findTestObject('Object Repository/Button - Back Menu Utama'), 0)
			Mobile.delay(2)
			Mobile.tap(findTestObject('Object Repository/Button - Back Menu Utama'), 0)
			Mobile.delay(2)
		}
	else {	
	Mobile.comment('Klik button bayar')
	Mobile.tap(findTestObject('Object Repository/multifinance/Button - Bayar'), 0)
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
	if (Mobile.verifyElementVisible(findTestObject('Object Repository/multifinance/View - Transaksi receipt'), 5, FailureHandling.OPTIONAL)) {
		Mobile.tap(findTestObject('Object Repository/multifinance/View - Transaksi receipt'), 0)
		Mobile.takeScreenshot()
		Mobile.delay(2)
	}
	
	Mobile.comment('Kembali ke menu utama')
	Mobile.tap(findTestObject('Object Repository/multifinance/Btn - close'), 0)
	Mobile.delay(2)
	}
	
}





