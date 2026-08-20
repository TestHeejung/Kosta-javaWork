package mvc.controller;

import java.util.List;

import mvc.dto.Electronics;
import mvc.exception.DMLException;
import mvc.exception.DuplicateModelNoEexepction;
import mvc.exception.ElectronicsArrayBoundsException;
import mvc.exception.SearchNotFoundException;
import mvc.service.ElectronicsService;
import mvc.service.ElectronicsServiceImpl;
import mvc.view.FailView;
import mvc.view.SuccessView;



/**
 * View와 Model 사이에서 중간 역할 
 *  : 사용자의 요청을 받아서 그에 해당하는 서비스를 호출하고
 *    호출한 결과를 받아서 결과값에 따라 결과 뷰를 호출해준다.
 */

public class ElectronicsController {
    private ElectronicsService service = ElectronicsServiceImpl.getInstance();

    /**
     * 전체검색
     */
    public void selectAll() {
    	//서비스를 호출하고 그결과를 받아서 결과view 를 호출한다!!!
    	 List<Electronics> list =  service.selectAll();
    	SuccessView.printAll(list);
    }
 

	 /**
     * 전자제품 등록 (길이 벗어낫는지, 중복여부 체크)
     */
    public void insert(Electronics electronics) {
    	//서비스를 호출하고 그 결과에 따라 성공, 실패 뷰로 이동
    	try {
    	 service.insert(electronics);
    	 SuccessView.printMessage("등록되었습니다.^^");
    	 
    	}catch (ElectronicsArrayBoundsException | DuplicateModelNoEexepction e) {
			FailView.errorMessage( e.getMessage() );
		}
        
    }
    
    

    /**
     * 모델번호에 해당하는 전자제품 검색
     * @param modelNo
     */
    public void searchByModelNo(int modelNo) {//900
    	//서비스 호출하고 그결과 받아서 성공 or 실패 뷰를 호출한다.
    	try {
			Electronics elec = service.searchByModelNo(modelNo);
			
			SuccessView.printSearchByModelNo(elec);
			
		} catch (SearchNotFoundException e) {
			//요기에 진입했다는것을 오류가 발생했다!!!
			FailView.errorMessage(   e.getMessage()   );
		}
    } 

    /**
     * 모델번호에 해당하는 전자제품 수정하기 
     * @param electronics
     */
    public void update(Electronics electronics) {
    	//서비스 호출하고 그 결과받아서 성공, 실패 호출
    	try {
    	  service.update(electronics);
    	  SuccessView.printMessage(electronics.getModelNo() + "에 해당하는 상품 정보가 수정되었습니다.");
    	
    	}catch (SearchNotFoundException e) {
    		FailView.errorMessage(e.getMessage());
		}
    }

    /**
     * 모델번호에 해당하는 전자제품 삭제하기 
     * @param electronics
     */
	public void deleteModelNo(int modelNo) {
		try {
			service.delete(modelNo);
			SuccessView.printMessage(modelNo + "에 해당하는 상품정보가 삭제되었습니다..");
		} catch (SearchNotFoundException e) {
			//FailView.errorMessage(modelNo + "에 해당하는 상품정보가 없어 삭제 할수 없습니다.");
			FailView.errorMessage(e.getMessage());
		}
		
	}
	
	
	 /**
     *  가격을 기준으로 정렬하기
     *  만약, 가격이 같으면 modelNo를 기준으로 정렬한다.
     * @return
     */
    public void selectSortByPrice() {
    	List<Electronics> list = service.selectSortByPrice();
    	SuccessView.printAll(list);
    }
    /////////////////////////////////////////////////////////////////
    
}











