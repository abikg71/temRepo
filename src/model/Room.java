package model;

import java.util.Objects;

public class Room implements IRoom {
    private final String roomNumber;
    protected final Double roomPrice;
    private final RoomType roomType;

    public Room(String roomNumber, Double roomPrice, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.roomPrice = roomPrice;
        this.roomType = roomType;
    }

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public double getRoomPrice() {
        return roomPrice;
    }

    @Override
    public RoomType getRoomType() {
        return null;
    }

    @Override
    public boolean isFree() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return Objects.equals(roomNumber, room.roomNumber) && Objects.equals(roomPrice, room.roomPrice) &&
                roomType == room.roomType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomNumber, roomPrice, roomType);
    }

    @Override
    public String toString() {
        return "Room{" + "roomNumber: '" + roomNumber + '\'' +
                ", roomPrice: " + roomPrice + ", roomType: " + roomType + '}' + " \n";
    }
}



