package stepdefnitions;
import com.driverfactory.DriverFactory;
import com.pages.CountrySelect;
import com.pages.SubscriptionPage;
import io.cucumber.java.en.*;
import org.junit.Assert;


public class SubscriptionSteps {

    private final SubscriptionPage subscriptionPage = new SubscriptionPage(DriverFactory.getDriver());
    private final CountrySelect countrySelect = new CountrySelect(DriverFactory.getDriver());
    private String title;

    @Given("User is on Subscription package page")
    public void user_on_subscription_page(){
        DriverFactory.getDriver().get("https://subscribe.stctv.com/sa-en");
    }
    @When("Subscriptions package page is displayed")
    public void subscription_page_displayed(){
        title = subscriptionPage.getSubscriptionPackagePageTitle();
        System.out.println(title);
    }
    @When("Country is {string}")
    public void country_is(String country){
        subscriptionPage.clickOnCountryButton();
        countrySelect.clickOnCountryFlag(country);
        String countryName = subscriptionPage.getCountryDisplayed();
        Assert.assertTrue(countryName.contains(country));
    }
    @When("Language is {string}")
    public void language_is(String language){
        String lang = subscriptionPage.getLanguageDisplayed();
        Assert.assertTrue(lang.contains(language));
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String expectedTitle){
        Assert.assertTrue(title.contains(expectedTitle));
    }
    @Then("Premium Plan Should be Displayed And Price is {string}")
    public void premium_plan_is(String string){
        Assert.assertTrue(subscriptionPage.premiumPlanDetailsIsDisplayed());
        String currency = subscriptionPage.getPremiumPlanPrice();
        System.out.println(currency);
        System.out.println(string);
        Assert.assertTrue(currency.contains(string));
    }
    @Then("Classic Plan Should be Displayed And Price is {string}")
    public void classic_plan_is(String string){
        Assert.assertTrue(subscriptionPage.classicPlanDetailsIsDisplayed());
        String currency = subscriptionPage.getClassicPlanPrice();
        System.out.println(currency);
        System.out.println(string);
        Assert.assertTrue(currency.contains(string));
    }
    @Then("Lite Plan Should be Displayed And Price is {string}")
    public void lite_plan_is(String string){
        Assert.assertTrue(subscriptionPage.litePlanDetailsIsDisplayed());
        String currency = subscriptionPage.getLitePlanPrice();
        System.out.println(currency);
        System.out.println(string);
        Assert.assertTrue(currency.contains(string));
    }
}
