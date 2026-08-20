package ex0803.lotto;
import java.util.Arrays;

public class LottoTest {
	int lotto [] = new int [6] ;//0
    int cnt;//배열방에 중복없이 숫자가 들어간 개수. = 0
    
    /**
     * 로또 번호 한개 생성하여 기존 로또번호와 비교하여 같으면 다시 생성.
     * */
    public void createLottoNo(){
    	int len = lotto.length;
    	
		while(cnt < len){//0
			 int lottoNo = (int)(Math.random()*45)+1;//5
			 if(  this.isCompareNo(lottoNo) ){
				 lotto[cnt] = lottoNo;
				 cnt++;
			 }
		}
		
        System.out.println("중복없이 추가완료 : " + Arrays.toString(lotto));
    } 
    /**
     * 로또번호 비교하는 부분
	    return : true : 중복아님, false이면 중복 * */
    public boolean isCompareNo(int lottoNo ){// lottoNo는 난수의 값
    	
    	for(int i=0; i < cnt ; i++){
    		if(lotto[i] == lottoNo ){
    		  return false;// 함수(메소드)를 빠져나가라.
    		}
    	}
    	
    	return true;   	
    }
    
    
    /**
     * 완성된 6개 번호 정렬하기
     * */
     public void lottoSort(){
    		//버블정렬방식 : 인접해 있는 데이터를 비교해서 큰값을 오른쪽 배치
 		int temp=0;//임시공간변수
 		int len = lotto.length-1;
 		
 		for(int i = len ; i > 0 ; i--){// 
 			for(int j=0; j< i; j++){//
 				//if(lotto[j] > lotto[j+1]){ 
 				if(lotto[j] < lotto[j+1]){ 
 					temp = lotto[j];
 					lotto[j] = lotto[j+1];
 					lotto[j+1] = temp;
 				}
 			}
 		}
 		
		//Arrays.sort(lotto);
     }
     

     /**
      * 출력하는 메소드
      * */
     public void printLotto(){
     	//출력
		for(int i=0; i< lotto.length ; i++){
     		System.out.print(lotto[i]+"\t");
     	}
     }
	
	public static void main(String[] args) {
		LottoTest lotto = new LottoTest();
		lotto.createLottoNo(); //로또번호를 중복없이 저장하는 메소드 
		System.out.println("--정렬하자 ----");

		lotto.lottoSort();//정렬

		lotto.printLotto(); //출력

	}
	

}
