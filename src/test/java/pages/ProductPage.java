package pages;

import org.openqa.selenium.By;
import base.BaseTest;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.ArrayList;

public class ProductPage {

    static List<String> product_details = new ArrayList<>();
    static List<WebElement> other_sizes;

    static By PRODUCT_MODEL = By.cssSelector(".po-model_name .a-span9");
    static By PRODUCT_SIZE = By.cssSelector("#variation_size_name .selection");
    static By PRODUCT_COLOR = By.cssSelector("#variation_color_name .selection");
    static By PRODUCT_PRICE = By.cssSelector(".priceToPay");
    static By PRODUCT_STOCK = By.id("availability");
    static By AVAILABLE_PRODUCT_SIZE = By.cssSelector("#variation_size_name .swatchAvailable");
    static By NAME_OVERLAY = By.cssSelector("#title_feature_div.js-feature-refresh-overlay");
    static By PRICE_OVERLAY = By.cssSelector("[id*='corePriceDisplay'].js-feature-refresh-overlay");
    static By STOCK_OVERLAY = By.cssSelector("[id*='availabilityInside'].js-feature-refresh-overlay");

    public static void check(){
        BaseTest.wait_for_element(PRODUCT_MODEL);
        BaseTest.wait_for_element(PRODUCT_SIZE);
        BaseTest.wait_for_element(PRODUCT_COLOR);
    }

    public static void waitForOverlaysDisappear(){
        BaseTest.wait_for_element_disappears(NAME_OVERLAY);
        BaseTest.wait_for_element_disappears(PRICE_OVERLAY);
        BaseTest.wait_for_element_disappears(STOCK_OVERLAY);
    }

    public static List<String> getProductDataForEachSize(){

        int i = 0;
        if (BaseTest.element_exists(AVAILABLE_PRODUCT_SIZE)){
            other_sizes = BaseTest.wait_for_all_elements(AVAILABLE_PRODUCT_SIZE);
            i = other_sizes.size();
        }
        do {
            product_details.add("Model: " + BaseTest.wait_for_element(PRODUCT_MODEL).getText());
            product_details.add("Size: " + BaseTest.wait_for_element(PRODUCT_SIZE).getText());
            product_details.add("Color: " + BaseTest.wait_for_element(PRODUCT_COLOR).getText());
            product_details.add("Price: " + BaseTest.wait_for_element(PRODUCT_PRICE).getText().replace("\n", ","));
            product_details.add("Stock: " + BaseTest.wait_for_element(PRODUCT_STOCK).getText() + "\n");
            if(other_sizes.isEmpty()){break;}
            other_sizes.get(0).click();
            waitForOverlaysDisappear();
            other_sizes.remove(0); i--;
        } while (i > -1);
        return product_details;
    }

}
