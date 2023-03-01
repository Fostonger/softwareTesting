package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Enumeration;
import java.util.Hashtable;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {
    private Reception sut;
    private Creature they;
    @BeforeEach
    void setUp() {
        they = new Creature() {};
        sut = Reception.getReception();
        they.setAction(Action.SIT_IN, sut);
    }
    @AfterEach
    void tearDown() {
        sut = null;
        they = null;
    }
    @Test
    void theyShouldSitInReception() {
        assertEquals(they.getAction(), Action.SIT_IN);
        assertEquals(they.getSubject(), sut);
    }
    @Test
    void receptionShouldHaveTableFurnitureAndRewards() {
        var contents = sut.getContent();
        var validContent = getValidObjects();
        Enumeration<String> keys = contents.keys();
        while(keys.hasMoreElements()) {
            String name = keys.nextElement();
            assertTrue(validContent.containsKey(name));
        }
    }
    @Test
    void receptionShouldHaveGlassyTableAndPlushyFurniture() {
        var contents = sut.getContent();
        var validContent = getValidObjects();
        Enumeration<String> keys = contents.keys();
        while(keys.hasMoreElements()) {
            String name = keys.nextElement();
            if (contents.get(name).getClass() == Furniture.class && validContent.containsKey(name)) {
                Furniture expected = (Furniture) validContent.get(name);
                Furniture found = (Furniture) contents.get(name);
                assertEquals(expected.getTexture(), found.getTexture());
            }
        }
    }

    private Hashtable<String, Object> getValidObjects() {
        Hashtable<String, Object> content = new Hashtable();
        content.put("furniture", new Furniture(Texture.PLUSH));
        content.put("tables", new Furniture(Texture.GLASS));
        content.put("rewards", new Rewards());
        return content;
    }
}