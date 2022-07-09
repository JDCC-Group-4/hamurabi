import java.io.IOException;

public class Hamurabi {


	private int year;
	private int bushelsHarvested;
	private int bushelsPerAcre;
	private int bushelsDestroyed;
	private int bushelsFed;
	private int people;
	private int population;
	private int acres;
	private int landValue;
	int peopleStarved;
	String printSummary;
	boolean uprising;


	public Hamurabi() {
		this.population = 100;
		this.bushelsHarvested = 2800;
		this.landValue = 19;
		this.acres = 1000;

	}



	 String printSummary() {

		printSummary = "You are in year " + year + " of your ten year rule.\n";
		printSummary += "In the previous year " + peopleStarved + " people starved to death.\n";
		printSummary += "In the previous year " + people + " people entered the kingdom.\n";
		printSummary += "The population is now " + population + ".\n";
		printSummary += "The city owns " + acres + " acres of land.\n";
		printSummary += "We harvested " + (bushelsPerAcre * acres) + " bushels at " + bushelsPerAcre + " bushels per acre.\n";
		printSummary += "Rats destroyed " + bushelsDestroyed + " bushels, leaving " + bushelsHarvested + " bushels in storage.\n";
		printSummary += "The city owns " + acres + " acres of land.\n";
		printSummary += "Land is currently worth " + landValue + " bushels per acre.";
		System.out.println(printSummary);
		return printSummary;
	}

	boolean uprising(int population, int peopleStarved){
		float percentStarved = (float) ((peopleStarved * 1.0) / (population * 1.0));
		if(percentStarved >= .45) {uprising = true;}
		else uprising = false;
		return uprising;
	}

	int peopleStarved(int population, int bushelsFed){
		if((bushelsFed/20) < population){
			population = bushelsFed/20;
		}
		peopleStarved = population - (bushelsFed/20);
		return peopleStarved;
	}

	int people(int population, int acres, int bushelsHarvested){
		if(peopleStarved > 0){ people = 0;}
		else {people = (20 * acres + bushelsHarvested) / (100 * population) + 1;}
		population += people;
		return people;
	}






	public static void main(String[] args) throws IOException {

		Hamurabi game = new Hamurabi();
		game.printSummary();


	}
}



