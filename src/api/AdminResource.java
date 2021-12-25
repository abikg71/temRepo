package api;
import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;
import java.util.ArrayList;
import java.util.Collection;

public class AdminResource {

    public static Collection<IRoom> AllRooms = new ArrayList<IRoom>();

    public static Customer getCustomer(String email){
        return CustomerService.getInstance().getCustomer(email)  ;
    }

    public static void addRoom(IRoom room){
       AllRooms.add(room);
    }

    public static Collection<IRoom> getAllRooms(){
        return AllRooms;}

     public static  Collection<Customer> getAllCustomers(){
        return CustomerService.getAllCustomers();
 }

    public static void displayAllReservations(){
        ReservationService.printAllReservation();
    }
}
