package Classes;

import org.springframework.stereotype.Component;

@Component("Tea")
public class Tea implements IProduct {
	private int price;
	private boolean sugar;
	private String type;
	private String name;

	public Tea() {
	}

	public Tea(boolean sugar, String type, String name) {
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

	@Override
	public void countCost() {
		price = 10;
		if (sugar)
			price += 10;
		if (type == "Green")
			price += 10;
		else if (type == "Black")
			price += 15;
		if (name == "Tess")
			price += 20;
		else if (name == " Curtis")
			price += 15;
		else if (name == "Lipton")
			price += 10;
	}

	public Tea getTea() {
		return new Tea(sugar, type, name);
	}

	@Override
	public int getCost() {
		countCost();
		return price;
	}

	@Override
	public String info() {
		if (sugar)
			return "Чай " + type + " с сахаром " + name + " - " + this.getCost();
		else
			return "Чай " + type + " без сахара " + name + " - " + this.getCost();

	}

}