package p2;

public class ConstructSequence {
	public static void main(String[] args) {
		Person p = new Student("李明", 18, "北大");
	}
}

class Person {
	String name="未命名";
	int age=-1;
	Person(String name, int age) {
		System.out.println("开始构造 Person(),此时 this.name="
				+ this.name + ",this.age=" + this.age);
		this.name = name;
		this.age = age;
		System.out.println("Person()构造完成,此时this.name="
				+ this.name + ",this.age=" + this.age);
	}
}

class Student extends Person {
	String school="未定学校";
	Student(String name, int age, String school) {
		super(name, age);
		System.out.println("开始构造Student(),此时this.name=" + this.name
				+ ",this.age=" + this.age + ",this.school=" + this.school);
		this.school = school;
		System.out.println("Student()构造完成,此时this.name=" + this.name
				+ ",this.age=" + this.age + ",this.school=" + this.school);
	}
}