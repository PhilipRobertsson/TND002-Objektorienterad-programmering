package Lab2;
public class Word {
	public static final int ORIGINAL = 0, BYNAME = 1, BYCOUNT = 2;
	private String theWord;
	private int count;
	public static int sortCriterion = BYCOUNT;
	
	public Word(String word, int arg) {theWord = word; count = arg;}
	
	public int getCount() {return count;}
	public String getWord() {return theWord;}
	
	public static final void setCriterion(int arg) {sortCriterion = arg;}
	public static final int getCriterion() {return sortCriterion;}
	
	public int compareTo(Word arg) {
		if(sortCriterion == BYNAME)	{return (arg.theWord.compareTo(this.theWord));}
		else if (sortCriterion == BYCOUNT) {
			if(arg.count == this.count) {return 0;}
			else if(arg.count > this.count) {return -1;}
			else {return 1;}
		}else {return 0;}
	}
	public String toString() {return String.format("Word: %10s   Count: %3d", this.theWord,this.count);}
}
