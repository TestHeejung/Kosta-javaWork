package ex0814.set;

import java.util.HashSet;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		String a = "Z@S.ME";
		String b = "Z@RN.E";
		
		/**
		 * String.hashCode()는 문자열의 내용을 기반으로 한 정수값을 계산
		 * 
		 * s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
		 * 
		 *   s[i]는 각 문자의 유니코드 값
             n은 문자열 길이
             31^k는 31의 거듭제곱
             
             hashCode()는 32비트 정수이기 때문에, 가능한 값의 개수는 **약 43억 개(2^32)**뿐이다.
             하지만 문자열은 경우의 수가 무한!!.
             즉, **서로 다른 문자열이 같은 hashCode를 가질 수밖에 없는 경우(충돌)**가 존재한다.
		 */
		if(a.hashCode() == b.hashCode()) {
		    System.out.println("same hashcode");
		} else {
		    System.out.println("different hashcode");
		}
		
		
		
		
		System.out.println("------------------");
		if(a.equals(b) ) {
		    System.out.println("same ");
		} else {
		    System.out.println("different");
		}
		
	}

}
