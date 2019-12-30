import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.math.*;


// Student Name: Armaan Merchant     Student number: 20047267     student ID: 16am122

//program description : calculating pi using multiple formulas

public class Calculating_Pi {

	 // Used to count iterations
    public static int count;
    // For screen input
    private static Scanner screenInput = new Scanner(System.in);


//methods start here

    //the big decimal bbp method, for some reason the math is the same as the double bbp but gives 3.5...
    //maybe because of big decimal nested arithmetic
public static BigDecimal piCalculatorBBPBig(int digits) {

		System.out.println("BigDecimal Start");

		//defining the numbers and variables i need as big decimal objects
		BigDecimal one = new BigDecimal("1");
		BigDecimal two = new BigDecimal("2");
		BigDecimal four = new BigDecimal("4");
		BigDecimal five = new BigDecimal("5");
		BigDecimal six = new BigDecimal("6");
		BigDecimal eight = new BigDecimal("8");
		BigDecimal sixteen = new BigDecimal("16");
		BigDecimal sum = new BigDecimal("0");
		BigDecimal term;
		BigDecimal power;
		BigDecimal oneOver16ToK;
		BigDecimal fraction1;
		BigDecimal fraction2;
		BigDecimal fraction3;
		BigDecimal fraction4;
		BigDecimal bigD_k;

		count = 0;
		for (int k=0; k<99999; k++) {  //for loop used as while loop never reached end statement using summation

    		bigD_k = new BigDecimal(k);  //big decimal version of k for arithmetic
    		power = sixteen.pow(k);

    		//defining variables for each part of the equation as it makes it easier to put it into sum
			oneOver16ToK = one.divide(power,digits,RoundingMode.HALF_EVEN);
			fraction1 = (four.divide( ((eight.multiply(bigD_k)).add(one)), digits, RoundingMode.HALF_EVEN));
			fraction2 = two.divide( ((eight.multiply(bigD_k)).add(four)), digits, RoundingMode.HALF_EVEN);
			fraction3 = one.divide( ((eight.multiply(bigD_k)).add(five)), digits, RoundingMode.HALF_EVEN);
			fraction4 = one.divide( ((eight.multiply(bigD_k)).add(six)), digits, RoundingMode.HALF_EVEN);

    		term = oneOver16ToK.multiply(  ( fraction1.subtract(fraction2.subtract(fraction3.subtract(fraction4))) )  );
    		sum = sum.add(term);
    		count++;
    	}
    	System.out.println("Big Decimal end");
    	return sum;





	}

		//calls the arcTanDoubleModified function to calculate the 3 arctan values and returns the formula for Pi
	public static double arcTanPiCalculatorDoubleModified() {
		double arctan10 = arcTanDoubleModified(1.0/10.0);
		double arctan515 = arcTanDoubleModified(1.0/515.0);
		double arctan239 = arcTanDoubleModified(1.0/239.0);
		return 4*(8*arctan10 - 4*arctan515 - arctan239);
	}
		//calls the arcTanDouble function to calculate the 3 arctan values and returns the formula for Pi
	public static double arcTanPiCalculatorDouble() {
		double arctan10 = arcTanDouble(1.0/10.0);
		double arctan515 = arcTanDouble(1.0/515.0);
		double arctan239 = arcTanDouble(1.0/239.0);
		return 4*(8*arctan10 - 4*arctan515 - arctan239);
	}


	//calls the arcTanFloat function to calculate the 3 arctan values and returns the formula for Pi
	public static float arcTanPiCalculatorFloat() {
		float arctan10 = arcTanFloat(1.0/10.0);
		float arctan515 = arcTanFloat(1.0/515.0);
		float arctan239 = arcTanFloat(1.0/239.0);
		return 4*(8*arctan10 - 4*arctan515 - arctan239);

	}

		//uses a while loop to run through the leibniz formula till it breaks out because adding it doesn't
		//affect the sum anymore
	 public static float piCalculatorLeibniz() {
	    	float leibniz = 0;
	    	float term = 3;
	    	float n = 0;
	    	double power;
    		float top;
    		float bottom;
    		count = 0;
    		System.out.println("Leibniz calculation started");

	    	while (leibniz != term+leibniz) {
	    		power = Math.pow(-1,n);
	    		top = (float)power;
	    		bottom = (2*n) +1;
	    		term = top/bottom;
	    		leibniz += term;
	    		n ++;
	    		count++;
	    	}
	    	return leibniz*4;
	    }

	 //uses the similar while loop to leibniz to run through BBP formula
	 public static double piCalculatorBBP() {
	    	double BBP = 0;   // is my total sum
	    	double term = 3;
	    	double k = 0;
	    	double power;
	    	count=0;

	    	while (BBP != term+BBP) {
	    		power = Math.pow(16,k);
	    		term = (1/power)*( (4/(8*k+1)) - (2/(8*k+4)) - (1/(8*k+5)) - (1/(8*k+6)) );
	    		BBP += term;
	    		k ++;
	    		count++;
	    	}
	    	return BBP;
	    }


	 public static float arcTanFloat(double x) {
		  	float arctan = 0;
	    	float term = 3;
	    	float n = 0;
	    	    							// defining the variables used in the loop and setting values
	    									//if necessary for the loop
	    	double power;
    		float top;
    		float bottom;
    		double powerx;
    		float xMultiple;
    		count = 0;

	    	while (arctan != term+arctan) {
	    		power = Math.pow(-1,n);
	    		powerx = Math.pow(x,2*n+1);
	    		top = (float)power;              //need to convert the power from double to float in two cases
	    		bottom = (2*n) +1;
	    		xMultiple = (float)powerx;

	    		term = (top/bottom)*xMultiple;
	    		arctan += (top/bottom)*xMultiple;
	    		n ++;
	    		count++;
	    	}
	    	return arctan;
	 }

	 //very similar to arctanfloat but only uses double values and does'nt have to convert types
	 public static double arcTanDouble(double x) {
		  	double arctan = 0;
	    	double term = 3;
	    	double n = 0;

	    	double power;
	    	double bottom;
	    	double powerx;
	    	count=0;

	    	while (arctan != term+arctan) {
	    		power = Math.pow(-1,n);
	    		powerx = Math.pow(x,2*n+1);
	    		bottom = (2*n) +1;

	    		term = (power/bottom)*powerx;
	    		arctan += (power/bottom)*powerx;
	    		n ++;
	    		count++;
	    	}
	    	return arctan;
	 }


	 //arctandouble but modified to use kahan method of catching values that round off and adding it back to the sum later to improve accuracy
	 public static double arcTanDoubleModified(double x) {
		  	double arcTan = 0;
	    	double term = 3;
	    	double n = 0;
	    	double tempSum;
	    	double portionOfTermInSum;
	    	double remainder = 0;
	    	count=0;
	    	double power;
	    	double bottom;
	    	double powerx;

	    	while (arcTan != term+arcTan) {
	    		power = Math.pow(-1,n);
	    		powerx = Math.pow(x,2*n+1);
	    		bottom = (2*n) +1;

	    		term = ((power/bottom)*powerx) + remainder;
	    		tempSum = arcTan + term;
	    		portionOfTermInSum = tempSum - arcTan;
	    		remainder = term - portionOfTermInSum;
	    		arcTan = tempSum;
	    		n ++;
	    		count++;
	    	}
	    	return arcTan;
	 }






    // Aids in displaying BigDecimal numbers to the screen using 100
    // digits per line.
    public static void displayResult(BigDecimal aNum) {
    	var asString = aNum.toString();
    	for(int i = 0; i < asString.length(); i++) {
    		System.out.print(asString.charAt(i));
    		if (i > 0 && (i + 1) % 100 == 0)
    			System.out.println();
    	}
    	System.out.println();
    } // end displayResult




    // Simplifies reporting the execution time and the number of iterations
    public static void timeIterationsReport(long start) {
        long finishTime = System.nanoTime();
        long diff = finishTime - start;
        if (diff <= 1e3)
            System.out.print("Took " + diff + " nanosec., ");
        else if (diff <= 1e6)
            System.out.print("Took " + Math.round(diff / 10.0) / 100.0 + " microsec. ");
        else if (diff <= 1e9)
        	System.out.print("Took " + Math.round(diff / 1e4) / 100.0 + " millisec. ");
        else
        	System.out.print("Took " + Math.round(diff / 1e7) / 100.0 + " sec. ");
        System.out.println("and required " + count + " iterations.");
        count = 0;
    } // end timeReport


    // Used to calculate and display the accuracy of a 16 digit result using the value of
    // pi stored in the Math class.
    public static void accuracyReport(double estimate) {
    	var error = 100 * (estimate - Math.PI) / Math.PI;
    	System.out.printf("Error is %.2e percent.\n\n", error);
    } // end accuracyReport

    // Copied from IOHelper (only method needed)
    public static int getInt(int low, String prompt, int high) {
        int numFromUser = 0;
        String dummy;
        boolean numericEntryOK;
        do {
            System.out.print(prompt);
            numericEntryOK = false;
            try {
                numFromUser = screenInput.nextInt();
                numericEntryOK = true;
            } catch (InputMismatchException e) {
                dummy = screenInput.nextLine();
                System.out.println(dummy + " is not an integer!");
                numFromUser = low;
            } // end try-catch
            // Indicate to the user why he is being prompted again.
            if (numFromUser < low || numFromUser > high) {
                System.out.println("The number is outside the legal limits.");
            }
        } while (!numericEntryOK || numFromUser < low || numFromUser > high);
        return numFromUser;
    } // end full parameter getInt method

    // This supplied main method uses assumed method names that you may certainly change.
    public static void main(String[] args) {

        long startTime;
        double estimate;
        int numDigitsDesired;

        System.out.printf("Math.PI is:\n%.16f\n\n", Math.PI);

        startTime = System.nanoTime();
        estimate = piCalculatorLeibniz();
        System.out.printf("%.16f - using Leibniz formula with float.\n", estimate);
        timeIterationsReport(startTime);
        accuracyReport(estimate);

        startTime = System.nanoTime();
        estimate = arcTanPiCalculatorFloat();
        System.out.printf("%.16f - using arcTan formula with float.\n", estimate);
        timeIterationsReport(startTime);
        accuracyReport(estimate);

        startTime = System.nanoTime();
        estimate = arcTanPiCalculatorDouble();
        System.out.printf("%.16f - using arcTan formula with double.\n", estimate);
        timeIterationsReport(startTime);
        accuracyReport(estimate);

         startTime = System.nanoTime();
        estimate = arcTanPiCalculatorDoubleModified();
        System.out.printf("%.16f - using Modified arcTan formula with double.\n", estimate);
        timeIterationsReport(startTime);
        accuracyReport(estimate);

        startTime = System.nanoTime();
        estimate = piCalculatorBBP();
        System.out.printf("%.16f - using BBP formula with double.\n", estimate);
        timeIterationsReport(startTime);
        accuracyReport(estimate);

        startTime = System.nanoTime();
        System.out.println("Using BBP formula with BigDecimals for 16 digits:");
        var estimateBigD = piCalculatorBBPBig(16);
        System.out.println(estimateBigD);
        timeIterationsReport(startTime);
        accuracyReport(estimateBigD.doubleValue());

        startTime = System.nanoTime();
        System.out.println("Using BBP formula with BigDecimals for 100 digits:");
        System.out.println(piCalculatorBBPBig(100));
        timeIterationsReport(startTime);
        System.out.println();

        numDigitsDesired = getInt(1000, "How many digits do you want to try for? ", 10000);

        startTime = System.nanoTime();
        System.out.println("Using BBP formula with BigDecimals for " + numDigitsDesired + " digits:");
        displayResult(piCalculatorBBPBig(numDigitsDesired));
        timeIterationsReport(startTime);

        screenInput.close();

    } // end main

}


/*

1) Provide a copy of the output of your program.
Math.PI is:
3.1415926535897930

Leibniz calculation started
3.1415967941284180 - using Leibniz formula with float.
Took 954.81 millisec. and required 16777216 iterations.
Error is 1.32e-04 percent.

3.1415927410125732 - using arcTan formula with float.
Took 293.93 microsec. and required 3 iterations.
Error is 2.78e-06 percent.

3.1415926535897927 - using arcTan formula with double.
Took 323.83 microsec. and required 5 iterations.
Error is -1.41e-14 percent.

3.1415926535897936 - using Modified arcTan formula with double.
Took 351.18 microsec. and required 5 iterations.
Error is 1.41e-14 percent.

3.1415926535897930 - using BBP formula with double.
Took 334.77 microsec. and required 12 iterations.
Error is 0.00e+00 percent.

Using BBP formula with BigDecimals for 16 digits:
BigDecimal Start
Big Decimal end
3.55159776886264026656311818595862
Took 934.6 millisec. and required 99999 iterations.
Error is 1.31e+01 percent.

Using BBP formula with BigDecimals for 100 digits:
BigDecimal Start
Big Decimal end
3.55159776886264030635094405571648741800949988479940470017498160500343619800862760153705010872776287454912022492842416311283559611979298773518508357648648201604914439035115229236920421705139436332785709
Took 1.35 sec. and required 99999 iterations.

How many digits do you want to try for?


2)Compare techniques 1 and 2 - which yields a better value and why is it better?
technique 1 is much worse than 2 because it has many more iterations which leads it to being much slower.
also its accuracy is 2 whole decimal places higher. technique 2 is better in both aspects

3)Why does this assignment not ask you to use the Leibniz formula with a double?
i think doubles are more accurate but take longer to work with when using arithmetic
therefore it you used a double with that 16 million iterations it would take forever to run

4)Compare techniques 2 and 3 - which one is better and why?
arctandouble did take 2 more iterations which is why it took slightly longer but it is so much more
accurate than arctanfloat that it is the clear winner in which method is better.

5)Were you able to improve the accuracy of the value reported by technique 3?
If so, what algorithm change(s) did you make to the technique?
i added Kahans mehtod to try minimalise round of error during the summation process
I dont actually think it did anything useful as the accuracy is the same and the time
took longer probably due to the added variables used to calculate the remainder everytime

6)Compare techniques 3 and 5 - which one is better and why?
well 5 has 0 error for accuracy so its the clear winner and its time is almost equivalent to method 3 so it doesnt lose there either

7)How does the use of a BigDecimal instead of a double affect the calculation?
  well i believe i couldnt properly use the big decimal arithmetic which lead me to a slightly off number.
  althought to me the math should work out using the big decimal function. maybe my error was using a for loop
  however when i tried to use a while loop it would never stop looping. When using a double the BBP method worked wonders.
  however i see the value in Big decimal as you can get alot more digits of Pi as you have fewer limitations
*/
