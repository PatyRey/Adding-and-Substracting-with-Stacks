/*****************************************************
 
  	File Name:		 StackOperations.java 
 
******************************************************/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author Patricia Reyes
 * @version 1.0 (11/05/21)
 * 
 * This Program will add and subtract large integers read from the text file "addsAndSubstract.txt"
 */

public class StackOperations {

	 /**
	  * This method will read the file "addsAndSubstract.txt" and print the operator and results
	  */
	 public void printStacks() {
		File filename = new File ("addsAndSubtracts.txt");
		try {
			try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
				String str;
						
				while((str=br.readLine())!= null) {
					String strAr[] = str.split(" ");
					//System.out.printf(strAr[0] + "\n" + strAr[1]+ strAr[2]+ "\n");
					//System.out.println(compute(strAr[0],strAr[1],strAr[2])+ "\n ");
					compute(strAr[0],strAr[1],strAr[2]);
					System.out.println();
				}
			}
		}
		catch (FileNotFoundException e1) {
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
                
		
		}
	 /**
	  * Constructor
	  */
	 public StackOperations(){
		 
		 printStacks();
		 
	 }	 
	 
	 /**
       * @param operator1 is the first operation sign to compare with symbol2
       * @param operator2 is the second operation sigh to compare with symbol1
       * @return str is the product of symbol1 and symbol2 operation signs
       */		
	public static String operation(String operator1,String operator2) {
		
		String str = null;
       
		if(operator1.equals("+") && operator2.equals("+"))
        	str = "+";
        else if(operator1.equals("+") && operator2.equals("-"))
            str = "-";
        else if(operator1.equals("-") && operator2.equals("+"))
            str = "-";
        else if(operator1.equals("-") && operator2.equals("-"))
            str = "+";
        return str;
        }
       
	/**
	 * It will compare the length of the 2 operands before they can be evaluated
	 * 
	 * @param number1 is the operand to be compare in length with number2
	 * @param number2 is the operand to be compare in length with number1
	 * @return true or false
	 */
	public static boolean isLong(String number1,String number2) {
		
		if(number1.length()>number2.length())
			return true;
		
		else if(number1.length()<number2.length())
			return false;
		
		for(int i = 0; i<number1.length(); i++) {
			if(Integer.parseInt(number1.charAt(i)+"")<Integer.parseInt(number2.charAt(i)+""))
			return false;
			
			else if(Integer.parseInt(number1.charAt(i)+"")>Integer.parseInt(number2.charAt(i)+""))
			return true;
            }
            return true;
        }
	
	/**
	 * Adds zeroes on the left to the smallest operand
	 * @param number1 it will compare length with number2
	 * @param number2 it will compare length with number
	 * @return number1 or number2 with zeroes added for padding
	 */	
	public static String padLengthZero(String number1,String number2) {
    	 int lg1 = number1.length();
    	 int lg2 = number2.length();
    	 
    	 if(lg1 > lg2) {
    		 for(int i = 0; i < lg1-lg2; i++)
    			 number2 = "0" + number2;
    		return number2;
             }
    	 
    	 for(int i = 0; i < lg2-lg1; i++)
    		 number1 = "0" + number1;
    	 	return number1;
        }
        
	/**
	 * 
	 * @param num1 First number
	 * @param symOp Arithmetic symbol
	 * @param num2 Second number
	 * @return str Returns result value
	 */
	public static String add(String num1, String symOp, String num2) {
    	 
    	 String str = "";
    	 Stack s1 = new Stack();
    	 Stack s2 = new Stack();
    	 Stack result = new Stack();
    	 int carrier = 0;
    	
    	 for(int i = 0; i <num1.length(); i++) {
    		 s1.push(Integer.parseInt(num1.charAt(i) + ""));
    		 s2.push(Integer.parseInt(num2.charAt(i) + ""));
             }
    	 int sum;
    	 
    	 while(!s1.isEmpty() && !s2.isEmpty()) {
    		 sum = s1.top()+s2.top()+ carrier;
    		 carrier = sum/10;   //it will carry a 1 if is over 10
             sum = sum%10;
             result.push(sum);
    		 s1.pop();
    		 s2.pop();
             }
    	 
  
         // If carry remains, push into the stack
         while (carrier > 0)
         {
             result.push(carrier);
             carrier /= 10;
         }
         //////////////////////////////////////////////////////////
    	
    	 while(!result.isEmpty()) {
             str+=result.top();
             result.pop();
         }
             return str;
             }
        
	/**
	 * 
	 * @param num1 First number
	 * @param op Arithmetic symbol
	 * @param num2 Second number
	 * @return str Return results value
	 */
	public static String subtract(String num1,String op,String num2 ) {
    	
    	 String str = "";
         Stack s1 = new Stack();
         Stack s2 = new Stack();
         Stack result = new Stack();
         int borrower = 0;
        
         for(int i = 0; i <num1.length(); i++) {
        	 s1.push (Integer.parseInt(num1.charAt(i) + "" ));
             s2.push(Integer.parseInt(num2.charAt(i) + "" ));
             }
        
         int diff;
         
         while(!s1.isEmpty()) {
        	 int d;
         
         if(s1.top()==0 && borrower==1)
        	 d = 9;    //if it borrows the left digit will lose 1
         
         else
        	 d = s1.top()-borrower;
         
         if(d<s2.top()) {
        	 borrower = 1;
        	 diff = 10+d-s2.top();
         	}
         else {
        	 borrower = 0;
        	 diff = d-s2.top();
         	}
         
         s1.pop();
         s2.pop();
         result.push(diff);
         }
         
         while(!result.isEmpty()) {
        	 str+= result.top();
        	 result.pop();
        	 }
         return str;
         }
        /**
         * 
         * @param num1 First number
         * @param op Arithmetic Operation
         * @param num2 Second number
         * @return results return results
         */
     public static String compute(String num1,String op,String num2) {
    	
    	 String opSymbol = "";
    	 String result = "";
    	 
    	 //Get the longer operand to later pad the shorter
    	 int longestNumber = getLongestNumber(num1,num2);
    	 
    	 //Pad top number with 1 extra to accommodate operator in second line
    	 printNice(num1,longestNumber+1);
    	 System.out.print(op);
    	 printNice(num2,longestNumber);
    	 //-------------------
    	 
    	 if(num2.charAt(0) == '-' || num2.charAt(0) == '+') {
    		 op = operation(op, num2.charAt(0) + "" );
    		 num2 = num2.substring(1);
    		 }
                
    	 if(num1.charAt(0) == '-' || num1.charAt(0) == '+') {
    		 char s = num1.charAt(0);
    		 num1 = num1.substring(1);
    		 
    		 if(isLong(num1,num2))
    			 opSymbol = s + "";
    		 else
    			 opSymbol = op;
    		 op = operation(op, s + "");      
    	 }
    	 
    	 if(num1.length()> num2.length())
    		 num2 = padLengthZero(num1,num2);
    	
    	 else if(num1.length()<num2.length())
    		 num1 = padLengthZero(num1,num2);
                
    	 if(op.equals("+"))
    		 result = opSymbol + add(num1, op, num2);
    	 
    	 else if(op.equals("-"))
    		 if(isLong(num1, num2))
    			 result = opSymbol + subtract(num1,op,num2);
    		 else
    			 result = opSymbol + subtract(num2,op,num1);
    	 
    	 
    	 //Replace extra zeros with spaces for result and again give extra padding to account for operator
    	 result = removeLeftPadding(result, longestNumber);
    	 printNice(result,longestNumber+1);
    	
    	 
    	 return result;
        }
     
     /**
      * @param str String
      * @param len length of the String
      */
     public static void printNice(String str, int len) {
    	
    	 while(str.length()<len) {
    		 str = " "+str;
    	 }
    	 System.out.println(str);
     }
     /**
      * @param num1 Firs number
      * @param num2 Second number
      * @return Return results
      */
     public static int getLongestNumber(String num1,String num2) {
    	 int longest =Math.max(num1.length(),num2.length());
    	 
    	 return longest;
     }
     
     /**
      * @param str String
      * @param len String length
      * @return return results
      */
     public static String removeLeftPadding(String str, int len) {
    	 String minusFlag = "";
    	 if(str.charAt(0)=='-') {
    		 str = str.substring(1,str.length());
    		 minusFlag = "-";
    	 }
    	 while(str.charAt(0)=='0') {
    		 str = str.substring(1,str.length());
    	 }
    	 return minusFlag+str;
     }
        	/** 
        	 * @param args, will evaluate all the arithmetic operations read from the "addsAndSubtracts.txt"
        	 * @throws IOException Exception 
        	 */
	public static void main(String[] args) throws IOException {
         
		 new StackOperations();
		 
		
	}

}




