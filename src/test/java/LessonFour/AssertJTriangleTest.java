 package LessonFour;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import LessonFour.Providers.InvalidTriangleProvider;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

@DisplayName("Треугольник")
    public class AssertJTriangleTest {

    @BeforeEach
    void setUp() {
        System.out.println("BeforeEach");
    }

    @AfterEach
    void tearDown() {
        System.out.println("AfterEach");
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("BeforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("AfterAll");
    }


    @Test
    @DisplayName("Разносторонний треугольник - все стороны которого имеют разную длину.")
    public void countPerimeterVersatileTriangleTest() {
        Triangle triangle = new Triangle(6, 8, 10); //Arrange
        int perimeter = triangle.countArea(); //Act
        assertEquals(24, perimeter); //Assert
    }

    @Test
    @DisplayName("Равносторонний треугольник - у которого все три стороны равны.")
    public void countPerimeterEquilateralTriangleTest() {
        Triangle triangle = new Triangle(6, 6, 6); //Arrange
        int perimeter = triangle.countArea(); //Act
        assertEquals(15, perimeter); //Assert
    }

    @Test
    @DisplayName("Равнобедренный треугольник - у которого две стороны равны")
    public void countIsoscelesTriangleTest() {
        Triangle triangle = new Triangle(7, 7, 10); //Arrange
        int perimeter = triangle.countArea(); //Act
        assertEquals(24, perimeter); //Assert
    }


    public static Stream<Arguments> triangles() {
        return Stream.of(Arguments.of(new Triangle(6, 8, 10), 24),
                Arguments.of(new Triangle(6, 6, 6), 15),
                Arguments.of(new Triangle(7, 7, 10), 24)
        );
    }

    @ParameterizedTest(name = "Периметр треугольника {0} равен {1}")
    @MethodSource("triangles")
    public void countPerimeterTriangleTest(Triangle triangle, int expectedPerimeter) {
        int perimeter = triangle.countArea(); //Act
        assertEquals(expectedPerimeter, perimeter); //Assert
    }

    @ParameterizedTest(name = "Перекрашивание треугольника из {0} в {1}")
    @CsvSource({"RED, GREEN", "GREEN, BLUE"})
    public void paintTriangleWithCsvSourceTest(Triangle.Colour colourBefore, Triangle.Colour colourAfter) {
        Triangle triangle = new Triangle(3, 3, 3, colourBefore); //arrange
        triangle.paint(colourAfter);
        assertEquals(colourAfter, triangle.getColour()); //Assert
    }

    @ParameterizedTest
    @ArgumentsSource(InvalidTriangleProvider.class)
    public void perimeterInvalidTriangleNegativeTestTest(Triangle triangle) {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
        assertEquals("The triangle must be valid", illegalArgumentException.getMessage());
    }


    @Nested
    class PaintTriangleTest {
        Triangle triangle;

        @BeforeEach
        void setUp() {
            triangle = new Triangle(3, 3, 3);
        }

        @ParameterizedTest(name = "Перекрашивание треугольника в {0}")
        @EnumSource(Triangle.Colour.class)
        public void paintTriangleTest(Triangle.Colour colour) {
            assumeFalse(colour.equals(triangle.getColour()));
            triangle.paint(colour);
            assertEquals(colour, triangle.getColour()); //Assert
        }

        @ParameterizedTest(name = "Перекрашивание треугольника в {0}")
        @ValueSource(strings = {"RED", "GREEN"})
        public void paintTriangleWithValueSourceTest(String colour) {
            triangle.paint(colour);
            assertEquals(Triangle.Colour.valueOf(colour), triangle.getColour()); //Assert
        }

    }

    @Test
    void listWithAssertJTest() {
        Triangle triangle = new Triangle(1, 1, 1);
        List<Triangle> similarTriangle = triangle.createSimilarTriangles(2, 3);

        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(similarTriangle).contains(new Triangle(2, 2, 3));
        softAssertions.assertThat(similarTriangle).contains(new Triangle(3, 2, 3));
        softAssertions.assertThat(similarTriangle).hasSize(3);
        softAssertions.assertAll();
//     можно заменить на это   assertThat(similarTriangles).containsExactlyInAnyOrder(new Triangle(2, 2, 2), new Triangle(3, 3, 3));
    }
}