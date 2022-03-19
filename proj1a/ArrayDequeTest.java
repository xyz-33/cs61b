/** Performs some basic Array tests. */
public class ArrayDequeTest {

	/* Utility method for printing out empty checks. */
	/*
	public static boolean checkEmpty(boolean expected, boolean actual) {
		if (expected != actual) {
			System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}
	*/
	/* Utility method for printing out empty checks. */
	/*
	public static boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	 */


	public static boolean checkEqual(int expected, int actual) {
		if (expected != actual) {
			System.out.println("Deque returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Prints a nice message based on whether a test passed.
	 * The \n means newline. */
	public static void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	/** Adds a few things to the list, checking isEmpty() and size() are correct,
	 * finally printing the results.
	 *
	 * && is the "and" operation. */

	/*
	public static void addIsEmptySizeTest() {
		//System.out.println("Running add/isEmpty/Size test.");
		//System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

		ArrayDeque<String> lld1 = new ArrayDeque<String>();

		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
		passed = checkSize(1, lld1.size()) && passed;
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast("middle");
		passed = checkSize(2, lld1.size()) && passed;

		lld1.addLast("back");
		passed = checkSize(3, lld1.size()) && passed;

		System.out.println("Printing out deque: ");
		lld1.printDeque();

		printTestStatus(passed);

	}

	 */

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */

	/*
	public static void addRemoveTest() {

		//System.out.println("Running add/remove test.");

		//System.out.println("Make sure to uncomment the lines below (and delete this print statement).");

		ArrayDeque<Integer> lld1 = new ArrayDeque<Integer>();
		// should be empty
		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.removeFirst();
		// should be empty
		passed = checkEmpty(true, lld1.isEmpty()) && passed;

		printTestStatus(passed);

	}

	 */

	public static void addLastTest(){
		ArrayDeque<Integer> ArrayDeque1 = new ArrayDeque<Integer>();
		System.out.println("nextFirst="+ArrayDeque1.nextFirst+" "+"nextLast="+ArrayDeque1.nextLast+" size="+ArrayDeque1.size);
		ArrayDeque1.addLast(0);
		ArrayDeque1.addLast(1);
		ArrayDeque1.addLast(2);
		ArrayDeque1.addLast(3);
		System.out.println("nextFirst="+ArrayDeque1.nextFirst+" "+"nextLast="+ArrayDeque1.nextLast+" size="+ArrayDeque1.size);
		ArrayDeque1.addLast(4);
		ArrayDeque1.addLast(5);
		System.out.println("nextFirst="+ArrayDeque1.nextFirst+" "+"nextLast="+ArrayDeque1.nextLast+" size="+ArrayDeque1.size);
		ArrayDeque1.addLast(6);
		System.out.println("nextFirst="+ArrayDeque1.nextFirst+" "+"nextLast="+ArrayDeque1.nextLast+" size="+ArrayDeque1.size);
		ArrayDeque1.addLast(7);
		ArrayDeque1.addLast(8);
		ArrayDeque1.addLast(9);
		System.out.println("nextFirst="+ArrayDeque1.nextFirst+" "+"nextLast="+ArrayDeque1.nextLast+" size="+ArrayDeque1.size);
		ArrayDeque1.addFirst(1);
		ArrayDeque1.addFirst(2);
		ArrayDeque1.addFirst(3);
		ArrayDeque1.addFirst(4);
		ArrayDeque1.addFirst(5);
		ArrayDeque1.addFirst(6);
		ArrayDeque1.addFirst(7);
		ArrayDeque1.addFirst(1);
		ArrayDeque1.addFirst(2);
		ArrayDeque1.addFirst(3);
		ArrayDeque1.addFirst(4);
		ArrayDeque1.addFirst(5);
		ArrayDeque1.addFirst(6);
		ArrayDeque1.addFirst(7);
		System.out.println("nextFirst="+ArrayDeque1.nextFirst+" "+"nextLast="+ArrayDeque1.nextLast+" size="+ArrayDeque1.size);
		ArrayDeque1.printDeque();
		System.out.println();
		ArrayDeque1.removeFirst();
		ArrayDeque1.removeFirst();
		ArrayDeque1.removeFirst();
		ArrayDeque1.removeFirst();
		ArrayDeque1.removeFirst();
		ArrayDeque1.removeFirst();
		ArrayDeque1.removeFirst();
		ArrayDeque1.printDeque();
		System.out.println();
		ArrayDeque1.removeLast();
		ArrayDeque1.removeLast();
		ArrayDeque1.removeLast();
		ArrayDeque1.removeLast();
		ArrayDeque1.removeLast();
		ArrayDeque1.removeLast();
		ArrayDeque1.removeLast();
		ArrayDeque1.removeLast();
		ArrayDeque1.removeLast();
		ArrayDeque1.printDeque();
		System.out.println();
		int returnItem = ArrayDeque1.removeLast();
		ArrayDeque1.printDeque();
		System.out.println();
		boolean passed = checkEqual(9, returnItem);
		printTestStatus(passed);
	}
	public static void main(String[] args) {
		System.out.println("Running tests.\n");
		addLastTest();

	}
} 