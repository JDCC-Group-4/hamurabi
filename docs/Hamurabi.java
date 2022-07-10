import java.io.IOException;
import java.util.Scanner;

public class Hamurabi {


	private int year;
	int totalBushels;
	private int bushelsPerAcre;
	private int bushelsPlanted;
	private int bushelsDestroyed;
	private int bushelsFed;
	private int people;
	int population;
	int acres;
	int landValue;
	int peopleStarved;
	String printSummary;
	boolean uprising;
	int buyOrSell;
	int userInput;
	String userInputString;

	public Hamurabi() {
		this.population = 100;
		this.totalBushels = 2800;
		this.landValue = 19;
		this.acres = 1000;
		this.buyOrSell = 2;
		this.bushelsPerAcre = 3;
	}


	String printSummary() {

		printSummary = "You are in year " + year + " of your ten year rule.\n";
		printSummary += "In the previous year " + peopleStarved + " people starved to death.\n";
		printSummary += "In the previous year " + people + " people entered the kingdom.\n";
		printSummary += "The population is now " + population + ".\n";
		printSummary += "The city owns " + acres + " acres of land.\n";
		printSummary += "We harvested " + (bushelsPlanted) + " bushels at " + bushelsPerAcre + " bushels per acre.\n";
		printSummary += "Rats destroyed " + bushelsDestroyed + " bushels, leaving " + totalBushels + " bushels in storage.\n";
		printSummary += "The city owns " + acres + " acres of land.\n";
		printSummary += "Land is currently worth " + landValue + " bushels per acre.\n";
		System.out.println(printSummary);
		return printSummary;
	}

	boolean uprising(int population, int peopleStarved) {
		float percentStarved = (float) ((peopleStarved * 1.0) / (population * 1.0));
		if (percentStarved >= .45) {
			uprising = true;
		} else uprising = false;
		return uprising;
	}

	int peopleStarved() {
		if ((bushelsFed / 20) < population) {
			population = bushelsFed / 20;
			peopleStarved = population - (bushelsFed / 20);
		}
		return peopleStarved;
	}

	int people(int population, int acres, int bushelsHarvested) {
		if (peopleStarved > 0) {
			people = 0;
		} else {
			people = (20 * acres + bushelsHarvested) / (100 * population) + 1;
		}
		population += people;
		return people;
	}

	int buyOrSellAcres() {
		System.out.println("Would you like to buy or sell acres?\n Type 'Buy' or 'Sell'");
		Scanner input = new Scanner(System.in);
		userInputString = input.nextLine().toLowerCase();
		if (userInputString.equals("buy")) {
			buyOrSell = 0;
		} else if (userInputString.equals("sell")) {
			buyOrSell = 1;
		} else {
			System.out.println("That's not a valid input");
			buyOrSell = 2;
		}
		return buyOrSell;
	}

	int askAcresToBuy() {
		System.out.println("How many acres would you like to buy?");
		Scanner input2 = new Scanner(System.in);
		userInput = input2.nextInt();
		if (totalBushels < landValue * userInput) {
			System.out.println("You don't own that much land!");
		} else {
			acres += userInput;
			totalBushels -= landValue * userInput;
		}
		return totalBushels;
	}

	int askAcresToSell() {
		System.out.println("How many acres would you like to sell?");
		Scanner input3 = new Scanner(System.in);
		userInput = input3.nextInt();
		if (userInput > acres) {
			System.out.println("You only have " + acres);
		} else {
			acres -= userInput;
			totalBushels += landValue * userInput;
		}
		return totalBushels;
	}

	int askHowMuchGrainToFeedPeople(){
		System.out.println("Enter amount of grain to feed people?");
		Scanner Input = new Scanner(System.in);
		userInput = Input.nextInt();
		if(userInput > totalBushels){
			System.out.println("You don't have that much food!");
		}
		else {
			totalBushels -= userInput;
		}
		return 0;
	}

	int howManyAcresToPlant() {
		System.out.println("How many acres would you like to plant?");
		Scanner Input = new Scanner(System.in);
		userInput = Input.nextInt();
		if (totalBushels >= userInput * 2) {
			if (acres >= userInput) {
				if (population >= userInput / 10) {
					bushelsPlanted = userInput * 2;
				}
				else {
					System.out.println("You don't have enough people");
				}
			}
			else {
					System.out.println("You don't have enough acres");
				}


			}
		else {
			System.out.println("You don't have enough bushels");
		}
		return bushelsPlanted;
	}

	public static void main(String[] args) throws IOException {

		Hamurabi game = new Hamurabi();
		game.printSummary();
		while(game.buyOrSell > 1) {
		game.buyOrSellAcres();// Sets buyOrSell
			if (game.buyOrSell == 0) {
				game.askAcresToBuy();
			} else if (game.buyOrSell == 1) {
				game.askAcresToSell();
			}
		}
		game.askHowMuchGrainToFeedPeople();
		game.howManyAcresToPlant();
		game.peopleStarved();

	}
}







