// Importing JUnit 5's Test annotation to define test methods.
import org.junit.jupiter.api.Test; 
// Importing assertion methods for validating test outcomes.
import static org.junit.jupiter.api.Assertions.*; 

class ContactTest {

    // Test case to validate the creation of a valid Contact.
    @Test
    void testValidContact() {
        // Creating a new Contact object with valid input data.
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        
        // Verifying that the Contact object's fields match the expected values.
        assertTrue(contact.getContactID().equals("12345")); // Check if contact ID matches.
        assertTrue(contact.getFirstName().equals("John")); // Check if first name matches.
        assertTrue(contact.getLastName().equals("Doe")); // Check if last name matches.
        assertTrue(contact.getPhone().equals("1234567890")); // Check if phone number matches.
        assertTrue(contact.getAddress().equals("123 Main St")); // Check if address matches.
    }

    // Test case to ensure that an exception is thrown when the Contact ID exceeds the maximum allowed length.
    @Test
    void testContactIDToLong() {
        // Assert that an IllegalArgumentException is thrown when the contact ID exceeds 10 characters.
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345678901", "John", "Doe", "1234567890", "123 Main St");
        });
        
        // Assert that an IllegalArgumentException is thrown when the contact ID is null.
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "John", "Doe", "1234567890", "123 Main St");
        });
    }

    // Test case to ensure that an exception is thrown for invalid first names (null or too long).
    @Test
    void testInvalidFirstName() {
        // Assert that an IllegalArgumentException is thrown when the first name is null.
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", null, "Doe", "1234567890", "123 Main St");
        });
        
        // Assert that an IllegalArgumentException is thrown when the first name exceeds the 10-character limit.
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "Johnathan-James", "Doe", "1234567890", "123 Main St");
        });
    }

    // Test case to ensure that an exception is thrown for invalid last names (null or too long).
    @Test
    void testInvalidLastName() {
        // Assert that an IllegalArgumentException is thrown when the last name is null.
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", null, "1234567890", "123 Main St");
        });
        
        // Assert that an IllegalArgumentException is thrown when the last name exceeds the 10-character limit.
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe-Rodriguez", "1234567890", "123 Main St");
        });
    }

    // Test case to ensure that an exception is thrown for invalid phone numbers (null, too short, too long, or non-numeric).
    @Test
    void testInvalidPhone() {
        // Assert that an IllegalArgumentException is thrown when the phone number is null.
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", null, "123 Main St");
        });
        
        // Assert that an IllegalArgumentException is thrown when the phone number is too short (less than 10 digits).
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "12345", "123 Main St");
        });
        
        // Assert that an IllegalArgumentException is thrown when the phone number is too long (more than 10 digits).
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "123456789012", "123 Main St");
        });
        
        // Assert that an IllegalArgumentException is thrown when the phone number contains non-numeric characters.
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "12345abcde", "123 Main St");
        });
    }

    // Test case to ensure that an exception is thrown for invalid addresses (null or too long).
    @Test
    void testInvalidAddress() {
        // Assert that an IllegalArgumentException is thrown when the address is null.
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890", null);
        });
        
        // Assert that an IllegalArgumentException is thrown when the address exceeds the 30-character limit.
        assertThrows(IllegalArgumentException.class, () -> {
            new Contact("12345", "John", "Doe", "1234567890", "This address is way too long and exceeds the maximum limit");
        });
    }

    // Test the first name setter method
    @Test
    void testContactClassSetFirstName() {
        // Creating a contact object and setting a valid first name.
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        
        // Setting the first name and checking if it was updated correctly.
        contact.setFirstName("John");
        assertTrue(contact.getFirstName().equals("John"));
    }
    
    // Test for setting first name to null, which should throw an IllegalArgumentException.
    @Test
    void testContactClassSetFirstNameNull() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName(null);
        });
    }
    
    // Test for setting first name to too long, which should throw an IllegalArgumentException.
    @Test
    void testContactClassSetFirstNameToLong() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setFirstName("Johnathan-James");
        });
    }

    // Test the last name setter method
    @Test
    void testContactClassSetLastName() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        contact.setLastName("Doe");
        assertTrue(contact.getLastName().equals("Doe"));
    }

    // Test for setting last name too long, which should throw an IllegalArgumentException.
    @Test
    void testContactClassSetLastNameTooLong() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName("Doe-Rodriguez");
        });
    }

    // Test for setting last name to null, which should throw an IllegalArgumentException.
    @Test
    void testContactClassSetLastNameNull() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setLastName(null);
        });
    }

    // Test the phone number setter method
    @Test
    void testContactClassSetPhone() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        contact.setPhone("1234567890");
        assertTrue(contact.getPhone().equals("1234567890"));
    }

    // Test for setting phone number too long, which should throw an IllegalArgumentException.
    @Test
    void testContactClassSetPhoneTooLong() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("12345678900987654321");
        });
    }

    // Test for setting phone number to null, which should throw an IllegalArgumentException.
    @Test
    void testContactClassSetPhoneNull() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone(null);
        });
    }

    // Test for setting phone number too short, which should throw an IllegalArgumentException.
    @Test
    void testContactClassSetPhoneTooShort() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("101");
        });
    }
    
 // Test for setting phone number too short, which should throw an IllegalArgumentException.
    @Test
    void testContactClassSetPhoneToNonNumber() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setPhone("12345abcde");
        });
    }
    
    // Test the address setter method
    @Test
    void testContactClassSetAddress() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        contact.setAddress("123 Main St");
        assertTrue(contact.getAddress().equals("123 Main St"));
    }

    // Test for setting address to null, which should throw an IllegalArgumentException.
    @Test
    void testContactClassSetAddressNull() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress(null);
        });
    }

    // Test for setting address to too long, which should throw an IllegalArgumentException.
    @Test
    void testContactClassSetAddressTooLong() {
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> {
            contact.setAddress("This address is way too long and exceeds the maximum limit");
        });
    }
}
