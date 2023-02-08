package week6;

public class Card {
	private int value;
	private String name;
	
	Card(int value, String name){
		setValue(value);
		setName(name);
	}
	
	Card(){}

	String describe() {
		return "The " + name + "\n";
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = Math.max(2, Math.min(value, 14));
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
