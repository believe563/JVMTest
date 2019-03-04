import java.lang.reflect.Method;

/**
 * 在一个类中调用另一个类的私有方法，通过反射机制
 * @author belie
 *
 */
public class Main {
	public static void main(String[] args) throws Exception {
		Method method=A.class.getDeclaredMethod("getNum");
		method.setAccessible(true);
		method.invoke(new A());
	}
}

class A{
	private int getNum(){
		System.out.println("called private getNum()");
		return 20;
	}
}
