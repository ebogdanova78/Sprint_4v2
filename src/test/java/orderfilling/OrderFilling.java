package orderfilling;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pageobject.OrderPage;

public class OrderFilling {
    public OrderPage objOrderPage;
    private final WebDriver driver;

    public OrderFilling(WebDriver driver) {
        this.driver = driver;
    }

    public OrderFilling OrderFilling_part1(String name, String surname, String address, String phoneNumber, String station) {
        this.objOrderPage = new OrderPage(this.driver);
        this.objOrderPage.getName().sendKeys(new CharSequence[]{name});
        this.objOrderPage.getSurname().sendKeys(new CharSequence[]{surname});
        this.objOrderPage.getAddress().sendKeys(new CharSequence[]{address});
        this.objOrderPage.getPhoneNumber().sendKeys(new CharSequence[]{phoneNumber});
        (new Actions(this.driver)).moveToElement(this.objOrderPage.getMetroStation()).click().sendKeys(new CharSequence[]{station}).sendKeys(new CharSequence[]{Keys.ARROW_DOWN}).sendKeys(new CharSequence[]{Keys.ENTER}).build().perform();
        return this;
    }

    public OrderFilling OrderFilling_part2() {
        this.objOrderPage = new OrderPage(this.driver);
        this.objOrderPage.getCalendar().click();
        this.objOrderPage.getDate().click();
        this.objOrderPage.getRentalPeriod().click();
        this.objOrderPage.getRentalDays().click();
        return this;
    }
}

