import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * VM Args��-Xmx20M -XX:MaxDirectMemorySize=10M
 * ָ�����ֱ���ڴ�Ĵ�С����ָ��ʱ����ڴ��С��ͬ
 * 
 * @author belie
 *������������Ա���ֱ���ڴ����
 *
 *���Unsafe.class.getDeclaredFields���ܵ��룬��Ҫ
 *��Fix_Setup��ʾ�е��here����ѡ��jre������ԭ����
 *SE1.8�Ļ�������ѡ��Ĭ��jre�Ǹ�ѡ�
 *
 *
 *�ó���Խ����DirectByteBuffer�ֱ࣬��ͨ�������ȡUnsafeʵ��
 *�����ڴ���䣬��Ϊ��ȻDirectByteBuffer�����ڴ�Ҳ���׳��ڴ�����쳣��
 *�����׳��쳣ʱû�����������ϵͳ��������ڴ棬����ͨ�������֪�ڴ��޷����䣬
 *Ȼ���ֶ��׳��쳣
 *
 *�����
 *Exception in thread "main" java.lang.OutOfMemoryError
 *	at sun.misc.Unsafe.allocateMemory(Native Method)
 *  at OOMTestThisMachineDirectMemory.main(OOMTestThisMachineDirectMemory.java:31)
 *
 *����ж���ֱ���ڴ������
 *OOM֮��Dump�ļ���С������������ֱ�ӻ���ʹ����NIO
 */
public class OOMTestThisMachineDirectMemory {
	private static final int _IMB=1024*1024;
	public static void main(String[] args) throws Exception{
		Field unsafeField=Unsafe.class.getDeclaredFields()[0];
		unsafeField.setAccessible(true);
		Unsafe unsafe=(Unsafe) unsafeField.get(null);
		while(true) {
//			������������ڴ�ķ���
			unsafe.allocateMemory(_IMB);
		}
	}
}
