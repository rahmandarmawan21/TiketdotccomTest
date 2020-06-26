import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium
import internal.GlobalVariable as GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

try{
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
	'set departure'
	driver.findElement(By.xpath("//*[@id='formhome']/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/input")).click()
	driver.findElement(By.xpath("//*[@id='formhome']/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/input")).sendKeys(departure.toString())
	driver.findElement(By.className("city")).click()
	'Set destination'
	driver.findElement(By.xpath("//*[@id='formhome']/div/div/div[1]/div[2]/div[3]/div[2]/div[2]/div/input")).click()
	driver.findElement(By.xpath("//*[@id='formhome']/div/div/div[1]/div[2]/div[3]/div[2]/div[2]/div/input")).sendKeys(destination.toString())
	driver.findElement(By.className("city")).click()
	'set date'
	driver.findElement(By.xpath("//*[@id='formhome']/div/div/div[1]/div[2]/div[4]/div[2]/div[2]/div/div/div[2]/div/div/div[1]/div[2]/div[2]/div/div[2]/div/table/tbody/tr[5]/td[3]/div")).click()	
	def count1 = driver.findElement(By.xpath("//*[@id='formhome']/div/div/div[1]/div[2]/div[6]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]")).getText()
	def count2 = driver.findElement(By.xpath("//*[@id='formhome']/div/div/div[1]/div[2]/div[6]/div[2]/div/div/div[2]/div[2]/div[2]/div[2]")).getText()
	for(int i = 0; i < penumpang1; i++){
		if(count1 != penumpang1.toString()){
			driver.findElement(By.xpath("//*[@id='formhome']/div/div/div[1]/div[2]/div[6]/div[2]/div/div/div[2]/div[1]/div[2]/div[3]/button")).click()
		}else{
			KeywordUtil.markPassed(penumpang1.toString())
		}
	}
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
	'detail pemesan'
//	driver.findElement(By.className("flight-dropdown")).click()
	driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[3]/div[1]/div[2]/div/input")).sendKeys(name)
	driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[3]/div[2]/div/input")).sendKeys(email)
	driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[1]/div[3]/div[3]/div[2]/div/input")).sendKeys(noHp)
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
	'Pilih kursi'
	WebUI.scrollToElement(findTestObject('Object Repository/Form/button_Pilih Kursi'), 1)
	WebUI.delay(1)
	driver.findElement(By.xpath("//*[@id='app']/div/div[2]/div[2]/div[2]/div/div[1]/div[4]/button[1]")).click()
	WebUI.delay(5)
	WebUI.scrollToElement(findTestObject('Object Repository/Form/button_Pembayaran'), 1)
	driver.findElement(By.xpath("//div[@id='app']/div/div[2]/div[2]/div[2]/div/div/div[4]/button")).click() 
	driver.findElement(By.xpath("//*[@id='popup']/div/div/div/div[5]/button[1]")).click()
	'pembayaran'
	WebUI.scrollToElement(findTestObject('Object Repository/Form/Mandiri Virtual Account'), 1)
	driver.findElement(By.xpath("//*[@id='app']/div/div[3]/div/div[2]/div[2]/div[1]/div/div[2]/div[3]/div/a[2]/div/div/span")).click()
	WebUI.delay(1)
	driver.findElement(By.xpath("//*[@id='app']/div/div[3]/div/div[2]/div[2]/div[1]/div/div/div[4]/div[2]/button")).click()
	WebUI.delay(3)
	WebUI.scrollToElement(findTestObject('Object Repository/Form/button_Saya Sudah Membayar'), 1)
	driver.findElement(By.xpath("//*[@id='app']/div/div[3]/div/div[2]/div[2]/div[1]/div/div/div/div[3]/div[2]/button")).click()
	driver.findElement(By.xpath("//*[@id='modal-root']/div/div/div/div[2]/div[2]/div/button")).click()
	WebUI.closeBrowser()
}catch(Exception ex){
	//println ex
	def error= ex.message.toString()
	def testName = ""
	if (error.length()> 40){
		testName = RunConfiguration.getExecutionSourceName().toString()
	}else{
		testName = RunConfiguration.getExecutionSourceName().toString() +'['+error+']'
	}
	//println testName
	'custome error handling'
	CustomKeywords.'errorHandling.fail.failure'(testName, FailureHandling.STOP_ON_FAILURE)
}