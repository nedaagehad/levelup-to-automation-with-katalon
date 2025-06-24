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

WebUI.selectOptionByValue(findTestObject('Object Repository/CURA Healthcare Service/Make Appointment/select_Tokyo CURA Healthcare Center        _5b4107'), 
    'Seoul CURA Healthcare Center', true)

WebUI.click(findTestObject('Object Repository/CURA Healthcare Service/Make Appointment/input_Apply for hospital readmission_hospit_63901f'))

WebUI.click(findTestObject('Object Repository/CURA Healthcare Service/Make Appointment/label_Medicaid'))

WebUI.click(findTestObject('Object Repository/CURA Healthcare Service/Make Appointment/span_Visit Date (Required)_glyphicon glyphi_cada34'))

WebUI.click(findTestObject('Object Repository/CURA Healthcare Service/Make Appointment/td_20'))

WebUI.setText(findTestObject('Object Repository/CURA Healthcare Service/Make Appointment/textarea_Comment_comment'), 
    'test comment')

WebUI.click(findTestObject('Object Repository/CURA Healthcare Service/Make Appointment/button_Book Appointment'))

WebUI.verifyElementText(findTestObject('Object Repository/CURA Healthcare Service/Make Appointment/h2_Appointment Confirmation'), 
    'Appointment Confirmation')

