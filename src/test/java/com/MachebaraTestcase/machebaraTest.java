package com.MachebaraTestcase;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class machebaraTest {
    public WebDriver driver;
    public WebDriver functions;


    @Before
    public void wDriver(){
//        ChromeOptions options = new ChromeOptions();
//        Map<String, Object> preference = new HashMap<String, Object>();
//        preference.put("profile.content_settings.exceptions.media_stream_camera.https://english.fdc-inc.com.setting","1");
//        preference.put("profile.content_settings.exceptions.media_stream_mic.https://english.fdc-inc.com.setting","1");
//        preference.put("credentials_enable_service", false);
//        options.setExperimentalOption("prefs", preference);
//        options.setExperimentalOption("useAutomationExtension", false);
//        options.addArguments("--use-fake-ui-for-media-stream=1");
        System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //functions = new Functions();
        //System.out.println("connected");
    }

    @Test
    public void login(){
        driver.get("http://variety.stg.inn.inmgt.com/");
        driver.findElement(By.id("js-login_modal")).click();
        driver.findElement(By.xpath("//*[@id='js-sns-login_modal_body']/div/div/div[3]/p[1]/span[1]")).click();
        driver.findElement(By.id("user_id_or_mail")).sendKeys("kimmyornopia@gmail.com");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.cssSelector("c-btn c-btn-color--blue c-btn--registerFrom")).click();

    }
}
