import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ContactServiceTest {
	
	private ContactService contactService;
	
	@BeforeEach
	void setUp() throws Exception {
		contactService = ContactService.getService();
	}

	@Test
	@DisplayName("Test Create New Contact and Access It")
	void testCreate() {
		// Create new contact and confirm it is valid by accessing it
		String ContactId = contactService.createNewContact();
		assertSame(ContactId, contactService.returnContact(ContactId).getContactID());
	}
	
	@Test
	@DisplayName("Test Delete Contact")
	void testDelete() {
		// Create new contact
		String ContactId = contactService.createNewContact();
		
		// Delete contact and verify it is deleted
		contactService.deleteContact(ContactId);
		assertNull(contactService.returnContact(ContactId));
	}
	
	@Test
	@DisplayName("Test firstName Update")
	void testFirstName() {
		// Create new contact
		String ContactId = contactService.createNewContact();

		// Confirm Update works
		String testString = "Kevin";
		contactService.updateFirstName(ContactId, testString);
		assertSame(testString, contactService.returnContact(ContactId).getFirstName());
	}
	
	@Test
	@DisplayName("Test lastName Update")
	void testLastName() {
		// Create new contact
		String ContactId = contactService.createNewContact();

		// Confirm Update works
		String testString = "Cooper";
		contactService.updateLastName(ContactId, testString);
		assertSame(testString, contactService.returnContact(ContactId).getLastName());
	}
	
	@Test
	@DisplayName("Test Number Update")
	void testNumber() {
		// Create new contact
		String ContactId = contactService.createNewContact();

		// Confirm Update works
		String testString = "1234567890";
		contactService.updateNumber(ContactId, testString);
		assertSame(testString, contactService.returnContact(ContactId).getNumber());
	}
	
	@Test
	@DisplayName("Test Address Update")
	void testAddress() {
		// Create new contact
		String ContactId = contactService.createNewContact();

		// Confirm Update works
		String testString = "123 Elm St, Chicago IL 60101";
		contactService.updateAddress(ContactId, testString);;
		assertSame(testString, contactService.returnContact(ContactId).getAddress());
	}
}
