package q02_associationCompositionAggregation;

// CompositionExample.java

class Room {
    String type;

    Room(String type) {
        this.type = type;
    }

    void display() {
        System.out.println("Room type: " + type);
    }
}

// House contains a Room, and Room doesn’t exist without House.
class House {
    private Room room;

    House() {
        // Room is created within House: Strong ownership
        // in the default constructor
        this.room = new Room("Bedroom");
    }

    void showRoom() {
        room.display();
    }
}

public class CompositionDemo {
    public static void main(String[] args) {
        House house = new House();
        house.showRoom();
    }
}

/*
output:
    Room type: Bedroom
 */