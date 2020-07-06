/*
 * Allison Snipes
 * Course 605.201.81 Summer 2020
 * Mini Project 1
 * 
 * Application Requirements:
 * 
 * This project involves writing a program to simulate a tortoise and hare race. 
 * The contenders will each race along a horizontal course that contains at least
 * 50 positions. You may add more if you wish. The race begins with each contender 
 * at position 1. The contender that first reaches or passes the last position of
 * the course is the winner of the race.
 * 
 * There are a number of ways to design this program. One way would be to have a looping
 * construct be the overall controller of things. Each iteration would adjust the contender 
 * positions, and the loop would terminate when one of the contenders reaches the last 
 * square of the race course. You will decide on an approach as part of your design step.
 * 
 * Specifics:
 * 1. Each contender starts at position 1 (from 50). When a contender slips, they 
 *    can’t slip any further left than position 1. 
 * 2. You will use a random number generator to simulate the percentages of each type
 *    of move indicated in the table. To generate random numbers, you can research the
 *    built-in Java random number method that is part of the Math class.
 * 3. Generate a random integer, n, in the range 1 ≤ n ≤ 10. 
 *           * For the tortoise, perform a fast plod if the number is 1-5, a slow plod 
 *             if the number is 6-8, and a slip if the number is 9-10. 
 *           * For the hare, perform a big hop if the number is 1-2, a small hop if the 
 *             number is 3-5, a big slip if the number is 6, a small slip if the number 
 *             is 7-8, and fall asleep if the number is 9-10.
 * 4. You must keep track of each contender’s position and display it each time positions
 *    change. Show the letter “T” in the position of the tortoise, and the letter “H” in
 *    the position of the Hare. It is possible for the contenders to land on the same 
 *    square. When this happens, the tortoise bites the hare, and your program should 
 *    display “OUCH!!” beginning at that square. All output positions other than the “T”, 
 *    the “H”, and the “OUCH!!” should be blank.
 * 5. If the tortoise wins, display “TORTOISE WINS!!”. If the hare wins, display “HARE WINS!!”.
 *    If the race is a tie, display “IT’S A TIE!!”. At the beginning of the race, display 
 *    “AND THEY’RE OFF!!”.
 * 
 */

/*
 *  * Important notes for this block:
 * 1. Here global variables are declared and initialized (if needed)
 * 2. Different classes must be used for both the Hare and Tortoise (and position they are in the race?)
 * 3. Getter (public int) and Setter (public void) methods are used here for use in the main method (start with get then set)
 */

class Tort {
	private int position;
	
	public int getPos() {
		return position;
	}
	
	public void setPos(int pos) {
		position = pos;
	}
	
	public void fastPlod() {
		position += 3; 
	}
	
	public void slowPlod() {
		position += 1; 
	}
	
	public void slip() {
		if (position <= 6) {
			position = 1;
		} else {
			position -= 6;
		}
	}
}

class Hare {
	private int position;
	
	public int getPos() {
		return position;
	}
	
	public void setPos(int pos) {
		position = pos;
	}
	
	public void bigHop() {
		position += 9; 
	}
	
	public void smallHop() {
		position += 1; 
	}
	
	public void bigSlip() {
		if (position <= 12) {
			position = 1;
		} else {
			position -= 12;
		}
	}
	
	public void smallSlip() {
		if (position <= 2) {
			position = 1;
		} else {
			position -= 2;
		}
	}
	
	public void sleep() {
		if (position == 9 || position == 10) {
			position = position;
		} 
	}
}

/*
 * This is the main class that executes the program, all program's essential features and components are
 * put together here. The main program control flow is located in the main.
 * 
 * Important notes for this block:
 * 
 * 1. New variables are initialized with the Tortoise and Hare classes (data types)
 * 2. Set the starting positions of the contenders with the setter methods
 * 3. Randomize the position of each of the contenders (this is matching back to the contenders' class)
 * 4. List all the various cases for the positions (gait and size) of the contenders (which is determined by
 * 	  the randomization)
 * 5. Prepare various print statements based on conditions of the contenders' position (use if statements and loops)
 *    it should be in a method on its own then called in the appropriate spot
 */

public class Racing {

	public static void main(String[] args) {
		headerMessage();
		System.out.println("And theyre off!");
				
		Tort tortoise = new Tort();
		Hare rabbit = new Hare();
		
		tortoise.setPos(1);
		rabbit.setPos(1);
	
		do {
			int randomizePos = (int)(Math.random()*10);
			switch (randomizePos) {
			
				case 1:
					tortoise.fastPlod();
					rabbit.bigHop();
					break;
					
				case 2:
					tortoise.fastPlod();
					rabbit.bigHop();
					break;
					
				case 3:
					tortoise.fastPlod();
					rabbit.smallHop();
					break;
					
				case 4:
					tortoise.fastPlod();
					rabbit.smallHop();
					break;
					
				case 5:
					tortoise.fastPlod();
					rabbit.smallHop();
					break;
					
				case 6:
					tortoise.slowPlod();
					rabbit.bigSlip();
					break;
					
				case 7:
					tortoise.slowPlod();
					rabbit.smallSlip();
					break;
					
				case 8:
					tortoise.slowPlod();
					rabbit.smallSlip();
					break;
					
				case 9:
					tortoise.slip();
					rabbit.sleep();;
					break;
					
				case 10:
					tortoise.slip();
					rabbit.sleep();
					break;
			}
			
			for (int i = 1; i < 50; i++) {
				
				if (tortoise.getPos() == rabbit.getPos()) {
					System.out.println("Ouchey! Mr. Tortoise is next to Mr. Hare and bit him!\n");
				} else  {
					if(i == tortoise.getPos()) {
						System.out.print(" t ");
					} else {
						System.out.print(" _ ");
					}
					
					if(i == rabbit.getPos()) {
						System.out.print(" h ");
					} else {
						System.out.print(" _ ");
					}
				}
			}
			System.out.println(" ");
			
	} while (tortoise.getPos() != 50 && rabbit.getPos() != 50);
	
	if (tortoise.getPos() == 50 && rabbit.getPos() == 50) {
		System.out.println("What a shame... it's a tie... Mr. Tortoise Wins!");
	} else if (tortoise.getPos() == 50) {
		System.out.println("Mr. Tortoise wins!");
	} else if (rabbit.getPos() == 50) {
		System.out.println("Mr. Hare wins!");
	}
}	
	
	private static void headerMessage() {
		System.out.println("\n");
		System.out.println("+--------------------------------------------------------------------------+");
		System.out.println("|                              Welcome User:                               |");
		System.out.println("|         This application simulates a race between a Tortoise and a       |");
		System.out.println("|       Hare. Enjoy this simple application of a favorite childhood fable! |");
		System.out.println("+--------------------------------------------------------------------------+");
		System.out.println("\n");
	}


}
