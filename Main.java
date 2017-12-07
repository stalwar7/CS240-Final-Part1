import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.Random;

public class Main {
	private static LinkedStack<Integer> bun = new LinkedStack<Integer>();
	private static LinkedStack<Integer> patty = new LinkedStack<Integer>();
	private static LinkedStack<Integer> lettuce = new LinkedStack<Integer>();;
	private static LinkedStack<Integer> tomato = new LinkedStack<Integer>();
	private static LinkedStack<Integer> cheese = new LinkedStack<Integer>();
	private static LinkedStack<Integer> onion = new LinkedStack<Integer>();
	private static int wasteBun;
	private static int wastePatty;
	private static int wasteLettuce;
	private static int wasteTomato;
	private static int wasteOnion;
	private static int wasteCheese;
	private static int countItemOne;
	private static int countItemTwo;
	private static int countItemThree;
	private static int countItemFour;
	private static int countItemFive;
	private static int countItemSix;
	private static int ship = 0;
	private static Random random = new Random();
	private static int date = 1201;
	private static boolean noFood = false;

	public static void main(String[] args) throws EmptyQueueException {
		// make burger
		LinkedList<String> burger = new LinkedList<String>();
		burger.add("Bun");
		burger.add("Patty");
		burger.add("Lettuce");
		burger.add("Tomato");
		burger.add("Onion");
		// make cheese burger
		LinkedList<String> cheeseBurger = new LinkedList<String>();
		cheeseBurger.add("Cheese");
		cheeseBurger.add("Bun");
		cheeseBurger.add("Patty");
		cheeseBurger.add("Lettuce");
		cheeseBurger.add("Tomato");
		cheeseBurger.add("Onion");
		// make vegan lettuce wrap burger
		LinkedList<String> veganBurger = new LinkedList<String>();
		veganBurger.add("Lettuce");
		veganBurger.add("Lettuce");
		veganBurger.add("Tomato");
		veganBurger.add("Onion");
		// make burger no onion
		LinkedList<String> noOnionBurger = new LinkedList<String>();
		noOnionBurger.add("Bun");
		noOnionBurger.add("Patty");
		noOnionBurger.add("Lettuce");
		noOnionBurger.add("Tomato");
		// make cheese burger no onion
		LinkedList<String> noOnionCheeseBurger = new LinkedList<String>();
		noOnionCheeseBurger.add("Cheese");
		noOnionCheeseBurger.add("Bun");
		noOnionCheeseBurger.add("Patty");
		noOnionCheeseBurger.add("Lettuce");
		noOnionCheeseBurger.add("Tomato");
		// make burger no tomato
		LinkedList<String> noTomatoBurger = new LinkedList<String>();
		noTomatoBurger.add("Bun");
		noTomatoBurger.add("Patty");
		noTomatoBurger.add("Lettuce");
		noTomatoBurger.add("Onion");
		int time = 0;
		int customersLost = 0;
		int customerLine = 0;
		int numCustomers = 1;
		int orderNum = 0;
		// startShipment();
		ship = date;
		ArrayQueue<Integer> numCustomer = new ArrayQueue<Integer>(50); // only
																		// 50
																		// ppl
																		// allowed
																		// per
																		// queue
																		// -
																		// rest
																		// get
																		// removed
		LinkedDictionary<Integer, Integer> numOrders = new LinkedDictionary<Integer, Integer>(); // account
																									// for
																									// diff
																									// orders

		// Stuff added for testing
		Queue<String> completedOrders = new LinkedList<String>();
		Map<Integer, String> orderOptions = new HashMap<Integer, String>();
		orderOptions.put(1, "Burger");
		orderOptions.put(2, "Cheese Burger");
		orderOptions.put(3, "Vegan Lettuce Wrap");
		orderOptions.put(4, "Burger No Onion");
		orderOptions.put(5, "Cheese Burger No Onion");
		orderOptions.put(6, "Burger No Tomato");

		while (date <= 1231) {
			System.out.println("------------------------------------------------");
			System.out.println("~DECEMBER " + (date % 100) + "~");

			checkExpiration();
			System.out.println("\nWASTE:");
			System.out.println("Buns wasted: " + wasteBun);
			System.out.println("Patties wasted: " + wastePatty);
			System.out.println("Lettuce wasted: " + wasteLettuce);
			System.out.println("Tomatoes wasted: " + wasteTomato);
			System.out.println("Onions wasted: " + wasteOnion);
			System.out.println("Cheese wasted: " + wasteCheese);

			if (ship == date) {
				startShipment();
			}

			time = 10;
			numCustomers = 1;
			resetData();
			numOrders.clear();
			customersLost = 0;

			System.out.println("\nINVENTORY:");
			System.out.println("Buns start: " + bun.getSize());
			System.out.println("Patties start: " + patty.getSize());
			System.out.println("Lettuce start: " + lettuce.getSize());
			System.out.println("Tomatoes start: " + tomato.getSize());
			System.out.println("Onions start: " + onion.getSize());
			System.out.println("Cheese start: " + cheese.getSize());

			while (time <= 19) {
				customerLine = 1 + random.nextInt(100);
				if (customerLine > 50) {
					customersLost += customerLine - 50;
					customerLine = 50;
				}
				for (int i = 0; i < customerLine; i++) {
					numCustomer.enqueue(1 + random.nextInt(6));
				}

				while (!numCustomer.isEmpty()) {
					orderNum = numCustomer.dequeue();
					// orderNum = random.nextInt(6) +1;
					switch (orderNum) {
					case 1:
						if (lettuce.getSize() >= 1 && tomato.getSize() >= 1 && onion.getSize() >= 1
								&& bun.getSize() >= 1 && patty.getSize() >= 1) {
							lettuce.pop();
							tomato.pop();
							onion.pop();
							bun.pop();
							patty.pop();
							countItemOne++;
							completedOrders.add("Customer #" + numCustomers + " - " + orderOptions.get(orderNum));
							numOrders.add(numCustomers, orderNum);
							numCustomers++;
						} else {
							customersLost++;
						}
						break;
					case 2:
						if (lettuce.getSize() >= 1 && tomato.getSize() >= 1 && onion.getSize() >= 1
								&& bun.getSize() >= 1 && patty.getSize() >= 1 && cheese.getSize() >= 1) {
							lettuce.pop();
							tomato.pop();
							onion.pop();
							bun.pop();
							patty.pop();
							cheese.pop();
							countItemTwo++;
							completedOrders.add("Customer #" + numCustomers + " - " + orderOptions.get(orderNum));
							numOrders.add(numCustomers, orderNum);
							numCustomers++;
						} else {
							customersLost++;
						}
						break;
					case 3:
						if (lettuce.getSize() >= 2 && tomato.getSize() >= 1 && onion.getSize() >= 1) {
							lettuce.pop();
							lettuce.pop();
							tomato.pop();
							onion.pop();
							countItemThree++;
							completedOrders.add("Customer #" + numCustomers + " - " + orderOptions.get(orderNum));
							numOrders.add(numCustomers, orderNum);
							numCustomers++;
						} else {
							customersLost++;
						}
						break;
					case 4:
						if (lettuce.getSize() >= 1 && tomato.getSize() >= 1 && bun.getSize() >= 1
								&& patty.getSize() >= 1) {
							lettuce.pop();
							tomato.pop();
							bun.pop();
							patty.pop();
							countItemFour++;
							completedOrders.add("Customer #" + numCustomers + " - " + orderOptions.get(orderNum));
							numOrders.add(numCustomers, orderNum);
							numCustomers++;
						} else {
							customersLost++;
						}
						break;
					case 5:
						if (lettuce.getSize() >= 1 && tomato.getSize() >= 1 && bun.getSize() >= 1
								&& patty.getSize() >= 1 && cheese.getSize() >= 1) {
							lettuce.pop();
							tomato.pop();
							bun.pop();
							patty.pop();
							cheese.pop();
							countItemFive++;
							completedOrders.add("Customer #" + numCustomers + " - " + orderOptions.get(orderNum));
							numOrders.add(numCustomers, orderNum);
							numCustomers++;
						} else {
							customersLost++;
						}
						break;
					case 6:
						if (lettuce.getSize() >= 1 && onion.getSize() >= 1 && bun.getSize() >= 1
								&& patty.getSize() >= 1) {
							lettuce.pop();
							onion.pop();
							bun.pop();
							patty.pop();
							countItemSix++;
							completedOrders.add("Customer #" + numCustomers + " - " + orderOptions.get(orderNum));
							numOrders.add(numCustomers, orderNum);
							numCustomers++;
						} else {
							customersLost++;
						}
						break;
					}
				}
				time++;
			}

			// how do I print out dictionary?? - iterators?
			System.out.println("\nORDERS PROCESSED:");
			while (!completedOrders.isEmpty()) {
				System.out.println(completedOrders.remove());
			}

			System.out.println("\nORDER COUNT:");
			System.out.println("Number of Burger's ordered: " + countItemOne);
			System.out.println("Number of Cheese Burger'sordered: " + countItemTwo);
			System.out.println("Number of Vegan Lettuce Wraps ordered: " + countItemThree);
			System.out.println("Number of Burger No Onion ordered: " + countItemFour);
			System.out.println("Number of Cheese Burger No Onion ordered: " + countItemFive);
			System.out.println("Number of Burger No Tomato ordered: " + countItemSix);

			System.out.println("\nLOST CUSTOMERS: " + customersLost);
			System.out.println("------------------------------------------------");
			date++;
		}
	}

	private static void resetData() {
		// reset all data day to day
		wasteBun = 0;
		wastePatty = 0;
		wasteLettuce = 0;
		wasteTomato = 0;
		wasteOnion = 0;
		wasteCheese = 0;
		countItemOne = 0;
		countItemTwo = 0;
		countItemThree = 0;
		countItemFour = 0;
		countItemFive = 0;
		countItemSix = 0;
	}

	private static void checkExpiration() {
		// check if ingredients are expired
		// check if lists are full or empty
		// if date is > expired time
		// remove and count
		boolean expired = false;
		while (bun.isEmpty() == false && expired == false) {
			if (bun.peek() <= date) {
				bun.pop();
				wasteBun++;
				// System.out.println("buns left:" + bun.getSize());
			} else
				expired = true;
		}
		expired = false;
		while (patty.isEmpty() == false && expired == false) {
			if (patty.peek() <= date) {
				patty.pop();
				wastePatty++;
				// System.out.println("patties left:" + patty.getSize());
			} else
				expired = true;
		}
		expired = false;
		while (lettuce.isEmpty() == false && expired == false) {
			if (lettuce.peek() <= date) {
				lettuce.pop();
				wasteLettuce++;
				// System.out.println("lettuce left:" + lettuce.getSize());
			} else
				expired = true;
		}
		expired = false;
		while (tomato.isEmpty() == false && expired == false) {
			if (tomato.peek() <= date) {
				tomato.pop();
				wasteTomato++;
				// System.out.println("tomato left:" + tomato.getSize());
			} else
				expired = true;
		}
		expired = false;
		while (onion.isEmpty() == false && expired == false) {
			if (onion.peek() <= date) {
				onion.pop();
				wasteOnion++;
				// System.out.println("onion left:" + onion.getSize());
			} else
				expired = true;
		}
		expired = false;
		while (cheese.isEmpty() == false && expired == false) {
			if (cheese.peek() <= date) {
				cheese.pop();
				wasteCheese++;
				// System.out.println("cheese left:" + cheese.getSize());
			} else
				expired = true;
		}
	}

	private static void startShipment() {
		// add new Food items in stacks
		// if previous stack is empty - fill up
		// add random number installments
		// change shipping dates
		// account for waste ingredients
		LinkedStack<Integer> oldBun = new LinkedStack<Integer>();
		LinkedStack<Integer> oldPatty = new LinkedStack<Integer>();
		LinkedStack<Integer> oldLettuce = new LinkedStack<Integer>();
		LinkedStack<Integer> oldTomato = new LinkedStack<Integer>();
		LinkedStack<Integer> oldOnion = new LinkedStack<Integer>();
		LinkedStack<Integer> oldCheese = new LinkedStack<Integer>();

		while (!bun.isEmpty()) {
			oldBun.push(bun.pop());
		}
		while (!patty.isEmpty()) {
			oldPatty.push(patty.pop());
		}
		while (!lettuce.isEmpty()) {
			oldLettuce.push(lettuce.pop());
		}
		while (!tomato.isEmpty()) {
			oldTomato.push(tomato.pop());
		}
		while (!onion.isEmpty()) {
			oldOnion.push(onion.pop());
		}
		while (!cheese.isEmpty()) {
			oldCheese.push(cheese.pop());
		}

		ship = random.nextInt(4) + date + 3;

		for (int i = 0; i < random.nextInt(500) + 700; i++) {
			int ingredient = random.nextInt(6);

			switch (ingredient) {
			case 0:
				bun.push(date + 5);
				break;

			case 1:
				patty.push(date + 4);
				break;

			case 2:
				lettuce.push(date + 3);
				break;

			case 3:
				tomato.push(date + 3);
				break;

			case 4:
				onion.push(date + 5);
				break;

			case 5:
				cheese.push(date + 2);
				break;
			}
		}

		System.out.println("\nINCOMING SHIPMENT:");
		System.out.println("Buns added: " + bun.getSize());
		System.out.println("Patties added: " + patty.getSize());
		System.out.println("Lettuce added: " + lettuce.getSize());
		System.out.println("Tomatoes added: " + tomato.getSize());
		System.out.println("Onions added: " + onion.getSize());
		System.out.println("Cheese added: " + cheese.getSize());

		while (!oldBun.isEmpty()) {
			bun.push(oldBun.pop());
		}
		while (!oldPatty.isEmpty()) {
			patty.push(oldPatty.pop());
		}
		while (!oldLettuce.isEmpty()) {
			lettuce.push(oldLettuce.pop());
		}
		while (!oldTomato.isEmpty()) {
			tomato.push(oldTomato.pop());
		}
		while (!oldOnion.isEmpty()) {
			onion.push(oldOnion.pop());
		}
		while (!oldCheese.isEmpty()) {
			cheese.push(oldCheese.pop());
			
		}
	}

}
