/**
 * @author Dion de Jong 
 * @version 1.0 3 March 2014
 * This is the 
 */ 

public class ExprEval extends MyStack {
	private String ExprEval = ""; 
	//put constructor call inside a method/constructor
	MyStack stack1 = new MyStack(); 

	//default Constructor 
	public ExprEval()
	{
	}

	//Constructor that sets the value of the instance variable
	public ExprEval(String expression)
	{ 
		this.ExprEval = expression; 
	}

	//getter and setter
	public String getExprEval() 
	{
		return ExprEval;
	}

	public void setExprEval(String exprEval)
	{
		ExprEval = exprEval;
	}

	//The evaluate method
	public void Evaluate()
	{
		//for loop that runs the length of the expression. 
		for (int i = 0; i < ExprEval.length(); i++)
		{

			//if value of the stack is a number
			if (Character.isDigit(ExprEval.charAt(i)))
			{
				String temp1 = ""; 
				//must account for multiple digit numbers
				//this for loop concatenates multiple digits to a string
				for (int j = i; Character.isDigit(ExprEval.charAt(j)); j++)
				{
					char temp = ExprEval.charAt(j); 
					temp1 = temp1 + temp; 
					//incrementing the main loop
					i++; 
				}
				//push the concatenated string to the stack
				stack1.push(temp1);
				//reset the string variable
				temp1 = ""; 
			}
			
			//if the value of the stack is an operator, just store it. 
			if (ExprEval.charAt(i) == '+' || ExprEval.charAt(i) == '-' || ExprEval.charAt(i) == '/' || ExprEval.charAt(i) == '*')
			{
				stack1.push(ExprEval.charAt(i));
			}

			//if it's a closed parenthesis, pop the last three values which should be 1 operator and 2 numbers and evaluate the expression.
			else if (ExprEval.charAt(i) == ')')
			{
				double expr1 = 0; 
				char expr2 = ' '; 
				double expr3 = 0;
				//if there are at least 3 items in the stack, pop the 3, if not, there is a formatting error. 
				if (stack1.getM_ptr() > 2)
				{
					expr1 = Double.valueOf(String.valueOf(stack1.pop())); 
					expr2 = (char)stack1.pop(); 
					expr3 = Double.valueOf(String.valueOf(stack1.pop())); 
				}
				else 
					break;
				

				//individual cases for each of the operands. Store the evaluated value of the expression onto the stack. 
				if (expr2 == '-')
				{
					double answer = expr3 - expr1; 
					stack1.push(answer);
				}

				else if (expr2 == '+')
				{
					double answer = expr3 + expr1; 
					stack1.push(answer);
				}

				else if (expr2 == '/')
				{
					double answer = expr3 / expr1; 
					stack1.push(answer);
				}

				else if (expr2 == '*')
				{
					double answer = expr3 * expr1; 
					stack1.push(answer);
				}
			}
			//this loop should repeat until all the parenthesis pairs are accounted for and there is one value in the loop. 

		}
		//if the stack has one value, that is the answer print it. 
		if (stack1.size() == 1)
		{
			System.out.println(stack1.top());
		}
		//otherwise there is an error. 
		else 
		{
			System.out.println("Your expression was not formatted correctly");
		}
	}

}


