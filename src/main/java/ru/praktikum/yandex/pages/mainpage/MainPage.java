package ru.praktikum.yandex.pages.mainpage;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import ru.praktikum.yandex.pages.orderpage.OrderPage;

import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    public static String URL = "https://qa-scooter.praktikum-services.ru/";

    // Иконка Яндекса
    @FindBy(how = How.XPATH, using = "//img[@alt='Yandex']")
    private SelenideElement yandexImg;

    // Иконка Самокат
    @FindBy(how = How.XPATH, using = "//img[@alt='Scooter']")
    private SelenideElement scooterHeaderImg;

    // Текст Учебный тренажер
    @FindBy(how = How.CLASS_NAME, using = "Header_Disclaimer__3VEni")
    private SelenideElement trainText;

    // Заголовок
    @FindBy(how = How.CLASS_NAME, using = "Home_Header__iJKdX")
    private SelenideElement mainHeader;

    // Заголовок "Как это работает"
    @FindBy(how = How.CLASS_NAME, using = "Home_SubHeader__zwi_E")
    private SelenideElement subHeader;

    // Степперы "Как это работает"
    @FindBy(how = How.CLASS_NAME, using = "Home_StatusInfo__HrjoZ")
    private ElementsCollection steppers;

    // Кнопка "Заказать"
    @FindBy(how = How.XPATH, using = "//div/div[1]/div[2]/button[1]")
    private  SelenideElement topOrderButton;

    // Кнопка "Заказать" внизу страницы
    @FindBy(how = How.XPATH, using = "//div/div[1]/div[4]/div[2]/div[5]/button")
    private  SelenideElement bottomOrderButton;

    // Заголовок "Вопросы о важном"
    @FindBy(how = How.CLASS_NAME, using = "//*[@id='root']/div/div[1]/div[5]/div[1]")
    private SelenideElement questionsHeader;

    // Список вопросов
    @FindBy(how = How.CLASS_NAME, using = "accordion__item")
    private ElementsCollection questions;

    // Кнопка "Статус заказа"
    @FindBy(how = How.XPATH, using = "//button[text()='Статус заказа']")
    private  SelenideElement orderStatusButton;

    // Картинка с самокатом
    @FindBy(how = How.XPATH, using = "//*/div[1]/div[2]/div[2]/img")
    private SelenideElement scooterImage;

    // Текст алерта с куками
    @FindBy(how = How.CLASS_NAME, using = "App_CookieText__1sbqp")
    private SelenideElement cookieText;

    // Кнопка согласия с использование cookie's
    @FindBy(how = How.ID, using = "rcc-confirm-button")
    private  SelenideElement cookieConfirmButton;

    public OrderPage topOrderButtonClick() {
        topOrderButton.click();
        return page(OrderPage.class);
    }

    public OrderPage bottomOrderButtonClick() {
        bottomOrderButton.scrollIntoView(true).click();
        return page(OrderPage.class);
    }

    public ElementsCollection getQuestionsList() {
        return questions;
    }
}
