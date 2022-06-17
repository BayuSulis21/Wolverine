import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.contribution.WebUiDriverCleaner
import com.kms.katalon.core.mobile.contribution.MobileDriverCleaner
import com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner
import com.kms.katalon.core.windows.keyword.contribution.WindowsDriverCleaner
import com.kms.katalon.core.testng.keyword.internal.TestNGDriverCleaner


DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.windows.keyword.contribution.WindowsDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.testng.keyword.internal.TestNGDriverCleaner())


RunConfiguration.setExecutionSettingFile('/var/folders/_x/hzlzwd8j20gfzg0809vw8zhh0000gq/T/Katalon/Test Cases/16. Retribusi - Globalindo/RE-40. BE-Inquiry Retribusi dengan location ID valid dan Idno InValid/20220615_135533/execution.properties')

TestCaseMain.beforeStart()

        TestCaseMain.runTestCase('Test Cases/16. Retribusi - Globalindo/RE-40. BE-Inquiry Retribusi dengan location ID valid dan Idno InValid', new TestCaseBinding('Test Cases/16. Retribusi - Globalindo/RE-40. BE-Inquiry Retribusi dengan location ID valid dan Idno InValid',[:]), FailureHandling.STOP_ON_FAILURE , false)
    
