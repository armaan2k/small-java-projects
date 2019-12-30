

import java.io.Serializable;
/**
 * This class creates an object LineItem that is a single line item in a pizza order
 * it has a link to pizza class and the number of pizzas ordered.
 * @author Armaan Merchant
 */
public class LineItem implements Comparable<LineItem>, Serializable {

	private static final long serialVersionUID = -4426430540640429496L;
	private int numPizzas;
	private Pizza pizza;
	
	/**
	 * The full parameter constructor
	 * @param number The number of pizzas that has been ordered. Has to lie between 1 and 100 inclusive.
	 * @param pizza The Pizza object for this order.
	 * @throws IllegalPizza If the number parameter is not valid.
	 */
	public LineItem(int number, Pizza pizza) throws IllegalPizza {
		if (pizza == null) 
			throw new IllegalPizza("Cant use Null");
		setNumber(number);
		this.pizza = pizza;
	} // end full parameter constructor
	
	/**
	 * single pizza constructor.
	 * @param pizza The Pizza object for this order
	 * @throws IllegalPizza is never thrown
	 */
	public LineItem(Pizza pizza) throws IllegalPizza {
		this(1, pizza);
	} //end of single pizza constructor
	
	/**
	 * mutator for the number of pizzas in the single line order.
	 * @param number number of pizzas that lie between 1 and 100 inclusive.
	 * @throws IllegalPizza If the number is illegal.
	 */
	public void setNumber(int number) throws IllegalPizza {
		if (number < 1 || number > 100)
			throw new IllegalPizza("Illegal number of pizzas!");
		numPizzas = number;		
	} // end setNumber
	
	/**
	 * accessor for the Pizza object.
	 * @return the pointer to the Pizza object.
	 */
	public Pizza getPizza() {
		return pizza;
	} // end getPizza
	
	/**
	 * accessor for the number of pizzas
	 * @return number of pizzas
	 */
	public int getNumber() {
		return numPizzas;
	} // end getNumber
	
	/**
	 * accessor for the total cost of this line item
	 * @return the total cost which is liable to discounts
	 */
	public float getCost() {
		if (numPizzas<=9) {
		return numPizzas * pizza.getCost();
		} else if (numPizzas >=10 && numPizzas <= 20) {
			return (float) ((numPizzas * pizza.getCost())*0.90);
		} else {
			return (float) ((numPizzas * pizza.getCost())*0.85);
		}
	} // end getCost
	
	/**
	 * shows the object as a string
	 * @return tells you the number of pizzas and describes the pizza itself
	 */
	public String toString() {
		if (numPizzas < 10)
			return " " + numPizzas + " " + pizza;
		else
			return numPizzas + " " + pizza;
	} // end toString
	
	/**
	 * Compares the current LineItem object to the one supplied. The basis for comparison is the
	 * total cost obtained through getCost().
	 * @param The supplied LineItem object.
	 * @return returns the difference total costs of 2 line items
	 */
	public int compareTo(LineItem item) {
		return (int)(item.getCost() - getCost());
	} // end compareTo
	
} // end LineItem class
