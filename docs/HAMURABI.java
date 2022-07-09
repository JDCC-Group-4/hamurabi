import java.io.IOException;
import java.util.Scanner;

public class HAMURABI{


	private int year;
	private int bushels;
	private int people;
	private int population;
	private int acres;
	private int landValue;
	private int peopleStarved;
	private String printSummary;

	public HAMURABI() {


	}

//	Hammurabi: I beg to report to you,
//In Year 1, 0 people starved.
//5 people came to the city.
//The city population is now 100.
//The city now owns 1000 acres.
//You harvested 3 bushels per acre.
//Rats ate 200 bushels.
//You now have 2800 bushels in store.
//-5700 bushels remaining
//Land is trading at 17 bushels per acre.


	public String printSummary() {

		printSummary = "You are in year " + year + " of your ten year rule.\n";
		printSummary += "In the previous year " + peopleStarved + " people starved to death.\n";
		printSummary += "In the previous year" + people + " people entered the kingdom.\n";
		printSummary += "The population is now " + population + ".\n";
		printSummary += "The city owns " + acres + " acres of land.\n";
		printSummary +=




		return null;
	}

	}


	public static void main(String[] args) throws IOException {
	}
}
}