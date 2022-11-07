package Lab2;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		String filePath = System.getProperty("user.dir");
		String input;
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		File newFile;
		
		int tries = 0;
		do {
			if(tries >= 3) {
				System.exit(0);
			}
			System.out.print("Type filename: ");
			input = b.readLine();
			input = filePath + "\\src\\Lab2\\" + input;
			newFile = new File(input);
			tries++;
		}while(!newFile.exists());
		
		String allLines = new String();
		String line;
		BufferedReader freader = new BufferedReader(new FileReader(newFile));
			
		while((line = freader.readLine()) != null){
			if(allLines.length() == 0) {allLines = line;}
			else {allLines = allLines + " " + line;}
		}
		freader.close();
		
		Dictionary dic = new Dictionary();
		String[] linesArray = allLines.split("\\s+");
		
		System.out.print("Search for word: ");
		input = b.readLine().trim();
		int count = 0;
		for (int i = 0; i < linesArray.length; i++) {
			if(input.equals(linesArray[i])) {
				count++;
			}
		}
		System.out.println("Word occurences: " + count + "\n");
		
		for (int i = 0; i< linesArray.length; i++) {
			try {
				Integer.valueOf(linesArray[i]);
			} catch (NumberFormatException ignore){
				System.out.println(dic.addString(linesArray[i]));
			}
		}
		System.out.println("\nOriginal");
		System.out.println(dic.toString());
		
		System.out.println(dic.sortList(Word.BYCOUNT));
		System.out.println(dic.toString());
		
		System.out.println(dic.sortList(Word.BYNAME));
		System.out.println(dic.toString());
		
		System.out.println(dic.sortList(Word.ORIGINAL));
		System.out.println(dic.toString());
		
		File resultFile = new File("result.txt");
		BufferedWriter fwriter = new BufferedWriter(new FileWriter(resultFile));
		int index = 0;
		String wordString = dic.returnWord(index);
		while(wordString != "end") {
			fwriter.write(wordString);
			fwriter.newLine();
			index++;
			wordString = dic.returnWord(index);
		}
		fwriter.flush();
		fwriter.close();
		b.close();
	}
}
