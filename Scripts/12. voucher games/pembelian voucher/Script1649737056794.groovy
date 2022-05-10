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
TestData input = findTestData('12. voucher games/pembelian-voucher')
for (int baris = 1; baris <= input.getRowNumbers(); baris++) {

	Mobile.comment('Klik Menu Voucher Games')
	Mobile.tap(findTestObject('Object Repository/Menu-OCSDK/Menu - Voucher Games 2'), 0)
	Mobile.takeScreenshot()
	Mobile.delay(2)
	
	Mobile.comment('Pilih Games')
	String str_games = input.getValue('games', baris)
	Mobile.tap(findTestObject('voucher-games/Pilih - Games',[('games'):str_games]), 0)
	Mobile.takeScreenshot()
	Mobile.delay(2)
	
	Mobile.comment('Input customerID')
	Mobile.setText(findTestObject('voucher-games/Eno_ID'), input.getValue('customerID', baris), 0)
	Mobile.takeScreenshot()
	Mobile.delay(2)
	
	//cek kondisi jika tidak ada inputan serverID
	if (Mobile.verifyElementVisible(findTestObject('voucher-games/EServer_ID'), 5, FailureHandling.OPTIONAL)) {
		Mobile.comment('Input serverID')
		Mobile.setText(findTestObject('voucher-games/EServer_ID'), input.getValue('serverID', baris), 0)
		Mobile.takeScreenshot()
		Mobile.delay(2)
	}
	
	Mobile.comment('Klik Pilih Diamond')
	String str_diamonds = input.getValue('diamond', baris)
	Mobile.tap(findTestObject('voucher-games/List-Diamonds',[('diamond'):str_diamonds]), 0)
	Mobile.takeScreenshot()
	Mobile.delay(2)

	Mobile.comment('Klik button lanjutkan')
	Mobile.tap(findTestObject('voucher-games/Button - Lanjutkan'), 0)
	Mobile.takeScreenshot()
	Mobile.delay(2)
	
	Mobile.comment('Klik button bayar')
	Mobile.tap(findTestObject('voucher-games/Button - Bayar'), 0)
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
	if (Mobile.verifyElementVisible(findTestObject('voucher-games/View - Transaksi'), 5, FailureHandling.OPTIONAL)) {
		Mobile.tap(findTestObject('voucher-games/View - Transaksi'), 0)
		Mobile.takeScreenshot()
		Mobile.delay(2)
	}
	
	Mobile.comment('Kembali ke menu utama')
	Mobile.tap(findTestObject('voucher-games/Button - close'), 0)
	Mobile.delay(2)
	
	
}





