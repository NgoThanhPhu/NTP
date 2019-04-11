import java.util.Stack;// test

//Sinh vien khong chinh sua bat ky dong lenh nao ben tren dong comment "Phan bai lam cua sinh vien", duoc phep them thu vien khi can thiet

public class InfixToPostfixSolve implements Requirement1_OutputGetter {
	private String inputString;
	private String outputString;
	
	public InfixToPostfixSolve(){ //Phuong thuc khong duoc chinh sua
		this.inputString = "";
		this.outputString = "";
	}
	
	public InfixToPostfixSolve(String inputString){ //Phuong thuc khong duoc chinh sua
		this.inputString = inputString;
		this.outputString = "";
	}
		
	public void setInputString(String inputString){ //Phuong thuc khong duoc chinh sua
		this.inputString = inputString;
	}
	
	 public String getOutputString() { //Phuong thuc khong duoc chinh sua
    	this.outputString = infixToPostfix();
		return outputString;
	}	
	
	// Phan bai lam cua sinh vien
	
private  String infixToPostfix(){
		String postfix = new String("");
		Stack<String> S = new Stack<String>();
		
		for (int i = 0; i < stringTokenizer(inputString).length; ++i) {
					// If the operand was found, add to postfix
					if (isNum(stringTokenizer(inputString)[i]))
						postfix += stringTokenizer(inputString)[i] +" " ;
					// 
					else if(stringTokenizer(inputString)[i].compareTo("(")==0)
						S.push(stringTokenizer(inputString)[i]);
					else if(stringTokenizer(inputString)[i].compareTo(")")==0)
					{
							
							while(!S.isEmpty() && S.peek().equals("(")==false)
								postfix+= S.pop() +" ";
							
							S.pop();
					}
					else
					{
							
							while(!S.isEmpty() && S.peek().equals("(")==false && priorityOfOperator(stringTokenizer(inputString)[i]) <= priorityOfOperator(S.peek()))
								postfix+= S.pop() +" ";
							
							
							S.push(stringTokenizer(inputString)[i]);
					}
		}
		while(!S.isEmpty())
			postfix+= S.pop()+" ";
		
		return postfix;
}
	private static boolean isNum(String c) {
    	return c.matches("0|([1-9][0-9]*)");
    }
	    
		private static int priorityOfOperator(String op){ //Hàm xét độ ưu tiên của toán tử.
       	 if(op.compareTo("^")==0)
			  return 4;
		 else if(op.compareTo("*")==0 || op.compareTo("/")==0) 
			 return 3;
		 else if (op.compareTo("-")==0|| op.compareTo("+")==0)
			 return 2;
         else if(op.compareTo("(")==0 ||  op.compareTo(")")==0) 
			 return 1;
		 else
			  return 0;
		  
	
    }   
	private static String[] stringTokenizer(String str){ // Hàm chuyển chuỗi trong input thành dãy kí tự( ko có Space)
	 	 String[] temp=str.split(" ");
	   	  return temp;
	 }
}
