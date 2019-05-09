package ÒÒ¼¶;

import java.util.Scanner;

public class A1022 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a =sc.nextInt();int b =sc.nextInt(); int c =sc.nextInt();
		int m =a+b;
		int ans[]=new int[31];int num=0;
		do{
			ans[num++]=m%c;
			m=m/c;
		}while(m!=0);
		for(int i=num-1;i>=0;i--){
			System.out.print(ans[i]);
		}
	}
	

}
