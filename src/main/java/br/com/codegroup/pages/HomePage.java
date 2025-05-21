package br.com.codegroup.pages;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchBar = By.xpath("//input[@id='twotabsearchtextbox']");
    private By searchBarResultsPanel = By.xpath("//div[@class='left-pane-results-container']");
    private By suggestion = By.xpath("//div[@class='s-suggestion s-suggestion-ellipsis-direction']");
    private By logo = By.id("nav-logo");
    private By cepBox = By.id("nav-global-location-popover-link");
    private By searchBarForm = By.id("nav-search-bar-form");
    private By accountLinksBox = By.id("nav-link-accountList");
    private By ordersBox = By.id("nav-orders");
    private By cartBox = By.id("nav-cart");
    private By menuNavItens = By.id("nav-xshop-container");
}
