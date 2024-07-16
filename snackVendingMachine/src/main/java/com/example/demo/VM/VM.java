package com.example.demo.VM;

import java.util.Scanner;

import com.example.demo.moneyAndSnack.MoneySlot;
import com.example.demo.moneyAndSnack.SnackSlot;
import com.example.demo.moneyAndSnack.MoneySlot.CardSlot;
import com.example.demo.moneyAndSnack.MoneySlot.CoinSlot;
import com.example.demo.moneyAndSnack.MoneySlot.NotesSlot;

public class VM {
	private SnackSlot[][] snackSlots;
//defenition or declaration
	private int currSnackSlotRow;
	private int currSnackSlotColumn;
	private int currQuantity;
	private int currPrice;

	public Scanner in = new Scanner(System.in);

	private CoinSlot coinSlot;
	private NotesSlot notesSlot;
	private CardSlot cardSlot;
	private MoneySlot moneySlot;
	private int balance;

	public VM() {
		// instantiation of the defined or declared properties
		// Assume Snack slots values here
		initSnackSlots();

	}

	public void initSnackSlots() {
		snackSlots = new SnackSlot[5][5];
		// (price,quantity)
		// First Row

		snackSlots[0][0] = new SnackSlot(10, 3);
		snackSlots[0][1] = new SnackSlot(20, 4);
		snackSlots[0][2] = new SnackSlot(4, 3);
		snackSlots[0][3] = new SnackSlot(20, 5);
		snackSlots[0][4] = new SnackSlot(5, 3);

		// Second Row
		snackSlots[1][0] = new SnackSlot(20, 3);
		snackSlots[1][1] = new SnackSlot(10, 10);
		snackSlots[1][2] = new SnackSlot(14, 3);
		snackSlots[1][3] = new SnackSlot(8, 1);
		snackSlots[1][4] = new SnackSlot(18, 3);
		// Third Row
		snackSlots[2][0] = new SnackSlot(15, 3);
		snackSlots[2][1] = new SnackSlot(19, 5);
		snackSlots[2][2] = new SnackSlot(10, 3);
		snackSlots[2][3] = new SnackSlot(24, 3);
		snackSlots[2][4] = new SnackSlot(13, 3);
		// Forth Row
		snackSlots[3][0] = new SnackSlot(2, 3);
		snackSlots[3][1] = new SnackSlot(20, 2);
		snackSlots[3][2] = new SnackSlot(11, 3);
		snackSlots[3][3] = new SnackSlot(9, 4);
		snackSlots[3][4] = new SnackSlot(16, 3);
		// Fifth Row
		snackSlots[4][0] = new SnackSlot(3, 3);
		snackSlots[4][1] = new SnackSlot(20, 3);
		snackSlots[4][2] = new SnackSlot(12, 8);
		snackSlots[4][3] = new SnackSlot(4, 3);
		snackSlots[4][4] = new SnackSlot(10, 3);
	}

	public void run() {
		boolean isSnackAvailable = false;
		while (!isSnackAvailable) {
			// Customer use the keypad to input the snack slot values
			inputSnackSlotRow();
			inputSnackSlotColumn();
			inputCurrQuantity();

			// Availability and Price
			// The VM displays a message that the snack is available for the selected number
			// and displays its price
			isSnackAvailable = verifySnackAvailability();
			getSnackPrice();
			displaySnackAvailabilityAndPrice(isSnackAvailable);

			if (!isSnackAvailable)
				notifyUserToInputAgain();
		}

		boolean isEnough = false;
		while (!isEnough) {
			// The customer inserts the money.
			selectMoneySlot();

			// The VM validates the money.
			validateMoney();

			// The VM accepts the money
			// The VM displays the accumulated amount of money each time new money is
			// entered
			displayBalance();

			// The VM monitors the amount of the accepted money, If the money is enough, the
			// VM dispenses the selected snack to the customer

			isEnough = verifyIfMoneyIsEnough();

		}

		dispenseSnack();

		// The VM determines if any change should be sent back to the customer.
		boolean existChange = verifyIfChangeToReturn();

		// The VM displays the change on the panel.
		if (existChange)

			// the VM dispenses change
			dispenseChange();
	}

	private void inputSnackSlotColumn() {

		System.out.println("Please enter the snack column number: ");

		currSnackSlotColumn = in.nextInt();

	}

	private void inputSnackSlotRow() {

		System.out.println("Please enter the snack row number: ");

		currSnackSlotRow = in.nextInt();

	}

	private void inputCurrQuantity() {
		System.out.println("Please enter the snack quantity: ");

		currQuantity = in.nextInt();

	}

	private boolean verifySnackAvailability() {
		SnackSlot snackSlot = snackSlots[this.currSnackSlotRow][this.currSnackSlotColumn];
		return (currQuantity <= snackSlot.getQuantity());

	}

	private int getSnackPrice() {

		SnackSlot snackSlot = snackSlots[this.currSnackSlotRow][this.currSnackSlotColumn];

		currPrice = currQuantity * snackSlot.getPrice();
		return currPrice;

	}

	private void displaySnackAvailabilityAndPrice(boolean isSnackAvailable) {
		if (isSnackAvailable) {
			System.out.println("snack is available");
			System.out.println("the price of what you requested is: " + currPrice);
		}
	}

	public void notifyUserToInputAgain() {
		System.out.println("the quantity requested is not available");

	}

	private MoneySlot selectMoneySlot() {
		System.out.println("please select the moneySlot\n" + "1 for coins " + " 2 for notes " + " 3 for cards");

		Integer m = in.nextInt();
		switch (m) {
		case 1:
			System.out.println("coins" + " is accepted for 10c,20c,50c,100c\n" + " " + "Please enter the money  ");
			balance = in.nextInt();

			switch (balance) {
			case 10:
				return (coinSlot == CoinSlot.c10) ? moneySlot.CoinSlot : null;
			case 20:

				return (coinSlot == CoinSlot.c20) ? moneySlot.CoinSlot : null;
			case 50:
				return (coinSlot == CoinSlot.c50) ? moneySlot.CoinSlot : null;
			case 100:
				return (coinSlot == CoinSlot.c100) ? moneySlot.CoinSlot : null;
			default:
				System.out.println("the money is not valid " + "try notes");
				break;

			}

		case 2:
			System.out.println("notes" + " is accepted for 20USD and 50USD");
			System.out.println("Please enter the money ");

			balance = in.nextInt();

			switch (balance) {
			case 20:
				return (notesSlot == NotesSlot.USD20) ? moneySlot.NotesSlot : null;
			case 50:

				return (notesSlot == NotesSlot.USD50) ? moneySlot.NotesSlot : null;

			default:
				System.out.println("the money is not valid " + "try a card");
				break;

			}

		case 3:
			System.out.println("the balance of the card must have at least 100 USD ");
			System.out.println("Please enter the money ");

			balance = in.nextInt();
			switch (balance) {
			case 100:
				return (cardSlot == CardSlot.USD100) ? moneySlot.CardSlot : null;

			default:
				break;
			}
			
		case 4:
			System.out.println("The machine is out of order ");
			

			default:
				return moneySlot.CoinSlot;
			}
		}


	public void validateMoney() {
		System.out.println("the money is valid");
	}

	public boolean verifyIfMoneyIsEnough() {

		if (balance >= currPrice) {
			System.out.println("the money is enough");

			return true;

		}
		System.out.println("the money is not enough");
		System.out.println("Take the money you inserted: " + balance);

		return false;
	}

	public void displayBalance() {
		// the money the user input or what have in the machine

		System.out.println(" The available money is " + balance);
	}

	public void dispenseSnack() {
		System.out.println("you got your snack");

	}

	public boolean verifyIfChangeToReturn() {

		if (balance > currPrice) {
			int change = balance - currPrice;
			System.out.println("there is change, " + "you got: " + change);
			return true;

		}
		System.out.println("there is no change");
		return false;
	}

	public int dispenseChange() {

		return balance = 0;
	}

}
