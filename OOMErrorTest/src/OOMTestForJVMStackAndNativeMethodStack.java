/**
 * 参数设定（在preference->java->installedJREs设置） VM Args:-Xss128k
 * 
 * @author belie 虚拟机栈和本地方法栈溢出---单线程
 * 
 *         -Xoss参数设置本地方法栈大小 由于HotSpot中不分两种栈 所以栈容量只由-Xss参数设定，减少内存容量
 * 
 *         StackOverFlowError异常：线程请求的栈深度大于虚拟机所允许的最大深度
 *         OutOfMemoryError异常：虚拟机在扩展栈时无法申请到足够的内存空间（栈小或已使用的栈空间太大）
 * 
 *实验说明：在单个线程下，无论是由于栈帧太大还是虚拟机栈容量太小，当内存无法分配时，虚拟机抛出的都是StackOverflowError异常
 *
 */
public class OOMTestForJVMStackAndNativeMethodStack {

	private int stackLength = 1;

	public static void main(String[] args) {
		OOMTestForJVMStackAndNativeMethodStack o=new OOMTestForJVMStackAndNativeMethodStack();
		try {
		o.stackLeak();
		}catch(Throwable e) {
			System.out.println("stack length;"+o.stackLength);
			//throw e;
		}
		//o.initInnerClass();
		
	}

	public void stackLeak() {
		stackLength++;
		stackLeak();
	}

	/**
	 * 这个类不能在static方法中直接被调用，需要先实例化外部类，再将该类封装到一个方法中，再用实例化后的外部类进行调用
	 */
	class InnerClassTest {
		int i = 0;
	}
	
	public void initInnerClass() {
		InnerClassTest ict=new InnerClassTest();
		ict.i++;
	}
}
