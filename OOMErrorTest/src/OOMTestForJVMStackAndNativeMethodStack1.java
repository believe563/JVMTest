/**
 * VM Args:-Xss2M(栈深度，可以先设置大一些)
 * 
 * @author belie 虚拟机栈和本地方法栈溢出---多线程
 * 物理内存-堆最大容量（Xmx）-最大方法区容量（MaxPermSize）
 * -（很小的）程序计数器消耗≈虚拟机栈和本地方法栈内存
 * 
 * 栈深度越大，可建立的线程数量越少，建立线程时容易将剩下的内存耗尽
 *
 *运行前要看：
 *由于在windows平台的虚拟机中，Java的线程是映射到
 *操作系统的内核线程上的，因此本代码执行时有较大的风险，
 *可能导致操作系统假死。
 *
 *运行结果：
 *Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread
 *
 */
public class OOMTestForJVMStackAndNativeMethodStack1 {
	private void dontStop() {
		while(true) {
			
		}
	}
	
	public void stackLeakByThread() {
		while(true) {
			Thread thread=new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					dontStop();
				}
				
			});
		}
	}
	
	public static void main(String[] args) throws Throwable{
		OOMTestForJVMStackAndNativeMethodStack1 oom=new OOMTestForJVMStackAndNativeMethodStack1();
		oom.stackLeakByThread();
	}
}
