package LessonFour;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import LessonFour.Providers.InvalidTriangleProvider;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@DisplayName("Треугольник")
    public class TriangleTest {

    private static final Logger logger = LoggerFactory.getLogger(TriangleTest.class);

    @BeforeEach
    void setUp() {
        logger.debug("BeforeEach");
    }

    @AfterEach
    void tearDown() {
        logger.debug("AfterEach");
    }

    @BeforeAll
    static void beforeAll() {
        logger.debug("BeforeAll");
    }

    @AfterAll
    static void afterAll() {
        logger.debug("AfterAll");
    }

    @Test
    @DisplayName("Разносторонний треугольник - все стороны которого имеют разную длину.")
    public void countPerimeterVersatileTriangleTest() {
        Triangle triangle = new Triangle(6, 8, 10);
        int perimeter = triangle.countArea();
        assertEquals(24, perimeter);
    }

    @Test
    @DisplayName("Равносторонний треугольник - у которого все три стороны равны.")
    public void countPerimeterEquilateralTriangleTest() {
        Triangle triangle = new Triangle(6, 6, 6);
        int perimeter = triangle.countArea();
        assertEquals(15, perimeter);
    }

    @Test
    @DisplayName("Равнобедренный треугольник - у которого две стороны равны")
     public void countIsoscelesTriangleTest() {
        Triangle triangle = new Triangle(7, 7, 10);
        int perimeter = triangle.countArea();
        assertEquals(24, perimeter);
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
            Assumptions.assumeFalse(colour.equals(triangle.getColour()));
            triangle.paint(colour);
            assertEquals(colour, triangle.getColour()); //Assert
        }

        @ParameterizedTest(name = "Перекрашивание треугольника в {0}")
        @ValueSource(strings = {"RED", "GREEN"})
        public void paintTriangleWithValueSourceTest(String colour) {
            triangle.paint(colour);
            assertEquals(Triangle.Colour.valueOf(colour), triangle.getColour()); //Assert
        }


        @ParameterizedTest
        @ArgumentsSource(InvalidTriangleProvider.class)
        public void perimeterInvalidTriangleNegativeTest(Triangle triangle) {
            IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, triangle::countPerimeter);
            assertEquals("The triangle must be valid", illegalArgumentException.getMessage());


        }
    }
}
