package eng.vers;
/*
* @author Joel Delgado jode9188
* Prog2 - VT2020
* Inlämningsuppgift 1 -  Del 2
* @version: 1.22
*/

public abstract class Valuable {

	private static final double VAT = 0.25;
	private String name;
	private double vat;

	public Valuable(String name) {
		this.name = name;
		this.vat = VAT;
	}

	
	public final String getName() {
		return name;
	}

	
	public abstract double getValue();

	
	public final void setVAT(double vat) {
		this.vat = vat;
	}

	
	public final double getValuePlusVAT() {
		return this.getValue() * (1 + vat);
	}

	
}
