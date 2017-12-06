import java.util.EmptyStackException;
import java.util.Random;

public class InNOutMain {
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
		startShipment();
		ArrayQueue<Integer> numCustomer = new ArrayQueue<Integer>(50); //only 50 ppl allowed per queue
		LinkedDictionary<Integer, Integer> numOrders = new LinkedDictionary<Integer, Integer>(); //account for difforders
		while (date <= 1231) {
			if (ship == date) {
				startShipment();
			}
			time = 10;
			numCustomers = 1;
			resetData();
			numOrders.clear();
			customersLost = 0;
			while (time <= 19) {
				customerLine = 1 + random.nextInt(100);
				if (customerLine > 50) {
					customersLost += customerLine - 50;
					customerLine = 50;
				}
				for (int i = 0; i < customerLine; i++) {
					numCustomer.enqueue(1 + random.nextInt(6));
				}

				while (!numCustomer.isEmpty()) 
				{
					orderNum = numCustomer.dequeue();
					try {
						switch (orderNum) {
						case 1:
							lettuce.pop();
							tomato.pop();
							onion.pop();
							bun.pop();
							patty.pop();
							break;
						case 2:
							lettuce.pop();
							tomato.pop();
							onion.pop();
							bun.pop();
							patty.pop();
							cheese.pop();
							break;
						case 3:
							lettuce.pop();
							lettuce.pop();
							tomato.pop();
							onion.pop();
							break;
						case 4:
							lettuce.pop();
							tomato.pop();
							bun.pop();
							patty.pop();
							break;
						case 5:
							lettuce.pop();
							tomato.pop();
							bun.pop();
							patty.pop();
							cheese.pop();
							break;
						case 6:
							lettuce.pop();
							onion.pop();
							bun.pop();
							patty.pop();
							break;
						}
					} catch (EmptyStackException e) {
						noFood = true;
					}
					if (noFood == false) {
						if (orderNum == 1)
							countItemOne++;
						else if (orderNum == 2)
							countItemTwo++;
						else if (orderNum == 3)
							countItemThree++;
						else if (orderNum == 4)
							countItemFour++;
						else if (orderNum == 5)
							countItemFive++;
						else if (orderNum == 6)
							countItemSix++;
						numOrders.add(numCustomers, orderNum);
						numCustomers++;
					} else {
						customersLost++;
						noFood = false;
					}
				}
				time++;
			}
			//how do I print out dictionary?? - iterators?
			
			System.out.println("December " + (date % 100));
			System.out.println("Number of customers lost : " + customersLost);
			checkExpiration();
			System.out.println("Buns wasted: " + wasteBun);
			System.out.println("Patties wasted: " + wastePatty);
			System.out.println("Lettuce wasted: " + wasteLettuce);
			System.out.println("Tomatoes wasted: " + wasteTomato);
			System.out.println("Onions wasted: " + wasteOnion);
			System.out.println("Cheese wasted: " + wasteCheese);
			System.out.println("Number of Burger's ordered: " + countItemOne);
			System.out.println("Number of Cheese Burger'sordered: " + countItemTwo);
			System.out.println("Number of Vegan Lettuce Wraps ordered: " + countItemThree);
			System.out.println("Number of Burger No Onion ordered: " + countItemFour);
			System.out.println("Number of Cheese Burger No Onion ordered: " + countItemFive);
			System.out.println("Number of Burger No Tomato ordered: " + countItemSix);
			System.out.println();
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
		while (!bun.isEmpty() && expired == false) {
			if (bun.peek() <= date) {
				bun.pop();
				wasteBun++;
			} else
				expired = true;
		}
		expired = false;
		while (!patty.isEmpty() && expired == false) {
			if (patty.peek() <= date) {
				patty.pop();
				wastePatty++;
			} else
				expired = true;
		}
		expired = false;
		while (!lettuce.isEmpty() && expired == false) {
			if (lettuce.peek() <= date) {
				lettuce.pop();
				wasteLettuce++;
			} else
				expired = true;
		}
		expired = false;
		while (!tomato.isEmpty() && expired == false) {
			if (tomato.peek() <= date) {
				tomato.pop();
				wasteTomato++;
			} else
				expired = true;
		}
		expired = false;
		while (!onion.isEmpty() && expired == false) {
			if (onion.peek() <= date) {
				onion.pop();
				wasteOnion++;
			} else
				expired = true;
		}
		expired = false;
		while (!cheese.isEmpty() && expired == false) {
			if (cheese.peek() <= date) {
				cheese.pop();
				wasteCheese++;
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
		LinkedStack<Integer> newBun = new LinkedStack<Integer>();
		LinkedStack<Integer> newPatty = new LinkedStack<Integer>();
		LinkedStack<Integer> newLettuce = new LinkedStack<Integer>();
		LinkedStack<Integer> tTomato = new LinkedStack<Integer>();
		LinkedStack<Integer> newOnion = new LinkedStack<Integer>();
		LinkedStack<Integer> newCheese = new LinkedStack<Integer>();
		while (!bun.isEmpty()) {
			newBun.push(bun.pop());
		}
		while (!patty.isEmpty()) {
			newPatty.push(patty.pop());
		}
		while (!lettuce.isEmpty()) {
			newLettuce.push(lettuce.pop());
		}
		while (!tomato.isEmpty()) {
			tTomato.push(tomato.pop());
		}
		while (!onion.isEmpty()) {
			newOnion.push(onion.pop());
		}
		while (!cheese.isEmpty()) {
			newCheese.push(cheese.pop());
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
		while (!newBun.isEmpty()) {
			if (newBun.peek() >= date)
				bun.push(newBun.pop());
			else
				wasteBun++;
		}
		while (!newPatty.isEmpty()) {
			if (newPatty.peek() >= date)
				patty.push(newPatty.pop());
			else
				wastePatty++;
		}
		while (!newLettuce.isEmpty()) {
			if (newLettuce.peek() >= date)
				lettuce.push(newLettuce.pop());
			else
				wasteLettuce++;
		}
		while (!tTomato.isEmpty()) {
			if (tTomato.peek() >= date)
				tomato.push(tTomato.pop());
			else
				wasteTomato++;
		}
		while (!newOnion.isEmpty()) {
			if (newOnion.peek() >= date)
				onion.push(newOnion.pop());
			else
				wasteOnion++;
		}
		while (!newCheese.isEmpty()) {
			if (newCheese.peek() >= date)
				cheese.push(newCheese.pop());
			else
				wasteCheese++;
		}
	}

}
