package Classes;

import org.springframework.stereotype.Component;

@Component("Coffee")
public class Coffee implements IProduct {

	private int price;
	private boolean sugar;
	private String type;
	private String name;

	public Coffee() {
	}

	public Coffee(boolean sugar, String type, String name) {
		this.sugar = sugar;
		this.type = type;
		this.name = name;
		countCost();
	}

	public void setSugar(boolean sugar) {
		this.sugar = sugar;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Coffee getCoffee() {
		return new Coffee(sugar, type, name);
	}

	@Override
	public void countCost() {
		price = 15;
		if (sugar)
			price += 10;
		if (type == "Black")
			price += 15;
		else if (type == "Milk")
			price += 20;
		if (name == " Egoiste")
			price += 20;
		else if (name == " Jacobs")
			price += 10;
		else if (name == " Nescafe")
			price += 15;

	}

	@Override
	public int getCost() {
		countCost();
		return price;
	}

	@Override
	public String info() {
		if (sugar)
			return "Кофе " + type + " с сахаром " + name + " - " + this.getCost();
		else
			return "Кофе " + type + " без сахара " + name + " - " + this.getCost();
	}

}
