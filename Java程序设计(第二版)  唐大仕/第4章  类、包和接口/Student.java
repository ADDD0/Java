public class Student extends Person{
	String school;
	int score;

	// void sayHello() {
	//     System.out.println("Hello! My name is " + name + 
	//             ".My school is " + school);
	// }

	void sayHello(Student another) {
		System.out.println("Hi!");
		if (school == another.school)
			System.out.println("Shoolmates");
	}

	boolean isGoodStudent() {
		return score >= 90;
	}

	void testThisSuper() {
		int a;
		a= age;
		a = this.age;
		a = super.age;
	}

	void sayHello() {
		super.sayHello();
		System.out.println("My school is " + school);
	}

	Student(String name, int age, String school) {
		super(name, age);
		this.school = school;
	}

	Student() {}

	public static void main(String[] args) {
		Person p = new Person("Liming", 50);
		Student s = new Student("Wangqiang", 20, "PKU");
		Person p2 = new Student("Zhangyi", 18, "THU");
		Student s2 = (Student) p2;
	}
}