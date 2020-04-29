package eng.vers;
/*
* @author Joel Delgado jode9188
* Prog2 - VT2020
* Inlämningsuppgift 1 -  Del 2
* @version: 1.22
*/

enum Material {

	Gold(2000), Silver(700);

	private final int value;

	
	Material(int value) {
		this.value = value;
	}

	
	public int getValue() {
		return value;
	}

	
}
