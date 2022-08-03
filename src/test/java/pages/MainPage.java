package pages;

import org.openqa.selenium.By;
import base.BaseTest;

public class MainPage {

    static By NAVBAR = By.id("navbar");
    static By SEARCH_BAR = By.id("nav-search");
    static By ACTIVE_SEARCH_BAR = By.cssSelector(".nav-active");
    static By SEARCH_BOX = By.id("twotabsearchtextbox");
    static By SEARCH_SUBMIT_BTN = By.cssSelector(".nav-right .nav-search-submit");
    static By COOKIES_WARNING = By.id("sp-cc");
    static By COOKIE_ACCEPT_BTN = By.id("sp-cc-accept");

    public static void check(){
        BaseTest.wait_for_element(NAVBAR);
        BaseTest.wait_for_element(SEARCH_BAR);
        BaseTest.wait_for_element(SEARCH_BOX);
        BaseTest.wait_for_element(SEARCH_SUBMIT_BTN);
        BaseTest.wait_for_element(COOKIES_WARNING);
    }

    public static void acceptCookies(){
        BaseTest.wait_for_element(COOKIE_ACCEPT_BTN).click();
        BaseTest.wait_for_element_disappears(COOKIES_WARNING);
    }

    public static void typeOnSearchBox(String key){
        BaseTest.wait_for_element(SEARCH_BOX).click();
        BaseTest.wait_for_element(ACTIVE_SEARCH_BAR);
        BaseTest.wait_for_element(SEARCH_BOX).sendKeys(key);
    }

    public static void clickOnSearchSubmit(){
        BaseTest.wait_for_element(SEARCH_SUBMIT_BTN).click();
    }

}
