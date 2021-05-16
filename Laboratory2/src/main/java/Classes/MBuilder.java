package Classes;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;

public class MBuilder {
	private Tea tea;
	private Coffee coffee;
	private List<IProduct> products = new ArrayList<IProduct>();

	public void printMenu() {

		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("CtxProduct.xml");
		tea = ctx.getBean("Tea", Tea.class);
		coffee = ctx.getBean("Coffee", Coffee.class);
		ctx.close();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Добрый день! Что Вы хотите заказать?\n1)Чай\n2)Кофе\n>");
		while (true) {
			int choice;
			while (true) {
				choice = scanner.nextInt();
				if (choice > 0 && choice < 3) {
					break;
				}
				System.out.println("Неправильный ввод! Попробуйте еще раз: \n>");
			}
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
			default:
				System.out.println("Неправильный ввод!");
			}
			System.out.println("Что-то еще?\n 1) Да\n 2) Нет \n>");
			int key;
			while (true) {
				key = scanner.nextInt();
				if (key > 0 && key < 3) {
					break;
				}
				System.out.println("Неправильный ввод! Попробуйте еще раз: \n>");
			}
			if (key == 2)
				break;
			else
				System.out.println("Что Вы хотите заказать?\n1)Чай\n2)Кофе\n>");
		}
	}

	private String choiceNameOfTea() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Выберите производителя?\n1)Tess\n2)Curtis\n3)Lipton\n>");
		int choice;
		while (true) {
			choice = scanner.nextInt();
			if (choice > 0 && choice < 4) {
				break;
			}
			System.out.println("Неправильный ввод! Попробуйте еще раз: \n>");
		}
		switch (choice) {
		case 1:
	//		tea.setName("Tess");
			return "Tess";
		case 2:
	//		tea.setName("Curtis");
			return "Curtis";
		case 3:
	//		tea.setName("Lipton");
			return "Lipton";
		default:
			return "";
		}
	}

	private String choiceNameOfCoffee() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Выберите производителя?\n1)Egoiste\n2)Jacobs\n3)Nescafe\n>");
		int choice;
		while (true) {
			choice = scanner.nextInt();
			if (choice > 0 && choice < 4) {
				break;
			}
			System.out.println("Неправильный ввод! Попробуйте еще раз: \n>");
		}
		switch (choice) {
		case 1:
			return "Egoiste";
		case 2:
			return "Jacobs";
		case 3:
			return "Nescafe";
		default:
			return "";
		}
	}

	private boolean choiceSugar() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Положить сахар?\n1)Да\n2)Нет\n>");
		int choice;
		while (true) {
			choice = scanner.nextInt();
			if (choice > 0 && choice < 3) {
				break;
			}
			System.out.println("Неправильный ввод! Попробуйте еще раз: \n>");
		}
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
		Scanner scanner = new Scanner(System.in);
		System.out.println("Зеленый или черный?\n1)Зеленый\n2)Черный\n>");
		int choice;
		while (true) {
			choice = scanner.nextInt();
			if (choice > 0 && choice < 3) {
				break;
			}
			System.out.println("Неправильный ввод! Попробуйте еще раз: \n>");
		}
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
		Scanner scanner = new Scanner(System.in);
		System.out.println("Черный или с молоком?\n1)Черный\n2)С молоком\n>");
		int choice;
		while (true) {
			choice = scanner.nextInt();
			if (choice > 0 && choice < 3) {
				break;
			}
			System.out.println("Неправильный ввод! Попробуйте еще раз: \n>");
		}
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
