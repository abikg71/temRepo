package model;

public abstract class FreeRoom extends Room {

    public FreeRoom(String roomNumber, RoomType roomType) {
        super(roomNumber, 0.0, roomType);
    }

    @Override
    public String toString() {
        return "FreeRoom{" + "price=" + roomPrice + '}';
    }
}
