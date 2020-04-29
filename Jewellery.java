/*
* @author Joel Delgado jode9188
* Prog2 - VT2020
* Assignment 1 -  Part 2
* @version: 1.30
*/

import java.text.DecimalFormat;

public class Jewellery extends Valuable {

	private static final int PRICEPERJEWEL = 500;
	private int jewels;
	private final Material material;

	public Jewellery(String name, int jewels, String material) {
		super(name);
		this.jewels = jewels;
		this.material = Material.valueOf(material);
	}

	
	public int getJewels() {
		return jewels;
	}

	
	public Material getMaterial() {
		return material;
	}

	
	@Override
	public double getValue() {
		return material.getValue() + PRICEPERJEWEL * this.getJewels();
	}

	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("0.00");
		return String.format("%-15s of %s \tgemstones: %10d \tvalue: %11s \t+VAT: %11s", 
				getName(), getMaterial(), getJewels(), df.format(getValue()), df.format(getValuePlusVAT()));
	}

	
}
