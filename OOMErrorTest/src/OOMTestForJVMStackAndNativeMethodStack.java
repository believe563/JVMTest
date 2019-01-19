/**
 * �����趨����preference->java->installedJREs���ã� VM Args:-Xss128k
 * 
 * @author belie �����ջ�ͱ��ط���ջ���---���߳�
 * 
 *         -Xoss�������ñ��ط���ջ��С ����HotSpot�в�������ջ ����ջ����ֻ��-Xss�����趨�������ڴ�����
 * 
 *         StackOverFlowError�쳣���߳������ջ��ȴ���������������������
 *         OutOfMemoryError�쳣�����������չջʱ�޷����뵽�㹻���ڴ�ռ䣨ջС����ʹ�õ�ջ�ռ�̫��
 * 
 *ʵ��˵�����ڵ����߳��£�����������ջ̫֡���������ջ����̫С�����ڴ��޷�����ʱ��������׳��Ķ���StackOverflowError�쳣
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
	 * ����಻����static������ֱ�ӱ����ã���Ҫ��ʵ�����ⲿ�࣬�ٽ������װ��һ�������У�����ʵ��������ⲿ����е���
	 */
	class InnerClassTest {
		int i = 0;
	}
	
	public void initInnerClass() {
		InnerClassTest ict=new InnerClassTest();
		ict.i++;
	}
}
