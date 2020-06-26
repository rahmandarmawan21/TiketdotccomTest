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
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When

class PesanKereta {

	@Given("User membuka web tiket dan memilih kereta")
	public void user_membuka_web_tiketcom_dan_memilih_kereta() throws Throwable {
		'using if direct test'
		WebUI.openBrowser(GlobalVariable.caseUrl)
		WebUI.maximizeWindow()
		WebUI.waitForPageLoad(100)
		//WebUI.openBrowser("https://www.tiket.com/kereta-api")
		'initiate Selenium Driver'
		WebDriver driver = DriverFactory.getWebDriver()
		String urlBase = GlobalVariable.caseUrl
		'initiate katalon webdriver'
		katalon = new WebDriverBackedSelenium(driver, urlBase)
	}

	@When("user memilih stasiun keberangkatan (.*) dan tujuan (.*)")
	public void user_memilih_stasiun_keberangkatan_dan_tujuan(String departure, String destination) throws Throwable {
		WebDriver driver = DriverFactory.getWebDriver()
		'set departure'
		driver.findElement(By.xpath("//*[@id='formhome']/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/input")).click()
		driver.findElement(By.xpath("//*[@id='formhome']/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/input")).sendKeys(departure.toString())
		driver.findElement(By.className("city")).click()
		'Set destination'
		driver.findElement(By.xpath("//*[@id='formhome']/div/div/div[1]/div[2]/div[3]/div[2]/div[2]/div/input")).click()
		driver.findElement(By.xpath("//*[@id='formhome']/div/div/div[1]/div[2]/div[3]/div[2]/div[2]/div/input")).sendKeys(destination.toString())
		driver.findElement(By.className("city")).click()
	}

	@Then("user memilih tanggal keberangkatan")
	public void user_memilih_tanggal_keberangkatan() throws Throwable {
		WebDriver driver = DriverFactory.getWebDriver()
		'set date'
		driver.findElement(By.xpath("//*[@id='formhome']/div/div/div[1]/div[2]/div[4]/div[2]/div[2]/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div[2]/div/table/tbody/tr[5]/td[3]/div")).click()
	}

	@And("user menentukan (.*) penumpang dewasa")
	public void user_menentukan_penumpang_dewasa(String penumpang1) throws Throwable {
		WebDriver driver = DriverFactory.getWebDriver()
		def count1 = driver.findElement(By.xpath("//*[@id='formhome']/div/div/div[1]/div[2]/div[6]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]")).getText()
		for(int i = 0; i < penumpang1; i++){
			if(count1 != penumpang1.toString()){
				driver.findElement(By.xpath("//*[@id='formhome']/div/div/div[1]/div[2]/div[6]/div[2]/div/div/div[2]/div[1]/div[2]/div[3]/button")).click()
			}else{
				KeywordUtil.markPassed(penumpang1.toString())
			}
		}
	}

	@And("user menentukan (.*) penumpang bayi")
	public void user_menentukan_penumpang_bayi(String penumpang2) throws Throwable {
		WebDriver driver = DriverFactory.getWebDriver()
		def count2 = driver.findElement(By.xpath("//*[@id='formhome']/div/div/div[1]/div[2]/div[6]/div[2]/div/div/div[2]/div[2]/div[2]/div[2]")).getText()
		for(int i = 0; i < penumpang2; i++){
			if(count2 != penumpang2.toString()){
				driver.findElement(By.xpath("//*[@id='formhome']/div/div/div[1]/div[2]/div[6]/div[2]/div/div/div[2]/div[2]/div[2]/div[3]/button")).click()
			}else{
				KeywordUtil.markPassed(penumpang2.toString())
			}
		}
		driver.findElement(By.xpath("//*[@id='formhome']/div/div/div[1]/div[2]/div[6]/div[2]/div/div/div[3]/button")).click()
		driver.findElement(By.xpath("//*[@id='formhome']/div/div/div[1]/div[3]/button")).click()
		driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[3]/div/div/div[2]/div[2]/div[1]/div/div[2]/div[3]/button")).click()
	}
}