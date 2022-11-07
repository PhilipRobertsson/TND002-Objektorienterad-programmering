package Lab6;

public class Person {
	private String givenName;
	private String surname;
	private int phoneNumber;
	
	public Person(String gName, String sName, int pNum) {
		givenName = gName;
		surname = sName;
		phoneNumber = pNum;
	}
	public String getSurname() {return surname;}
	public String getFullname() {return givenName + " " + surname;}
	public int  getPhoneNumber() {return phoneNumber;}
}
