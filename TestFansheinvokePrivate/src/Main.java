import java.lang.reflect.Method;

/**
 * ��һ�����е�����һ�����˽�з�����ͨ���������
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
