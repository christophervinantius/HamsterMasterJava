import java.util.Random;
import java.util.Scanner;

public class HamsterMasterJava {

	Scanner scan = new Scanner(System.in);
	Random rand = new Random();
	int hour;
	int day;
	int score;
	int happiness;
	int energy;
	String name;
	
	public void work() {
		System.out.println(" ");
		if(happiness <= 50) {
			System.out.println(name + " doesn't have enough happiness!");
			System.out.println("Press any key to continue...");
			scan.nextLine();
			doSimulation();
		}else{
			int x, y, result = 0, answer, operator, happinessDrain, energyDrain, scoreGain;
			operator = rand.nextInt(2);
			x = rand.nextInt(100-1) + 1;
			y = rand.nextInt(100-1) + 1;
			System.out.println("What's the result for the following equation?");
			if(operator == 0) {
				System.out.println(x + " + " + y);
				result = x + y;
			}else if(operator == 1) {
				System.out.println(x + " - " + y);
				result = x - y;
			}
			System.out.print(">> ");
			answer = scan.nextInt();
			scan.nextLine();
			System.out.println(" ");
			System.out.println("Right answer: " + result);
			System.out.println(" ");
			hour++;
			happinessDrain = 10;
			happiness -= happinessDrain;
			energyDrain = rand.nextInt(20-1) + 1;
			energy -= energyDrain;
			if(answer == result) {
				System.out.println(name + "'s answer is right!");
				scoreGain = 10 + day;
				score += scoreGain;
				System.out.println(name + " gets " + scoreGain + " score!");
				System.out.println(name + " uses " + happinessDrain + " of its happiness!");
				System.out.println(name + " uses " + energyDrain + " of its energy!");
				System.out.println("Press any key to continue...");
				scan.nextLine();
				doSimulation();
			}else{
				System.out.println(name + "'s answer is wrong!");
				score += 0;
				System.out.println(name + " doesn't get any score!");
				System.out.println(name + " uses " + happinessDrain + " of its happiness!");
				System.out.println(name + " uses " + energyDrain + " of its energy!");
				System.out.println("Press any key to continue...");
				scan.nextLine();
				doSimulation();
			}
		}
	}
	
	public void play() {
		System.out.println(" ");
		int gain, drain = 10;
		hour += 2;
		if(happiness == 100) {
			System.out.println(name + " is playing!");
			System.out.println(name + "'s happiness are full!");
			System.out.println(name + " uses " + drain + " of its energy!");
			System.out.println("Press enter to continue. . .");
			scan.nextLine();
			doSimulation();
		}else{
			System.out.println(name + " is playing!");
			gain = 15;
			happiness += gain;
			if(happiness > 100) {
				gain -= (happiness - 100);
				happiness = 100;
			}
			System.out.println(name + " gets " + gain + " point of happiness!");
			energy -= drain;
			System.out.println(name + " uses " + drain + " of its energy!");
			System.out.println("Press any key to continue...");
			scan.nextLine();
			doSimulation();
		}
	}
	
	public void sleep() {
		System.out.println(" ");
		if(energy >= 50) {
			System.out.println(name + " doesn't want to sleep!");
			System.out.println("Press any key to continue...");
			scan.nextLine();
			doSimulation();
		}else {
			System.out.println(name + " is sleeping!");
			int gain = 100 - energy;
			System.out.println(name + " gets " + gain + " point of energy!");
			energy = 100;
			day++;
			hour = 5;
			System.out.println("Press any key to continue...");
			scan.nextLine();
			doSimulation();
		}
	}
	
	public void endSimulation() {
		System.out.println(" ");
		System.out.println("Game over!");
		System.out.println("Your total score: " + score);
		System.out.println("Press any key to continue...");
		scan.nextLine();
		mainMenu();
	}
	
	public void doSimulation() {
		System.out.println(" ");
		if(energy <= 0) {
			System.out.println("Game over!");
			System.out.println(name + " has run out of energy!");
			System.out.println("Your total score: " + score);
			System.out.println("Press any key to continue...");
			scan.nextLine();
			mainMenu();
		}else {
			System.out.println("=================");
			System.out.println("Simulation Status");
			System.out.println("=================");
			System.out.println(" ");
			hour %= 24;
			System.out.println("Score: " + score);
			System.out.println("Day: " + day);
			if(hour < 10) {
				System.out.println("Hour: 0" + hour + ":00");
			}else {
				System.out.println("Hour: " + hour + ":00");
			}
			System.out.println(name + "'s happiness: " + happiness);
			System.out.println(name + "'s energy: " + energy);
			System.out.println(" ");
			System.out.println("===============");
			System.out.println("Simulation Menu");			
			System.out.println("===============");
			System.out.println(" ");
			System.out.println("1. Work");
			System.out.println("2. Play");
			System.out.println("3. Sleep");
			System.out.println("4. End Simulation");
			int choice;
			do {
				System.out.print(">> ");
				choice = scan.nextInt();
				scan.nextLine();
			}while(choice < 1 || choice > 4);
			switch(choice) {
				case 1:
					work();
					break;
				case 2:
					play();
					break;
				case 3:
					sleep();
					break;
				case 4:
					endSimulation();
					break;
			}
		}
	}
	
	public void simulationMenu() {
		hour = 5;
		day = 1;
		score = 0;
		happiness = 100;
		energy = 100;
		System.out.println(" ");
		do {
			System.out.print("What's your hamster's name? [5-12]: ");
			name = scan.nextLine();
		}while(name.length() < 5 || name.length() > 12);
		System.out.println(name + " has been added!");
		System.out.println("Press any key to continue...");
		scan.nextLine();
		doSimulation();
	}
	
	public void howToPlay() {
		System.out.println(" ");
		System.out.println("============");
		System.out.println("How To Play?");
		System.out.println("============");
		System.out.println(" ");
		System.out.println("1. Introduction:");
		System.out.println("Hamster Master is a Simulation Application for someone that want to practice");
		System.out.println("their nurture skill before actually buy a real hamster to pet.");
		System.out.println(" ");
		System.out.println("2. Guide to be a better Hamster Master:");
		System.out.println("- You need to make score as much as possible.");
		System.out.println("- Make your hamster work so you can earn score.");
		System.out.println("- Make your hamster play if its happiness point are low.");
		System.out.println("- Make your hamster sleep if its energy point are low.");
		System.out.println("- The simulation will end if its energy point are below or equal to 0.");
		System.out.println(" ");
		System.out.println("Press any key to continue...");
		scan.nextLine();
		mainMenu();
	}
	
	public void mainMenu() {
		System.out.println(" ");
		System.out.println("==============");
		System.out.println("Hamster Master");
		System.out.println("==============");
		System.out.println(" ");
		System.out.println("1. Start Simulation");
		System.out.println("2. How To Play?");
		System.out.println("3. Exit");
		int choice;
		do{
			System.out.print(">> ");
			choice = scan.nextInt();
			scan.nextLine();
		}while(choice < 1 || choice > 3);
		switch(choice) {
			case 1:
				simulationMenu();
				break;
			case 2:
				howToPlay();
				break;
			case 3:
				System.out.println(" ");
				System.out.println("========");
				System.out.println("Goodbye!");
				System.out.println("========");
				return;
		}
	}
	
	public HamsterMasterJava() {
		mainMenu();
	}

	public static void main(String[] args) {
		new HamsterMasterJava();
	}

}