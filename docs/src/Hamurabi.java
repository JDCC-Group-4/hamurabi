package hammurabi.docs.src;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;



public class Hamurabi {


	private int year;
	int totalBushels;
	private int bushelsPerAcre;
	private int acresPlanted;
	private int bushelsDestroyed;
	private int bushelsFed;
	int peopleImmigrated;
	public int population;
	int acres;
	int landValue;
	int peopleStarved;
	String printSummary;
	boolean uprising;
	boolean buyOrSellLoopSwitch2;
	boolean feedGrainLoopSwitch;
	boolean plantSeedLoopSwitch;
	int buyOrSellLoopSwitch;
	int userInput;
	String userInputString;
	int game;
	int minAttack;
	int maxAttack;
	int attackResult;
	int allTimeBushelsHarvested;
	int bushelsHarvested;
	int peopleStarvedTotal;
	int totalImmigrants;
	int totalBushelsDestroyed;
	int plagueDeaths;
	int allTimePlagueDeaths;


	public Hamurabi() {
		this.population = 100;
		this.totalBushels = 2800;
		this.landValue = 19;
		this.acres = 1000;
		this.buyOrSellLoopSwitch = 2;
		this.buyOrSellLoopSwitch2 = false;
		this.feedGrainLoopSwitch = false;
		this.plantSeedLoopSwitch = false;
		this.year = 1;
		this.peopleStarved = 0;
		this.bushelsPerAcre = 3;
	}

	public void setBushelsFed(int bushelsFed){
		this.bushelsFed = bushelsFed;
	}

	public void setPopulation(int population){
		this.population = population;
	}

	public void setPeopleStarved(int peopleStarved){
		this.peopleStarved = peopleStarved;
	}

	public void setBushelsHarvested(int bushelsHarvested){
		this.bushelsHarvested = bushelsHarvested;
	}

	public void setAcres(int acres){
		this.acres = acres;
	}

	public void setUprising(boolean uprising){
		this.uprising = uprising;
	}

	String printSummary() {

		printSummary = "Hammurabi, I can report to you:\nYou are in year " + year + " of your 10 year rule.\n";
		printSummary += "In the previous year " + peopleStarved + " people starved to death.\n";
		printSummary += "In the previous year " + peopleImmigrated + " people immigrated to the kingdom.\n";
		printSummary += plagueDeaths + " people died from plague in your kingdom.\n";
		printSummary += "The population is now " + population + ".\n";
		printSummary += "The city owns " + acres + " acres of land.\n";
		printSummary += "Planting costs 2 bushels per acre.\n";
		printSummary += "Your kingdom harvested " + (bushelsHarvested) + " bushels at " + bushelsPerAcre + " bushels per acre.\n";
		printSummary += "Rats destroyed " + bushelsDestroyed + " bushels, leaving " + totalBushels + " bushels in storage.\n";
		printSummary += "Land is currently worth " + landValue + " bushels per acre.\n";
		System.out.println(printSummary);
		return printSummary;
	}

	String winPrintSummary() {

		printSummary = "O Great Hammurabi,\nYou have successfully led your kingdom for 10 years.\n";
		printSummary += "A total of " + peopleStarvedTotal + " people starved to death.\n";
		printSummary += "A total of " + totalImmigrants + " people immigrated to the kingdom.\n";
		printSummary += "The population is now " + population + ".\n";
		printSummary += "The city owns " + acres + " acres of land.\n";
		printSummary += "You have " + (acres/population) + " acres per person in your kingdom.\n";
		printSummary += "Your kingdom harvested a total of " + (allTimeBushelsHarvested) + " bushels.\n";
		printSummary += "Rats destroyed a total of " + totalBushelsDestroyed + " bushels.\n";
		printSummary += "Land is currently worth " + landValue + " bushels per acre.\n";
		printSummary += allTimePlagueDeaths + " total people died from plague in your kingdom.\n";
		printSummary += "\nI did not doubt you even for a moment.\n";
		System.out.println(printSummary);
		System.exit(0);
		return printSummary;
	}

	String printSummaryInit() {

		printSummary = "O Great Hammurabi, This is the first year of your ten year rule.\n";
		printSummary += "The population is now " + population + ".\n";
		printSummary += "The city owns " + acres + " acres of land.\n";
		printSummary += "Planting costs 2 bushels per acre.\n";
		printSummary += "You currently have " + totalBushels + " in storage\n";
		printSummary += "Land is currently worth " + landValue + " bushels per acre.\n";
		printSummary += "Bushels are harvesting at 3 bushels per acre.\n";
		System.out.println(printSummary);
		return printSummary;
	}

	public boolean uprising() {
		float percentStarved = (float) ((peopleStarved * 1.0) / (population * 1.0));
		if (percentStarved >= .45) {
			System.out.println("Hammurabi, You have neglected your people.\nAn uprising has occurred and your rule must come to an end.");
			uprising = true;
			System.exit(0);
		} else uprising = false;
		return uprising;
	}

	public int peopleStarved() {
		peopleStarved = 0;
		if ((bushelsFed / 20) < population) {
			peopleStarved += (population - (bushelsFed / 20));
			population = population - peopleStarved;
			peopleStarvedTotal += peopleStarved;
		}
		return peopleStarved;
	}

	public int peopleImmigrated() {
		if (peopleStarved > 0) {
			peopleImmigrated = 0;
		} else {
			peopleImmigrated = (20 * acres + bushelsHarvested) / (100 * population) + 1;
		}
		population += peopleImmigrated;
		totalImmigrants += peopleImmigrated;
		return peopleImmigrated;
	}

	int buyOrSellAcres() {
		System.out.println("Would you like to buy or sell acres?\n Type 'Buy' or 'Sell'");
		Scanner input = new Scanner(System.in);
		userInputString = input.nextLine().toLowerCase().replaceAll("\\s+","");
		if (userInputString.equals("buy")) {
			buyOrSellLoopSwitch = 0;
		} else if (userInputString.equals("sell")) {
			buyOrSellLoopSwitch = 1;
		} else {
			System.out.println("O Great Hammurabi, I don't understand your request");
			buyOrSellLoopSwitch = 2;
		}
		return buyOrSellLoopSwitch;
	}

	int askAcresToBuy() {
		System.out.println("How many acres would you like to buy?");
		Scanner input2 = new Scanner(System.in);
		while(buyOrSellLoopSwitch2 == false) {
			try {
				userInput = input2.nextInt();
				if (totalBushels < landValue * userInput) {
					System.out.println("You only have "+ totalBushels +" to spend!\nHow many acres would you like to buy?");
					input2.nextInt();
				}
				else if(userInput < 0){
					System.out.println("Number must be 0 or more\nHow many acres would you like to buy?");
				}
				else {
					acres += userInput;
					totalBushels -= landValue * userInput;
					buyOrSellLoopSwitch2 = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("O Great Hammurabi, your request must be in numbers\nHow many acres would you like to buy?");
			}
			input2.nextLine();
		}
		return totalBushels;
	}

	int askAcresToSell() {
		System.out.println("How many acres would you like to sell?");
		Scanner input3 = new Scanner(System.in);
		while(buyOrSellLoopSwitch2 == false) {
			try {
				userInput = input3.nextInt();
				if (userInput > acres) {
					System.out.println("You only have " + acres + " !\nHow many acres would you like to sell?");
					input3.nextInt();
				}
				else if(userInput < 0){
					System.out.println("Hammurabi, the number must be 0 or more\nHow many acres would you like to sell?");
				}
				else {
					acres -= userInput;
					totalBushels += landValue * userInput;
					buyOrSellLoopSwitch2 = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("O Great Hammurabi, your request must be in numbers\nHow many acres would you like to sell?");
			}
			input3.nextLine();
		}
		return totalBushels;
	}

	int askHowMuchGrainToFeedPeople(){
		System.out.println("Enter amount of grain to feed people?");
		Scanner Input = new Scanner(System.in);
		while(feedGrainLoopSwitch == false) {
			try {
				userInput = Input.nextInt();
				if (userInput > totalBushels) {
					System.out.println("You don't have that much food!\nEnter amount of grain to feed people?");
				} else if (userInput < 0) {
					System.out.println("Hammurabi!....You can't take food from people!\nEnter amount of grain to feed people?");
				} else {
					totalBushels -= userInput;
					bushelsFed = userInput;
					feedGrainLoopSwitch = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("O Great Hammurabi, your request must be in numbers\nEnter amount of grain to feed people?");
			}
			Input.nextLine();
		}
		return 0;
	}

	int howManyAcresToPlant() {
		System.out.println("How many acres would you like to plant?");
		Scanner Input = new Scanner(System.in);
		while(plantSeedLoopSwitch == false) {
			try {
				userInput = Input.nextInt();
				if (userInput < 0) {
					System.out.println("Hammu?.......bro, what are you asking me to do? You can't unplant the plants!\nHow many acres would you like to plant?");
				} else if (totalBushels >= userInput * 2) {
					if (acres >= userInput) {
						if (population >= userInput / 10) {
							acresPlanted = userInput;
							totalBushels -= (acresPlanted * 2);
							plantSeedLoopSwitch = true;
						} else {
							System.out.println("O Great Hammurabi, You don't have enough people\nHow many acres would you like to plant?");
						}
					} else {
						System.out.println("O Great Hammurabi, You don't have enough acres\nHow many acres would you like to plant?");
					}
				} else {
					System.out.println("O Great Hammurabi, You don't have enough bushels\nHow many acres would you like to plant? ");
				}
			} catch (InputMismatchException e) {
				System.out.println("O Great Hammurabi, your request must be in numbers\nHow many acres would you like to plant?");
			}
			Input.nextLine();
		}
		return acresPlanted;
	}

	int newHarvest(){
		if(year != 1) {
			Random random = new Random();
			bushelsPerAcre = random.nextInt(5 + 1) + 1;
		}
		else{

		}
		bushelsHarvested = (acresPlanted * bushelsPerAcre);
		totalBushels += bushelsHarvested;
		allTimeBushelsHarvested += bushelsHarvested;

		return bushelsHarvested;
	}

	int landValue(){
		Random random = new Random();
		landValue = 17 + random.nextInt(24 - 17);
		return landValue;
	}

	int ratAttack() {
		Random r = new Random();
		game = r.nextInt(100);
		minAttack = (int) (totalBushels * .1);
		maxAttack = (int) (totalBushels * .3);
		attackResult = minAttack + r.nextInt(maxAttack-minAttack);

		if (game < 60) { // if game number is 60 that leaves 40%
			// to do something?
			bushelsDestroyed = attackResult;
			totalBushels = totalBushels - attackResult;
			totalBushelsDestroyed += bushelsDestroyed;
		}else{
			System.out.println("Fortune favors your kingdom, Hammurabi, the plague has not visited us.");
		}
		return attackResult;
	}

	int plague(){
		Random r = new Random();
		int plaguePercent = r.nextInt(100);
		if(plaguePercent < 15){
			population /= 2;
			plagueDeaths = population;
			allTimePlagueDeaths += plagueDeaths;
		}
		return plaguePercent;
	}

	boolean switchReset(){
		buyOrSellLoopSwitch = 2;
		buyOrSellLoopSwitch2 = false;
		feedGrainLoopSwitch = false;
		plantSeedLoopSwitch = false;
		return false;
	}



	public static void main(String[] args) throws IOException {

		Hamurabi game = new Hamurabi();
		game.printSummaryInit();
		for(game.year = 1; game.year <= 10; game.year++) {
			if(game.year > 1){
				game.printSummary();}
			while (game.buyOrSellLoopSwitch > 1) {
				game.buyOrSellAcres();// Sets buyOrSell
			}
			while (game.buyOrSellLoopSwitch2 == false) {
				if (game.buyOrSellLoopSwitch == 0) {
					game.askAcresToBuy();
				} else if (game.buyOrSellLoopSwitch == 1) {
					game.askAcresToSell();
				}
			}
			while (game.feedGrainLoopSwitch == false) {
				game.askHowMuchGrainToFeedPeople();
			}
			while (game.plantSeedLoopSwitch == false) {
				game.howManyAcresToPlant();
			}
			game.newHarvest();
			game.peopleStarved();
			game.uprising();
			game.peopleImmigrated();
			game.ratAttack();
			game.plague();
			game.landValue();
			game.switchReset();
		}
		game.winPrintSummary();
	}
}








