/**
 * VM Args:-Xss2M(ջ��ȣ����������ô�һЩ)
 * 
 * @author belie �����ջ�ͱ��ط���ջ���---���߳�
 * �����ڴ�-�����������Xmx��-��󷽷���������MaxPermSize��
 * -����С�ģ�������������ġ������ջ�ͱ��ط���ջ�ڴ�
 * 
 * ջ���Խ�󣬿ɽ������߳�����Խ�٣������߳�ʱ���׽�ʣ�µ��ڴ�ľ�
 *
 *����ǰҪ����
 *������windowsƽ̨��������У�Java���߳���ӳ�䵽
 *����ϵͳ���ں��߳��ϵģ���˱�����ִ��ʱ�нϴ�ķ��գ�
 *���ܵ��²���ϵͳ������
 *
 *���н����
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
