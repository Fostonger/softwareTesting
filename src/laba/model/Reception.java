package model;

import java.util.Hashtable;
import java.util.Objects;

public class Reception extends Room {
    private Reception(Hashtable<String, Object> content) {
        super(content);
    }
    public static Reception getReception() {
        Hashtable<String, Object> content = new Hashtable();
        content.put("furniture", new Furniture(Texture.PLUSH));
        content.put("tables", new Furniture(Texture.GLASS));
        content.put("rewards", new Rewards());
        return new Reception(content);
    }
}
