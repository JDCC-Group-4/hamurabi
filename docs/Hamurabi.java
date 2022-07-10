import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
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
	boolean buyOrSellLoopSwitch2;
	boolean feedGrainLoopSwitch;
	boolean plantSeedLoopSwitch;
	int buyOrSellLoopSwitch;
	int userInput;
	int newLV;
	String userInputString;
	int game;
	int minAttack;
	int maxAttack;
	int attackResult;

	public Hamurabi() {
		this.population = 100;
		this.totalBushels = 2800;
		this.landValue = 19;
		this.acres = 1000;
		this.buyOrSellLoopSwitch = 2;
		this.buyOrSellLoopSwitch2 = false;
		this.feedGrainLoopSwitch = false;
		this.plantSeedLoopSwitch = false;
		this.bushelsPerAcre = 3;
		this.newLV = 19;
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
		userInputString = input.nextLine().toLowerCase().replaceAll("\\s+","");
		if (userInputString.equals("buy")) {
			buyOrSellLoopSwitch = 0;
		} else if (userInputString.equals("sell")) {
			buyOrSellLoopSwitch = 1;
		} else {
			System.out.println("That's not a valid input");
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
					System.out.println("You only have "+ totalBushels +" to spend!");
					input2.nextInt();
				} else {
					acres += userInput;
					totalBushels -= landValue * userInput;
					buyOrSellLoopSwitch2 = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Try that again with numbers");
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
					System.out.println("You only have " + acres + " !");
					input3.nextInt();
				} else {
					acres -= userInput;
					totalBushels += landValue * userInput;
					buyOrSellLoopSwitch2 = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Try that again with numbers");
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
					System.out.println("You don't have that much food!");
				} else if (userInput < 0) {
					System.out.println("You can't take food from people!");
				} else {
					totalBushels -= userInput;
					feedGrainLoopSwitch = true;
				}
			} catch (InputMismatchException e) {
				System.out.println("Try that again with numbers");
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
					System.out.println("You can't unplant the plants!");
				} else if (totalBushels >= userInput * 2) {
					if (acres >= userInput) {
						if (population >= userInput / 10) {
							bushelsPlanted = userInput * 2;
							plantSeedLoopSwitch = true;
						} else {
							System.out.println("You don't have enough people");
						}
					} else {
						System.out.println("You don't have enough acres");
					}


				} else {
					System.out.println("You don't have enough bushels");
				}
			} catch (InputMismatchException e) {
				System.out.println("Try that again with numbers");
			}
			Input.nextLine();
		}
		return bushelsPlanted;
	}

	int newHarvest(){
		//IF YEAR CHANGES??
		//while(year < 10)??
		Random random = new Random();
		int n = random.nextInt(6 + 1);

		bushelsPerAcre += (bushelsPlanted * n) + totalBushels;
		return bushelsPerAcre;
	}

	int newLandValue(){
		//IF YEAR CHANGES??
		//while(year < 10)??
		Random random = new Random();
		newLV = 17 + random.nextInt(24 - 17);
		//*LAND VALUE IS DEPENDENT ON YEAR CHANGE? SO THE VALUE ONLY CHANGES WHEN
		//*A NEW RANDOM VALUE IS NEEDED
		return newLV;
	}

	int ratAttack() {
		//IF YEAR CHANGES ......should game be YEAR!??! Everytime we do random number
		//its because the YEAR changed?
		Random r = new Random();
		game = r.nextInt(100);
		minAttack = (int) (totalBushels * .1);
		maxAttack = (int) (totalBushels * .3);
		attackResult = minAttack + r.nextInt(maxAttack-minAttack);

		if (game < 60) { // if game number is 60 that leaves 40%
			// to do something?
			bushelsDestroyed = totalBushels - attackResult;
			totalBushels = totalBushels - bushelsDestroyed;
			 ;
		}else{
			System.out.println("You got lucky this plague season....");
		}
		return attackResult;
	}

	int plague(){
		Random r = new Random();
		int plaguePercent = r.nextInt(100);
		if(plaguePercent < 15){
			population -= people / 2;

		}

		return plaguePercent;
	}

	public static void main(String[] args) throws IOException {

		Hamurabi game = new Hamurabi();
		game.printSummary();
		while(game.buyOrSellLoopSwitch > 1) {
			game.buyOrSellAcres();// Sets buyOrSell
		}
		while(game.buyOrSellLoopSwitch2 == false) {
			if (game.buyOrSellLoopSwitch == 0) {
				game.askAcresToBuy();
			} else if (game.buyOrSellLoopSwitch == 1) {
				game.askAcresToSell();
			}
		}
		while(game.feedGrainLoopSwitch == false){
			game.askHowMuchGrainToFeedPeople();
		}
		while(game.plantSeedLoopSwitch == false){
			game.howManyAcresToPlant();
		}
		game.peopleStarved();


	}
}







