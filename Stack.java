/*****************************************************
  
   	File Name:		 Stack.java 
  	
This program will define the Stack

******************************************************/

public class Stack {
	
	/** he stack will initialize empty */
	private StackNode top = null;
			
	/** Stack 	 */
	public Stack() {
		top = null;
			}
	
	/**
	 * Inner class of class theStack that defines Nodes
	 */
	private class StackNode {
		
		private int value;
		private StackNode next;
		
		/** Setters 
		 * @param val, n
		 * */
		public StackNode(int val,Stack.StackNode n) {
			this.value = val;
			this.next = n;
		}
		
		
		/** Getters 
		 * @return next, next node
		 */
		public StackNode getNext() {
			return next;
		}
		
		/** Getters 
		 * @return value
		 * */				
		public int getVal() {
			return value;
		}
	}
	
	
		/** It will check if the stack is empty 
		 * @return top 
		 */
	public boolean isEmpty(){
		return top ==null;		
	}
	
	/**
	 * This method will push a value to the stack
	 * @param val, value to push
	 */
	public void push (int val) {
		StackNode node = new StackNode(val ,top);
		top = node;
	}
	
	/**
	 * This method will return the first value in the stack
	 * @return the value at the top of the stack
	 */
	public int top() {
		return top.getVal();
		}
	
	/**
	 * This method will pop and return the value pop from the stack
	 */
	public void pop() {
		if(top!= null)
			top =top.getNext();
	}
	
	/**
	 * PrintStack Method 
	 */
	public void printStack() {
		StackNode node = top;
		while(node!=null) {
			System.out.println(node.getVal());
			node =node.getNext();
		}
	}

}