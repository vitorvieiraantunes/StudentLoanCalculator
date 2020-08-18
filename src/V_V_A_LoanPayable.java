/*
 			 Title: V_V_A_LoanPayable.java
	    Author: Vitor Antunes
	      Date: Apr 8, 2020 6:41:22 PM
 Description: interface for holding the final double that converts from annual to monthly, 
 							and force the creating of the calculateLoanPayment method
 */
public interface V_V_A_LoanPayable
{

	// Variable use to calculate montly rate based on YEarly rate
	public final double ANNUAL_RATE_TO_MONTHLY_RATE = (1/1200.0);
	//Abstract method to be implemented in the app class for making the loan calculation
	public double calculateLoanPayment(double principalAmount, double  annualPrimeInterestRate, int amortizationPeriodMonths);  


}