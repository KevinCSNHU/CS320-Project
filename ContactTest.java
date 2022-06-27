import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactTest {

	private Contact contact;
	
	@BeforeEach
	void setUp() throws Exception {
		contact = new Contact("ABCD1234");
	}
	
	@Test
	@DisplayName("Test Contact ID")
	void testContactId() {
		// Create new contact with null
		contact = new Contact(null);
		
		// Test that null was not accepted as contactId
		assertNotNull(contact.getContactID());
		
		// Create new contact with valid entry and confirm update worked
		String testString = "1234567890";
		contact = new Contact(testString);
		assertSame(testString, contact.getContactID());
		
		//Create new contact with too long entry and confirm it was rejected
		String longString = "12345678901";
		contact = new Contact(longString);
		assertNotSame(longString, contact.getContactID());
	}

	@Test
	@DisplayName("Test firstName")
	void testFirstName() {
		// Confirm not initially null
		assertNotNull(contact.getFirstName());
		
		// Confirm null update is ignored
		contact.setFirstName(null);
		assertNotNull(contact.getFirstName());
		
		// Update and confirm update was taken
		String testString = "1234567890";
		contact.setFirstName(testString);
		assertSame(testString, contact.getFirstName());
		
		// Confirm too long string is ignored
		String longString = "12345678901";
		contact.setFirstName(longString);
		assertNotSame(longString, contact.getFirstName());
	}
	
	@Test
	@DisplayName("Test lastName")
	void testLastName() {
		// Confirm not initially null
		assertNotNull(contact.getLastName());
		
		// Confirm null update is ignored
		contact.setLastName(null);
		assertNotNull(contact.getLastName());
		
		// Update and confirm update was taken
		String testString = "1234567890";
		contact.setLastName(testString);
		assertSame(testString, contact.getLastName());
		
		// Confirm too long string is ignored
		String longString = "12345678901";
		contact.setLastName(longString);
		assertNotSame(longString, contact.getLastName());
	}
	
	@Test
	@DisplayName("Test Number")
	void testNumber() {
		// Confirm not initially null
		assertNotNull(contact.getNumber());
		
		// Confirm null update is ignored
		contact.setNumber(null);
		assertNotNull(contact.getNumber());
		
		// Update and confirm update was taken
		String testString = "1234567890";
		contact.setNumber(testString);
		assertSame(testString, contact.getNumber());
		
		// Confirm too short string is ignored
		String shortString = "123456789";
		contact.setNumber(shortString);
		assertNotSame(shortString, contact.getNumber());
		
		// Confirm too long string is ignored
		String longString = "12345678901";
		contact.setNumber(longString);
		assertNotSame(longString, contact.getNumber());
	}

	@Test
	@DisplayName("Test Address")
	void testAddress() {
		// Confirm not initially null
		assertNotNull(contact.getAddress());
		
		// Confirm null update is ignored
		contact.setAddress(null);
		assertNotNull(contact.getAddress());
		
		// Update and confirm update was taken
		String testString = "123456789012345678901234567890";
		contact.setAddress(testString);
		assertSame(testString, contact.getAddress());
		
		// Confirm too long string is ignored
		String longString = "1234567890123456789012345678901";
		contact.setAddress(longString);
		assertNotSame(longString, contact.getAddress());
	}
}
