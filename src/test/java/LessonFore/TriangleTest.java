package LessonFore;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import LessonFore.Providers.InvalidTriangleProvider;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Треугольник")
    public class TriangleTest {

    @Test
    @DisplayName("Разносторонний треугольник - все стороны которого имеют разную длину.")
    @Disabled("Перенесены в параметризированный тест")
       public void countPerimeterVersatileTriangleTest() {
       Triangle triangle = new Triangle(6, 8, 10);
       double perimeter = triangle.countArea();
       assertEquals(24, perimeter);
   }

    @Test
    @DisplayName("Равносторонний треугольник - у которого все три стороны равны.")
    @Disabled("Перенесены в параметризированный тест")
    public void countPerimeterEquilateralTriangleTest() {
        Triangle triangle = new Triangle(6, 6, 6);
        int perimeter = triangle.countArea();
        assertEquals(15, perimeter);
    }

    @Test
    @DisplayName("Равнобедренный треугольник - у которого две стороны равны")
    @Disabled("Перенесены в параметризированный тест")
    public void countIsoscelesTriangleTest() {
        Triangle triangle = new Triangle(7, 7, 10);
        int perimeter = triangle.countArea();
        assertEquals(24, perimeter);
    }


    @ParameterizedTest
    @ArgumentsSource(InvalidTriangleProvider.class)
    public void perimeterInvalidTriangleNegativeTest(Triangle triangle) {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countArea);
        assertEquals("The triangle must be valid", illegalArgumentException.getMessage());
    }



}

