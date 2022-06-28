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

import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Driver;
import com.kms.katalon.core.annotation.Keyword

//Connect to Database
CustomKeywords.'com.database.ConnectionMysql.connectDB'('34.101.167.194', 'secure_page', '3306', 'wolverine', 'W0lver1ne#21')
String trxId ='MOBAYU100003500077'
String queryData='SELECT * FROM secure_page where trxId="'+trxId+'"'
ResultSet queryResult = CustomKeywords.'com.database.ConnectionMysql.executeQuery'(queryData)
queryResult.next()
String valueFromDatabase = queryResult.getString(12)
println(valueFromDatabase)
CustomKeywords.'com.database.ConnectionMysql.closeDatabaseConnection'()
