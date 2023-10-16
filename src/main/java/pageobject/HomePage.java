package pageobject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;
    private final By headingQuestion = By.xpath("//div[text() = 'Вопросы о важном']");
    private final By acceptCookieButton = By.id("rcc-confirm-button");
    public static final By orderButtonTop = By.xpath("//*[@class='Button_Button__ra12g']");
    public static final By orderButtonDown = By.xpath("//button[contains(@class, 'Button_Middle')]");
    private final By listQuestion = By.xpath("//*[@class='accordion__button']");
    private final By listAnswer = By.xpath("//div[@data-accordion-component='AccordionItemPanel']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage() {
    }

    public WebElement getQuestion() {
        return this.driver.findElement(this.headingQuestion);
    }

    public WebElement getCookie() {
        return this.driver.findElement(this.acceptCookieButton);
    }

    public HomePage scroll(WebElement element) {
        ((JavascriptExecutor)this.driver).executeScript("arguments[0].scrollIntoView();", new Object[]{element});
        return this;
    }

    public HomePage click(WebElement element) {
        this.scroll(element);
        element.click();
        return this;
    }

    public HomePage click2(By elementLokator) {
        WebElement element = this.driver.findElement(elementLokator);
        this.scroll(element);
        element.click();
        return this;
    }

    public List<WebElement> getListQuestions() {
        return this.driver.findElements(this.listQuestion);
    }

    public List<WebElement> getListAnswers() {
        return this.driver.findElements(this.listAnswer);
    }
}
