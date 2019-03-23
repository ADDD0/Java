abstract class C {
	abstract void callme();
	void metoo() {
		System.out.println("Inside C's metoo() method");
	}
}

class D extends C {
	void callme() {
		System.out.println("Inside D's callme() method");
	}
}