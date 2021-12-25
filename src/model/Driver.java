package model;

public class Driver {
    public static void main(String[] args) {
        try {
            Customer customer = new Customer("Abinet" , "Kenore", "abi1@gmail.com");
            System.out.println("\n "+ customer);
            Customer customer2 = new Customer("Doe" ,"Joe","doejoe1@gmail.com");
            System.out.println("\n "+customer2);
        }
        catch (IllegalArgumentException e){
            System.out.println("Error, Invalid email");
        }
    }
}
