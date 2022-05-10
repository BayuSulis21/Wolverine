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
Mobile.setText(findTestObject('Registrasi/Enama'), GlobalVariable.nama, 0)
Mobile.takeScreenshot()
//Mobile.takeScreenshot('Reports//Registrasi//regis1.png')
Mobile.delay(2)

Mobile.comment('Isi email')
Mobile.setText(findTestObject('Registrasi/Eemail'), GlobalVariable.email, 0)
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

//send request TOP (trigernya dari klik aktifkan baru bisa send request TOP)
	def responseObj = WS.sendRequest(findTestObject('Object Repository/GetOTP'))
	if (WS.verifyResponseStatusCode(responseObj, 200))
	{
		System.out.println('Get OTP BERHASIL')
	
		Mobile.delay(2)
		JsonSlurper slurper = new JsonSlurper()
		Map parsedJson = slurper.parseText(responseObj.getResponseText())
		String getOTP = parsedJson.get("data").get("otp").get("otp_number")
		System.out.println(getOTP)
		
		Mobile.delay(1)
		String varOTP = getOTP
		String otp1 = varOTP.substring(0, 1).trim()
		String otp2 = varOTP.substring(1, 2).trim()
		String otp3 = varOTP.substring(2, 3).trim()
		String otp4 = varOTP.substring(3, 4).trim()
		String otp5 = varOTP.substring(4, 5).trim()
		String otp6 = varOTP.substring(5, 6).trim()
		
		Mobile.comment('Input OTP')
		Mobile.pressBack()
		Mobile.setText(findTestObject('aktivasi/Eotp1'), otp1, 0)
		Mobile.pressBack()
		Mobile.setText(findTestObject('aktivasi/Eotp2'), otp2, 0)
		Mobile.pressBack()
		Mobile.setText(findTestObject('aktivasi/Eotp3'), otp3, 0)
		Mobile.pressBack()
		Mobile.setText(findTestObject('aktivasi/Eotp4'), otp4, 0)
		Mobile.pressBack()
		Mobile.setText(findTestObject('aktivasi/Eotp5'), otp5, 0)
		Mobile.pressBack()
		Mobile.delay(1)
	    Mobile.setText(findTestObject('aktivasi/Eotp6'), otp6, 0)
		
		String pin=GlobalVariable.pin
		Mobile.comment('Masukkan PIN')
		Mobile.setText(findTestObject('Registrasi/Epin1'), pin, 0)
		Mobile.setText(findTestObject('Registrasi/Epin2'), pin, 0)
		Mobile.takeScreenshot()
		//Mobile.takeScreenshot('Reports//Registrasi//regis5.png')
		Mobile.delay(2)
		
		Mobile.comment('Klik SIMPAN')
		Mobile.tap(findTestObject('Registrasi/Simpan'), 0)
		Mobile.takeScreenshot()
		//Mobile.takeScreenshot('Reports//Registrasi//regis6.png')
		Mobile.delay(2)
		
		//Mobile.takeScreenshot('Reports//Registrasi//regis7.png')
		Mobile.comment('Selesai Registrasi')
		Mobile.takeScreenshot()
		Mobile.tap(findTestObject('Registrasi/Selesai'), 0)
		Mobile.delay(2)
		
	}else {
		System.out.println('Get OTP TIDAK BERHASIL')
	}




