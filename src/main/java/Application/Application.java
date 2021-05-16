package Application;

import Classes.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("CtxBuilder.xml");
		Order order = ctx.getBean("Order", Order.class);
		System.out.println("Заказ:");
		order.info();
		System.out.println("Полная цена: " + order.getCost());
		ctx.close();
	}

}
