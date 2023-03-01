package model;

public class Magratian extends Creature {
    public Magratian(Object subject) {
        super();
        setAction(Action.STAND_IN_FRONT_OF, subject);
    }
}
