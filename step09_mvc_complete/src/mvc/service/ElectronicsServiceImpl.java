package mvc.service;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

import mvc.dto.Electronics;
import mvc.exception.DMLException;
import mvc.exception.DuplicateModelNoEexepction;
import mvc.exception.ElectronicsArrayBoundsException;
import mvc.exception.SearchNotFoundException;

/**
 * 전자제품에 관련된 기능을 담당할 클래스
 */

public class ElectronicsServiceImpl implements ElectronicsService {
	
	
	private static ElectronicsService instance = new ElectronicsServiceImpl(); 
    private static final int MAX_SIZE=6;
    List<Electronics> list = new ArrayList<Electronics>();
    
    
    /** 
     * 외부에서 객체 생성안됨. 
     * InitInfo.properties파일을 로딩하여  List에 추가하여
     * 초기치 데이터를 만든다.
     * 
     */
    private ElectronicsServiceImpl() {
    	ResourceBundle rb = ResourceBundle.getBundle("InitInfo");//dbInfo.properties
        for(String key : rb.keySet()) {
     	  String value =  rb.getString(key); //value는 100,선풍기,35000,삼성 선풍기
     	  
     	   String data[] = value.split(",");
     	   //System.out.println(key +" = " + value); //100 = 100,선풍기,35000,삼성 선풍기
     	  Electronics elec =  
           new Electronics(  Integer.parseInt(data[0]) ,data[1],  Integer.parseInt( data[2]), data[3]);
     	  
     	     list.add(elec);
     	  
        }
        
        //System.out.println(list);
      
    }
    
    public static ElectronicsService getInstance() {
		return instance;
	}

	@Override
	public void insert(Electronics electronics) 
			throws ElectronicsArrayBoundsException , DuplicateModelNoEexepction {
		
		if(list.size() == MAX_SIZE) {
			throw new ElectronicsArrayBoundsException("더이상 등록할수 없습니다.");
		}
		
		 
		try {
	    	//모델번호 중복여부 체크
			this.searchByModelNo(electronics.getModelNo());
			
		    throw new DuplicateModelNoEexepction(electronics.getModelNo()+"중복이므로 등록할수 없습니다.");
		 
		}catch (SearchNotFoundException e) {
			//예외가 발생했다는것은 중복아니다.
			list.add(electronics);
		}
	}

	@Override
	public List<Electronics> selectAll() {
		
		return list;
	}

	@Override
	public Electronics searchByModelNo(int modelNo) throws SearchNotFoundException {
		for(Electronics elec : list) {
    		if(elec.getModelNo() == modelNo ){
                return elec;
            }
    	}
        
        //찾는 정보가 없다!!!
        throw new SearchNotFoundException(modelNo+"는 없는 모델번호로 검색할수 없습니다.");
	}
	

	  /**
     * 모델번호에 해당하는 전자제품 수정하기 
     * (설명만 수정한다)
     * @param electronics
     * @return
     */
	
    public void update(Electronics electronics)throws SearchNotFoundException{//모델번호, 설명
		//인수로 전달된 모델번호에 해당하는 전자제품이 있는지 검색한다.
    	
         Electronics dbElectronics =  this.searchByModelNo(electronics.getModelNo());
         
        // 수정
         dbElectronics.setModelDetail( electronics.getModelDetail()  );
    }
    
    

	@Override
	public void delete(int modelNo) throws SearchNotFoundException {
		 Electronics dbElectronics = 
				 this.searchByModelNo(modelNo);
		 
		list.remove(dbElectronics);
		
		
	}
	////////////////////////////
	/*class A implements Comparator<Electronics>{
		@Override
		public int compare(Electronics a, Electronics b) {
			// TODO Auto-generated method stub
			return a.getModelPrice() == b.getModelPrice() ?
					    b.getModelNo()-a.getModelNo() : 
						a.getModelPrice()-b.getModelPrice();
		}
	}*/
///////////////////////////////////////////////
	@Override
	public List<Electronics> selectSortByPrice() {
		
		//정렬을 할 자료구조 
		List<Electronics> sortList = new ArrayList<Electronics>(list);
		//Collections.sort(sortList);//직접 Comparable<Electronics> 구현한경우
			
		//Collections.sort(sortList, new A());//외부에 구현객체 만든경우
		
		
		Collections.sort(sortList,new Comparator<Electronics>() {
			@Override
			public int compare(Electronics a, Electronics b) {
				
				return a.getModelPrice()-b.getModelPrice();
			}
		} );
		////////////////////////////////////////////////////////////////////
		//Functional Interface를 람다식으로 표현
		Collections.sort(sortList , (a,b)-> 
		             a.getModelPrice() == b.getModelPrice() ? 
		        		b.getModelNo()-a.getModelNo() : a.getModelPrice()-b.getModelPrice());
				
				
				
				
		
		/*Collections.sort(sortList, (o1,o2) ->{
			int result =  (o1.getModelPrice() - o2.getModelPrice()) == 0 
					? o1.getModelNo() - o2.getModelNo() : 
						(o1.getModelPrice() - o2.getModelPrice());
			
		    return result;
		});*/
		
		return sortList;
	}

	@Override
	public void saveObject() {
		// TODO Auto-generated method stub
		
	}
	
	/*@Override
	public List<Electronics> selectSortByPrice() {
		List<Electronics> sortList = new ArrayList<Electronics>(list);
		
		Collections.sort(sortList , new Comparator<Electronics>() {
			@Override
			public int compare(Electronics o1, Electronics o2) {
				//return o1.getModelPrice()  - o2.getModelPrice(); //올림
				//return o2.getModelPrice()  - o1.getModelPrice();//내림
				
				return  (o1.getModelPrice()  - o2.getModelPrice()==0)
						? (o2.getModelNo() - o1.getModelNo()) : 
							o1.getModelPrice()  - o2.getModelPrice();
			}
		} );
		
		return sortList;
	}*/

    
} // 클래스 끝 




