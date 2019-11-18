import java.util.*;

public class Stack {
	private ArrayList<Integer> stack;
	private int index;

	Stack() {
		stack = new ArrayList<Integer>();
		index = 0;
	}

	public void push(int element) {
		stack.add(element);
	}

	public int pop() {
		if (stack.get(index) != null) {
			int element = stack.get(index);
			stack.remove(index);
			return element;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	public int peek() {
		if (stack.get(index) != null) {
			return stack.get(index);
		}
		return -1;
	}

	public void incrementStack() {
		this.index++;
	}

	public int search(int element) {
		for (int index = 0; index < stack.size(); index++) {
			int current = stack.get(index);
			if (current == element) {
				return stack.indexOf(current);
			}
		}
		return -1;
	}

	public void move(int element) {
		int toMove = search(element);
		if (toMove == -1) {
			return;
		} else {
			stack.add(toMove);
		}
	}
}
