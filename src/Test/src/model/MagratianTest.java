package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MagratianTest {
    private Creature they;
    private Magratian sut;
    @BeforeEach
    void setUp() {
        they = new Creature() {};
        sut = new Magratian(they);
    }
    @AfterEach
    void tearDown() {
        they = null;
        sut = null;
    }
    @Test
    void magratianShouldStandInFrontOfThem() {
        assertEquals(sut.getAction(), Action.STAND_IN_FRONT_OF);
        assertEquals(sut.getSubject(), they);
    }
}