package ex0821;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class SerializableLoadExam {
    public SerializableLoadExam() {
    	
    	try(ObjectInputStream ois = 
    			new ObjectInputStream(
    					new FileInputStream("src/ex0821/save.txt"))){
    		
    		/*Member m1 = (Member)ois.readObject();
    		Member m2 = (Member)ois.readObject();
    		Member m3 = (Member)ois.readObject();
    		
    		System.out.println("m1 = " + m1);
    		System.out.println("m2 = " + m2);
    		System.out.println("m3 = " + m3);*/
    		
    		List<Member> list = (List<Member>)ois.readObject();
    		System.out.println("list.size() = " + list.size());
    		System.out.println("list = " + list);
    	}catch (Exception e) {
			e.printStackTrace();
		}
    	
    	
    }
	public static void main(String[] args) {
		new SerializableLoadExam();

	}

}
