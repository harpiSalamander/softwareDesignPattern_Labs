package Classes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Generator implements Runnable{
	private int num;
	private static int counter = 1;
	
	public Generator(int num) {
		super();
		this.num = num;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if (Thread.currentThread().isInterrupted()) break;
			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("CtxBuilder.xml");
			Order order = ctx.getBean("Order", Order.class);
			System.out.println("Касса " + num);
			System.out.println("Заказ №" + counter + ":");
			order.info();
			System.out.println("Полная цена: " + order.getCost());
			ctx.close();
   			counter +=1;
      			// Остановка потока, если достигли 10 заказа
      			if (counter > 10)
			  break;	
		}
		System.out.println("Касса " + num + " остановлена...");
	}
}
