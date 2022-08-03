package steps;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import static org.junit.Assert.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import java.util.List;
import pages.MainPage;
import pages.ProductPage;
import pages.SearchResultPage;

@RunWith(Cucumber.class)
public class ProductLookUpTest {

    public static Logger log;
    List<String> product_details;

    @Before
    public void setUp(){
        System.setProperty("log4j.configurationFile","log4j2-test.xml");
        log = LogManager.getLogger(ProductLookUpTest.class);
        BaseTest.setDriver();
        log.info("SetUp completed.");
    }

    @Given("^Go to \"([^\"]*)\"$")
    public void goToUrl(String url){
        BaseTest.navigate_to(url);
        MainPage.check();
        MainPage.acceptCookies();
        log.info("Home page opened and cookies accepted.");
    }

    @When("^Search \"([^\"]*)\"$")
    public void searchProduct(String product){
        MainPage.typeOnSearchBox(product);
        MainPage.clickOnSearchSubmit();
        log.info("Search made for given product.");
    }

    @Then("^Check that the results are listed$")
    public void checkSearchResultsListed(){
        SearchResultPage.check();
        assertTrue(SearchResultPage.areResultsListed());
        log.info("Search results page opened and results listed successfully!");
    }

    @And("^Click iPhone 13 at the top of the list$")
    public void goToProduct(){
        SearchResultPage.selectProduct(0);
        ProductPage.check();
        log.info("Clicked on the first product.\n");
    }
    
    @Then("^Log the product details for each size$")
    public void logProductDetails(){
        product_details = ProductPage.getProductDataForEachSize();
        for (String line: product_details) {
            log.info(line);
        }
        log.info("Product details gathered successfully!");
    }
    
    @After
    public void tearDown(){
        BaseTest.tear_down();
        log.info("End of test. TEAR DOWN");
    }
    
}
