package p01_Variable;

public class VariableEx {
	//�������� 
	int a  =20;
	
	static int b = 10 ; 

	public static void main(String []args){
		
		// args..? : parameter ����, Java virtual machine
		
		VariableEx ve = new VariableEx();
		
		// ����Ÿ��.. VariableEx
		// �������� �ּҰ��� �˰��ִ�..
		
		int number = 10 ;
		
		// �⺻�� ���� �������� ����Ǿ��ֵ�
		
		ve.add();
		VariableEx.multiply();
		System.out.println(ve.divide(10,2));
		
	}
	
	//�ν��Ͻ� �żҵ�

	void add() {
		System.out.println(a+b);
		
	}

	//����ƽ �޼ҵ�
	static void multiply() {
		VariableEx ve2 = new VariableEx(); 
		System.out.println(ve2.a*b);
	}
	
	// parameter variable �Ű�����  : a, b
	// parameter type : int 
	
	int divide(int a, int b) {
	
		long kk = 10 ; 
		return a / b ;
		
	}
	
	}


