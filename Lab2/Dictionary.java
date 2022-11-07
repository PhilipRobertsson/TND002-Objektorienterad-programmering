package Lab2;
import java.util.ArrayList;
import java.util.Collections;
public class Dictionary{
	private ArrayList<Word> theList;
	private ArrayList<Word> backup = null;
	
	public Dictionary() {theList = new ArrayList<>();}
	
	public String addString(String arg) {
		boolean found = false;
		int foundIndex = 0;
		
		for (int index = 0; index <this.theList.size(); index++) {
			if(this.theList.get(index).getWord().equals(arg)) {
				found = true;
				foundIndex = index;
				break;
			}
		}
		if(found) {
			int count = this.theList.get(foundIndex).getCount();
			count++;
			String word = this.theList.get(foundIndex).getWord();
			Word newWord = new Word(word,count);
			this.theList.set(foundIndex, newWord);
			return newWord.toString();
		}else {
			Word newWord = new Word(arg,1);
			this.theList.add(newWord);
			return newWord.toString();
		}
	}
	
	public String sortList(int arg) {
		if(backup == null || backup.isEmpty()) {
			backup = new ArrayList<>();
			for(int i = 0; i < theList.size(); i++) {
				Word temp = new Word(theList.get(i).getWord(), theList.get(i).getCount());
				backup.add(temp);
			}
		}
		if (arg == Word.ORIGINAL) {
			theList = backup;
			Word.setCriterion(Word.ORIGINAL);
			return "Sorting criterion undefined";
		}
		if (arg == Word.BYNAME) {
			Word.setCriterion(arg);
			for (int i = 0; i < theList.size()-1; i++) {
				for(int j = 0; j < this.theList.size()-i-1; j++) {
					Word w1 = this.theList.get(j);
					Word w2 = this.theList.get(j+1);
					
					if(w1.compareTo(w2) == -1) {
						Collections.swap(this.theList, j, j+1);
					}
				}
			}
			return "Sorted alphabetically";
			
		}
		if (arg == Word.BYCOUNT) {
			Word.setCriterion(arg);
			for (int i = 0; i < theList.size()-1; i++) {
				for(int j = 0; j < this.theList.size()-i-1; j++) {
					Word w1 = this.theList.get(j);
					Word w2 = this.theList.get(j+1);
					
					if(w1.compareTo(w2) == -1) {
						Collections.swap(this.theList, j, j+1);
					}
				}
			}
			return "Sorted by counts";
		}else {return "Sorting criterion undefined";}
	}
	
	public String returnWord(int arg) {
		if(arg >= theList.size()) {return "end";}
		else {return theList.get(arg).toString();}
	}
	
	public String toString() {
		String output = "Content: \n";
		for (int i = 0; i < theList.size(); i++) {
			output += (theList.get(i).toString() + "\n");
		}
		return output;
	}
}
