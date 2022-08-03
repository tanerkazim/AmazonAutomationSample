package pages;

import org.openqa.selenium.By;
import base.BaseTest;
import org.openqa.selenium.WebElement;
import java.util.List;

public class SearchResultPage {

    static By SEARCHED_TEXT = By.cssSelector(".s-breadcrumb .a-text-bold");
    static By SEARCH_RESULT_SLOT = By.cssSelector(".s-main-slot");
    static By SEARCH_RESULTS = By.cssSelector("[data-component-type='s-search-result']");
    static By SEARCH_RESULTS_TITLE = By.cssSelector(".s-card-container h2 a");
    static List<WebElement> product_list;

    public static void check(){
        BaseTest.wait_for_element(SEARCH_RESULT_SLOT);
        BaseTest.wait_for_element(SEARCHED_TEXT);
    }

    public static boolean areResultsListed(){
        product_list = BaseTest.wait_for_all_elements(SEARCH_RESULTS);
        return product_list.size() > 0;
    }

    public static void selectProduct(int index){
        BaseTest.scroll_to_web_element(product_list.get(index));
        List<WebElement> product_titles = BaseTest.wait_for_all_elements(SEARCH_RESULTS_TITLE);
        BaseTest.wait_for_web_element(product_titles.get(index)).click();
    }

}
