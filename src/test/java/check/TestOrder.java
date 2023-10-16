package check;

import orderfilling.OrderFilling;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.HomePage;
import pageobject.OrderPage;

@RunWith(Parameterized.class)
public class TestOrder {
    public ChromeDriver driver;
    public OrderPage objOrderPage;
    public HomePage objHomePage;
    public OrderFilling objOrderFilling;
    private final String name;
    private final String surname;
    private final String address;
    private final String phoneNumber;
    private final String station;
    private final String comment;
    private final By clickOrderButton;

    public TestOrder(String name, String surname, String address, String phoneNumber, String station, String comment, By clickOrderButton) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.station = station;
        this.comment = comment;
        this.clickOrderButton = clickOrderButton;
    }

    @Parameters
    public static Object[][] getData() {
        HomePage homePage = new HomePage();
        return new Object[][]{{"Иван", "Иванов", "112233, г Москва, ул Ивановская, д 11", "81234567890", "Спартак", "Комментарий 1", HomePage.orderButtonTop}, {"Сергей", "Сергеевич", "445566, г Тюмень, ул Пушкина, д 17", "87945612322", "Беговая", " Комментарий 2", HomePage.orderButtonDown}};
    }

    @Test
    public void orderCreation() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ebogdanova.OPENINTEGRATION\\WebDriver\\bin\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        this.driver = new ChromeDriver(options);
        this.driver.get("https://qa-scooter.praktikum-services.ru/");
        this.objOrderPage = new OrderPage(this.driver);
        this.objHomePage = new HomePage(this.driver);
        this.objOrderFilling = new OrderFilling(this.driver);
        this.objHomePage.getCookie().click();
        this.objHomePage.click2(this.clickOrderButton);
        this.objOrderFilling.OrderFilling_part1(this.name, this.surname, this.address, this.phoneNumber, this.station);
        this.objHomePage.click(this.objOrderPage.getNextButton());
        this.objOrderFilling.OrderFilling_part2();
        this.objOrderPage.getColour().click();
        this.objOrderPage.getComment().sendKeys(new CharSequence[]{this.comment});
        this.objOrderPage.getOderButton().click();
        this.objOrderPage.getConfirmationButton().click();
        Assert.assertTrue("Отсутствует сообщение об успешном завершении заказа", this.objOrderPage.isDisplayed(this.objOrderPage.orderConfirmedHeader));
        this.driver.quit();
    }
}