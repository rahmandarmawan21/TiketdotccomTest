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



class FormPenumpang {
	@Given("user memilih title (.*)")
	public void user_memilih_title(String title) throws Throwable {
		println title
	}

	@Then("user mengisi nama (.*)")
	public void user_mengisi_nama(String name) throws Throwable {
		'detail pemesan'
		WebDriver driver = DriverFactory.getWebDriver()
		//	driver.findElement(By.className("flight-dropdown")).click()
			driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[3]/div[1]/div[2]/div/input")).sendKeys(name)
			
			
	}

	@And("user mengisi alamat email (.*)")
	public void user_mengisi_alamat_email(String email) throws Throwable {
		WebDriver driver = DriverFactory.getWebDriver()
		driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[3]/div[2]/div/input")).sendKeys(email)
	}

	@And("user mengisi no ponsel (.*)")
	public void user_mengisi_no_ponsel(String noHp) throws Throwable {
		WebDriver driver = DriverFactory.getWebDriver()
		driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[3]/div[3]/div[2]/div/input")).sendKeys(noHp)
	}
	
	@And("user mengisi semua identitas penumpang")
	public void user_mengisi_semua_identitas_penumpang(String ktp1) throws Throwable {
		WebDriver driver = DriverFactory.getWebDriver()
		'detail penumpang'
		WebUI.scrollToElement(findTestObject('Object Repository/Form/switch'), 1)
		WebUI.click(findTestObject('Object Repository/Form/switch'))
		driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[2]/div[4]/div/input")).sendKeys(ktp1)
		WebUI.scrollToElement(findTestObject('Object Repository/Form/div_Penumpang 2 Dewasa'), 1)
		'penumpang ke 2'
		driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[3]/div[3]/div/input")).sendKeys('Jumadi')
		driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[3]/div[4]/div/input")).sendKeys('1233312345123123')
		'penumpang ke 3'
		driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[4]/div[3]/div/input")).sendKeys('Juned')
		driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[4]/div[4]/div/input")).sendKeys('8787827181772827')
		'Penumpang bayi'
		WebUI.scrollToElement(findTestObject('Object Repository/Form/div_Penumpang 4 Bayi'), 1)
		driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[5]/div[3]/div/input")).sendKeys('bedul')
		driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[5]/div[4]/div")).click()
		WebUI.delay(1)
		driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[5]/div[4]/div/div[1]/div[1]/div/div[3]/ul/li[1]")).click()
		WebUI.delay(1)
		driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[5]/div[4]/div/div[1]/div[3]/div/div[3]/ul/li[1]")).click()
		WebUI.delay(1)
		driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[5]/div[4]/div/div[1]/div[5]/div/div[3]/ul/li[1]")).click()
		
		driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[6]/div[3]/div/input")).sendKeys('dullah')
		driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[6]/div[4]/div/div[1]")).click()
		WebUI.delay(1)
		driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[6]/div[4]/div/div[1]/div[1]/div/div[3]/ul/li[1]")).click()
		WebUI.delay(1)
		driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[6]/div[4]/div/div[1]/div[3]/div/div[3]/ul/li[1]")).click()
		WebUI.delay(1)
		driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[2]/div[6]/div[4]/div/div[1]/div[5]/div/div[3]/ul/li[1]")).click()
	}
	
	@Then("user memilih kursi")
	public void user_memilih_kursi() throws Throwable {
		WebDriver driver = DriverFactory.getWebDriver()
		'Pilih kursi'
		WebUI.scrollToElement(findTestObject('Object Repository/Form/button_Pilih Kursi'), 1)
		WebUI.delay(1)
		driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[4]/button[1]")).click()
		WebUI.delay(5)
		WebUI.scrollToElement(findTestObject('Object Repository/Form/button_Pembayaran'), 1)
		driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div[2]/div/div/div[4]/button")).click()
		driver.findElement(By.xpath("//*[@id='popup']/div/div/div/div[5]/button[1]")).click()
	}
}