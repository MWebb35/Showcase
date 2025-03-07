package a4_q1;

/*The purpose of this class is to establish the methods and attributes relevant to the PoS class*/

//POS CLASS
public class PoS{
		//ATTRIBUTES
		PrePaidCard[] posCards;
		Sales posSales;
		
		//CONSTRUCTORS
		//DEFAULT CONSTRUCTOR
		PoS(){
			posSales = new Sales();
			posCards = new PrePaidCard[1];
		}
		
		//CUSTOM CONSTRUCTOR WITH TWO OBJECT PARAMETERS
		PoS(Sales newSale, PrePaidCard[] newCards) {
			posSales = newSale;
			posCards = newCards;
		}
		
		//CUSTOM METHODS
		//Method which will return true if the total $ value of sales of two PoS objects are equal, and false otherwise.
		public static boolean totalSalesComparison(Sales compare1, Sales compare2) {
			if (compare1.totalSales() == compare2.totalSales()) {
				return true;
			} else {
				return false;
			}
		}
		
		//Method which will return true if the number of each sales category of two PoS objects are equal, and false otherwise.
		public static boolean salesDistribution(Sales compare1, Sales compare2) {
			if (compare1.toString().equals(compare2.toString())) {
				return true;
			} else {
				return false;
			}
		}
		
		//Method which will return the total $ sales of a PoS.
		public int totalSales(){
			return posSales.totalSales();
		}
		
		//Method which will return the number of prepaid cards in a PoS - length is one higher so -1 is required
		public int numberOfCards() {
			return posCards.length-1;
		}

		//Method which will add a new PrePaiCard to the PoS - returns the number of the pre-paid cards of a PoS after the addition.
		public int addCard(String type, int id, int day, int month) {
			//Creates a prepaidcard called temp card which contains what the user wants to insert 
			PrePaidCard tempCard = new PrePaidCard(type, id, day, month);
			int currentIndex;
			
			//Solved a logic error where prepaidcard arrays with no elements would cause the program to crash 
			//This ensures the method can be used in every instance
			if (posCards.length == 0) {
				currentIndex = 0;
			} else {
				currentIndex = posCards.length-1;
			}
			
			/*As the array contains a spare space at the end of the array, the temp card can be inserted straight away. 
			/This means that the array can be cloned in its entirety which makes it easier to increase the size of the array and copy the contents over */
			posCards[currentIndex] = tempCard;
			int size = posCards.length+1;
			
			//Creates a clone of the current posCards
			PrePaidCard tempcards[] = posCards.clone();
			//Creates a new array of posCards where its size is increased
			posCards = new PrePaidCard[size];
			
			//While i < length of the newly copied array, append the items. This ensures every item gets copied into the new array
			for (int i = 0; i < tempcards.length; i++) {
				posCards[i] = tempcards[i];
			}
			
			//Returns the amount of elements in the array - not length as there is now an extra space on the end of the array
			return posCards.length-1;
		}
		
		//Method which will remove a pre-paid card from the PoS - This method returns true if the removal of the card was successful and false if it was not.
		public boolean removeCard(int removeIndex, PrePaidCard[] existingArray) {
			int newLength = existingArray.length-1;
			//Create a temp array at the length of the current array - 1
			PrePaidCard tempArray[] = new PrePaidCard[newLength];
			
			//Loop through the array
			for (int i = 0, j = 0; i < existingArray.length; i++) { 
				//If i = to the index the user wants to remove, continue to the next array
	            if (i == removeIndex) { 
	                continue; 
	            } // else, append i to tempArray at position j++
	            tempArray[j++] = existingArray[i]; 
	        }
			
			//Create a new array at the new length
			posCards = new PrePaidCard[newLength];
			
			//Loop through again and append every item to the new array
			//There's a bit of code redundancy in this method but the solution demonstrates each step of removing an element from an array
			for (int i = 0; i < tempArray.length; i++) {
				posCards[i] = tempArray[i];
			}
			
			return true;
		}
		
		//Method which will update the expiry day and month of a prepaid card.
		public String updateDate(int updateIndex, int updateDay, int updateMonth) {
			posCards[updateIndex].setDay(updateDay);
			posCards[updateIndex].setMonth(updateMonth);
			return "Expiry date updated";
		}
		
		//Method which will add meals sales to the PoS - has 5 parameters, one for each meal category and returns the new total sales value payments of the PoS.
		public int addSales(int updateJunior, int updateTeen, int updateMedium, int updateBig, int updateFamily) {
			posSales.addSales(updateJunior, updateTeen, updateMedium, updateBig, updateFamily);
			return posSales.totalSales();
		}
		
		//Method which will return true if the total $ amount sales value and the number of pre-paid card of two PoS objects are equal, and false otherwise.
		public static boolean equals(PoS compare1, PoS compare2) {
			if (PoS.totalSalesComparison(compare1.posSales, compare2.posSales) == true && compare1.numberOfCards() == compare2.numberOfCards()) {
				return true;
			} else {
				return false;
			}
		}
		
		//Method which will return a string indicating the number of each meal sales category as well as the details of each pre-paid card of the PoS.
		public String toString(PoS currentObj) {
			String currentString ="";
			currentString += ""+posSales.toString()+"\n";
			if (posCards.length == 1 || posCards.length == 0) {
				currentString += "No pre-paid cards";
			} else {
			  for (int i = 0; i < posCards.length-1; i++) {
				//Returns the string value of the current index of posCards and a new space line 
				  //valueOf is there to append as an object cannot be appended to a string w/o conversion
				currentString += String.valueOf(currentObj.posCards[i] + "\n");
			   }
			}
			return currentString;
		}
		
		//Method which will return a string with just the breakdown of the sales.
		public String justString(){
			return posSales.toString();
		}	
}
