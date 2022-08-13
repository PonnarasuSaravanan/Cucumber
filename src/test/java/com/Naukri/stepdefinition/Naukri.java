package com.Naukri.stepdefinition;

import java.io.File;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Naukri {
	
	static WebDriver driver;
	
	@Given("User launches Naukri application")
	public void user_launches_Naukri_application() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	}

	@Given("User clicks the login button")
	public void user_clicks_the_login_button() {
		WebElement login = driver.findElement(By.id("login_Layer"));
		login.click();
	
	}

	@When("User login the naukri application using one dimensional List")
	public void user_login_the_naukri_application_using_one_dimensional_List(DataTable dataTable) {
       List<String> asList = dataTable.asList();
		
	WebElement user = driver.findElement(By.xpath("//input[contains(@placeholder,'Enter your active Email ID')]"));
		user.sendKeys(asList.get(0));
		WebElement pass = driver.findElement(By.xpath("//input[@type='password']"));
		pass.sendKeys(asList.get(1));
		WebElement ck = driver.findElement(By.xpath("//button[@type='submit']"));
		ck.click();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebElement cross = driver.findElement(By.xpath("//div[contains(@class,'crossIcon chatBot chatBot')]"));
		cross.click();
		
	}

	@When("User search for jobs using one dimensional map")
	public void user_search_for_jobs_using_one_dimensional_map(DataTable dataTable) {
		Map<String,String> asMap = dataTable.asMap(String.class, String.class);
		
		WebElement job = driver.findElement(By.name("qp"));
		job.sendKeys(asMap.get("Job"));
		WebElement locat = driver.findElement(By.name("ql"));
		locat.sendKeys(asMap.get("Place"));
		WebElement search = driver.findElement(By.xpath("//button[@type='submit']"));
		search.click();

	}

	@Then("User select the particular iteration and print it in the excel sheets")
	public void user_select_the_particular_iteration_and_print_it_in_the_excel_sheets() throws Throwable {
		
		WebElement txt = driver.findElement(By.xpath("//a[contains(@title,'Automation/Manual Testing')]"));
		String a = txt.getText();
		System.out.println(a);
		
	    WebElement place = driver.findElement(By.xpath("(//a[text()='Appscrip'])[1]"));
	    String b = place.getText();
	    System.out.println(b);
	    
	    
	    WebElement qual = driver.findElement(By.xpath("(//span[text()='1-3 Yrs'])[1]"));
	    String c = qual.getText();
	    System.out.println(c);
	    
	    
	    
	    
	    
		
		
		
		
		File f = new File("C:\\Users\\Admin\\Desktop\\eclipse-committers-oxygen-3a-win32-x86_64\\Cucumber-July\\target\\Naukri Jobs.xlsx");
		FileOutputStream o = new FileOutputStream(f);
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("Naukri Jobs");
		HSSFRow row1 = sheet.createRow((short)0);
		row1.createCell(0).setCellValue("Serial Nmber");
		row1.createCell(1).setCellValue("Job Type");
		row1.createCell(2).setCellValue("Companies Name");
		row1.createCell(3).setCellValue("Experience Required");
		
		HSSFRow row2 = sheet.createRow((short)1);
		row2.createCell(0).setCellValue("1");
		row2.createCell(1).setCellValue(a);
		row2.createCell(2).setCellValue(b);
		row2.createCell(3).setCellValue(c);
		
		
		wb.write(o);
		
		o.close();
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	}


}
