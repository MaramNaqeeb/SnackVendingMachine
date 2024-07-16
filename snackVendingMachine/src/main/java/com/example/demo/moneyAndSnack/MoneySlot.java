package com.example.demo.moneyAndSnack;

import com.example.demo.moneyAndSnack.MoneySlot.NotesSlot;

public class MoneySlot {

	public MoneySlot CardSlot;
	public MoneySlot CoinSlot;
	public MoneySlot NotesSlot;

	public MoneySlot() {
	}

	public enum CoinSlot {
		c10, c20, c50, c100
	}

	public enum NotesSlot {
		USD20, USD50
	}

	public enum CardSlot {
		USD100
	}
}
