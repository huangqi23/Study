package ex06.pyrmont.core;

import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleEvent;
import org.apache.catalina.LifecycleListener;

public class MyListener implements LifecycleListener {

    public void lifecycleEvent(LifecycleEvent event) {
        Lifecycle lifecycle = event.getLifecycle();
        System.out.println("MyListener's event " +
                event.getType().toString());
        if (Lifecycle.START_EVENT.equals(event.getType())) {
            System.out.println("MyListener Starting context.");
        }
        else if (Lifecycle.STOP_EVENT.equals(event.getType())) {
            System.out.println("MyListener Stopping context.");
        }
    }
}