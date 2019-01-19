import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author belie
 * 测试OutOfMemoryError异常
 * 
 * 在preference-->java-->installed jres中，双击右侧jre路径，设置其中vm args
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 *其中-Xms20m是堆内存的最小值参数，-Xmx20m是堆内存的最大值参数，这是限制了Java堆的大小为20MB，将最大值和最小值设置为相同，表示不可扩展
 *-XX:+HeapDumpOnOutOfMemoryError可以让虚拟机在出现内存溢出异常时Dump出当前的内存堆转储快照，以便事后进行分析
 *
 *
 *快照结果为：
 *java.lang.OutOfMemoryError: Java heap space
 *Dumping heap to java_pid14060.hprof ...
 *Heap dump file created [28028869 bytes in 0.089 secs]
 *
 *-XX:+HeapDumpOnCtrlBreak  该命令可以获取堆转储文件
 *
 *
 *这个类中的测试主要是堆内存溢出
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
