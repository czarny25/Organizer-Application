package GUI;

import java.util.EventObject;
import javax.swing.JTextField;




public class CustomEntryEvent extends EventObject {

	String firstName;
	String secondName;
	String occupation;
	String City;
	
	
	public CustomEntryEvent(Object object, String firstName, String secondName,
							String occupation, String city) {
		super(object);
		this.firstName = firstName;
		this.secondName = secondName;
		this.occupation = occupation;
		City = city;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	

}
