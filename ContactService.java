// Manages a collection of contacts, providing methods for adding, deleting, updating, and retrieving contacts.
import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private final Map<String, Contact> contacts = new HashMap<>(); // Stores contacts using their contact ID as the key.

    // Adds a new contact to the service.
    // Throws IllegalArgumentException if the contact ID already exists.
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactID())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contact.getContactID(), contact);
    }

    // Deletes a contact based on its contact ID.
    // Throws IllegalArgumentException if the contact ID does not exist.
    public void deleteContact(String contactID) {
        if (!contacts.containsKey(contactID)) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }
        contacts.remove(contactID); // Remove the contact from the map.
    }

    // Updates an existing contact's details if they exist.
    // Any null fields will not be updated.
    // Throws IllegalArgumentException if the contact ID does not exist.
    public void updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID does not exist");
        }

        // Update each field if it's not null.
        if (firstName != null) {
            contact.setFirstName(firstName);
        }
        if (lastName != null) {
            contact.setLastName(lastName);
        }
        if (phone != null) {
            contact.setPhone(phone);
        }
        if (address != null) {
            contact.setAddress(address);
        }
    }

    // Retrieves a contact by its contact ID.
    public Contact getContact(String contactID) {
        return contacts.get(contactID); // Returns null if the contact ID doesn't exist.
    }
}