package model;

public interface IRoom
{
//All interface methods are public by default. So, you can remove the public access modifier from these methods
    enum RoomType {SINGLE,DOUBLE}
    String getRoomNumber();
    double getRoomPrice();
    RoomType getRoomType();
    boolean isFree();
}