package ex0806.enumex;

/**
 * enum은 열거형으로 안에 정의된 정보는 static final = 상수 이다.
 * */
/*public enum Grade {
   BASIC , SILVER, GOLD;
}*/
//////////////////////////////////////

public enum Grade {
	BASIC("일반",100,5) , 
	SILVER("우수",200,10), 
	GOLD("최우수",300, 30);
	
     private final String kind;
     private final int point;
     private final int role;
	
	//enum타입안에 있는 생성자는 무조건 private이이다
	Grade(String kind, int point, int role){
		this.kind=kind;
		this.point=point;
		this.role=role;
	}

	public String getKind() {
		return kind;
	}

	public int getPoint() {
		return point;
	}

	public int getRole() {
		return role;
	}
	
	
}


/*static final String BASIC="일반 , 100, 5";

class 
static final String BASIC_KIND="일반"
static final int BASIC_POINT=100
static final int BASIC_ROLE=5

static final String SILVER_KIND="일반"
static final int SILVER_POINT=100
static final int SILVER_ROLE=5*/
