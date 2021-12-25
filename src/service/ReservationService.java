package service;
import model.Customer;
import model.IRoom;
import model.Reservation;
import java.util.*;

public class ReservationService {

    private static ReservationService reservationService;
    public static Collection<Reservation> reservations = new HashSet<>();
    public static Collection<IRoom> rooms = new HashSet<>();
    private ReservationService() {}

    public static ReservationService getInstance(){
        if (reservationService == null){
            reservationService = new ReservationService();
        }
        return reservationService;
    }

    public static boolean reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        Reservation reservedRoom = new Reservation(customer,room,checkInDate, checkOutDate);

        if(reservations.size() == 0){
            reservations.add(reservedRoom);
            return true;
        }

        boolean returnValue = false;
        for(int x = 0; x < reservations.size(); x++){
            boolean  available =  reservedRoom.IsRoomAvailable((Reservation) reservations.toArray()[x]);
           if(available){
               reservations.add(reservedRoom);
               returnValue = true;
           }
           else {
               continue;
           }
        }
        return  returnValue;

    }
    /*  Not My Code
// Ref://https://knowledge.udacity.com/questions/718863
    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        Collection<IRoom> availableRooms = new ArrayList<>();
        for (IRoom room : getAllRooms()){
            if (isRoomFree(room, checkInDate, checkOutDate)){
                availableRooms.add(room);
            }
        }return availableRooms;
    }
 // TODO 51-64???
    private static boolean isRoomFree(IRoom room, Date checkInDate, Date checkOutDate){
        if (reservations.isEmpty())
            return true;
        for (Reservation reservation : reservations){
          IRoom reservedRoom = reservation.getARoom(rooms);
            if (reservedRoom.getRoomNumber().equals(room.getRoomNumber()))
            {
                if (reservationDoesNotCollide(reservation, checkInDate, checkOutDate)){return true;}}
        }
        return false;
    }

    public static boolean reservationDoesNotCollide(Reservation reservation, Date checkIn, Date checkOut){
        return checkOut.before(reservation.getCheckInDate()) || checkIn.after(reservation.getCheckOutDate());}
*/
    Collection<IRoom> getAllRooms() {return rooms;}

    public Collection<Reservation> getCustomersReservation(Customer customer){
        CustomerService.getCustomer(customer.getEmail());
        return reservations;
    }

    public static void printAllReservation(){
        for (Reservation reservation : reservations){
            System.out.println(reservation);
        }
    }
}


