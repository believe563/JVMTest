import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author belie
 * ����OutOfMemoryError�쳣
 * 
 * ��preference-->java-->installed jres�У�˫���Ҳ�jre·������������vm args
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 *����-Xms20m�Ƕ��ڴ����Сֵ������-Xmx20m�Ƕ��ڴ�����ֵ����������������Java�ѵĴ�СΪ20MB�������ֵ����Сֵ����Ϊ��ͬ����ʾ������չ
 *-XX:+HeapDumpOnOutOfMemoryError������������ڳ����ڴ�����쳣ʱDump����ǰ���ڴ��ת�����գ��Ա��º���з���
 *
 *
 *���ս��Ϊ��
 *java.lang.OutOfMemoryError: Java heap space
 *Dumping heap to java_pid14060.hprof ...
 *Heap dump file created [28028869 bytes in 0.089 secs]
 *
 *-XX:+HeapDumpOnCtrlBreak  ��������Ի�ȡ��ת���ļ�
 *
 *
 *������еĲ�����Ҫ�Ƕ��ڴ����
 *
 */
public class OOMTest {
	
	static class OOMObject{
		
	}
	
	public static void main(String[] args) {
		List<OOMObject> list=new ArrayList<OOMObject>();
		while(true) {
			list.add(new OOMObject());
		}
	}

}
