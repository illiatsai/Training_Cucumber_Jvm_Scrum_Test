package com.scrum.behavior;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;

public class MyStepdefs {
    @Given("^User is on Google page$")
    public void User_is_on_Google_page() {
        open(Configuration.baseUrl);
    }

    @When("^User enters \"([^\\\"]*)\" in search field$")
    public void User_enters_in_search_field(String text) {
        $(By.id("lst-ib")).sendKeys(text);
        //WebElement productName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@name, 'btnK')]")));
        //$(By.xpath("//*[contains(@name, 'btnK')]")).click();
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@name, 'btnK')]")));
        //WebElement productName = wait.until($(By.xpath("//*[contains(@name, 'btnK')]")));

    }

    @And("^User clicks Search button$")
    public void User_clicks_Search_button() {

        $(By.xpath("//*[contains(@name, 'btnG')]")).click();

    }




    @Then("^User clicks \"([^\\\"]*)\" link$")
    public void User_clicks_link(String result) throws Throwable {
        ElementsCollection col = $$(By.xpath("//a[contains(@onmousedown, 'return rwt')]"));
        SelenideElement element = col.find(Condition.hasText(result));
        element.click();
        Thread.sleep(5000);
    }
}
