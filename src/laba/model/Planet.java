package model;

public class Planet {
    private TimeTracker timer;
    public Planet(TimeTracker timer) {
        this.timer = timer;
        timer.subscribeToTimer(() -> {
            isDisappeared = true;
        }, 60);
    }
    public boolean isDisappeared = false;
}