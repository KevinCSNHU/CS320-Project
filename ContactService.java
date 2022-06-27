import java.security.SecureRandom;
import java.util.ArrayList;

public class ContactService {
	ArrayList<Contact> contactList; // Contains all contacts
	private static ContactService service_instance = null; // Store instance for Singleton format
	
	private ContactService() {
		// Create an array to store contacts
		contactList = new ArrayList<>();
	}
	
	// Method to create and retrieve instance of Contact Service singleton
	public static ContactService getService() {
		if (service_instance == null) {
			service_instance = new ContactService();
		}
		
		return service_instance;	
	}
	
	// Create blank new contract and return its ContactId
	public String createNewContact() {
		
		// Get new, unique contact ID
		String contactId = generateContactId(); 
		
		// Create contact and add to contacts
		Contact contact = new Contact(contactId);
		contactList.add(contact);
	    
	    return contactId;
	}
	
	// Delete contact if contact ID exists.
	public void deleteContact(String contactId) {
        for (Contact contact : contactList) {
            if (contact.getContactID().equalsIgnoreCase(contactId)) {
            	// If contact ids match, remove contact.
            	contactList.remove(contact);
                break;
            }
        }
	}
	
	// Generate Contact Id for adding Contact
	private String generateContactId() {
        // create StringBuilder and SecureRandom instances
		StringBuilder sb = new StringBuilder();
		SecureRandom rand = new SecureRandom();
        
        // create list of candidates for string
        String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        
        // loop to create new string ID using SecureRandom
        for (int i = 0; i < 10; i++) {
        	sb.append(candidateChars.charAt(rand.nextInt(candidateChars.length())));
        }
        
        // Convert finished StringBuilder to String
        String contactId = sb.toString();
        
        // Check if Contact ID is unique and not already in contacts
		for (Contact contact : contactList) {
	        if (contact.getContactID().equalsIgnoreCase(contactId)) {
	        	// If contact ID is found, recursively call this function to attempt to get a unique ID again
	        	contactId = generateContactId();
	            break;
	        }
		}
        
        // Return Contact ID
        return contactId;
	}
	
	// Update the first name
	public void updateFirstName(String contactId, String newFirstName) {
        for (Contact contact : contactList) {
            if (contact.getContactID().equalsIgnoreCase(contactId)) {
            	// If contact id matches, update info.
            	contact.setFirstName(newFirstName);
            	break;
            }
        }
	}
	
	// Update the last name
	public void updateLastName(String contactId, String newLastName) {
        for (Contact contact : contactList) {
            if (contact.getContactID().equalsIgnoreCase(contactId)) {
            	// If contact id matches, update info.
            	contact.setLastName(newLastName);
                break;
            }
        }
	}
	
	// Update number
	public void updateNumber(String contactId, String newNumber) {
        for (Contact contact : contactList) {
            if (contact.getContactID().equalsIgnoreCase(contactId)) {
            	// If contact id matches, update info.
            	contact.setNumber(newNumber);
                break;
            }
        }
	}
	
	// Update address
	public void updateAddress(String contactId, String newAddress) {
        for (Contact contact : contactList) {
            if (contact.getContactID().equalsIgnoreCase(contactId)) {
            	contact.setAddress(newAddress);
                break;
            }
        }
	}
	
	// Return contact based on contactId
    public Contact returnContact(String contactId) {
        for(Contact contact: contactList) {
        	if (contact.getContactID().equalsIgnoreCase(contactId)) {
        		// Return object if found
        		return contact;
        	}
        }
        return null; // Return null if not found
	}
}