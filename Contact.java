public class Contact {
    private String contactId = "";  // This variable should not be changed.
    private String firstName = "";
    private String lastName = "";
    private String number = "0000000000";
    private String address = "";
    
    // Constructor
    public Contact(String contactId) {
		// Construct the contact, only adding values if contactId is valid.
        if(contactId != null && contactId.length() <= 10) {
            this.contactId = contactId;
        }
    }

    // Mutators
	public void setFirstName(String firstName) {
    	// Set value only if it is valid.
        if(firstName != null && firstName.length() <= 10) {
        	this.firstName = firstName;
        }
    }
    
    public void setLastName(String lastName) {
    	// Set value only if it is valid.
        if(lastName != null && lastName.length() <= 10) {
        	this.lastName = lastName;
        }
    }

    public void setNumber(String number) {
    	// Set value only if it is valid.
        if(number != null && number.length() == 10) {
        	this.number = number;
        }
    }
    
    public void setAddress(String address) {
    	// Set value only if it is valid.
        if(address != null && address.length() <= 30) {
        	this.address = address;
        }
    }

    // Accessors
    public String getContactID() {
    	return contactId;
    }

    public String getFirstName() {
    	return firstName;
    }

    public String getLastName() {
    	return lastName;
    }

    public String getNumber() {
    	return number;
    }

    public String getAddress() {
    	return address;
    }
}
