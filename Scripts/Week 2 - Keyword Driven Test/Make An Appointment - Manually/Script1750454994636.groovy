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

CustomKeywords.'Auth.Login'()

for (def n : (0..2)) {
    WebUI.selectOptionByIndex(findTestObject('CURA Healthcare Service/Make Appointment/select_Tokyo CURA Healthcare Center        _5b4107'), 
        '1', FailureHandling.STOP_ON_FAILURE)

    WebUI.check(findTestObject('CURA Healthcare Service/Make Appointment/input_Apply for hospital readmission_hospit_63901f'))

    if (n == 0) {
        WebUI.click(findTestObject('CURA Healthcare Service/Make Appointment/input_Medicare_programs'))
    } else if (n == 1) {
        WebUI.click(findTestObject('CURA Healthcare Service/Make Appointment/input_Medicaid_programs'))
    } else {
        WebUI.click(findTestObject('CURA Healthcare Service/Make Appointment/input_None_programs'))
    }
    
    WebUI.setText(findTestObject('CURA Healthcare Service/Make Appointment/textarea_Comment_comment'), 'This is a test comment')

    WebUI.setText(findTestObject('CURA Healthcare Service/Make Appointment/input_Visit Date (Required)_visit_date'), '25/7/2025')

    WebUI.click(findTestObject('CURA Healthcare Service/Make Appointment/button_Book Appointment'))

    WebUI.verifyElementText(findTestObject('CURA Healthcare Service/Make Appointment/h2_Appointment Confirmation'), 'Appointment Confirmation')

    WebUI.click(findTestObject('CURA Healthcare Service/Make Appointment/a_Go to Homepage'))

    if (n <= 1) {
        WebUI.click(findTestObject('CURA Healthcare Service/Home Page/a_btn-make-appointment'))
    }
}

WebUI.closeBrowser()

CustomKeywords.'Completed.Congrats'('Tester')

