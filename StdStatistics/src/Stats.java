import edu.princeton.cs.introcs.*;
import java.util.Random;
import java.util.Scanner;

public class Stats {

	public static void main(String[] args) {
		//User Input
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the length of the ammount of random numbers you wish to do statistical analysis with: ");
		int length = keyboard.nextInt();
		
		//Random Number Generation
		StdDraw.setXscale(0,100);
		StdDraw.setYscale(0,100);
		Random rng = new Random();
		double[] arr = new double[length];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rng.nextInt(99) + 1;
		}
		//Graphing & Statistical Analysis
		StdDraw.setPenColor(StdDraw.GREEN);
		StdStats.plotLines(arr);
		StdDraw.setPenColor(StdDraw.BLACK);
		StdStats.plotBars(arr);
		System.out.println("\n***********Descriptive Statistics***********");
		System.out.println("The Max of the data is: " + StdStats.max(arr));
		System.out.println("The Min of the data is: " + StdStats.min(arr));
		System.out.println("The mean of the data is: " + StdStats.mean(arr));
		System.out.println("The Standard Deviation of the data is: " + StdStats.stddev(arr));
		System.out.println("The Variance of the data is: " + StdStats.var(arr));
		System.out.println("The range of the data is: " + (StdStats.max(arr) - StdStats.min(arr)));
	}
	
}
