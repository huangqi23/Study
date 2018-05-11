package event;

import java.util.EventObject;

public class Door1Event extends EventObject {
    private static final long serialVersionUID = 6496098798146410884L;

    private final String key ;
    private final String value  ;

    public Door1Event(Object source,String key , String value) {
        super(source);
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }
}