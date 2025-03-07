package a4_q1;

/*The purpose of this class is to establish the methods and attributes relevant to the Sales class*/

//SALES CLASS
	public class Sales{
		//ATTRIBUTES
		//Number of sales
		private int numSales; //Total
		//Meal type specific
		private int numJunior;
		private int numTeen;
		private int numMedium;
		private int numBig;
		private int numFamily;
		
		//Constant values for sales
		static private final int junior = 5;
		static private final int teen = 10;
		static private final int medium = 12;
		static private final int big =  15;
		static private final int family = 20;
		
		//
		//CONSTRUCTORS
		//DEFAULT CONSTRUCTOR- sets all attributes to 0
		public Sales(){
			numSales = 0;
			numJunior = 0;
			numTeen = 0;
			numMedium = 0;
			numBig = 0;
			numFamily = 0;
			
		}
		
		//CUSTOM CONSTRUCTOR WITH FIVE PARAMETERS
		public Sales (int meal1, int meal2, int meal3, int meal4, int meal5) {
			numJunior = meal1;
			numTeen = meal2;
			numMedium = meal3;
			numBig = meal4;
			numFamily = meal5;
		}
		
		//COPY CONSTRUCTOR
		//Copies the current parameter to the object parameters
		public Sales(Sales SalesParam) {
			this.numSales = SalesParam.numSales;
			this.numJunior = SalesParam.numJunior;
			this.numTeen = SalesParam.numTeen;
			this.numMedium = SalesParam.numMedium;
			this.numBig = SalesParam.numBig;
			this.numFamily = SalesParam.numFamily;
		}
		
		//ACCESSORS AND MUTATORS
		//Accessor for numSales
		public int getSales() {
			return numSales;
		}
		
		//Mutator for numSales
		public void setSales(int newValue) {
			numSales += newValue;
		}
		
		//Accessor for numJunior
		public int getNumJunior() {
			return numJunior;
		}
		
		//Mutator for numJunior
		public void setNumJunior(int newValue) {
			numJunior += newValue;
		}
		
		//Accessor for numTeen
		public int getNumTeen() {
			return numTeen;
		}
				
		//Mutator for numTeen
		public void setNumTeen(int newValue) {
			numTeen += newValue;
		}
				
		//Accessor for numMedium
		public int getNumMedium() {
			return numMedium;
		}
				
		//Mutator for numJunior
		public void setNumMedium(int newValue) {
			numMedium += newValue;
		}
				
		//Accessor for numBig
		public int getNumBig() {
			return numBig;
		}
				
		//Mutator for numBig
		public void setNumBig(int newValue) {
			numBig += newValue;
		}
		
		//Accessor for numFamily
		public int getNumFamily() {
			return numFamily;
		}
				
		//Mutator for numJunior
		public void setNumFamily(int newValue) {
			numFamily += newValue;
		}
				
		//CUSTOM METHODS
		//Adds the new values to the current values
		public void addSales(int updateJunior, int updateTeen, int updateMedium, int updateBig, int updateFamily) {
			numJunior += updateJunior;
			numTeen += updateTeen;
			numMedium += updateMedium;
			numBig += updateBig;
			numFamily += updateFamily;
		}
		
		//Calculates the total sales based on the current value of the attribute and the const value it relates to
		//This means it only calculates when required which saves processing power
		public int totalSales() {
			numSales = (numJunior*junior) + (numTeen*teen) + (numMedium*medium) + (numBig*big) + (numFamily*family);
			return numSales;
		}
		
		//Returns the string value of the calculations
		public String toString() {
			return ""+numJunior+" x $"+junior+" + "+numTeen+" x $"+teen+" + "+numMedium+" x $"+medium+" + "+numBig+" x $"+big+" + "+numFamily+" x $"+family;
		}
		
		//If the objects contents equals return true
		//Can also do this using toString (this is seen in PoS.java) but wanted to showcase two different ways of achieving the desired outcome
		public static boolean equals(Sales objOne, Sales objTwo) {
			if (objOne.numJunior == objTwo.numJunior && objOne.numTeen == objTwo.numTeen && objOne.numMedium == objTwo.numMedium && objOne.numBig == objTwo.numBig && objOne.numFamily == objTwo.numFamily) {
				return true;
			} else {
				return false;
			}
			
		}
	}
