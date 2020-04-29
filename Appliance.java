/*
* @author Joel Delgado jode9188
* Prog2 - VT2020
* Assignment 1 -  Part 2
* @version: 1.30
*/

import java.text.DecimalFormat;

public class Appliance extends Valuable {

	private static final double NUMERATOR = 10.0;
	private double price;
	private int condition;

	public Appliance(String name, double price, int wear) {
		super(name);
		this.price = price;
		this.condition = wear;
	}
	

	public double getPrice() {
		return price;
	}

	
	public int getCondition() {
		return condition;
	}

	
	@Override
	public double getValue() {
		return price * condition / NUMERATOR;
	}

	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		return String.format("%-15s condition: %3d \tcost price: %9s  \tvalue: %11s \t+VAT: %11s", 
				getName(), getCondition(), df.format(getPrice()), df.format(getValue()), df.format(getValuePlusVAT()));
	}

	
}
