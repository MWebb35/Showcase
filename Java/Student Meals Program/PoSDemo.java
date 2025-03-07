// ---------------------------------------------------------
// Assignment 4
// Written by: MADISON WEBB 40291854
// For COMP 248 Section T – Fall 2023
// ---------------------------------------------------------

/*The purpose of the program is to create an interactive point of sale system that allows the user to update Point Of Sale objects. 
 * 
 * This file is the driver, and creates the interface of the program. The default PoS objects are hard coded in the beginning of main. 
 * 
 * The user is greeted with a welcome message and a menu is displayed with all of the options available to them. This operates within a while loop 
 * (while the user doesn't want to quit) and utilises a switch case to switch between menu options. This was the most appropriate construct as 
 * code will only be run when the user choices that option. This saves processing capacity, as compared to an if statement less intense comparisons 
 * are being made. 
 * 
 * More detail about these options will be provided below.*/
package a4_q1;

import java.util.Scanner;

public class PoSDemo{
	
	//MAIN
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//Boolean variable which handles the while loop of the program - whether the program repeats or not
		//This condition controlled loop was the easiest implementation to make recursive calls to the menu w/o having repetitive code
		boolean exit = false;
		
		//Hard codes the POSs for the system
		//POS 0
		Sales sales0 = new Sales(2, 1, 0, 4, 1);
		//Includes an extra element to allow the array to update easily when adding a card
		PrePaidCard[] cards0 = new PrePaidCard[3];
		cards0[0] = new PrePaidCard("Vegetarian", 40825164, 25, 12);
		cards0[1] = new PrePaidCard("Carnivore", 21703195, 03, 12);
		//Call to custom constructor
		PoS pos0 = new PoS(sales0, cards0);
		
		//POS 1
		Sales sales1 = new Sales(2, 1, 0, 4, 1);
		PrePaidCard[] cards1 = new PrePaidCard[3];
		cards1[0] = new PrePaidCard("Vegan", 40825164, 07, 12);
		cards1[1] = new PrePaidCard("Vegetarian", 21596387, 24, 07);
		PoS pos1 = new PoS(sales1, cards1);
		
		//POS 2
		Sales sales2 = new Sales(0, 1, 5, 2, 0);
		PrePaidCard[] cards2 = new PrePaidCard[4];
		cards2[0] = new PrePaidCard("Pescatarian",95432806, 01, 06);
		cards2[1] = new PrePaidCard("Halal", 42087913, 18, 12);
		cards2[2] = new PrePaidCard("Kosher", 40735421, 05, 04);
		PoS pos2 = new PoS(sales2, cards2);
		
		//POS 3
		Sales sales3 = new Sales(3, 2, 4, 1, 2);
		PrePaidCard[] cards3 = new PrePaidCard[1];
		PoS pos3 = new PoS(sales3, cards3);
		
		//POS 4
		Sales sales4 = new Sales(3, 2, 4, 1, 2);
		PrePaidCard[] cards4 = new PrePaidCard[1];
		PoS pos4 = new PoS(sales4, cards4);
		
		//posChoice is used in multiple places in the code, so it is initalised outside of the loop to save using unneccesary memory by redefining
		int posChoice;
		
		//Welcome message
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\r\n"
				+ "");
		System.out.println("| Welcome to Concordia CostLessBites Catering Sales Counter Application	     |\r\n"
				+ "");
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\r\n"
				+ "");
		
		//While the exit variable is not set to true - while the user doesn't want to quit
		while (!exit) {
			//Sets posChoice out of range so it can be used in the switch if necessary - valid options include 0-4 
			//This variable needs to set in each iteration of the loop so that it can be used within the switch w/o disrupting program flow
			posChoice = 5;
			//Options menu
			System.out.println("\n| What would you like to do? 						     |\r\n"
					+ "| 1 >> See the content of all PoSs                           		     |\r\n"
					+ "| 2 >> See the content of one PoS 					     |\r\n"
					+ "| 3 >> List PoSs with same $ amount of sales 				     |\r\n"
					+ "| 4 >> List PoSs with same number of Sales categories 	 		     |\r\n"
					+ "| 5 >> List PoSs with same $ amount of Sales and same number of prepaid cards|\r\n"
					+ "| 6 >> Add a PrePaiCard to an existing PoS 				     |\r\n"
					+ "| 7 >> Remove an existing prepaid card from a PoS 			     |\r\n"
					+ "| 8 >> Update the expiry date of an existing Prepaid card 		     |\r\n"
					+ "| 9 >> Add Sales to a PoS 						     |\r\n"
					+ "| 0 >> To quit 								     |\r\n"
					+ "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.print("\nPlease enter your choice and press <Enter>: ");
			int userChoice = input.nextInt();
			
			//If userChoice is not a valid choice - will iterate within the while loop again
			if (userChoice < 0 || userChoice > 9) {
				System.out.println("Sorry that is not a valid choice. Try again.\n");
			} else {
				//Switch using the choice of the user - switches between options 0-9
				switch (userChoice) {
				case 1:
					//Displays the content of each PoS
					System.out.println("Contents of each PoS:\n---------------------");
					System.out.println("PoS #0:\n"+pos0.toString(pos0));
					System.out.println("\nPoS #1:\n"+pos1.toString(pos1));
					System.out.println("\nPoS #2:\n"+pos2.toString(pos2));
					System.out.println("\nPoS #3:\n"+pos3.toString(pos3));
					System.out.println("\nPoS #4:\n"+pos4.toString(pos4));
				break;
				
				case 2:
					System.out.println("Which PoS do you want to see the contents of? (Enter number 0 to 4):");
					posChoice = input.nextInt();
					
					while (posChoice < 0 || posChoice > 4) {
						System.out.print("Please enter a number between 0 and 4: ");
						posChoice = input.nextInt();
					}
					
					//Switch through each PoS until the desired one is found
					switch (posChoice) {
						case 0:
							System.out.println(pos0.toString(pos0)); //Output the string equivalent of pos0
							break;
						case 1:
							System.out.println(pos1.toString(pos1));
							break;
						case 2:
							System.out.println(pos2.toString(pos2));
							break;
						case 3:
							System.out.println(pos3.toString(pos3));
							break;
						case 4:
							System.out.println(pos4.toString(pos4));
							break;
					}
					break;
					
					case 3:
						System.out.println("List of PoSs with same total $ Sales:\n");
						/*POS 0  evaluates against 1,2,3,4; POS1 evaluates against 2,3,4 and so on - 
						 * this is done to avoid repetition in the output as if 0 and 1 are true,
						1 and 0 will also be true (each statement only needs to be output once)*/
						
						//POS 0
						//Evaluates if two PoSs have an equal total - if they do then print the pair and the total accordingly
						if (PoS.totalSalesComparison(pos0.posSales, pos1.posSales) == true) {
							//Pos0.posSales.totalSales is used as the output as both will share the same total so this statement only needs to be run once
							System.out.println("	PoSs 0 and 1 both have " + pos0.posSales.totalSales());
						}
						
						if (PoS.totalSalesComparison(pos0.posSales, pos2.posSales) == true) {
							System.out.println("	PoSs 0 and 2 both have " + pos0.posSales.totalSales());
						}
						
						if (PoS.totalSalesComparison(pos0.posSales, pos3.posSales) == true) {
							System.out.println("	PoSs 0 and 3 both have " + pos0.posSales.totalSales());
						}
						
						if (PoS.totalSalesComparison(pos0.posSales, pos4.posSales) == true) {
							System.out.println("	PoSs 0 and 4 both have " + pos0.posSales.totalSales());
						}
						
						//POS 1
						if (PoS.totalSalesComparison(pos1.posSales, pos2.posSales) == true) {
							System.out.println("	PoSs 1 and 2 both have " + pos1.posSales.totalSales());
						}
						
						if (PoS.totalSalesComparison(pos1.posSales, pos3.posSales) == true) {
							System.out.println("	PoSs 1 and 3 both have " + pos1.posSales.totalSales());
						}
						
						if (PoS.totalSalesComparison(pos1.posSales, pos4.posSales) == true) {
							System.out.println("	PoSs 1 and 4 both have " + pos1.posSales.totalSales());
						}
						
						//POS 2
						if (PoS.totalSalesComparison(pos2.posSales, pos3.posSales) == true) {
							System.out.println("	PoSs 2 and 3 both have " + pos2.posSales.totalSales());
						}
						
						if (PoS.totalSalesComparison(pos2.posSales, pos4.posSales) == true) {
							System.out.println("	PoSs 2 and 4 both have " + pos2.posSales.totalSales());
						}
						
						//POS 3
						if (PoS.totalSalesComparison(pos3.posSales, pos4.posSales) == true) {
							System.out.println("	PoSs 3 and 4 both have " + pos3.posSales.totalSales());
						}
					break;
					
				case 4:
					//Uses a similar system as case 3 to avoid repetitive outputs
					System.out.println("List of PoSs with same Sales categories:\n");
					//POS 0
					if (PoS.salesDistribution(pos0.posSales, pos1.posSales) == true) {
						System.out.println("	PoSs 0 and 1 both have " + pos0.posSales.toString());
					}
					
					if (PoS.salesDistribution(pos0.posSales, sales2) == true) {
						System.out.println("	PoSs 0 and 2 both have " + pos0.posSales.toString());
					}
					
					if (PoS.salesDistribution(pos0.posSales, pos3.posSales) == true) {
						System.out.println("	PoSs 0 and 3 both have " + pos0.posSales.toString());
					}
					
					if (PoS.salesDistribution(pos0.posSales, pos4.posSales) == true) {
						System.out.println("	PoSs 0 and 4 both have " + pos0.posSales.toString());
					}
					
					//POS 1
					if (PoS.salesDistribution(pos1.posSales, sales2) == true) {
						System.out.println("	PoSs 1 and 2 both have " + pos1.posSales.toString());
					}
					
					if (PoS.salesDistribution(pos1.posSales, pos3.posSales) == true) {
						System.out.println("	PoSs 1 and 3 both have " + pos1.posSales.toString());
					}
					
					if (PoS.salesDistribution(pos1.posSales, pos4.posSales) == true) {
						System.out.println("	PoSs 1 and 4 both have " + pos1.posSales.toString());
					}
					
					//POS 2
					if (PoS.salesDistribution(pos2.posSales, pos3.posSales) == true) {
						System.out.println("	PoSs 2 and 3 both have " + pos2.posSales.toString());
					}
					
					if (PoS.salesDistribution(pos2.posSales, pos4.posSales) == true) {
						System.out.println("	PoSs 2 and 4 both have " + pos2.posSales.toString());
					}
					
					//POS 3
					if (PoS.salesDistribution(pos3.posSales, pos4.posSales) == true) {
						System.out.println("	PoSs 3 and 4 both have " + pos3.posSales.toString());
					}
					break;
					
				case 5: 
					//Uses a similar system as case 3 and 4 to avoid repetitive outputs
					System.out.println("List of PoSs with same $ amount of sales and same number of PrePaidCards:\n");
					
					//POS 0
					if (PoS.equals(pos0, pos1) == true) {
						System.out.println("	PoSs 0 and 1");
					}
					
					if (PoS.equals(pos0, pos2) == true) {
						System.out.println("	PoSs 0 and 2");
					}
					
					if (PoS.equals(pos0, pos3) == true) {
						System.out.println("	PoSs 0 and 3");
					}
					
					if (PoS.equals(pos0, pos4) == true) {
						System.out.println("	PoSs 0 and 4");
					}
					
					//POS 1
					if (PoS.equals(pos1, pos2) == true) {
						System.out.println("	PoSs 1 and 2");
					}
					
					if (PoS.equals(pos1, pos3) == true) {
						System.out.println("	PoSs 1 and 3");
					}
					
					if (PoS.equals(pos1, pos4) == true) {
						System.out.println("	PoSs 1 and 4");
					}
					
					//POS 2
					if (PoS.equals(pos2, pos3) == true) {
						System.out.println("	PoSs 2 and 3");
					}
					
					if (PoS.equals(pos2, pos4) == true) {
						System.out.println("	PoSs 2 and 4");
					}
					
					//POS 3
					if (PoS.equals(pos3, pos4) == true) {
						System.out.println("	PoSs 3 and 4");
					}
					break;
					
				case 6:
					System.out.print("Which PoS do you want to add a PrePaidCard to? (Enter number 0 to 4): ");
					posChoice = input.nextInt();
					
					//While posChoice is not a valid option
					while (posChoice < 0 || posChoice > 4) {
						System.out.print("Please enter a number between 0 and 4: ");
						posChoice = input.nextInt();
					}
					
					System.out.println("\nPlease enter the following information so that we may complete the PrePaidCard-");
					System.out.print("-->Type of PrePaidCard (Carnivore, Halal, Kosher, Pescatarian, Vegetarian, Vegan): ");
					String typeChoice = input.next();
					System.out.print("\n-->Id of the PrePaidCard owner: ");
					int idChoice = input.nextInt();
					System.out.print("\n-->Expiry day number and month (seperate by a space): ");
					int dayChoice = input.nextInt();
					int monthChoice = input.nextInt();
					
					int amountReturn = 0;
					
					/*This could use a switch or an if - an if was used here to demonstrate another way of achieving the desired output.
					 * This has to use either a switch or an if in order to target the correct PoS. This means that code is repeated, but 
					 * the amount of computational resources it consumes is minimal. Therefore, the choice was made for simplicity rather than 
					 * removing repeating code*/
					if (posChoice == 0) {
						amountReturn = pos0.addCard(typeChoice, idChoice, dayChoice, monthChoice);
					} else if (posChoice == 1) {
						amountReturn = pos1.addCard(typeChoice, idChoice, dayChoice, monthChoice);
					} else if (posChoice == 2) {
						amountReturn = pos2.addCard(typeChoice, idChoice, dayChoice, monthChoice);
					} else if (posChoice == 3) {
						amountReturn = pos3.addCard(typeChoice, idChoice, dayChoice, monthChoice);
					} else if (posChoice == 4) {
						amountReturn = pos4.addCard(typeChoice, idChoice, dayChoice, monthChoice);
					}
					
					/*Returns the amount return - could be included in the else itself but that would require 4 additional lines of code. 
					 * Therefore, the decision was made to assign the return to a variable and have one output statement*/ 
					System.out.println("You now have "+amountReturn+" PrePaidCard(s)");
					
					break;
					
				case 7:
					System.out.println("Which PoS you want to remove an PrePaiCard from? (Enter number 0 to 4): ");
					posChoice = input.nextInt();
					
					while (posChoice < 0 || posChoice > 4) {
						System.out.print("Please enter a number between 0 and 4: ");
						posChoice = input.nextInt();
					}
					
					//Removal index common to each case - initialised outside so it can be used in each w/o reinitialising
					int removalIndex;
					switch(posChoice) {
					//Switch doesn't need a default as there is an authentication while loop beforehand
					//Switch was used to display the relevant info for each PoS as information will differ between objects
					case 0 :
						//Checks if the PoS has any prepaidcards - breaks if not
						if (pos0.posCards.length == 0 || pos1.posCards.length == 0) {
							System.out.println("Sorry that PoS has no PrePaidCards");
							break;
						} 
						
						//Length is -2 as the system needs to access the position of the cards, and .length returns the amount of elements in the array. 
						//posCards has one additional blank element at the end of the array to account for the addition of the next element - this is why the length -2
						System.out.println("Which PrePaidCard do you want to update? (Enter number 0 to "+((pos0.posCards.length)-2)+"): ");
						removalIndex = input.nextInt();
						
						//If card has been removed
						if (pos0.removeCard(removalIndex, pos0.posCards) == true) {
							System.out.println("PrePaidCard was removed successfully");
						}
						break;
					case 1:
						if (pos1.posCards.length == 1 || pos1.posCards.length == 0) {
							System.out.println("Sorry that PoS has no PrePaidCards");
							break;
						} 
						
						System.out.println("Which PrePaidCard do you want to update? (Enter number 0 to "+((pos1.posCards.length)-2)+"): ");
						removalIndex = input.nextInt();
						
						if (pos1.removeCard(removalIndex, pos1.posCards) == true) {
							System.out.println("PrePaidCard was removed successfully");
						}
						break;
					case 2:
						if (pos2.posCards.length == 1 || pos2.posCards.length == 0) {
							System.out.println("Sorry that PoS has no PrePaidCards");
							break;
						} 
						
						System.out.println("Which PrePaidCard do you want to update? (Enter number 0 to "+(pos2.posCards.length-2)+"): ");
						removalIndex = input.nextInt();
						
						if (pos2.removeCard(removalIndex, pos2.posCards) == true) {
							System.out.println("PrePaidCard was removed successfully");
						}
						break;
					
					case 3:
						if (pos3.posCards.length == 1 || pos3.posCards.length == 0) {
							System.out.println("Sorry that PoS has no PrePaidCards");
							break;
						} 
						
						System.out.println("Which PrePaidCard do you want to update? (Enter number 0 to "+(pos3.posCards.length-2)+"): ");
						removalIndex = input.nextInt();
						
						if (pos3.removeCard(removalIndex, pos3.posCards) == true) {
							System.out.println("PrePaidCard was removed successfully");
						}
						break;
					
					case 4:
						if (pos4.posCards.length == 1 || pos4.posCards.length == 0) {
							System.out.println("Sorry that PoS has no PrePaidCards");
							break;
						} 
						System.out.println("Which PrePaidCard do you want to update? (Enter number 0 to "+(pos4.posCards.length-2)+"): ");
						removalIndex = input.nextInt();
						
						if (pos4.removeCard(removalIndex, pos4.posCards) == true) {
							System.out.println("PrePaidCard was removed successfully");
						}
						break;
					}
					
					break;
					
				case 8:
					System.out.println("Which PoS do you want to update a PrePaidCard from? (Enter number 0 to 4): ");
					posChoice = input.nextInt();
					
					while (posChoice < 0 || posChoice > 4) {
						System.out.print("Please enter a number between 0 and 4: ");
						posChoice = input.nextInt();
					}
			
					int cardChoice;
					/*As this case uses two switch statements, it was important to be able to break effectively from both. 
					 * The solution was a simple boolean variable that it changed if length == 0 || length == 1
					 * Later, an if statement of !valid is used to break from the outer switch*/
					boolean valid = true;
					
					switch(posChoice) {
					case 0 :
						if (pos0.posCards.length == 1 || pos0.posCards.length == 0) {
							valid = false;
							System.out.println("Sorry that PoS has no PrePaidCards");
							//Breaks from the inner switch
							break;
						} 
						//Displays PoS relevant data
						System.out.println("Which PrePaidCard do you want to update? (Enter number 0 to "+((pos0.posCards.length)-2)+"): ");
						break;
					case 1:
						if (pos1.posCards.length == 1 || pos1.posCards.length == 0) {
							valid = false;
							System.out.println("Sorry that PoS has no PrePaidCards");
							break;
						} 
						System.out.println("Which PrePaidCard do you want to update? (Enter number 0 to "+((pos1.posCards.length)-2)+"): ");
						break;
					case 2:
						if (pos2.posCards.length == 1 || pos2.posCards.length == 0) {
							valid = false;
							System.out.println("Sorry that PoS has no PrePaidCards");
							break;
						} 
						System.out.println("Which PrePaidCard do you want to update? (Enter number 0 to "+(pos2.posCards.length-2)+"): ");
						break;
					case 3:
						if (pos3.posCards.length == 1 || pos3.posCards.length == 0) {
							valid = false;
							System.out.println("Sorry that PoS has no PrePaidCards");
							break;
						} 
						System.out.println("Which PrePaidCard do you want to update? (Enter number 0 to "+(pos3.posCards.length-2)+"): ");
						break;
					case 4:
						if (pos4.posCards.length == 1 || pos4.posCards.length == 0) {
							valid = false;
							System.out.println("Sorry that PoS has no PrePaidCards");
							break;
						} 
						System.out.println("Which PrePaidCard do you want to update? (Enter number 0 to "+(pos4.posCards.length-2)+"): ");
						break;
					}
					
					//Breaks out of the outer switch
					if (!valid) {
						break;
					}
					
					//This is out of the switch as it appears to all classes
					cardChoice = input.nextInt();
	
					System.out.print("Enter new expiry day and month (seperated by a space): ");
					int newDay = input.nextInt();
					int newMonth = input.nextInt();
					
					//Switch to access appropriate PoS again
					switch(posChoice) {
						case 0 :
							//Call to instance method updateDate with the card the user wants to manipulate, and the new data
							System.out.println(pos0.updateDate(cardChoice, newDay, newMonth));
							break;
						case 1:
							System.out.println(pos1.updateDate(cardChoice, newDay, newMonth));
							break;
						case 2:
							System.out.println(pos2.updateDate(cardChoice, newDay, newMonth));
							break;
						case 3:
							System.out.println(pos3.updateDate(cardChoice, newDay, newMonth));
							break;
						case 4:
							System.out.println(pos4.updateDate(cardChoice, newDay, newMonth));
							break;
					}
					
					break;
				
				case 9:
					System.out.print("Which PoS do you want to add sales to? (Enter number 0 to 4): ");
					posChoice = input.nextInt();
					
					while (posChoice < 0 || posChoice > 4) {
						System.out.print("Please enter a number between 0 and 4: ");
						posChoice = input.nextInt();
					}
					
					System.out.println("How many junior, teen, medium, big and family meal sales do you want to add? (Enter 5 numbers, seperated by a space)");
					//Next 5 int values get assigned to next variables
					int junior = input.nextInt();
					int teen = input.nextInt();
					int medium = input.nextInt();
					int big = input.nextInt();
					int family = input.nextInt();
					
					int total = 0;
					
					//Switch for different PoSs
					switch(posChoice) {
						case 0:
							//Add each value to posSales of the particular object, then return the total and store it in total
							total = pos0.addSales(junior, teen, medium, big, family);
							break;
						case 1:
							total = pos1.addSales(junior, teen, medium, big, family);
							break;
						case 2:
							total = pos2.addSales(junior, teen, medium, big, family);
							break;
						case 3:
							total = pos3.addSales(junior, teen, medium, big, family);
							break;
						case 4:
							total = pos4.addSales(junior, teen, medium, big, family);
							break;
					}
					
					//Outputs the total - relevant to each case so exists outside of the inner switch
					System.out.println("You now have $"+(double)total);
					break;
					
				case 0:
					System.out.println("\nThank you for using Concordia CostLessBites Catering Sales Counter Application!");
					//Changes the boolean variable to true which will stop the overall while loop from iterating
					exit = true;
					break;
					
				}
			}
		}
		//Closes the input - avoids memory leaks
	   input.close();
	}
}
