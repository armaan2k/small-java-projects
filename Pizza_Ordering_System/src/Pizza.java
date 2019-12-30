
import java.io.Serializable;

/**
 * this program represents 1 pizza order with the 5 variables
 * @author Armaan Merchant
 *
 */
public class Pizza implements Serializable {
	
	private static final long serialVersionUID = 3077433977298795869L;
	private String size;
	private String cheese;
	private String pineapple;
	private String greenPepper;
	private String ham;
	
	//full pizza constructor
	//public Pizza(String size, String cheese, String pineapple, String greenPepper, String ham) throws IllegalPizza {
		
	/**
	 * this is the full constructor which includes all the 'set' methods within it instead of having them
	 * as individual methods. checks to see if all values are legal and throws an exception if its illegal
	 * @param size defines the size of the pizza
	 * @param cheese defines amount of cheese on the pizza
	 * @param pineapple defines if there is pineapple on the pizza
	 * @param greenPepper defines if there is green peppers on the pizza
	 * @param ham defines if there is ham on the pizza
	 * @throws IllegalPizza the exception class to be thrown if needed
	 */
	public Pizza(String size, String cheese, String pineapple, String greenPepper, String ham) throws IllegalPizza {
		if (size == null || cheese == null || pineapple == null || greenPepper == null || ham == null)
			throw new IllegalPizza("Cant use Null");
		
		size = size.toLowerCase();
		cheese = cheese.toLowerCase();
		pineapple = pineapple.toLowerCase();
		greenPepper = greenPepper.toLowerCase();
		ham = ham.toLowerCase();
		
		if (size.equals("small") || size.equals("medium") || size.equals("large"))
			this.size = size;
		else
			throw new IllegalPizza("Illegal size: " + size);
		if (cheese.equals("single") || cheese.equals("double") || cheese.equals("triple"))
			this.cheese = cheese;
		else
			throw new IllegalPizza("Illegal amount of cheese: " + cheese);
		if (pineapple.equals("none") || pineapple.equals("single"))
			this.pineapple = pineapple;
		else
			throw new IllegalPizza("Illegal amount of pineapple: " + pineapple);
		if (greenPepper.equals("none") || greenPepper.equals("single"))
			this.greenPepper = greenPepper;
		else
			throw new IllegalPizza("Illegal amount of green peppers: " + greenPepper);
		if (ham.equals("none") || ham.equals("single"))
			this.ham = ham;
		else
			throw new IllegalPizza("Illegal amount of ham: " + ham);
		if (ham.equals("none") && pineapple.equals("single"))
			throw new IllegalPizza("Can't add pineapple without ham");
		if (ham.equals("none") && greenPepper.equals("single"))
			throw new IllegalPizza("Can't add green peppers without ham");
	} // end full 5 parameter constructor
	
	
	/**
	 * the smaller constructor used for a small pizza with single cheese and ham
	 * @throws IllegalPizza the exception to be thrown, should never be thrown
	 */
	public Pizza() throws IllegalPizza {
		this("small", "single", "none", "none", "single");
	} // end of small pizza with just single cheese and ham constructor
	
	
	/**
	 * a method to get the cost of the pizza. adds the cost based on size and then based on
	 * the number of toppings on the pizza
	 * @return
	 */
	public float getCost() {
		float cost = 0;
		float toppings = 0;
		if (size.equals("small")) {
			cost = 7;
		} else if (size.equals("medium")) {
			cost = 9;
		} else {
			cost = 11;
		}
		
		if (cheese.equals("double")) {
			toppings += 1;
		} else if (cheese.equals("triple")) {
			toppings += 2;
		}
		
		if (pineapple.equals("single")) {
			toppings += 1;
		}
		
		if (greenPepper.equals("single")) {
			toppings += 1;
		}
		
		if (ham.equals("single")) {
			toppings += 1;
		}
		
		cost += toppings *1.5;
		return cost;
	} // end getCost
	

	@Override
	/**formats pizza object into a string so the user can visualise it
	 *@return returns s which is a string representation of pizza
	 */
	public String toString() {
		size = size.toLowerCase();
		cheese = cheese.toLowerCase();
		pineapple = pineapple.toLowerCase();
		greenPepper = greenPepper.toLowerCase();
		ham = ham.toLowerCase();

		String s = size + " pizza, " + cheese;
		if (pineapple.equals("none") && greenPepper.equals("none") && ham.equals("none")) {
			s += " cheese.";
			s += String.format(" Cost: $" + getCost() + "0 each.");
			return s;
		} else { s+= " cheese, ";}
		if (pineapple.equals("single") && greenPepper.equals("none") && ham.equals("none")) {
			s += "pineapple.";
		}
		if (pineapple.equals("single") && greenPepper.equals("single") && ham.equals("none")) {
			s += "pineapple, green pepper.";
		}
		if (pineapple.equals("single") && greenPepper.equals("none") && ham.equals("single")) {
			s += "pineapple, ham.";
		}
		if (pineapple.equals("single") && greenPepper.equals("single") && ham.equals("single")) {
			s += "pineapple, green pepper, ham.";
		}
		if (pineapple.equals("none") && greenPepper.equals("single") && ham.equals("none")) {
			s += "green pepper.";
		}
		if (pineapple.equals("none") && greenPepper.equals("single") && ham.equals("single")) {
			s += "green pepper, ham.";
		}
		if (pineapple.equals("none") && greenPepper.equals("none") && ham.equals("single")) {
			s += "ham.";
		}
		s += String.format(" Cost: $" + getCost() + "0 each.");
		return s;
	}//end of toString
	
	
	@Override
	/**
	 * checks to see if pizza is equivalent to another pizza object
	 * @return returns a boolean; true if it is equal and false if its not equal
	 */
	public boolean equals(Object otherObject) {
		if (otherObject instanceof Pizza) {
			Pizza otherPizza = (Pizza)otherObject;
			if (size.equals(otherPizza.size))
				return otherPizza.size.equals(size) && otherPizza.cheese.equals(cheese) && otherPizza.pineapple.equals(pineapple) && otherPizza.greenPepper.equals(greenPepper) && otherPizza.ham.equals(ham);
			}
		return false;
	} // end equals
	
	@Override
	/**
	 * creates a clone for testing, not needed as pizza is immutable
	 * @return returns the clone of pizza which is not attached to the original object
	 */
	public Pizza clone() {
		Pizza pizzaClone = null;
		try {
			pizzaClone = new Pizza(size, cheese, pineapple, greenPepper, ham);
		} catch (IllegalPizza e) {
		}
		return pizzaClone;
	} // end clone
	

}//end of Pizza class
