package LessonSix.Tests;
import LessonFive.BaseTest;
import LessonSix.MainPages.MainFiltersPage;
import org.junit.jupiter.api.Test;

public class FiltersAndProductComparisonTest extends BaseTest {

    @Test
    void PositiveFilterTest(){
        webDriver.get(URL);

        new MainFiltersPage(webDriver).clickSubmenuLaptops()
                .clickOnParameterInTheFilter()
                .moveToElementAndClick()
                .selectAndClickBrandInTheFilter()
                .moveToChosenModifications()
                .chooseTwoOptionsForComparison()
                .clickTheCompareButton();

    }

}
