package model;

import java.lang.reflect.Executable;

public interface TimeTracker {
    void subscribeToTimer(Subscribable completion, int delay);
    public interface Subscribable {
        void doAction();
    }
}
