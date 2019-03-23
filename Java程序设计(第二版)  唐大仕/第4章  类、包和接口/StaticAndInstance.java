public class StaticAndInstance {
	static int classVar;
	int instanceVar;
	static void setClassVar(int i) {
		classVar = i;
		//instanceVar = i;  //不能在类方法中存取实例变量
	}
	static int getClassVar() {
		return classVar;
	}
	void setInstanceVar(int i) {
		classVar = i;       //可以在实例方法中存取类域
		instanceVar = i;
	}
	int getInstanceVar() {
		return instanceVar;
	}
}