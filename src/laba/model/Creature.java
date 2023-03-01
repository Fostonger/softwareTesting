package model;
public abstract class Creature {
    private Action action;
    private Object interactionSubject;
    public Object getSubject() {
        return interactionSubject;
    }
    public Action getAction() {
        return action;
    }
    public void setAction(Action action, Object subject) {
        this.action = action;
        this.interactionSubject = subject;
    }
}
