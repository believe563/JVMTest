
//import java.math.BigInteger;
//import java.util.Scanner;
//
//public class Main {
//	
//	public static void main(String[] args) {
//		
//		BigInteger x,f,d,p,havefruitxdays,day=BigInteger.ZERO;
//		
//		
//		Scanner sc=new Scanner(System.in);
//		
//		x=sc.nextBigInteger();//每天x元租金
//		f=sc.nextBigInteger();//已有f个水果
//		d=sc.nextBigInteger();//已有d元钱
//		p=sc.nextBigInteger();//商店水果卖p元
//		
//		havefruitxdays=d.divide(x);
//		if(havefruitxdays.compareTo(f)>0) {
//			BigInteger money=p.add(x);//一天花这么多钱  +苹果
//			BigInteger haisheng=d.subtract(f.multiply(x));//还剩多少钱
//			BigInteger houmiandays=haisheng.divide(money);
//			day=f.add(houmiandays);
//		}else {
//			day=d.divide(x);
//		}
//		System.out.println(day);
//		
//		
//	}
//}
/**
 *牛客网中模拟笔试201902
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;// 数据组数（1~100）
		int N, A, B, C;

		T = sc.nextInt();
		List list = new ArrayList<List>();
		List list1;
		for (int i = 0; i < T; i++) {
			list1=new ArrayList<Integer>();
			N=sc.nextInt();
			A=sc.nextInt();
			B=sc.nextInt();
			C=sc.nextInt();
			list1.add(N);
			list1.add(A);
			list1.add(B);
			list1.add(C);
			list.add(list1);
		}
		int livedays,threenum;
		List list2=new ArrayList<Integer>();
		for(int i=0;i<T;i++) {
			list2=(List) list.get(i);
			N=(int) list2.get(0);
			A=(int)list2.get(1);
			B=(int)list2.get(2);
			C=(int)list2.get(3);
			livedays=0;
			threenum=C;
			livedays+=B/3;
			B=B%3;
			if(A>B) {
				threenum+=B;
				
				A=A-B;
				B=0;
				threenum+=A/3;
			}else {
				threenum+=A;
				
				B=B-A;
				A=0;
			}
			livedays+=threenum/2;
					
			if(livedays>=N) {
				System.out.println("Yes");
			}else {
				System.out.println("No");
			}
		}

	}
}

//
// 4
// 1 1 1 1
// 2 0 0 4
// 3 0 2 5
// 4 24 0 0
//  
//  //输出：
//   * Yes
//   * Yes
//   * No
//   * Yes
//   */
