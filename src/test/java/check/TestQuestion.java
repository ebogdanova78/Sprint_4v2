package check;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.HomePage;

@RunWith(Parameterized.class)
public class TestQuestion {
    public static ChromeDriver driver;
    public static HomePage objHomePage;
    private final String checkedText;
    private final int index;

    public TestQuestion(String checkedText, int index) {
        this.checkedText = checkedText;
        this.index = index;
    }

    @Parameters
    public static Object[][] getTestData() {
        return new Object[][]{{"Сутки — 400 рублей. Оплата курьеру — наличными или картой.", 0},
                {"Пока что у нас так: один заказ — один самокат.", 1},
                {"Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру.", 2},
                {"Только начиная с завтрашнего дня.", 3},
                {"всегда можно позвонить в поддержку по красивому номеру 1010.", 4},
                {"Самокат приезжает к вам с полной зарядкой.", 5},
                {"Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", 6},
                {"Да, обязательно. Всем самокатов! И Москве, и Московской области.", 7}
        };
    }

    @Test
    public void checkingQuestions() {
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ebogdanova.OPENINTEGRATION\\WebDriver\\bin\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomePage objHomePage = new HomePage(driver);
        objHomePage.getCookie().click();
        objHomePage.getQuestion().click();
        objHomePage.click((WebElement)objHomePage.getListQuestions().get(this.index));
        MatcherAssert.assertThat(((WebElement)objHomePage.getListAnswers().get(this.index)).getText(), JUnitMatchers.containsString(this.checkedText));
        driver.quit();
    }
}

