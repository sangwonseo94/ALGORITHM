package p01_Variable;

public class VariableEx {
	//전역변수 
	int a  =20;
	
	static int b = 10 ; 

	public static void main(String []args){
		
		// args..? : parameter 변수, Java virtual machine
		
		VariableEx ve = new VariableEx();
		
		// 참조타입.. VariableEx
		// 참조변수 주소값을 알고있다..
		
		int number = 10 ;
		
		// 기본형 변수 실제값이 저장되어있따
		
		ve.add();
		VariableEx.multiply();
		System.out.println(ve.divide(10,2));
		
	}
	
	//인스턴스 매소드

	void add() {
		System.out.println(a+b);
		
	}

	//스테틱 메소드
	static void multiply() {
		VariableEx ve2 = new VariableEx(); 
		System.out.println(ve2.a*b);
	}
	
	// parameter variable 매개변수  : a, b
	// parameter type : int 
	
	int divide(int a, int b) {
	
		long kk = 10 ; 
		return a / b ;
		
	}
	
	}


