import java.lang.reflect.Field;

import sun.misc.Unsafe;

/**
 * VM Args：-Xmx20M -XX:MaxDirectMemorySize=10M
 * 指定最大直接内存的大小，不指定时与堆内存大小相同
 * 
 * @author belie
 *这个类用来测试本机直接内存溢出
 *
 *如果Unsafe.class.getDeclaredFields不能导入，需要
 *在Fix_Setup提示中点击here重新选择jre（例如原先是
 *SE1.8的话，重新选成默认jre那个选项）
 *
 *
 *该程序越过了DirectByteBuffer类，直接通过反射获取Unsafe实例
 *进行内存分配，因为虽然DirectByteBuffer分配内存也会抛出内存溢出异常，
 *但它抛出异常时没有真正向操作系统申请分配内存，而是通过计算得知内存无法分配，
 *然后手动抛出异常
 *
 *结果：
 *Exception in thread "main" java.lang.OutOfMemoryError
 *	at sun.misc.Unsafe.allocateMemory(Native Method)
 *  at OOMTestThisMachineDirectMemory.main(OOMTestThisMachineDirectMemory.java:31)
 *
 *如何判断是直接内存溢出：
 *OOM之后Dump文件很小，而程序中又直接或间接使用了NIO
 */
public class OOMTestThisMachineDirectMemory {
	private static final int _IMB=1024*1024;
	public static void main(String[] args) throws Exception{
		Field unsafeField=Unsafe.class.getDeclaredFields()[0];
		unsafeField.setAccessible(true);
		Unsafe unsafe=(Unsafe) unsafeField.get(null);
		while(true) {
//			真正申请分配内存的方法
			unsafe.allocateMemory(_IMB);
		}
	}
}
