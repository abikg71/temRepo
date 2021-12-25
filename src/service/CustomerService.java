package service;
import model.Customer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public  class CustomerService {
    private static CustomerService customerService = null;
    public static Collection<Customer> customers = new ArrayList<>();
    private CustomerService() {}

    public static CustomerService getInstance(){
        if(customerService == null) {customerService = new CustomerService();}
        return customerService;
    }
    public  static Customer addCustomer(String email,String firstName,String lastName){
        Customer customer = new Customer(email,firstName,lastName);
        customers.add(customer);
        return  customer;
    }

    public  static Customer getCustomer(String customerEmail){
        Optional<Customer> customer = customers.stream().filter(c -> customerEmail.equals(c.getEmail())).findFirst();
        return customer.orElse(null);
    }

    public static Collection<Customer>getAllCustomers(){return customers;}

}
