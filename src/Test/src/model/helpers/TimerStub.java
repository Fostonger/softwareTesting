package model.helpers;

import model.TimeTracker;

import java.util.ArrayList;
import java.util.List;

public class TimerStub implements TimeTracker {
    private List<Subscribable> completions = new ArrayList<>();
    public boolean isExecuting = false;
    @Override
    public void subscribeToTimer(Subscribable completion, int delay) {
        completions.add(completion);
        isExecuting = true;
    }
    public void executeCompletions() {
        for (Subscribable complete: completions) {
            complete.doAction();
        }
        completions.clear();
        isExecuting = false;
    }
}
