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
 * 1. Here global variables are declared and initialized
 * 2. The main program control flow is located in the main
 * 3. Getter and Setter methods are used
 * 4. Different classes must be used for both the Hare and Tortoise (place those classes at the end
 *    to prevent confusion)
 */

public class Racing {
	
	

	public static void main(String[] args) {
		headerMessage();
		System.out.println("3...2...1..\n");
		System.out.println("AND THEY'RE OFF!");
				
		Tort tortoise = new Tort();
		Hare rabbit = new Hare();
		
		// start the program with setting the position with the contenders
		tortoise.setPos(1);
		rabbit.setPos(1);
		
		//set up the various cases for the race and gait of the contenders
		while (tortoise.getPos() > 0) {
			// randomize the position of each of the contenders
			int randomizePos = (int)(Math.random()*10);
			switch (randomizePos) {
			
				case 1:
					tortoise.fastPlod();
					rabbit.bigHop();
					break;
					
				case 2:
					tortoise.slowPlod();
					rabbit.bigHop();
					break;
					
				case 3:
					tortoise.slip();
					rabbit.bigHop();
					break;
					
				case 4:
					tortoise.fastPlod();
					rabbit.smallHop();
					break;
					
				case 5:
					tortoise.slowPlod();
					rabbit.smallHop();
					break;
					
				case 6:
					tortoise.slip();
					rabbit.smallHop();
					break;
					
				case 7:
					tortoise.fastPlod();
					rabbit.bigSlip();
					break;
					
				case 8:
					tortoise.slowPlod();
					rabbit.bigSlip();
					break;
					
				case 9:
					tortoise.slip();
					rabbit.bigSlip();
					break;
					
				case 10:
					tortoise.fastPlod();
					rabbit.smallSlip();
					break;
					
				case 11:
					tortoise.slowPlod();
					rabbit.smallSlip();
					break;
					
				case 12:
					tortoise.slip();
					rabbit.smallSlip();
					break;
					
				case 13:
					tortoise.fastPlod();
					rabbit.sleep();
					break;
					
				case 14:
					tortoise.slowPlod();
					rabbit.sleep();
					break;
					
				case 15:
					tortoise.slip();
					rabbit.sleep();
					break;
					
				default:
					System.out.println("An unknown error has occured, please restart the program.\n");
			}
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
