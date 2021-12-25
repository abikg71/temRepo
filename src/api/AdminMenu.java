package api;
import model.Customer;
import model.IRoom;
import model.Room;
import service.CustomerService;
import service.ReservationService;
import java.text.ParseException;
import java.util.*;
import static java.lang.System.*;
import static model.IRoom.*;

public class AdminMenu {

    public static Scanner input = new Scanner(in);
    public static String addRoom;
    public static int typeOfRoom;

    public static void AdminMenu() throws ParseException {

        String menu;
        String space = "------------------------------------------\n";
        String msg = "Please Select a Number for the menu Option\n ";
        while (true) {
            out.println(space  + """
                        1. See all Customers
                        2. See all Rooms
                        3. See all Reservations
                        4. Add a Room
                        5. Add Test Data
                        6. Back to Main Menu"""  );
            out.println(space + msg);
            menu = input.next();
            out.println(space);
            switch (menu) {
                case "1" -> out.println(CustomerService.getAllCustomers());
                case "2" -> out.println(AdminResource.getAllRooms());
                case "3" -> out.println(ReservationService.reservations);
                case "4" -> AddARoom();
                case "5" -> addTestData();
                case "6" -> MainMenu.MainMenu();
                default -> out.println("Invalid selection");
            }
        }
    }

    public static void AddARoom(){
        do {
            RoomType roomType;
            out.println("Enter room number:");
            String roomNumber = input.next();
            out.println("Enter price per night:");
            Double roomPrice = input.nextDouble();

            while (true) {
                out.println("Enter room type: 1 for Single bed, 2 for Double bed");
                typeOfRoom = input.nextInt();
                if (typeOfRoom == 1) {
                    roomType = RoomType.SINGLE;
                    break;
                } else if (typeOfRoom == 2) {
                    roomType = RoomType.DOUBLE;
                    break;
                }
                else {System.out.println("Please Enter valid input");}
            }

            IRoom room = new Room(roomNumber, roomPrice, roomType);
            AdminResource.addRoom(room);

            do {
                out.println("Would you like to add another room? y/n");
                input.nextLine();
                addRoom = input.next().toLowerCase().trim();
            } while (!addRoom.equals("y") && !addRoom.equals("n"));
        } while (addRoom.equals("y"));
    }

    public static void addTestData(){
        HotelResource.createACustomer("Abinet", "Kenore", "abinetem211@emial.com");
        HotelResource.createACustomer("Doe", "Joe", "doejoe1@emial.com");

        AdminResource.addRoom(new Room("100A",135.0, RoomType.SINGLE));
        AdminResource.addRoom(new Room("100B",189.56, RoomType.DOUBLE));

        ReservationService.reserveARoom(new Customer("Abinet", "kenore", "abinetem211@emial.com"),
        new Room("100A",122.22, RoomType.SINGLE), new Date("12/23/2012") ,new Date("12/23/2012"));
        ReservationService.reserveARoom(new Customer("Doe", "Joe", "doejoe1@emial.coms"),
                new Room("100B",22.22, RoomType.DOUBLE), new Date("12/23/2012") ,new Date("12/23/2012"));
    }
}