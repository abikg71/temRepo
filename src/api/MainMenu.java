package api;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;
import model.Customer;
import model.IRoom;
import model.Reservation;
import service.CustomerService;
import service.ReservationService;

import static java.lang.System.in;
import static java.lang.System.out;

public class MainMenu {
    public static final String emailRegex = "^(.+)@(.+).(.+)$";
    public static final Pattern pattern= Pattern.compile(emailRegex);

    public static final String regexmmddyyy = "^(0[1-9]|[12][0-9]|[3][01])/(0[1-9]|1[012])/\\d{4}$";
    private static Pattern ddmmyy = Pattern.compile(regexmmddyyy);

    private static String firstName;
    private static String lastName;
    private static String email;
    private static Date chkInDate = new Date();
    private static Date chkOutDate = new Date();
    public static  Scanner input = new Scanner(System.in);
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static String space = "------------------------------------------\n";
    public static String welcome = "Welcome to the Hotel Reservation Application\n ";
    public static  String msg = "Please Select a Number for the menu Option ";

    public static void MainMenu() throws ParseException {
        out.print(welcome + space );
        while (true) {
            String menu = "";
            for (String s : Arrays.asList( """ 
                        1.  Find and Reserve a Room
                        2.  See my Reservations
                        3.  Create an Account
                        4.  Admin
                        5.  Exit""", space + msg + menu))
            {out.println(s);}

            menu = input.nextLine();
            out.println(space);

            switch (menu)
            {
                case "1" -> findAndReserveARoom();
                case "2" -> AdminResource.displayAllReservations();
                case "3" -> createAnAccount();
                case "4" -> AdminMenu.AdminMenu();
                case "5" -> System.exit(0);
                default -> out.println("Invalid selection");
            }
        }
    }
    public static void validateCustomerInformation()
    {
        out.println("Enter your First Name");
        firstName = input.nextLine();
        out.println("Enter your Last Name");
        lastName = input.nextLine();
        out.println("Enter your Email");
        email = input.nextLine();
    }
    public static void findAndReserveARoom() throws ParseException{
        out.print(space);
        showAvailableRooms(); //
        final Collection<IRoom> rooms = AdminResource.getAllRooms();

        out.println("Enter the Check in Date in DD/MM/YYYY ");
        while (true) {
            String dateInput  = input.nextLine();
            if(isDateValid(dateInput)){
                chkInDate   =  sdf.parse(dateInput);
                break;
            }
            else {
                out.println("Invalid Date. Please Enter Valid Date!");
            }
        }
        out.println("Enter the Check Out Date in DD/MM/YYYY ");
        while (true) {
            String dateInput  = input.nextLine();
            if(isDateValid(dateInput) ){
                chkOutDate =  sdf.parse(dateInput);

                if(chkInDate.compareTo(chkOutDate) >= 0){out.println("Please Enter valid checkout date");}
                else {break;}
            }
            else {out.println("Invalid Date. Please Enter Valid Date!");}
        }

        validateCustomerInformation();
        Customer customer = CustomerService.addCustomer(firstName,lastName,email);
        if(rooms.size() < 0){out.println("Warn a customer. ");}

        else {
            if(ReservationService.reserveARoom(customer,(IRoom) rooms.toArray()[0], chkInDate,chkOutDate)){
                rooms.remove(0);
              //  rooms.addAll(rooms);
                out.println("Reservation Sucessfull");}

            else {out.println(" Room already reserved.");}
        }
    }

    public static void showAvailableRooms(){
        out.println("Choose from the following Rooms:\n " + AdminResource.getAllRooms());
    }

    public static void createAnAccount(){
        validateCustomerInformation();
        if (!pattern.matcher(email).matches()) {
            throw new IllegalArgumentException("Error, Invalid email");}
        try {
            HotelResource.createACustomer(firstName, lastName, email);
            out.println("Account created successfully \n");
        }
        catch (Exception e) {out.println("Account not created successfully ");}
    }
    public static boolean isDateValid(String strDate){
        boolean isValide = false;
        if(strDate.matches( regexmmddyyy )){
            sdf.setLenient(false);
            try{
                sdf.parse(strDate);
                isValide = true;
            }
            catch(Exception pe){}
            }
            return isValide;
    }
}