package algorithm;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShellSortTest {
    private ShellSort sut;
    @BeforeEach
    void setUp() {
        sut = new ShellSort();
    }
    @AfterEach
    void tearDown() {
        sut = null;
    }
    @Test
    void sortEmptyArrayShouldReturnEmptyArray() {
        int[] array = {};
        sut.sort(array);
        int[] expected = {};

        assertArrayEquals(expected, array);
    }
    @Test
    void sortOneElementArrayShouldReturnOneElementArray() {
        int[] array = {1};
        sut.sort(array);
        int[] expected = {1};

        assertArrayEquals(expected, array);
    }

    @Test
    void sortManyOnesArrayShouldReturnManyOnesArray() {
        int[] array = {1, 3, 1, 4, 1, 10, 1};
        sut.sort(array);
        int[] expected = {1, 1, 1, 1, 3, 4, 10};

        assertArrayEquals(expected, array);
    }
    @Test
    void sortSortedArrayShouldReturnTheSameArray() {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        sut.sort(array);
        int[] expected = {1, 2, 3, 4, 5, 6, 7};

        assertArrayEquals(expected, array);
    }
    @Test
    void sortBackverseSortedArrayShouldReturnSortedArray() {
        int[] array = {7, 6, 5, 4, 3, 2, 1};
        sut.sort(array);
        int[] expected = {1, 2, 3, 4, 5, 6, 7};

        assertArrayEquals(expected, array);
    }
    @Test
    void sortHalfsortedArrayShouldReturnSortedArray() {
        int[] array = {7, 6, 5, 1, 2, 3, 4};
        sut.sort(array);
        int[] expected = {1, 2, 3, 4, 5, 6, 7};

        assertArrayEquals(expected, array);
    }
    @Test
    void sortAllOnesArrayShouldReturnAllOnesArray() {
        int[] array = {1, 1, 1, 1, 1, 1, 1};
        sut.sort(array);
        int[] expected = {1, 1, 1, 1, 1, 1, 1};

        assertArrayEquals(expected, array);
    }
}