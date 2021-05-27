package Classes;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class Order implements IProduct {
	private List<IProduct> products = new ArrayList<IProduct>();
	private int FullCost;

	@Autowired
	public Order(List<IProduct> products) {
		for (IProduct product : products) {
			this.products.add(product);
		}
	}

	public void countCost() {
		FullCost = 0;
		for (IProduct product : products) {
			FullCost += product.getCost();
		}
	}

	@Override
	public int getCost() {
		countCost();
		return FullCost;
	}

	@Override
	public String info() {
		for (IProduct product : products) {
			System.out.println(product.info());
		}
		return null;
	}
}
