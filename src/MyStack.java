/**
 * @author Dion de Jong 
 * @version 1.0 1 March 2014
 * This is my implementation of the the 
 * Stack class. It creates a stack manageable by other classes 
 * to be used to store values. 
 */ 

//main class header, should implement Stack class. 
public class MyStack implements Stack{

//instance variables, including an Object array to be flexible. 
private final static int MAX_SIZE = 150; 
private static Object[] Stack = new Object[MAX_SIZE]; 
private static int m_ptr = 0;  

//default constructor
public MyStack()
{
}

//getter for the stack pointer. 
public static int getM_ptr() 
{
	return m_ptr;
}

//check if the stack is empty. 
public boolean isEmpty()
{
	
	boolean empty = true; 
	//if every value in the stack is set to null, the stack is empty. 
	for (int i = 0; i < Stack.length; i++)
	{
		if (Stack[i] != null)
		{
			empty = false; 
		}
	}
	return empty; 
}


//returns the the number of values held in the stack. 
@Override
public int size()
{
	int size = 0; 
	//if the value of an index is not null, a value is held there, and thus the stack size is incremented. 
	for (int i = 0; i < Stack.length; i++)
	{
		if (Stack[i] != null)
		{
			size ++; 
		}
	}
	return size; 
}

//returns the last value added to the stack. 
@Override
public Object top() 
{
	//pointer always points to the first empty space, so must find the value at the point 1 below the pointer. 
	Object top = Stack[m_ptr-1];
	return top;
}

//take an object and push it onto the top of the stack. 
@Override
public void push(Object element) 
{
	//store the object in the array where the pointer is
	Stack[m_ptr] = element; 
	//must move pointer to next empty space
	m_ptr ++; 
	
}

//remove the top object of the stack and return it. 
@Override
public Object pop() 
	{
	//decrement pointer to reach top object
	m_ptr --; 
	//save that to a variable
	Object popped = Stack[m_ptr]; 
	//clear that space to null
	Stack[m_ptr] = null;
	//return the object
	return popped; 
	}

//print the stack. 
public void PrintStack()
{
	for (int i = 0; i < size(); i ++)
	{
		System.out.print(Stack[i] + " ");
	}
	System.out.println();
}

//some test stuff
//public static void main(String[] args) {
//	// TODO Auto-generated method stub
////should convert from string to number
//	
//	MyStack test = new MyStack(); 
//	System.out.println(test.isEmpty()); 
//	test.push('a');
//	System.out.println(test.size());
//	System.out.println(test.top());
//	System.out.println(test.isEmpty()); 
//	System.out.println(test.pop());
//	
//	//Double.valueOf(String.ValueOf(variable)); 
//	System.out.println(test.size());
//}
}


