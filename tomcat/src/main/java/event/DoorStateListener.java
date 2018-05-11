package event;

import java.util.EventListener;

public class DoorStateListener implements EventListener {
    public void doorEvent(Door1Event event) {
        if (event.getValue() != null && event.getValue().equals("open")) {
            System.out.println("door 1 open");
        } else {
            System.out.println("door 1 close");
        }
    }
}