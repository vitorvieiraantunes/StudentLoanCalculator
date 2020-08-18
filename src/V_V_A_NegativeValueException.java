/*
 			 Title: V_V_A_NegativeValueException.java
	    Author: Vitor Antunes
	      Date: Apr 9, 2020 8:25:51 PM
 Description: Exception class to catch negative numbers in the loan field of the Jframe
 */
public class V_V_A_NegativeValueException extends Exception
{

	private static final long serialVersionUID = 1L;

	V_V_A_NegativeValueException(String inputName)
	{
		super(inputName + " can't be a negative value");
	}
	
}