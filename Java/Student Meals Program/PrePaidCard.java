package a4_q1;

/*The purpose of this class is to establish the methods and attributes relevant to the PrePaidCard class*/

//PREPAIDCARD CLASS
	public class PrePaidCard{
		//ATTRIBUTES 
		private String type;
		private int id;
		private int day;
		private int month;
		
		//CONSTRUCTORS
		//DEFAULT CONSTRUCTOR - sets initial values to 0
		PrePaidCard(){
			type = "temp";
			id = 0;
			day = 0;
			month = 0;
		}
		
		//CONSTRUCTOR WITH 4 PARAMETERS
		PrePaidCard(String typeSet, int idSet, int daySet, int monthSet){
			if (typeSet.equals("Carnivore") || typeSet.equals("Halal") || typeSet.equals("Kosher") || typeSet.equals("Pescatarian") || typeSet.equals("Vegetarian") || typeSet.equals("Vegan")){
				type = typeSet;
			}
			
			id = idSet;
			
			if (daySet > 0 && daySet <= 31) {
				day = daySet;
			} else {
				day = 0;
			}
			
			if (monthSet > 0 && monthSet <= 12) {
				month = monthSet;
			} else {
				month = 0;
			}
		}
		
		//COPY CONSTRUCTOR
		public PrePaidCard(PrePaidCard prepaidcard) {
			this.type = prepaidcard.type;
			this.id = prepaidcard.id;
			this.day = prepaidcard.day;
			this.month = prepaidcard.month;
		}
		
		//ACCESSOR METHODS
		public String getType() {
			return type;
		}
		
		public int getId() {
			return id;
		}
		
		public int getDay() {
			return day;
		}
		
		public int getMonth() {
			return month;
		}
		
		//MUTATOR METHODS
		public void setDay(int newDay) {
			//If the day is a valid, make the attribute equal. Else the attribute will equal 0
			if (newDay > 0 && newDay < 32) {
				day = newDay;
			} else {
				day = 0;
			}
		}
		
		public void setMonth(int newMonth) {
			//If the month is a valid, make the attribute equal. Else the attribute will equal 0
			if (newMonth > 0 && newMonth <= 12) {
				month = newMonth;
			} else {
				month = 0;
			}
		}
		
		//CUSTOM METHODS
		public String toString() {
			//Formats date if the number is below 9
			String day2 = String.valueOf(day);
			if (!(day2.length() > 1)) {
				day2 = "0" + day2;
			}
			String month2 = String.valueOf(month);
			if (!(month2.length() > 1)) {
				month2 = "0" + month2;
			}
			return ""+type+" - "+id+" - "+day2+"/"+month2;
		}
		
		public static boolean equals(PrePaidCard objOne,PrePaidCard objTwo ) {
			//Uses get methods to compare if the attributes of the specified objects are equal. Returns a boolean accordingly
			if (objOne.getType().equals(objTwo.getType()) && objOne.getId() == objTwo.getId() && objOne.getDay() == objTwo.getDay() && objOne.getMonth() == objTwo.getMonth()) {
				return true;
			} else {
				return false;
			}
		}
	}
