package kosta.db.view;

import java.util.List;
import java.util.function.Consumer;

import kosta.db.dao.EmpDAO;
import kosta.db.dto.EmpDTO;

public class MainApp {
	public static void main(String[] args) {
		System.out.println("**JDBC 시작하기 ****");
	    EmpDAO dao = new EmpDAO();
	    //dao.selectNames();
	    
	    System.out.println("**삭제하기 ***********");
	    //dao.deleteByEmpno(7566);
	    
	    //dao.deleteByEmpno2(7698);
	    
	    System.out.println("***전체 검색 ****");
	    List<EmpDTO> list = dao.selectAll();
	    
	   // list.forEach(System.out :: println);//메소드 참조문법
	    
	    /*list.forEach(new Consumer<EmpDTO>() {
	    	@Override
	    	public void accept(EmpDTO t) {
	    		System.out.println(t);
	    		
	    	}
		});*/
	    
	    //list.forEach((t)-> System.out.println(t));
	    
	    System.out.println("---사원번호 검색 ----");
	    EmpDTO dto = dao.selectByEmpno(7788);
	    if(dto==null) {
	    	System.out.println("검색된 정보가 없습니다.");
	    }else {
	    	System.out.println(dto);
	    }
	    
	    System.out.println("**등록하기 *****");
	    
	    int re = dao.insert(new EmpDTO(8000, "희정", "강사", 2000, null));
	    if(re==0)System.out.println(re+"=> 등록되지 않았습니다.");
	    else System.out.println(re+"=> 등록되었습니다.");

	}

}










