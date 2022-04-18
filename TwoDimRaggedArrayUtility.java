import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

// Class
public class TwoDimRaggedArrayUtility {	
	// Methods
	// open the file
	// read the file
  public static double[][] readFile(File file) throws FileNotFoundException {
		double[][] array;
		Scanner scanner = new Scanner(file);
		int rowCount = 0;
		while(scanner.hasNextLine()) {
			rowCount++;
			scanner.nextLine();
		}
		// close the file
		scanner.close();
		scanner = new Scanner(file);
		String line;
		array = new double[rowCount][];
		for(int i = 0; i < array.length; i++) {
			line = scanner.nextLine();
			String[] input = line.split(" ");
			array[i] = new double[input.length];
			for(int j = 0; j < array[i].length; j++) {
				array[i][j] = Double.valueOf(input[j]);
			}
		}
		scanner.close();
		return array;
	}
	// open the file
    // pass in a two dimensional data array of doubles and a file,
  	// and writes the data array into the file.
  	public static void writeToFile(double[][] data, File file) throws FileNotFoundException{
    	// open the file
    	PrintWriter outputFile = new PrintWriter(file);
    	// read the array and print into file with spaces
    	for (int i = 0; i < data.length; i++){
    		for (int j = 0; j < data[i].length; j++){
    			outputFile.write(data[i][j] + " ");
    		}
    		outputFile.println();
    	}
    	// close the file
    	outputFile.close();
    }
    // definition of the method getAverage
    // pass in a two dimensional ragged array of doubles
    // and returns the average of the elements in the array
	public static double getAverage(double[][] data) {
		double avg = 0.0;
		// Loop through i and j to increment a count
		int count = 0;
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				count++;
			}
		}
	// Divide total by number of elements found
		avg = getTotal(data) / count;
		return avg;
	}
	
	// definition of the method getTotal
	// pass in a two dimensional data array of doubles

	public static double getTotal(double[][] data) {
		double total = 0.0;
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				// Sum
				total += data[i][j];
			}
		}
		return total;
	}
	// definition of the method getRowTotal
	// pass in a two-dimensional ragged array of doubles

	public static double getRowTotal(double[][] data, int row) {
		double total = 0.0;
		for(int i = 0; i < data[row].length; i++) {
				// Sum
				total += data[row][i];
		}
		return total;
	}
	// and a column index and returns the total of that column.
	// takes a two-dimensional data array of doubles and a
	// row index and returns the index of the largest element in that column.

	public static double getColumnTotal(double[][] data, int col) {
		double total = 0.0;
		for(int i = 0; i < data.length; i++) {
			if(col < data[i].length) {
				// Sum
				total += data[i][col];
			}
		}
		return total;
	}
	// takes a two dimensional data array of doubles and a
	// row index and returns the index of the largest element in that column.
	public static double getHighestInRow(double[][] data, int row) {
		double highest = 0.0;
		for(int i = 0; i < data[row].length; i++) {
			if(i == 0) {
				highest = data[row][i];
			}else if(data[row][i] > highest) {
				highest = data[row][i];
			}
		}
		return highest;
	}
	//definition of the method getHighestInRowIndex 
	// takes a two dimensional ragged array of double and a
	// row index and returns integer type of the index of the largest element in that row
	
	public static int getHighestInRowIndex(double[][] data, int row) {
		double highest = 0.0;
		int index = -1;
		for(int i = 0; i < data[row].length; i++) {
			if(i == 0) {
				highest = data[row][i];
				index = i;
			}else if(data[row][i] > highest) {
				highest = data[row][i];
				index = i;
			}
		}
		return index;
	}
	//definition of the method getLowestInRow 
	// takes a two dimensional ragged array of double and a
	// row index and returns integer type of the index of the largest element in that row
	
	public static double getLowestInRow(double[][] data, int row) {
		double lowest = 0.0;
		for(int i = 0; i < data[row].length; i++) {
			if(i == 0) {
				lowest = data[row][i];
			}else if(data[row][i] < lowest) {
				lowest = data[row][i];
			}
		}
		return lowest;
	}
	
	//definition of the method getLowestInRowIndex
	// takes a two dimensional ragged array of doubles and a
	// row index and returns the smallest element in that row.
	public static int getLowestInRowIndex(double[][] data, int row) {
		double lowest = 0.0;
		int index = 0;
		for(int i = 0; i < data[row].length; i++) {
			if(i == 0) {
				lowest = data[row][i];
				index = i;
			}else if(data[row][i] < lowest) {
				lowest = data[row][i];
				index = i;
			}
		}
		return index;
	}
	//definition of the method getHighestInColumn   

		// pass in a two dimensional ragged array of doubles

		   	  // and a column index and returns the largest element in that column
	public static double getHighestInColumn(double[][] data, int col) {
		double highest = Double.NEGATIVE_INFINITY;
		for(int i = 0; i < data.length; i++) {
			if(col < data[i].length && data[i][col] > highest) {
				highest = data[i][col];
			}
		}
		return highest;
	}
	//definition of the method getHighestInColumnIndex
	 // takes a two dimensional ragged array of doubles and a

	 // row index and returns integer data type the index of the largest element in that column.
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double highest = Double.NEGATIVE_INFINITY;
		int idx = -1;
		for(int i = 0; i < data.length; i++) {
			if(col < data[i].length && data[i][col] > highest) {
				highest = data[i][col];
				idx = i;
			}
		}
		return idx;
	}
		// pass in a two dimensional data array of doubles and a column
	
		// index and returns the smallest element in that column
	public static double getLowestInColumn(double[][] data, int col) {
		double lowest = Double.POSITIVE_INFINITY;
		for(int i = 0; i < data.length; i++) {
			if(col < data[i].length && data[i][col] < lowest) {
				lowest = data[i][col];
			}
		}
		return lowest;
	}
		// pass in a two dimensional data array of doubles and a column
	
		// index and returns the smallest element in that column
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double lowest = Double.POSITIVE_INFINITY;
		int index = 0;
		for(int i = 0; i < data.length; i++) {
			if(col < data[i].length && data[i][col] < lowest) {
				lowest = data[i][col];
				index = i;
			}
		}
		return index;
	}
	
	//definition of the method getLowestInArray
	// pass in a two dimensional ragged array of doubles
	// and returns the smallest element in the array.
	
	public static double getLowestInArray(double[][] data) {
		double lowest = 0.0;
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				if(i == 0 && j == 0) {
					lowest = data[i][j];
				}else if(data[i][j] < lowest) {
					lowest = data[i][j];
				}
			}
		}
		return lowest;
	}
	//definition of the method getHighestInArray
	// pass in a two dimensional ragged array of doubles
	// and returns the largest element in the array.
	
	public static double getHighestInArray(double[][] data) {
		double highest = 0.0;
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				if(i == 0 && j == 0) {
					highest = data[i][j];
				}else if(data[i][j] > highest) {
					highest = data[i][j];
				}
			}
		}
		return highest;
	}
}
	//end TwoDimRaggedArrayUtility 