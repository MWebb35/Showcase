package a3_Q2;

import java.util.Scanner;

public class A3_Q2 {
	public static void main(String[] args) {
		//Creates an instance of the scanner
		Scanner input = new Scanner(System.in);
		
		//Boolean variable - changes if the user doesn't wish to append more items
		boolean repeat = true;
		
		//Current index that the data will be appended to
		int currentIndex = 0;
		
		//Empty 20 element arrays - to hold skier names and times accordingly 
		String[] skiierNames = new String[20];
		double[] skiierTimes = new double[20];
		
		//First, second and third podium index. Set to initial values of the first three elements of the arrays. 
		//This is due to the first three elements appending to one of these podiums
		int firstPodiumIndex = 0;
		int secondPodiumIndex = 1;
		int thirdPodiumIndex = 2;
		
		//Welcome message
		System.out.println("Welcome to Mont-Halloween Skiing Contest Ranker.\nWhenever a skier makes it to the finish line, enter their name and skiing time.");
		
		//While repeat is == true (while the user wants to continue) AND whilst the currentIndex doesn't exceed the length of the array
		while (repeat || currentIndex == 19) {
			//Prompt for input
			System.out.print("Please input the skier's name: ");
			//Next line input is appended to the currentIndex of the string array skiierNames
			//Next line allows input with spaces which was more appropriate than next() as this would skip everything but the first word
			skiierNames[currentIndex] = input.nextLine(); 
			
			//Prompt for input
			System.out.print("Please input the skier's time: ");
			//Next Double input is appended to the current index of the double array skiierTimes
			skiierTimes[currentIndex] = input.nextDouble();
			
			//Occurs if the podiums have not yet been filled
			if (currentIndex < 3) {
				//Switch using the current index
				switch (currentIndex) {
				//Case 0 - No podiums filled - First podium automatically goes to currentIndex 0
				case 0:
					//No need to assign as firstPodiumIndex is already set to 0
					//Output first podium
					System.out.println("First podium goes to " + skiierNames[firstPodiumIndex] + " who made it in " + skiierTimes[firstPodiumIndex]);
					break;
				
				//Case 1 - First podium filled
				case 1:
					//Check if smaller than first podium
					if (skiierTimes[currentIndex] < skiierTimes[firstPodiumIndex]) {
						//Assign to first podium and assign the firstPodiumIndex to the second podium
						secondPodiumIndex = firstPodiumIndex;
						firstPodiumIndex = currentIndex;
					} else {
						//Assign to second podium
						secondPodiumIndex = currentIndex;
					}
					
					//Output first and second podium
					System.out.println("First podium goes to " + skiierNames[firstPodiumIndex] + " who made it in " + skiierTimes[firstPodiumIndex]);
					System.out.println("Second podium goes to " + skiierNames[secondPodiumIndex] + " who made it in " + skiierTimes[secondPodiumIndex]);
					break;
				
				//Case 2 - First and second podium filled
				case 2:
					//Check if smaller than first podium index
					if (skiierTimes[currentIndex] < skiierTimes[firstPodiumIndex]) {
						thirdPodiumIndex = secondPodiumIndex;
						secondPodiumIndex = firstPodiumIndex;
						firstPodiumIndex = currentIndex;
					//Check if smaller than second podium index
					} else if (skiierTimes[currentIndex] < skiierTimes[secondPodiumIndex]){
						thirdPodiumIndex = secondPodiumIndex;
						secondPodiumIndex = currentIndex;
					//Assign to third podium
					} else {
						thirdPodiumIndex = secondPodiumIndex;
					}
					
					//Output first, second and third podium
					System.out.println("First podium goes to " + skiierNames[firstPodiumIndex] + " who made it in " + skiierTimes[firstPodiumIndex]);
					System.out.println("Second podium goes to " + skiierNames[secondPodiumIndex] + " who made it in " + skiierTimes[secondPodiumIndex]);
					System.out.println("Third podium goes to " + skiierNames[thirdPodiumIndex] + " who made it in " + skiierTimes[thirdPodiumIndex]);
					break;
				}
			//Else podiums all filled
			} else {
				//Check to see if podiums need to change
				if (skiierTimes[currentIndex] < skiierTimes[firstPodiumIndex]) {
					thirdPodiumIndex = secondPodiumIndex;
					secondPodiumIndex = firstPodiumIndex;
					firstPodiumIndex = currentIndex;
				} else if (skiierTimes[currentIndex] < skiierTimes[secondPodiumIndex]){
					thirdPodiumIndex = secondPodiumIndex;
					secondPodiumIndex = currentIndex;
				} else if (skiierTimes[currentIndex] < skiierTimes[thirdPodiumIndex]){
					thirdPodiumIndex = currentIndex;
				}
				
				//Output podiums
				System.out.println("First podium goes to " + skiierNames[firstPodiumIndex] + " who made it in " + skiierTimes[firstPodiumIndex]);
				System.out.println("Second podium goes to " + skiierNames[secondPodiumIndex] + " who made it in " + skiierTimes[secondPodiumIndex]);
				System.out.println("Third podium goes to " + skiierNames[thirdPodiumIndex] + " who made it in " + skiierTimes[thirdPodiumIndex]);
				
			}
			
			//Prompt the user as to if they want to add another skier
			System.out.print("Do you want to add another skier? y/yes: ");
			//Assigns input to string addAnother
			String addAnother = input.next();
			
			//Solved a logic error where the next nextLine would skip - needs to take the rest of the line but doesn't assign it to anything
			input.nextLine();
			
			//If not equal to either of the options, user does not want to continue
			if (!addAnother.equals("y") && !addAnother.equals("yes")) {
				repeat = false;
			}
			
			//Increment currentIndex ready for the next iteration
			currentIndex += 1;
		}
		
		//Closing message
		System.out.println("Goodbye!");
		
		//Closes input - avoid data leaks
		input.close();
	}
}
