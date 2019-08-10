interface Runner {
	public void run();
}

interface Swimmer {
	public void swim();
}

abstract class Animal {
	abstract public void eat();
}

class Human extends Animal implements Runner, Swimmer {
	public void run() {
		System.out.println("run");
	}

	public void swim() {
		System.out.println("swim");
	}

	public void eat() {
		System.out.println("eat");
	}
}

public class TestInterface {
	public static void main(String[] args) {
		TestInterface t = new TestInterface();
		Human h = new Human();
		t.m1(h);
		t.m2(h);
		t.m3(h);
	}

	public void m1(Runner f) {
		f.run();
	}

	public void m2(Swimmer s) {
		s.swim();
	}

	public void m3(Animal a) {
		a.eat();
	}
}