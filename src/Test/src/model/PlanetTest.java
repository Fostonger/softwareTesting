package model;

import model.helpers.TimerStub;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlanetTest {
    private Planet lastPlanet;
    private TimerStub timerStub;
    private Creature they;
    private Object realWorld;
    @BeforeEach
    void setUp() {
        timerStub = new TimerStub();
        lastPlanet = new Planet(timerStub);
        they = new Creature() {};
        timerStub.subscribeToTimer(()->{
            they.setAction(Action.APPEAR, realWorld = new Object());
        }, 60);
    }
    @AfterEach
    void tearDown() {
        timerStub = null;
        lastPlanet = null;
        they = null;
        realWorld = null;
    }
    @Test
    void lastPlanetShouldBeVisibleAtStart() {
        assertFalse(lastPlanet.isDisappeared);
    }
    @Test
    void theyShouldntHaveActionAtStart() {
        assertNull(they.getAction());
        assertNull(they.getSubject());
    }
    @Test
    void timerShouldWork() {
        assertTrue(timerStub.isExecuting);
    }
    @Test
    void lastPlanetShouldDisappearAfterMinute() {
        timerStub.executeCompletions();
        assertTrue(lastPlanet.isDisappeared);
    }
    @Test
    void theyShouldAppearInRealWorldAfterMinute() {
        timerStub.executeCompletions();
        assertEquals(they.getAction(), Action.APPEAR);
        assertEquals(they.getSubject(), realWorld);
    }
    @Test
    void timerShouldStopAfterExecution() {
        timerStub.executeCompletions();
        assertFalse(timerStub.isExecuting);
    }
}