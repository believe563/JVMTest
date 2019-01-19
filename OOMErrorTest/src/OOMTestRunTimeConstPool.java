import java.util.ArrayList;
import java.util.List;

/**
 * VM args:-XX:PermSize=10M -XX:MaxPermSize=10M
 * 
 * ����ʱ�������Ƿ�������һ���֣����Է�����������ʱ�����ص��������һ�����
 * 
 * String.intern()��һ��native���������������ǣ�����ַ���
 * ���������Ѿ�����һ�����ڴ�String������ַ������򷵻�
 * �����������ַ�����String���󣻷��򣬽���String����
 * �������ַ�����ӵ��������У������ش�String���������
 * 
 * ͨ��-XX:PermSize=10M -XX:MaxPermSize=10M���Ʒ�������С��
 * �Ӷ�������Ƴ����ص�����
 * 
 * 
 * jdk6�����н����
 * Exception in thread "main" java.lang.OutOfMemoryError:PermGen space
 * 	at java.lang.String.intern(Native Method)
 * 	at org.fenixsoft.oom.RuntimeConstantPoolOOM.main(RuntimeConstantPoolOOM.java:18)
 * 
 * jdk7�����н����
 * ��Ϊjava8��֧�ָò�����������ѭ�������ַ���ʱ��һֱ����
 * 
 * @author belie
 *
 */
public class OOMTestRunTimeConstPool {
	public static void main(String[] args) {
		//ʹ��List�����ų��������ã�����Full GC���ճ�������Ϊ
		//List<String> list=new ArrayList<String>();
		
		//10MB��PermSize��integer��Χ���㹻����OOM��
		//int i=0;
		//while(true) {
			//list.add(String.valueOf(i++).intern());
		//}
//		�������д����ǲ��Է������ͳ����������
//		��Ϊ��Ҫ���ò����������ò�����java8�в�֧���ˣ�����û�г���Ԥ���쳣
		
//---------------------------------------------------------------------
//		���������ǲ���java7���ڳ������е��������´����ı���֮��Ĺ�ϵ
//		String str1=new StringBuilder("�����").append("���").toString();
//		System.out.println(str1.intern()==str1);
//		
//		String str2=new StringBuilder("ja").append("va").toString();
//		System.out.println(str2.intern()==str2);
		
//		���н����
//		true
//		false
//		Java HotSpot(TM) 64-Bit Server VM warning: ignoring option PermSize=10M; support was removed in 8.0
//		Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=10M; support was removed in 8.0
//		�����������ʾ��֧�����÷�������С��������������
//		����һ��trueһ��false����Ϊjava7��internʵ��ֻ���ڳ������м�¼�״γ��ֵ�ʵ�����ã�
//		�����str1��intern���ص����ú���StringBuilder�������Ǹ��ַ���ʵ����ͬһ����
//		����str2�С�java������ַ�����ִ��tostring֮ǰ�ѳ��ֹ����ַ������������Ѿ������������ˣ������ϡ��״γ��֡���ԭ�򣬷���false
		
//		��java6��StringBuilder�������ַ�������Java���ϣ����Խ��������false
//		---------------------------------------------------------

//		�����³����£���Ҫ�ر�ע����Ļ���״����
//		CGLib�ֽ�����ǿ����̬���ԡ�����JSP��̬����JSP�ļ���Ӧ�ã�JSP��һ������ʱ��Ҫ����ΪJava�ࣩ������OSGi��Ӧ��
	}
}
