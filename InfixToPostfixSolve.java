import java.io.*;
import java.util.Stack;

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
		String postfix = "";
		String Sinfix="";
		for(int i=0;i<stringTokenizer(inputString).length;i++)
			Sinfix += stringTokenizer(inputString)[i];
	
        Stack<Character> S = new Stack<Character>();
        char pop;

        for (int i = 0; i < Sinfix.length(); i++) {

            char get = Sinfix.charAt(i);

            if (!isOperator(get))
                postfix += get;

            else if (get == ')')
                while ((pop = S.pop()) != '(')
                    postfix += pop;

            else {
                while ( priorityOfOperator(S.peek()) >= priorityOfOperator(get) && !S.isEmpty() && get != '(' )
                    postfix += S.pop();

                S.push(get);
            }
        }
        // pop any remaining operator
        while (!S.isEmpty())
            postfix += S.pop();

        return postfix;
	}
	    
	private static boolean isOperator(char o){ 
		if(priorityOfOperator(o) >= 1)
			return true;
		return false;
	}
	
	private static int priorityOfOperator(char op){ //Hàm xét độ ưu tiên của toán tử.
       	 if(op == '^')
			  return 4;
		 else if(op == '*' || op == '/') 
			 return 3;
		 else if (op == '-'  || op == '+')
			 return 2;
         else if(op == '(' ||  op == ')') 
			 return 1;
		 else
			  return 0;
	
    }   
	private static String[] stringTokenizer(String str){ // Hàm chuyển chuỗi trong input thành dãy kí tự( ko có Space)
	 	 String[] temp=str.split(" ");
	   	  return temp;
	 }
}

