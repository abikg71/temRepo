package model;
import service.ReservationService;

import java.util.Collection;
import java.util.Date;

import static service.ReservationService.rooms;

public class Reservation {

private final Customer customer;
private final IRoom room;
private final Date checkInDate;
private final Date checkOutDate;

public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        this.customer = customer;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public IRoom getARoom (Collection<IRoom> roomId)
    {
        for (IRoom room : rooms) {
            if (roomId.equals(room.getRoomNumber()))
            {return room;}
        }
        return null;
    }
    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public boolean IsRoomAvailable(Reservation reservation){
    if (this.room.getRoomNumber() == reservation.room.getRoomNumber())
    {return checkInDate.compareTo(reservation.checkInDate) * reservation.checkInDate.compareTo(checkInDate) > 0;}

    else return true;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "customer=" + customer + ", room: " + room +
                ", checkInDate: " + checkInDate + ", checkOutDate: " + checkOutDate + '}'+" \n\n";
    }


}
