package ex0821;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializableSaveExam {
     public SerializableSaveExam() {
    	 //객체를 저장하자
    	 try(ObjectOutputStream oos =
    			 new ObjectOutputStream(
    		      new FileOutputStream("src/ex0821/save.txt"))){
    		 
    		 Member m1 = new Member("jang", 20, "서울");
    		 Member m2 = new Member("king", 25, "대전");
    		 Member m3 = new Member("queen", 23, "서울");
    		 
    		 List<Member> list =new ArrayList<Member>();
    		 list.add(m1);
    		 list.add(m2);
    		 list.add(m3);
    		 
    		 //oos.writeObject(m1);
    		 //oos.writeObject(m2);
    		 //oos.writeObject(m3);
    		 
    		 oos.writeObject(list);
    		 
    	 }catch (Exception e) {
			e.printStackTrace();
		}
    	 
    	 System.out.println("**저장 완료***");
    	 
     }
	public static void main(String[] args) {
		new SerializableSaveExam();

	}

}
