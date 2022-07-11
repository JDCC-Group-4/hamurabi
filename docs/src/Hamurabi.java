package hammurabi.docs.src;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Hamurabi {


	private int year;
	int totalBushels;
	public int bushelsPerAcre;
	public int bushelsPlanted;
	private int bushelsDestroyed;
	private int bushelsFed;

	public void setChance(int chance) {
		this.chance = chance;
	}

	private int chance;

	public void setPeople(int people) {
		this.people = people;
	}

	private int people;

	public void setPlaguePercent(int plaguePercent) {
		this.plaguePercent = plaguePercent;
	}

	public int plaguePercent;
	public void setBushelsFed(int bushelsFed) {
		this.bushelsFed = bushelsFed;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

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

	public void setPercentStarved(float percentStarved) {
		this.percentStarved = percentStarved;
	}

	float percentStarved;
	int userInput;
	int newLV;
	String userInputString;
	int game;
	int minAttack;
	int maxAttack;
	int attackResult;
	int n;
	int bushelsHarvested;

	public void setPeopleStarved(int peopleStarved) {
		this.peopleStarved = peopleStarved;
	}

	public void setUprising(boolean uprising) {
		this.uprising = uprising;
	}

	public Hamurabi() {
		this.population = 100;
		this.totalBushels = 2800;
		this.landValue = 19;
		this.acres = 1000;
		this.buyOrSellLoopSwitch = 2;
		this.buyOrSellLoopSwitch2 = false;
		this.feedGrainLoopSwitch = false;
		this.plantSeedLoopSwitch = false;
		this.newLV = 19;
		this.year = 1;
		this.peopleStarved = 0;
		this.n = 0;
		this.plaguePercent = 0;
		this.people = 0;
		this.chance = 0;
		this.percentStarved = 0;
	}
	public void setBushelsPlanted(int bushelsPlanted){
		this.bushelsPlanted = bushelsPlanted;

	}

	public void setTotalBushels(int totalBushels){
		this.totalBushels = totalBushels;

	}

	public void setBushelsPerAcre(int bushelsPerAcre){
		this.bushelsPerAcre = bushelsPerAcre;

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

	 public int peopleStarved() {
		if ((bushelsFed / 20) < population) {
			peopleStarved += (population - (bushelsFed / 20));
			population = population - peopleStarved;
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
				}
				else if(userInput < 0){
					System.out.println("Number must be 0 or more");
				}
				else {
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
				}
				else if(userInput < 0){
					System.out.println("Number must be 0 or more");
				}
				else {
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
					bushelsFed = userInput;
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

	public int newHarvest(){
		//IF YEAR CHANGES??
		//while(year < 10)??
		Random random = new Random();
		bushelsPerAcre = random.nextInt(6 + 1);

		bushelsHarvested += (bushelsPlanted * bushelsPerAcre);
		totalBushels += bushelsHarvested;
		return bushelsHarvested;
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

	public int ratAttack() {
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

	public int plague(){
		Random r = new Random();
		int plaguePercent = 15;
		int chance = r.nextInt(100);
		if(plaguePercent > chance){
			System.out.println(("Covid-15 plague has wiped out half your people! hahahaha"));
			population -= population / 2;

		}
			return population;
//		System.out.println(("You only have half your bushels left, only " + totalBushels + (" remaining.")));;
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
		for(game.year = 1; game.year <= 10; game.year++) {
			game.printSummary();
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
			game.peopleStarved();
			game.switchReset();
		}

	}
}







