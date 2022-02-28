package LessonSeven.Tests;

import LessonFive.BaseTest;
import LessonSeven.MainPages.MainLocationPage;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Изменение локации, региона, города")
public class LocationChangeRegionCityTest extends BaseTest {

    @Test
    @Description("В этом тесте проверяется исправности локации!")
    @Severity(SeverityLevel.CRITICAL)


    void ChangeLocationTest() {
        webDriver.get(URL);

        new MainLocationPage(webDriver).ClickOnTheLocationButton()
                .clickTheRegionButtonChange()
                .moveAndClickTheCityButton()
                .clickAndChangeTheCity()
                .waitUntilCityChanges();
    }


}
