package classes;

public class SymmetricStringAnalyzer {
	private String s; 
	public SymmetricStringAnalyzer(String s) {
		this.s = s; 
	}
	
	/**
	 * Determines if the string s is symmetric
	 * @return true if it is; false, otherwise. 
	 */
	public boolean isValidContent() { 
		SLLStack<Character> stack = new SLLStack<Character>();
		
		for(int i = 0; i<s.length(); i++){
			if(stack.isEmpty())
				stack.push(s.charAt(i));
			else if((s.charAt(i)+"").compareToIgnoreCase((stack.top()+"")) == 0)
				stack.pop();
			else stack.push(s.charAt(i));
		}
		return stack.isEmpty();  // need to change if necessary....
	}
	
	public String toString() { 
		return s; 
	}

	public String parenthesizedExpression() 
	throws StringIsNotSymmetricException 
	{
		try{
			if(!isValidContent())
				throw new StringIsNotSymmetricException();
		}catch(StringIsNotSymmetricException e){
			e.printStackTrace();
			return null;
		}
		
		
		SLLStack<Character> stack = new SLLStack<Character>();
		String str = new String();
		
		for(int i = 0; i<s.length(); i++){
			if(stack.isEmpty()){
				stack.push(s.charAt(i));
				str += "<"+s.charAt(i)+" ";
			}
			else if((s.charAt(i)+"").compareToIgnoreCase((stack.top()+"")) == 0)
				str += stack.pop()+">"+" ";
			else {
				stack.push(s.charAt(i));
				str += "<"+s.charAt(i)+" ";
			}
		}
		
		return str;  // need to change if necessary....
	}

}
