/*
 			 Title: Student.java
	    Author: Vitor Antunes
	      Date: Apr 8, 2020 2:51:06 PM
 Description: Main class to build Student Objects to be used in the StudentLoanApp class
 */
public class Student
{

	//declare class variables
	private String studentID;
	private String surname;
	private String middleName;
	private String firstName;
	private String aptNumber;
	private String streetNumber;
	private String streetName;
	private String city;
	private String province;
	private String postalCode;
	private double cslLoanAmount;
	private double oslLoanAmount;
	
	
	//Contructor
	public Student(String studentID, String surname , String middleName, String firstName,
		   String aptNumber, String streetNumber, String streetName, String city, 
		   String province,  String postalCode, double cslLoanAmount, double oslLoanAmount) 
	{
		
		this.studentID = studentID;
		this.surname = surname;
		this.middleName = middleName;
		this.firstName = firstName;
		this.aptNumber = aptNumber;
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.city = city;
		this.province = province;
		this.postalCode = postalCode;
		this.cslLoanAmount = cslLoanAmount;
		this.oslLoanAmount = oslLoanAmount;
		
	}

	//Getters and Setters
	public String getStudentID()
	{
		return studentID;
	}

	public String getSurname()
	{
		return surname;
	}

	public String getMiddleName()
	{
		return middleName;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public String getAptNumber()
	{
		return aptNumber;
	}

	public String getStreetNumber()
	{
		return streetNumber;
	}

	public String getStreetName()
	{
		return streetName;
	}

	public String getCity()
	{
		return city;
	}

	public String getProvince()
	{
		return province;
	}

	
	public String getPostalCode()
	{
		return postalCode;
	}

	public double getCslLoanAmount()
	{
		return cslLoanAmount;
	}

	public double getOslLoanAmount()
	{
		return oslLoanAmount;
	}

	public void setSurname(String surname)
	{
		this.surname = surname;
	}

	public void setMiddleName(String middleName)
	{
		this.middleName = middleName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public void setAptNumber(String aptNumber)
	{
		this.aptNumber = aptNumber;
	}

	public void setStreetNumber(String streetNumber)
	{
		this.streetNumber = streetNumber;
	}

	public void setStreetName(String streetName)
	{
		this.streetName = streetName;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public void setProvince(String province)
	{
		this.province = province;
	}

	public void setPostalCode(String postalCode)
	{
		this.postalCode = postalCode;
	}

	public void setCslLoanAmount(double cslLoanAmount)
	{
		this.cslLoanAmount = cslLoanAmount;
	}

	public void setOslLoanAmount(double oslLoanAmount)
	{
		this.oslLoanAmount = oslLoanAmount;
	}

	/*Method Name: toString
	*Purpose: Returns a String with all the information about the object in a formated manner
	*Accepts: 
	*Returns: String
	*/
	public String toString()
	{
		
		return String.format("Student Name: %s, %s %s\nStudent Number: %s\nCSL Amount is $%.1f\nOSL  Amount is $%.1f",
				surname, firstName, middleName, studentID, cslLoanAmount, oslLoanAmount);
	}
	

}
