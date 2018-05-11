package event;

public class Door1Test {
    public static void main(String[] args) {

        Door1 door = new Door1();
        door.setStateListener(new DoorStateListener());
        door.setNameListener(new DoorNameListener());
        // 开门
        door.setState("open");
        System.out.println("I'm coming");
        // 关门
        door.setState("close");
    }
}