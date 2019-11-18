
public class StackTest {

	public static void main(String[] args) {
		Stack myStack = new Stack();
		for (int number = 1; number <= 10; number++) {
			myStack.push(number);
		}
		for (int number = 1; number <= 5; number++) {
			int print = myStack.pop();
			System.out.println(print);
		}
		int peek = myStack.peek();
		System.out.println("\r" + peek);
		int position = myStack.search(8);
		System.out.println("postion is " + position);
		myStack.move(10);
	}

}
