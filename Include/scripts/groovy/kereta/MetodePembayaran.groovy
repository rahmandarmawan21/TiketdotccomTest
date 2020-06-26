package kereta
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class MetodePembayaran {
	@Given("user menggunakan transfer mandiri")
	public void user_menggunakan_transfer_mandiri() throws Throwable {
		WebDriver driver = DriverFactory.getWebDriver()
		'pembayaran'
		WebUI.scrollToElement(findTestObject('Object Repository/Form/Mandiri Virtual Account'), 1)
		driver.findElement(By.xpath("//*[@id='app']/div/div[3]/div/div[2]/div[2]/div[1]/div/div[2]/div[3]/div/a[2]/div/div/span")).click()
	}

	@When("user melanjutkan transaksi")
	public void user_melanjutkan_transaksi() throws Throwable {
		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.delay(1)
		driver.findElement(By.xpath("//*[@id='app']/div/div[3]/div/div[2]/div[2]/div[1]/div/div/div[4]/div[2]/button")).click()
	}

	@Then("pembayaran selesai")
	public void pembayaran_selesai() throws Throwable {
		WebDriver driver = DriverFactory.getWebDriver()
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('Object Repository/Form/button_Saya Sudah Membayar'), 1)
		driver.findElement(By.xpath("//*[@id='app']/div/div[3]/div/div[2]/div[2]/div[1]/div/div/div/div[3]/div[2]/button")).click()
		driver.findElement(By.xpath("//*[@id='modal-root']/div/div/div/div[2]/div[2]/div/button")).click()
		WebUI.closeBrowser()
	}
}