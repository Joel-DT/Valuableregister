/*
* @author Joel Delgado jode9188
* Prog2 - VT2020
* Assignment 1 -  Part 2
* @version: 2.0
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
