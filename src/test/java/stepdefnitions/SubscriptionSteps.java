package stepdefnitions;
import com.driverfactory.DriverFactory;
import com.pages.CountrySelect;
import com.pages.SubscriptionPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import com.utils.JsonReader;


public class SubscriptionSteps {

    private final SubscriptionPage subscriptionPage = new SubscriptionPage(DriverFactory.getDriver());
    private final CountrySelect countrySelect = new CountrySelect(DriverFactory.getDriver());
    private String title;
    private String lang = "En";
    JsonReader jsonReader;

    @Given("User is on Subscription package page")
    public void user_on_subscription_page(){
        DriverFactory.getDriver().get("https://subscribe.stctv.com/sa-en");
    }
    @When("Subscriptions package page is displayed")
    public void subscription_page_displayed(){
        title = subscriptionPage.getSubscriptionPackagePageTitle();
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

    @When("I select language {string}")
    public void language_select(String language){
        String l = subscriptionPage.getLanguageDisplayed();
        subscriptionPage.selectArabicLanguage();
        Assert.assertTrue(l.contains(language));
        lang = "Ar";
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String expectedTitle){
        Assert.assertTrue(title.contains(expectedTitle));
    }
    @Then("Premium Plan Should be Displayed And Price is {string}")
    public void premium_plan_is(String string){
        jsonReader = new JsonReader(string, lang);
        Assert.assertTrue(subscriptionPage.premiumPlanDetailsIsDisplayed());
        String currency = subscriptionPage.getPremiumPlanPrice();
        Assert.assertTrue(currency.contains(jsonReader.getPricePackage("PremiumPrice")));
    }
    @Then("Classic Plan Should be Displayed And Price is {string}")
    public void classic_plan_is(String string){
        jsonReader = new JsonReader(string, lang);
        Assert.assertTrue(subscriptionPage.classicPlanDetailsIsDisplayed());
        String currency = subscriptionPage.getClassicPlanPrice();
        Assert.assertTrue(currency.contains(jsonReader.getPricePackage("ClassicPrice")));
    }
    @Then("Lite Plan Should be Displayed And Price is {string}")
    public void lite_plan_is(String string){
        jsonReader = new JsonReader(string, lang);
        Assert.assertTrue(subscriptionPage.litePlanDetailsIsDisplayed());
        String currency = subscriptionPage.getLitePlanPrice();
        Assert.assertTrue(currency.contains(jsonReader.getPricePackage("LitePrice")));
    }
}
