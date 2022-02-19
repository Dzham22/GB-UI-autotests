package LessonSix.Tests;

import LessonFive.BaseTest;
import LessonSix.MainPages.MainProductSearchPage;
import org.junit.jupiter.api.Test;

public class ProductSearchTest extends BaseTest {


    @Test
    void ProductSearchTest() {
        webDriver.get(URL);

       new MainProductSearchPage(webDriver).clickInTheSearchField()
                              .enterAValueInTheSearch()
                              .clickSearchButton()
                              .moveToAccordeonElement()
                              .chooseOneOfTheCheckboxOptions()
                              .moveAndSelectDeliveryCheckbox();

   }


}
