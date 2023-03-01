package model;

import java.util.Hashtable;

public class Room {
    private Hashtable<String, Object> content;
    public Room(Hashtable<String, Object> content) {
        this.content = content;
    }

    public Room() {
    }

    public Hashtable<String, Object> getContent() {
        return content;
    }
}
