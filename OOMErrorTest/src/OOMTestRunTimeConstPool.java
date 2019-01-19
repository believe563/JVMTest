import java.util.ArrayList;
import java.util.List;

/**
 * VM args:-XX:PermSize=10M -XX:MaxPermSize=10M
 * 
 * 运行时常量池是方法区的一部分，所以方法区和运行时常量池的溢出放在一起进行
 * 
 * String.intern()是一个native方法，它的作用是：如果字符串
 * 常量池中已经包含一个等于此String对象的字符串，则返回
 * 代表池中这个字符串的String对象；否则，将此String对象
 * 包含的字符串添加到常量池中，并返回此String对象的引用
 * 
 * 通过-XX:PermSize=10M -XX:MaxPermSize=10M限制方法区大小，
 * 从而间接限制常量池的容量
 * 
 * 
 * jdk6的运行结果：
 * Exception in thread "main" java.lang.OutOfMemoryError:PermGen space
 * 	at java.lang.String.intern(Native Method)
 * 	at org.fenixsoft.oom.RuntimeConstantPoolOOM.main(RuntimeConstantPoolOOM.java:18)
 * 
 * jdk7的运行结果：
 * 因为java8不支持该参数，所以在循环创建字符串时会一直运行
 * 
 * @author belie
 *
 */
public class OOMTestRunTimeConstPool {
	public static void main(String[] args) {
		//使用List保持着常量池引用，避免Full GC回收常量池行为
		//List<String> list=new ArrayList<String>();
		
		//10MB的PermSize在integer范围内足够产生OOM了
		//int i=0;
		//while(true) {
			//list.add(String.valueOf(i++).intern());
		//}
//		上述几行代码是测试方法区和常量池溢出的
//		因为需要设置参数，而所用参数在java8中不支持了，所以没有出现预计异常
		
//---------------------------------------------------------------------
//		下述代码是测试java7中在常量池中的引用与新创建的变量之间的关系
//		String str1=new StringBuilder("计算机").append("软件").toString();
//		System.out.println(str1.intern()==str1);
//		
//		String str2=new StringBuilder("ja").append("va").toString();
//		System.out.println(str2.intern()==str2);
		
//		运行结果：
//		true
//		false
//		Java HotSpot(TM) 64-Bit Server VM warning: ignoring option PermSize=10M; support was removed in 8.0
//		Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=10M; support was removed in 8.0
//		后两个警告表示不支持设置方法区大小的这两个参数了
//		出现一个true一个false是因为java7的intern实现只是在常量池中记录首次出现的实例引用，
//		因此在str1中intern返回的引用和由StringBuilder创建的那个字符串实例是同一个，
//		而在str2中“java”这个字符串在执行tostring之前已出现过，字符串常量池中已经有它的引用了，不符合“首次出现”的原则，返回false
		
//		在java6中StringBuilder创建的字符串是在Java堆上，所以结果是两个false
//		---------------------------------------------------------

//		在以下场景下，需要特别注意类的回收状况：
//		CGLib字节码增强、动态语言、大量JSP或动态产生JSP文件的应用（JSP第一次运行时需要编译为Java类）、基于OSGi的应用
	}
}
