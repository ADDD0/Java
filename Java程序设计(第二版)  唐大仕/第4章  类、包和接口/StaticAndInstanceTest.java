public class StaticAndInstanceTest {
	public static void main(String[] args) {
		StaticAndInstance m1 = new StaticAndInstance();
		StaticAndInstance m2 = new StaticAndInstance();
		m1.setClassVar(1);
		m2.setClassVar(2);
		System.out.println("m1.classVar=" + m1.getClassVar() + " m2.classVar=" + m2.getClassVar());
		m1.setInstanceVar(11);
		m2.setInstanceVar(22);
		System.out.println("m1.InstanceVar=" + m1.getInstanceVar() + " m2.InstanceVar=" + m2.getInstanceVar());
	}
}