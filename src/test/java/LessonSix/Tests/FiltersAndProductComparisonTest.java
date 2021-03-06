package LessonSix.Tests;
import LessonFive.BaseTest;
import LessonSix.MainPages.MainFiltersPage;
import org.junit.jupiter.api.Test;


public class FiltersAndProductComparisonTest extends BaseTest {

    @Test
    void FilterTest(){
        webDriver.get(URL);

        new MainFiltersPage(webDriver).clickSubmenuLaptops()
                .clickOnParameterInTheFilter()
                .moveToElementAndClick()
                .findTheBrandAndClick()
                .selectAndClickTheFilterButton()
                .moveToChosenModifications()
                .chooseTwoOptionsForComparison()
                .clickTheCompareButton();
    }

}
