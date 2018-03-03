import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdStats;
import java.util.Scanner;

public class Grapher {

	public static void main(String[] args) {

		//Rescale the coordinate system
		StdDraw.setYscale(0, 50);
		StdDraw.setXscale(0, 50);

		//Graphs the function
		double[] x = new double[10];
		double[] y = new double[10];
		for (int i = 0; i < 10; i++) {
			x[i] = i;
			y[i] = f(i);
		}


		//Plots the Bars
		StdDraw.setPenColor(StdDraw.GREEN);
		StdStats.plotBars(y);
		
		//Plots the line as well as the trapezoidal subintervals
		for (int i = 0; i < 10; i++) {
			StdDraw.setPenRadius(.01);
			StdDraw.setPenColor(StdDraw.BLACK);
			if (i < 9)
				StdDraw.line(x[i], y[i], x[i+1], y[i+1]);
			StdDraw.line(x[i], 0, x[i], y[i]);
		}

		//User Input
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the a bounds delimited followed by enter...");
		int a = keyboard.nextInt();
		System.out.println("Enter the b bounds delimited followed by enter...");
		int b = keyboard.nextInt();
		System.out.println("Enter the ammount of n subintervals...");
		int n = keyboard.nextInt();
		
		//Integrates the functions
		double integral= IntSimpson(a,b,n);
		double trapintegral = IntTrap(a,b,n);
		System.out.println("Simpsons Integral: " + integral + "\nTrapezoidal Integral: " + trapintegral);
	}

	public static double f(double x) {                                             
		return Math.pow(x, 2);													//Change Function Here!
	}

	//Simpson's Integral from a modified implementation on Stack Overflow (https://stackoverflow.com/questions/3381817/how-to-solve-an-integral-in-java)
	public static double IntSimpson(double a, double b,int n){                     
		int i,z;                                                       
		double changeX,s;                                                    

		n=2*n;
		s = f(a)*f(b);
		changeX = (b-a)/n;                                        
		z = 4;

		for(i = 1; i < n; i++){
			s = s + z * f(a+i*changeX);
			z = 6 - z;
		}
		return (s * changeX)/3;
	} 

	//Trapezoidal Integral
	static double IntTrap(double a, double b, int n) {
		//Delta x
		double changeX = (b - a) / n;   
		//Area of a Trapezoid
		double sum = changeX * 0.5 * (f(a) + f(b));    
		for (int i = 1; i < n; i++) {
			double x = a + changeX * i;
			sum += changeX * f(x);
		}
		return sum;
	}

}
