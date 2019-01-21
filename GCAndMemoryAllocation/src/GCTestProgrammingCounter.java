/**
 * VM Args:
 * -XX:+PrintGC ���GC��־
 * -XX:+PrintGCDetails ���GC����ϸ��־
 * ����ɲο���ҳ https://www.cnblogs.com/qlqwjy/p/7929414.html �еĶ�Ӧ�����б�
 * 
 * @author belie
 *
 */
public class GCTestProgrammingCounter {
	public Object instance=null;
	private static final int _1MB=1024*1024;
	private byte[] bigSize=new byte[2*_1MB];
	public static void testGC() {
		GCTestProgrammingCounter objA=new GCTestProgrammingCounter();
		GCTestProgrammingCounter objB=new GCTestProgrammingCounter();
		objA.instance=objB;
		objB.instance=objA;
		objA=null;
		objB=null;
		System.gc();
	}
	
	public static void main(String[] args) {
		testGC();
	}
}

/**
 * java7�����н����
 *[GC[DefNew: 2747K->401K(4928K), 0.0038691 secs] 2747K->2449K(15872K), 0.0039533 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[Full GC[Tenured: 2048K->401K(10944K), 0.0042633 secs] 4639K->401K(15872K), [Perm : 171K->171K(12288K)], 0.0043301 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
Heap
 def new generation   total 4992K, used 89K [0x25140000, 0x256a0000, 0x2a690000)
  eden space 4480K,   2% used [0x25140000, 0x251566d0, 0x255a0000)
  from space 512K,   0% used [0x255a0000, 0x255a0000, 0x25620000)
  to   space 512K,   0% used [0x25620000, 0x25620000, 0x256a0000)
 tenured generation   total 10944K, used 401K [0x2a690000, 0x2b140000, 0x35140000)
   the space 10944K,   3% used [0x2a690000, 0x2a6f4430, 0x2a6f4600, 0x2b140000)
 compacting perm gen  total 12288K, used 171K [0x35140000, 0x35d40000, 0x39140000)
   the space 12288K,   1% used [0x35140000, 0x3516acf0, 0x3516ae00, 0x35d40000)
    ro space 10240K,  44% used [0x39140000, 0x395b73f0, 0x395b7400, 0x39b40000)
    rw space 12288K,  52% used [0x39b40000, 0x3a18dd28, 0x3a18de00, 0x3a740000)
�ڶ���Full GC����2048K->401K,˵�������û����Ϊ�����������໥���þͲ��������ǣ�����˵�����������ͨ�����ü����㷨���ж϶����Ƿ���
 */
/**
 * java8�����н����
 * [GC (System.gc()) [PSYoungGen: 6092K->680K(38400K)] 6092K->688K(125952K), 0.0085903 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
[Full GC (System.gc()) [PSYoungGen: 680K->0K(38400K)] [ParOldGen: 8K->565K(87552K)] 688K->565K(125952K), [Metaspace: 2770K->2770K(1056768K)], 0.0068841 secs] [Times: user=0.00 sys=0.00, real=0.01 secs] 
Heap
 PSYoungGen      total 38400K, used 333K [0x00000000d5d80000, 0x00000000d8800000, 0x0000000100000000)
  eden space 33280K, 1% used [0x00000000d5d80000,0x00000000d5dd34a8,0x00000000d7e00000)
  from space 5120K, 0% used [0x00000000d7e00000,0x00000000d7e00000,0x00000000d8300000)
  to   space 5120K, 0% used [0x00000000d8300000,0x00000000d8300000,0x00000000d8800000)
 ParOldGen       total 87552K, used 565K [0x0000000081800000, 0x0000000086d80000, 0x00000000d5d80000)
  object space 87552K, 0% used [0x0000000081800000,0x000000008188d598,0x0000000086d80000)
 Metaspace       used 2777K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 301K, capacity 386K, committed 512K, reserved 1048576K
 * 
 * 
 */