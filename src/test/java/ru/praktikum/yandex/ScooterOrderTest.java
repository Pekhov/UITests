package ru.praktikum.yandex;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.praktikum.yandex.pages.confirmorderpage.ConfirmOrderPage;
import ru.praktikum.yandex.pages.finalorderpage.FinalOrderPage;
import ru.praktikum.yandex.pages.mainpage.MainPage;
import ru.praktikum.yandex.pages.orderpage.OrderPage;
import ru.praktikum.yandex.pages.rentpage.RentPage;
import ru.praktikum.yandex.pages.statusorderpage.StatusOrderPage;

import static com.codeborne.selenide.Selenide.open;

public class ScooterOrderTest {

    MainPage mainPage;

    @BeforeEach
    public void setUp() {
        mainPage = open(MainPage.URL, MainPage.class);
    }

    @Test
    public void topOrderButtonTest() {
        OrderPage orderPage = mainPage.topOrderButtonClick();
        RentPage rentPage = orderPage.setName("Василий")
                .setSurName("Алибаббаевич")
                .setAddress("г. Москва")
                .setMetroStation("Черкизовская")
                .setPhoneNumber("+79161111111")
                .nextButtonClick();
        ConfirmOrderPage confirmOrderPage = rentPage.setDateFieldWithFirstDay()
                .selectRentOption("сутки")
                .selectScooterColor("чёрный жемчуг")
                .setComment("Комментарий")
                .makeOrderButtonClick();
        FinalOrderPage finalOrderPage = confirmOrderPage.yesButtonClick();
        StatusOrderPage statusOrderPage = finalOrderPage.showStatusButtonClick();
        Assertions.assertTrue(statusOrderPage.isCancelButtonDisplayed(), "Заказ не оформлен");
    }

    @Test
    public void bottomOrderButtonTest() {
        OrderPage orderPage = mainPage.bottomOrderButtonClick();
        RentPage rentPage = orderPage.setName("Николай")
                .setSurName("Валуев")
                .setAddress("г. Саратов")
                .setMetroStation("Сокольники")
                .setPhoneNumber("+79105123465")
                .nextButtonClick();
        ConfirmOrderPage confirmOrderPage = rentPage.setDateField("27.09.2021")
                .selectRentOption("двое суток")
                .selectScooterColor("серая безысходность")
                .setComment("Комментарий еще один")
                .makeOrderButtonClick();
        FinalOrderPage finalOrderPage = confirmOrderPage.yesButtonClick();
        StatusOrderPage statusOrderPage = finalOrderPage.showStatusButtonClick();
        Assertions.assertTrue(statusOrderPage.isCancelButtonDisplayed(), "Заказ не оформлен");
    }
}