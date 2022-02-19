package LessonSix.Tests;

import LessonFive.BaseTest;
import LessonSix.MainPages.MainLocationPage;
import org.junit.jupiter.api.Test;

public class LocationChangeRegionCityTest extends BaseTest {

    @Test
    void ChangeLocationTest() {
        webDriver.get(URL);

        new MainLocationPage(webDriver).ClickOnTheLocationButton()
                .clickTheRegionButtonChange()
                .moveAndClickTheCityButton()
                .clickAndChangeTheCity()
                .waitUntilCityChanges();

    }


}
