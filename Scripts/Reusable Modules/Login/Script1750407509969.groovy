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

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.G_MainURL)

WebUI.click(findTestObject('Object Repository/CURA Healthcare Service/Home Page/a_Make Appointment'))

if (!UserName) {
	UserName = GlobalVariable.G_Cura_UserName
}

if (!Password) {
	Password = GlobalVariable.G_Cura_Password
}

WebUI.setText(findTestObject('Object Repository/CURA Healthcare Service/Login/input_Username_username'), UserName)

WebUI.setEncryptedText(findTestObject('Object Repository/CURA Healthcare Service/Login/input_Password_password'), CustomKeywords.'Auth.EncryptText'(
        Password))

WebUI.click(findTestObject('Object Repository/CURA Healthcare Service/Login/button_Login'))

WebUI.verifyElementText(findTestObject('Object Repository/CURA Healthcare Service/Home Page/h2_Make Appointment'), 'Make Appointment')

