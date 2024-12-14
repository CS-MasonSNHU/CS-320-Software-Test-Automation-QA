// Represents a Contact with a unique ID, first name, last name, phone number, and address.
public class Contact {
    private final String contactID;  // Unique identifier for the contact (cannot be changed).
    private String firstName;        // First name of the contact.
    private String lastName;         // Last name of the contact.
    private String phone;            // Phone number of the contact (must be 10 digits).
    private String address;          // Address of the contact (max length 30).

    // Constructor to initialize a Contact object with valid parameters.
    // Throws IllegalArgumentException if any input is invalid.
    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
        // Validate contact ID: cannot be null or longer than 10 characters.
        if (contactID == null || contactID.length() > 10) {
            throw new IllegalArgumentException("Invalid Contact ID");
        }
        // Validate first name: cannot be null or longer than 10 characters.
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid First Name");
        }
        // Validate last name: cannot be null or longer than 10 characters.
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid Last Name");
        }
        // Validate phone number: cannot be null, must be exactly 10 digits, and contain only numbers.
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }
        // Validate address: cannot be null or longer than 30 characters.
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid Address");
        }

        // Initialize fields if all validations pass.
        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getter methods to retrieve the properties of the contact.
    public String getContactID() { return contactID; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPhone() { return phone; }
    public String getAddress() { return address; }

    // Setter methods to modify the properties of the contact. 
    // They validate the input data similarly to the constructor.
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("Invalid First Name");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Invalid Last Name");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            throw new IllegalArgumentException("Invalid Phone Number");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Invalid Address");
        }
        this.address = address;
    }
}