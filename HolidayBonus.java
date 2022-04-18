public class HolidayBonus {
  
	//Calculates the holiday bonus for each store
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
		// Double array of bonuses
		double[] bonuses = new double[data.length];

		// Loop through i and j for every row and column
		for(int row = 0; row < data.length; row++) {
			for(int col = 0; col < data[row].length; col++) {
				double calcHigh = TwoDimRaggedArrayUtility.getHighestInColumn(data, col);
				double calcLow = TwoDimRaggedArrayUtility.getLowestInColumn(data, col);
				if(data[row][col] > 0) {
					if(data[row][col] == calcHigh) {
						bonuses[row] = bonuses[row] + high;
					}else if(data[row][col] == calcLow) {
						bonuses[row] = bonuses[row] + low;
					}else {
						bonuses[row] = bonuses[row] + other;
					}
				}
			}
		}
		return bonuses;
	}

	//Calculates the total holiday bonuses
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		// Double array of bonuses
		double[] bonuses = calculateHolidayBonus(data, high, low, other);
		// Double total
		double total = 0.0;
		// For every bonus in bonuses, add to total
		for(int i = 0; i < bonuses.length; i++) {
			//Sum total 
			total += bonuses[i];
		}
		return total;
	}

}	

		