package model;
import java.util.Objects;
import java.util.regex.Pattern;

public class Customer {
    private final String firstName;
    private final String lastName;
    private final String email;
    public  final String emailRegex = "^(.+)@(.+).(.+)$";
    private  final Pattern pattern= Pattern.compile(emailRegex);

    public Customer(String  firstName, String lastName, String email) throws IllegalArgumentException {
        if(!pattern.matcher(email).matches()){
            throw new IllegalArgumentException("Error, Invalid email");}
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override //?
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return firstName.equals(customer.firstName) && lastName.equals(customer.lastName) && email.equals(customer.email);
    }

    @Override
    public int hashCode() {return Objects.hash(firstName, lastName, email);
    }

    @Override
    public String toString() {
        return "Customer{" + "firstName: '" + firstName + '\'' +
                ", lastName: '" + lastName + '\'' + ", email: '" + email + '\'' + '}'+" \n";
    }
}

