package mvc.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;

import mvc.dto.Electronics;
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
    
    private File file ;//= new File("save.txt");
    
    //private File file  =new File("src/mvc/view/save.txt");
    
    /** 
     * 외부에서 객체 생성안됨. 
     * InitInfo.properties파일을 로딩하여  List에 추가하여
     * 초기치 데이터를 만든다.
     * 
     */
    private ElectronicsServiceImpl() {
    	
    	System.out.println("user.dir = "+System.getProperty("user.dir"));
    	System.out.println("user.home = "+ System.getProperty("user.home"));
    	
    	String path = System.getProperty("user.dir") + "/save.txt";
    	
    	 file = new File(path);
		try {
    		if(file.exists()) {
    			System.out.println(1);
    			try(ObjectInputStream ois = 
    					new ObjectInputStream(new BufferedInputStream(
    							new FileInputStream(file)));){
    				
    				Object obj = ois.readObject();
    				if(obj instanceof List) {
    					list = (List<Electronics>)obj;
    				}
    				
    			}
    		}else {
    			System.out.println(2);
    			ResourceBundle rb = ResourceBundle.getBundle("InitInfo");
		        
		        for (String key : rb.keySet()) {
					String value = rb.getString(key);
					String[] arr = value.split(","); // 콤마를 기준으로 분리해서 배열로 리턴
					list.add(new Electronics(Integer.parseInt(arr[0]),arr[1],Integer.parseInt(arr[2]),arr[3]));
	        	}
    			
    		}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
      
    }
    
    public static ElectronicsService getInstance() {
		return instance;
	}

	@Override
	public void insert(Electronics electronics) 
			throws ElectronicsArrayBoundsException , 
			       DuplicateModelNoEexepction {
		
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
	
    public void update(Electronics electronics)
    		throws SearchNotFoundException{
		//인수로 전달된 모델번호에 해당하는 전자제품이 있는지 검색한다.
    	
         Electronics dbElectronics = 
        		 this.searchByModelNo(electronics.getModelNo());
         
        // 수정
         dbElectronics.setModelDetail( electronics.getModelDetail()  );
         
    	
    }
    
    

	@Override
	public void delete(int modelNo) throws SearchNotFoundException {
		 Electronics dbElectronics = this.searchByModelNo(modelNo);
		list.remove(dbElectronics);
		
		
	}

	/*@Override
	public List<Electronics> selectSortByPrice() {
		List<Electronics> sortList = new ArrayList<Electronics>(list);
		Collections.sort(sortList, (o1,o2) ->{
			int result =  (o1.getModelPrice() - o2.getModelPrice()) == 0 
					? o1.getModelNo() - o2.getModelNo() : 
						(o1.getModelPrice() - o2.getModelPrice());
		    return result;
		});
		
		return sortList;
	}*/
	
	@Override
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
	}
	
	@Override
	public void saveObject() throws Exception {
		//list 를 save.txt 에 저장한다.
		try(ObjectOutputStream oos = 
				new ObjectOutputStream(
						new BufferedOutputStream(
						new FileOutputStream( file ))))  {
			
			oos.writeObject(list);
		} 
		
	}

    
} // 클래스 끝 




