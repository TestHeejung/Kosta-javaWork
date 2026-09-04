package kosta.db.view;

import kosta.db.dao.EmpDAO;

public class MainApp {
	public static void main(String[] args) {
		System.out.println("**JDBC 시작하기 ****");
	    EmpDAO dao = new EmpDAO();
	    //dao.selectNames();
	    
	    System.out.println("**삭제하기 ***********");
	    //dao.deleteByEmpno(7566);
	    
	    dao.deleteByEmpno2(7698);

	}

}
