package br.com.codegroup.utils;

import br.com.codegroup.steps.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {

    public static WebDriverWait getWait() {
        return new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
    }

    public static void fillElement(By element, String text){
        Hooks.driver.findElement(element).sendKeys(text);
    }

    public static void clickInElement(By element) {
        Hooks.driver.findElement(element).click();
    }

    public static void executeSpecialKey(By element, Keys comand){
        Hooks.driver.findElement(element).sendKeys(comand);
    }
}
