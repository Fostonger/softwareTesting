package function;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;
class ArccosTest {
    private Arccos sut;
    @BeforeEach
    void setUp() {
        sut = new Arccos();
    }
    @AfterEach
    void tearDown() {
        sut = null;
    }
    @ParameterizedTest(name = "{index}: arccos({0}) = {2}")
    @CsvFileSource(resources = "/arccosTest.csv", numLinesToSkip = 1)
    void arccosTest(double x, int n, double expected, double delta) {
        assertEquals(expected, sut.computeSeries(x,n), delta);
    }
}