# ⬆️ Level Up to Automation Testing with Katalon 🧪

This project serves as hands-on practice based on what I've learned from the 
[**"Leveling Up from a Manual Tester to an Automation Beginner (with Katalon Studio)"**](https://academy.katalon.com/learning-path/fresher-automation-engineer/) learning path.

<br>

![It's Automation, Baby!](./automation-audio-engineer.gif)

<br>

### ✅ What's in This Project:

<hr>

* Creating test cases using the **Katalon Record/Playback** feature.
* Capturing objects using the **Katalon Spy** feature.
* Adding **Data Files** for data binding in test cases.
* Building more complex test cases using **loops** and **conditions**.
* Manually creating test steps using drag-and-drop objects.
* Writing test case scripts from scratch using predefined classes.
* Organizing objects into structured, functionality-based folders.
* Creating and using **Local** and **Global** Variables dynamically in test cases.
* Abstracting test cases and calling them from other test cases.
* Integrating with **Github** to manage version control.
* Creating **Test Suites**.
* Arranging **Test Suites** into **Test Suite Collections** to run tests concurrently or sequentially across different browsers.
* Using **Katalon Studio Recording Engine Extension** to capture test cases directly from active browser sessions.
* Creating and reusing **Custom Keywords**.

<br>


### ❌ What's <u>NOT</u> Included (Due to Katalon Free Version Limitations):

<hr>

* Advanced Data Binding.
* Self-Healing Smart XPath.
* StudioAssist AI.
* Debugging Tools.
* Full Reporting Features.

<br>

### 🚀 Getting Started
<hr>
To run this project successfully, make sure you have the following set up:

<br>

#### ✅ Prerequisites

* Katalon Studio installed (free version).

* Git (optional, but recommended for version control).

* Chrome or another supported browser for execution.

<br>
<hr>
<br>

#### 📦 Cloning the Project
You can either clone this repo or download it as a ZIP:

```bash
bash

git clone https://github.com/nedaagehad/levelup-to-automation-with-katalon.git
```
<br>
<hr>
<br>

#### 🛠 Opening in Katalon Studio

<br>

1. Open Katalon Studio.

2. Go to `File > Open Project`.

3. Navigate to the folder where you cloned/downloaded this project.

4. Select the `.prj` file.

<br>
<hr>
<br>

#### ▶️ Running the Tests

1. From the **Test Cases** folder, open a test case of your choice (e.g. `Login`).

2. Make sure **Global Variables** or **Data Files** contain the required credentials.

3. Click the **Run** button (top toolbar) to execute.

> ⚠️ If you're running the `Login` test case directly, ensure that credentials are set in either the **global variables** or passed in by another test case.

<br>
<hr>
<br>

#### 💡 Tip:

To run a full suite of tests:

* Go to the **Test Suites** folder.

* Open any `.ts` file (e.g. `Regression`) and click **Run**.

<br>
<hr>
<br>

### 🧗 Challenges Encountered:

<hr>

1. **Password Encryption**

When passing **User Credentials** to the **Login** test case, the test would <u>*fail*</u> because it expected the **password** to be **encrypted**. However, the credentials were stored in **Global Variables** and **Data Files** in plain text. To fix this, I needed a way to encrypt the password <u>*before*</u> setting it in the input field.

✅ ***Solution:*** Create a **Custome Keyword** that returns an encrypted version of the password.

```{groovy}
groovy

import com.kms.katalon.util.CryptoUtil

@Keyword
	def EncryptText (String PlainText) {
		return CryptoUtil.encodeSensitiveInfo(PlainText)
	}

```

<br>

2. **Running the Login Test Case without Passing Values to the Local Variables:**

The **local variables** for the **Login** test case have no default values — intentionally — so they stay dynamic. As a result, running the test case in isolation (i.e. without being called by another case) executes with empty credentials, causing the test to fail.

✅ **Solution:** Check if the local variables are empty and assign values from a **Data File** or **Global Variables**.

```{groovy}
groovy

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

```

### 🔗 Useful Links:

<hr>

* [**Katalon Studio Documentation**](https://docs.katalon.com/katalon-studio/about-katalon-studio)
* [**Browser-Based Video Recording in Katalon**](https://docs.katalon.com/katalon-studio/test-reports/generate-test-reports/generate-browser-based-videos-in-katalon-studio-reports)
* [**Groovy Tutorials**](https://www.tutorialspoint.com/groovy/index.htm)


