package ru.praktikum.yandex;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.praktikum.yandex.pages.mainpage.MainPage;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.text.IsEmptyString.isEmptyString;

public class QuestionsTest {

    MainPage mainPage;

    @BeforeEach
    public void setUp() {
        Configuration.holdBrowserOpen = true;
        mainPage = open(MainPage.URL, MainPage.class);
    }

    @Test
    public void questionsTextShouldNotBeEmpty() {
        ElementsCollection questions = mainPage.getQuestionsList();
        for(SelenideElement question : questions) {
            question.scrollIntoView(true).click();
            assertThat(question.$(By.className("accordion__panel")).shouldBe(Condition.visible).getText(), not(isEmptyString()));
        }
    }
}
