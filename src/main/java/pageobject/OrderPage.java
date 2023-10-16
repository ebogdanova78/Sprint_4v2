package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
    private WebDriver driver;
    private final By inputName = By.xpath("//input[@placeholder='* Имя']");
    private final By inputSurname = By.xpath("//input[@placeholder='* Фамилия']");
    private final By inputAddress = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By inputMetroStation = By.xpath("//input[@placeholder='* Станция метро']");
    private final By inputPhoneNumber = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nextButton = By.cssSelector(".Button_Button__ra12g.Button_Middle__1CSJM");
    private final By inputDateCalendar = By.xpath("//input[@placeholder ='* Когда привезти самокат']");
    private final By inputDate = By.xpath("//div[contains(@class, 'day--today')]");
    private final By inputRentalPeriod = By.xpath("//*[@class='Dropdown-placeholder']");
    private final By inputRentalDays = By.xpath("//div[@class='Dropdown-menu']/div[text() = 'двое суток']");
    private final By checkboxColour = By.id("grey");
    private final By inputComment = By.xpath("//input[@placeholder ='Комментарий для курьера']");
    private final By orderButton = By.xpath("//div[@class='Order_Buttons__1xGrp']//button[contains(text(), 'Заказать')]");
    private final By confirmationButton = By.xpath("//button[contains(text(), 'Да')]");
    public final By orderConfirmedHeader = By.xpath("//div[(text()= 'Заказ оформлен')]");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getName() {
        return this.driver.findElement(this.inputName);
    }

    public WebElement getSurname() {
        return this.driver.findElement(this.inputSurname);
    }

    public WebElement getAddress() {
        return this.driver.findElement(this.inputAddress);
    }

    public WebElement getMetroStation() {
        return this.driver.findElement(this.inputMetroStation);
    }

    public WebElement getPhoneNumber() {
        return this.driver.findElement(this.inputPhoneNumber);
    }

    public WebElement getCalendar() {
        return this.driver.findElement(this.inputDateCalendar);
    }

    public WebElement getDate() {
        return this.driver.findElement(this.inputDate);
    }

    public WebElement getRentalPeriod() {
        return this.driver.findElement(this.inputRentalPeriod);
    }

    public WebElement getRentalDays() {
        return this.driver.findElement(this.inputRentalDays);
    }

    public WebElement getColour() {
        return this.driver.findElement(this.checkboxColour);
    }

    public WebElement getComment() {
        return this.driver.findElement(this.inputComment);
    }

    public WebElement getNextButton() {
        return this.driver.findElement(this.nextButton);
    }

    public WebElement getOderButton() {
        return this.driver.findElement(this.orderButton);
    }

    public WebElement getConfirmationButton() {
        return this.driver.findElement(this.confirmationButton);
    }

    public boolean isDisplayed(By by) {
        try {
            return this.driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException var3) {
            return false;
        }
    }
}

