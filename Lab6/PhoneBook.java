package Lab6;
import java.io.*;
import java.util.*;
public class PhoneBook {
	private ArrayList<Person> listOfNumbers;
	
	public PhoneBook() {
		listOfNumbers = new ArrayList<Person>();
	}
	
	public String load(String fileName) {
		try {
			String filePath = System.getProperty("user.dir");
			filePath = filePath + "\\src\\Lab6\\" + fileName;
			File newFile = new File(filePath);
			BufferedReader freader = new BufferedReader(new FileReader(newFile));
			String eachLine;
			String[] personData;
			int phoneNumber;
			Person newPerson;
			while ((eachLine = freader.readLine()) != null) {
				personData = eachLine.split(" +");
				phoneNumber = Integer.parseInt(personData[2]);
				newPerson = new Person(personData[0], personData[1], phoneNumber);
				listOfNumbers.add(newPerson);
			}
			freader.close();
			return "Phone book loaded";
		} catch (Exception ignore) { // IOException ignore
			return "Try again";
		}
	}
	
	public ArrayList<Person> search(String arg){
		ArrayList<Person> searchResults = new ArrayList<Person>();
		for (Person person : listOfNumbers) {
			try {
				if(arg.equals(person.getSurname()) || Integer.parseInt(arg) == person.getPhoneNumber()) {
					searchResults.add(person);
				}
			}		
			catch (NumberFormatException ignore) {
				
			}
		}
		return searchResults;
	}
	
	public String deletePerson(String fullName, int pNum) {
		for (int i = 0; i < listOfNumbers.size(); i++) {
			if(listOfNumbers.get(i).getFullname().equals(fullName) && listOfNumbers.get(i).getPhoneNumber() == pNum) {
				listOfNumbers.remove(i);
				return "Person deleted";
			}
		}
		return "The person/number does not exist";
	}
	
	public boolean addPerson(String fullName, int pNum) {
		String[] splitName = fullName.split(" ");
		boolean pNumFound = false;
		for (Person person : listOfNumbers) {
			if(person.getPhoneNumber() == pNum) {
				pNumFound = true;
			}
		}
		if(splitName.length != 2 || pNumFound) {
			return false;
		}
		Person newPerson = new Person(splitName[0], splitName[1], pNum);
		listOfNumbers.add(newPerson);
		return true;
	}
	
	public String save(String fileName) {
		File saveFile = new File(fileName);
		String outputLine;
		try {
			BufferedWriter fwriter = new BufferedWriter(new FileWriter(saveFile));
			
			for (Person person : listOfNumbers) {
				outputLine = String.format("%-20s %-5d", person.getFullname(), person.getPhoneNumber());
				
				fwriter.write(outputLine);
				fwriter.newLine();
			}
			fwriter.flush();
			fwriter.close();
			return "Saved " + listOfNumbers.size() + " people to the file";
		} catch (IOException ignore) {
			return "Could not save to the file";
		}
	}
}
