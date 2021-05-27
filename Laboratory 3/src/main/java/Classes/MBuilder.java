package Classes;

import java.util.ArrayList;

import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

public class MBuilder {
	
	@Autowired
	private Tea tea;
	@Autowired
	private Coffee coffee;
	private List<IProduct> products = new ArrayList<IProduct>();

	public void printMenu() {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("CtxProduct.xml");
		tea = ctx.getBean("Tea", Tea.class);
		coffee = ctx.getBean("Coffee", Coffee.class);
		ctx.close();
		while (true) {
			int max = 1;
			int choice = (int) (Math.random() * ++ max) + 1;
			switch (choice) {
			case 1:
				tea.setType(choiceTypeOfTea());
				tea.setSugar(choiceSugar());
				tea.setName(choiceNameOfTea());
				products.add(tea.getTea());
				break;
			case 2:
				coffee.setType(choiceTypeOfCoffee());
				coffee.setSugar(choiceSugar());
				coffee.setName(choiceNameOfCoffee());
				products.add(coffee.getCoffee());
				break;
			}
			int key = (int) (Math.random() * ++ max);
			if (key == 2)
				break;
		}
	}

	private String choiceNameOfTea() {
		int max = 2;
		int choice = (int) (Math.random() * ++ max) + 1;
		switch (choice) {
		case 1:
			tea.setPrice(30);
			return "Tess";
		case 2:
			tea.setPrice(25);
			return "Curtis";
		case 3:
			tea.setPrice(20);
			return "Lipton";
		default:
			return "";
		}
	}

	private String choiceNameOfCoffee() {
		int max = 2;
		int choice = (int) (Math.random() * ++ max) + 1;
		switch (choice) {
		case 1:
			coffee.setPrice(30);
			return "Egoiste";
		case 2:
			coffee.setPrice(20);
			return "Jacobs";
		case 3:
			coffee.setPrice(25);
			return "Nescafe";
		default:
			return "";
		}
	}

	private boolean choiceSugar() {
		int max = 1;
		int choice = (int) (Math.random() * ++ max) + 1;
		switch (choice) {
		case 1:
			return true;
		case 2:
			return false;
		default:
			return false;
		}
	}

	private String choiceTypeOfTea() {
		int max = 1;
		int choice = (int) (Math.random() * ++ max) + 1;
		switch (choice) {
		case 1:
			return "Green";
		case 2:
			return "Black";
		default:
			return "";
		}
	}

	private String choiceTypeOfCoffee() {

		int max = 1;
		int choice = (int) (Math.random() * ++ max) + 1;
		switch (choice) {
		case 1:
			return "Black";
		case 2:
			return "Milk";
		default:
			return "";
		}
	}

	public Order getOrder() {
		printMenu();
		return new Order(products);
	}
}
