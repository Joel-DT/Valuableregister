/*
* @author Joel Delgado jode9188
* Prog2 - VT2020
* Assignment 1 -  Part 2
* @version: 1.30
*/

import java.text.DecimalFormat;

public class Stock extends Valuable {

	private int quantity;
	private double rate;

	public Stock(String name, int quantity, double rate) {
		super(name);
		this.quantity = quantity;
		this.rate = rate;
	}
	

	public int getQuantity() {
		return quantity;
	}

	
	public double getRate() {
		return rate;
	}

	
	public void setRate(double rate) {
		this.rate = rate;
	}

	
	@Override
	public double getValue() {
		return quantity * rate;
	}

	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		return String.format("%-15s quantity: %4d \tshare price: %8s \tvalue: %11s \t+VAT: %11s",
				getName(), getQuantity(), df.format(getRate()), df.format(getValue()), df.format(getValuePlusVAT()));
	}

	
}
