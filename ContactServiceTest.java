// Importing JUnit 5's Test annotation to define test methods.
import org.junit.jupiter.api.Test; 
// Importing assertion methods for validating test outcomes.
import static org.junit.jupiter.api.Assertions.*; 

class ContactServiceTest {

    // Test case to verify that adding a contact to the service works correctly.
    @Test
    void testAddContact() {
        // Creating a new ContactService instance and a contact object.
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        
        // Adding the contact to the service.
        service.addContact(contact);
        
        // Verifying that the contact was successfully added by checking if we can retrieve it by its ID.
        assertEquals(contact, service.getContact("12345")); // Assert the contact was added successfully.
    }

    // Test case to check that attempting to add a duplicate contact (with the same ID) throws an exception.
    @Test
    void testAddDuplicateContact() {
        // Creating a new ContactService instance and a contact object.
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        
        // Adding the contact to the service for the first time.
        service.addContact(contact);
        
        // Attempting to add the same contact again, which should throw an IllegalArgumentException.
        // Assert that an exception is thrown when adding a duplicate contact.
        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact); // Try to add the same contact again (should throw an exception).
        });
    }
    
    // Test case to check that deleting a non-existent contact throws an exception.
    @Test
    void testDeleteNonExistentContact() {
        // Creating a new ContactService instance.
        ContactService service = new ContactService();
        
        // Attempting to delete a contact that doesn't exist should throw an IllegalArgumentException.
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("12345"); // Trying to delete a non-existent contact (should throw an exception).
        });
    }

    // Test case to verify that deleting a contact works correctly.
    @Test
    void testDeleteContact() {
        // Creating a new ContactService instance and a contact object.
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        
        // Adding the contact to the service.
        service.addContact(contact); 
        
        // Deleting the contact by its ID.
        service.deleteContact("12345");
        
        // Verifying that the contact was successfully deleted by checking if it no longer exists in the service.
        assertNull(service.getContact("12345")); // Assert that the contact was deleted.
    }
    
    // Test case to check that attempting to update a non-existent contact throws an exception.
    @Test
    void testUpdateNonExistentContact() {
        // Creating a new ContactService instance.
        ContactService service = new ContactService();
        
        // Attempting to update a contact that doesn't exist should throw an IllegalArgumentException.
        assertThrows(IllegalArgumentException.class, () -> {
            service.updateContact("12345", "Jane", "Doe", "9876543210", "456 Park Ave"); // Try updating a non-existent contact.
        });
    }
    
    // Test case to verify that updating a contact works correctly.
    @Test
    void testUpdateContact() {
        // Creating a new ContactService instance and a contact object.
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        
        // Adding the contact to the service.
        service.addContact(contact); 
        
        // Updating the contact's first name, last name, phone, and address.
        service.updateContact("12345", "Jane", "Dow", "1234567892", "456 Park Ave");
        
        // Verifying that the contact's details were updated correctly.
        assertEquals("Jane", contact.getFirstName()); // Verify first name was updated.
        assertEquals("Dow", contact.getLastName()); // Verify last name was updated.
        assertEquals("1234567892", contact.getPhone()); // Verify phone number was updated.
        assertEquals("456 Park Ave", contact.getAddress()); // Verify address was updated.
    }
    
 // Test case to verify that updating info to null gets handled properly
    @Test
    void testUpdateContactNullInfo() {
        // Creating a new ContactService instance and a contact object.
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        
        // Adding the contact to the service.
        service.addContact(contact); 
        
        // Updating the contact's first name, last name, phone, and address to null.
        service.updateContact("12345", null, null, null, null);
    }
}
