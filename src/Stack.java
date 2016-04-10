/**
 * @author Dion de Jong 
 * @version 1.0 28 February 2014
 * This class is the template for the mystack class. 
 */ 

public interface Stack {

    // return the number of elements in the stack
    public int size();
    
    // see if the stack is empty
    public boolean isEmpty();
    
    // return the top element 
    public Object top();
     
    // push an element on to the stack
    public void push(Object element);
    
    // return and remove the top element of the stack
   public Object pop(); 

}