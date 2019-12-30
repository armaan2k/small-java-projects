/*
 * name: Armaan Merchant
 * student number: 20047267
 * description: a stack data structure
 */
import java.util.ArrayList;

public class stack {
	
	static ArrayList<Object> stack = new ArrayList<Object>();

	public static void main(String[] args) {

	}

	public static boolean isEmpty(){
		//checks to see if the stack is empty
		if(stack.size()==0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	//adds an object to the top of the stack
	public void push(Object item){
		stack.add(item);
	}
	
	//removes the top object from the stack and returns it
	public Object pop(){
		if(stack.isEmpty() == true) {
			return null;
		}
		Object item = stack.get(stack.size()-1);
		stack.remove(stack.size()-1);
		return item;
	}
	
	public static Object top(){
		return stack.get(stack.size()-1);
	}
	
	public int size(){
		return stack.size();
	}
}
