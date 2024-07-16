package com.example.demo.moneyAndSnack;

public class SnackSlot {

	private int price;
	private int quantity;

	public SnackSlot(int p, int q) {
		price = p;
		quantity = q;
	}

	public SnackSlot() {
		this.price = 0;
		this.quantity = 0;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
