package api;
import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;
import java.util.Collection;
import java.util.Date;

public class  HotelResource {
    public static ReservationService reservationService = ReservationService.getInstance();
    private HotelResource(){}

    public static Customer getCustomer(String email){
        return CustomerService.getCustomer(email);
    }

    public static void createACustomer(String firstName, String lastName, String email){
        CustomerService.addCustomer(firstName, lastName, email);
    }

    public static boolean bookARoom(String customerEmail, IRoom room, Date checkInDate, Date checkOutDate)
    {
        Customer customer = CustomerService.getCustomer(customerEmail);
        if (customer == null) {
        }
        return reservationService.reserveARoom(customer,room,checkInDate,checkOutDate);

    }

    public static Collection<Reservation> getCustomerReservations(String customerEmail)
    {
        Customer customer = CustomerService.getCustomer(customerEmail);
        if (customer == null)
            return null;
        return reservationService.getCustomersReservation(customer);
    }

   /* public static Collection<IRoom> findARoom(Date checkInDate, Date checkOutDate){
        return reservationService.findRooms(checkInDate, checkOutDate);
    }*/

}