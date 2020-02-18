package com.MachebaraTestcase;

import org.joda.time.DateTime;
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
    public void loginViewer() throws InterruptedException {
        driver.get("http://variety.stg.inn.inmgt.com/");
        driver.findElement(By.id("js-login_modal")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='js-sns-login_modal_body']/div/div/div[3]/p[1]/span[1]")).click();
        driver.findElement(By.id("user_id_or_mail")).sendKeys("kimmyornopia18@gmail.com");
        driver.findElement(By.xpath("(//input[@class='c-form-inputText'])[5]")).sendKeys("admin123");
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
    }

    @Test
    public void loginTalent() throws InterruptedException {
        driver.get("http://variety.stg.inn.inmgt.com/");
        driver.findElement(By.id("js-login_modal")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='js-sns-login_modal_body']/div/div/div[3]/p[1]/span[1]")).click();
        driver.findElement(By.id("user_id_or_mail")).sendKeys("kimkim");
        driver.findElement(By.xpath("(//input[@class='c-form-inputText'])[5]")).sendKeys("admin123");
        driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
    }

    @Test
    public void registerViaEmail() throws InterruptedException {
        String email = "kimoy"+ DateTime.now().toString("mmddYYYY")+"@mail.com";
        driver.get("http://variety.stg.inn.inmgt.com/");
        driver.findElement(By.id("js-login_modal")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='js-sns-login_modal_body']//span[@onclick='modal_jump_register()']")).click();
        driver.findElement(By.id("register_mail_address")).sendKeys(email);
        driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("admin123");
        driver.findElement(By.xpath("//*[@id='register_nick_name']")).sendKeys("fdckim");
        driver.findElement(By.xpath("(//button[@type='submit'])[1]//span")).click();
    }

    @Test
    public void startBcast() throws InterruptedException {
        loginTalent();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='btn-streaming-container']//span[contains(text(),'配信開始')]")).click();
//        Thread.sleep(5000);
//        driver.findElement(By.xpath("//*[@id='l-layer--modal']//button[contains(text(),'このお知らせを閉じる')]")).isDisplayed();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[contains(text(),'イベントの選択')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='l-layer--modal']//button[@data-event_id='419']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//button[@class='c-btn c-btn--cameraStart']//span[contains(text(),'配信スタート')]")).click();
        Thread.sleep(7000);
//        driver.findElement(By.xpath("//*[@id='js-room_start_form']//button[@class='c-btn c-btn--cameraStart']")).click();
//        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id='push-notif-yes']")).click();
        Thread.sleep(5000);
    }

    @Test
    public void joinBcast() throws InterruptedException {
        loginViewer();
        Thread.sleep(5000);
        driver.get("http://variety.stg.inn.inmgt.com/talent/kim/room");
    }

    @Test
    public void sendGift() throws InterruptedException {
        joinBcast();
        Thread.sleep(5000);
        driver.get("http://variety.stg.inn.inmgt.com/talent/kim/room");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//i[@class='size-50 g-icon-gifting_id_33']")).click();
        driver.findElement(By.xpath("//button[@class='js-giftSend js-giftSend_33 giftBtn c-planeBtn c-planeBtn-color--eGreen']")).click();

    }



}
