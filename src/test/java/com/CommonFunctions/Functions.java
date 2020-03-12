package com.CommonFunctions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Functions {

    public void sleepMethod(int time) {
        try {
            Thread.sleep(time * 1000);     //50
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void checkAndClick(String xpath, WebDriver driver, int waitTime) {
        int i=0;
        while(i<waitTime) {
            if(isElementPresent(xpath, driver)) {
                driver.findElement(By.xpath(xpath)).click();
                break;
            }
            sleepMethod(2);
            i++;
        }
        if(i==waitTime) {
            Assert.fail("Element Not Found: " + xpath);
        }
    }

    public boolean isElementPresent(String xpath, WebDriver driver) {
        try {
            driver.findElement(By.xpath(xpath));
        } catch (Throwable e) {
            return false;
        }
        return true;
    }
}
