package model;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.List;

public class Timer implements TimeTracker {
    private List<Subscribable> completions = new ArrayList<Subscribable>();
    private boolean isExecuting = false;
    @Override
    public void subscribeToTimer(Subscribable completion, int delay) {
        completions.add(completion);
        if (isExecuting) return;
        try {
            isExecuting = true;
            Thread.sleep(delay*1000);
            for (Subscribable complete: completions) {
                complete.doAction();
            }
            completions.clear();
            isExecuting = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
