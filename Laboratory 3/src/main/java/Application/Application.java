package Application;

import Classes.*;

import java.util.ArrayList;
import java.util.List;


public class Application {

	public static void main(String[] args) {
		List<Thread> cashDesk = new ArrayList<>();
		for (int i=0;i<4;i++) 
			cashDesk.add(new Thread(new Generator(i+1)));
		for (Thread thread : cashDesk) {
			thread.start();
		}
	}

}
