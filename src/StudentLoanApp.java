/*
 			 Title: StudentLoanApp.java
	    Author: Vitor Antunes
	      Date: Apr 8, 2020 3:13:46 PM
 Description: Class to Create a prototype GUI to calculate modification on student loan payments
 */

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.util.ArrayList;

public class StudentLoanApp extends JFrame implements V_V_A_LoanPayable
{

	private static final long serialVersionUID = 1L;
	//List to hold Student Objects
	ArrayList<Student> studentList;
	//JFrame objects
	private JLabel TopLabel;
	private JTextField txFInputStudentID, txFInputSurname, txFInputMiddleName, txFInputFirstName, txFInputAptNumber,
										 txFInputStreetNumber, txFInputStreetName, txFInputCity, txFInputProvince, txFInputPostalCode,
										 txFInputCslLoanAmount, txFInputOslLoanAmount;
	private JTextField txFOutputStudentID, txFOutputSurname, txFOutputMiddleName, txFOutputFirstName, txFOutputAptNumber,
										 txFOutputStreetNumber, txFOutputStreetName, txFOutputCity, txFOutputProvince, txFOutputPostalCode,
										 txFOutputCslLoanAmount, txFOutputOslLoanAmount;
	private JTextField txFCslMonthlyPayments, txFOslMonthlyPayments, txFTotalMonthlyPayments, txFTotalWithInterest, 
										 txFOriginalBorrowed, txFTotalInterest, txFPrime1, txFPrime2, txFAmortizationPeriod;	
	private JButton btnCreateStudent, btnNextStudent, btnPreviousStudent, btnIncrPrime1, btnIncrPrime2, btnDecrPrime1, btnDecrPrime2, btnCalculate;
	private JPanel leftPanel, topLeftPanel,topCenterPanel, centerPanel, bottomCenterPanel, primePanel1, primePanel2, rightPanel, mainRightPanel;
	//int to keep track of the current student from the list
	private int index;
	//Boolean to signal if the list is empty
	private boolean emptyList = true;
	
	
	//class constructor
	StudentLoanApp()
	{
		//boiler plate
		super("Vitor Antunes 0795460");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900, 500);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout());
		
		//initializes the list
		studentList = new ArrayList<Student>();
		
		//Tittle Label
		TopLabel = new JLabel();
		TopLabel.setText("This is Vitor’s Student Loan Calculator ");
		TopLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(TopLabel, BorderLayout.NORTH);
		
		//Methods to build the panels
		buildleftPanel();
		buildCenterPanel();
		buildRightPanel();
		
		//Add the panel
		add(leftPanel, BorderLayout.WEST);
		add(centerPanel, BorderLayout.CENTER);
		add(mainRightPanel, BorderLayout.EAST);
		
		//Creates a margin for the main panels
		leftPanel.setBorder(new EmptyBorder(5, 5, 5, 5) );
		centerPanel.setBorder(new EmptyBorder(5, 5, 5, 5) );
		mainRightPanel.setBorder(new EmptyBorder(5, 5, 5, 5) );
		this.setVisible(true);
	}
	
	/*Method Name: buildleftPanel
	*Purpose: Build the left panel
	*Accepts: 
	*Returns: Void
	*/
	public void buildleftPanel()
	{
		//set up the panel
		leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout());
		
		//function to build part of the left panel
		buildtopLeftPanel();
		
		//add the panel
		leftPanel.add(topLeftPanel, BorderLayout.CENTER);
		//create the button to create the Student object
		btnCreateStudent = new JButton("Create Student");
		btnCreateStudent.addActionListener(new createStudentButtonListener());
		leftPanel.add(btnCreateStudent, BorderLayout.SOUTH);
		
	}
	
	/*Method Name: buildtopLeftPanel
	*Purpose: Build the top part of the left panel
	*Accepts: 
	*Returns: Void
	*/
	public void buildtopLeftPanel()
	{
		//Declares JLabels
		JLabel lblStudentID, lblSurname, lblMiddleName, lblFirstName, lblAptNumber,
		lblStreetNumber, lblStreetName, lblCity, lblProvince, lblPostalCode,
		lblCslLoanAmount, lblOslLoanAmount;
		
		//Instantiate the panel
		topLeftPanel = new JPanel();
		topLeftPanel.setLayout(new GridLayout(12,2,2,5));
			
		//Create Labels and text Field
		lblStudentID = new JLabel("Student ID");
		topLeftPanel.add(lblStudentID);
		txFInputStudentID = new JTextField();
		txFInputStudentID.addKeyListener(new KeyAdapter() {
		//Condition that stops uses from inputing anything but numbers 
			public void keyPressed(KeyEvent k)
       {
          if ((k.getKeyChar() >= '0' && k.getKeyChar() <= '9'))
          	{
          	if(txFInputStudentID.getText().length()>=7)
            	txFInputStudentID.setEditable(false); 
          	else
          		txFInputStudentID.setEditable(true);    
          	}
          else if (k.getKeyCode()== KeyEvent.VK_BACK_SPACE|| k.getKeyCode()== KeyEvent.VK_DELETE)
          	txFInputStudentID.setEditable(true);
          else 
          	txFInputStudentID.setEditable(false);            
       }
		 });
		topLeftPanel.add(txFInputStudentID);
	//Create Labels and text Field
		lblSurname = new JLabel("Surname");
		topLeftPanel.add(lblSurname);
		txFInputSurname= new JTextField();
		topLeftPanel.add(txFInputSurname);
	//Create Labels and text Field
		lblMiddleName = new JLabel("Middle Name");
		topLeftPanel.add(lblMiddleName);
		txFInputMiddleName= new JTextField();
		topLeftPanel.add(txFInputMiddleName); 
	//Create Labels and text Field
		lblFirstName = new JLabel("First Name");
		topLeftPanel.add(lblFirstName);
		txFInputFirstName= new JTextField();
		topLeftPanel.add(txFInputFirstName);
	//Create Labels and text Field
		lblAptNumber= new JLabel("Apt Number");
		topLeftPanel.add(lblAptNumber);
		txFInputAptNumber= new JTextField();
		topLeftPanel.add(txFInputAptNumber);	
	//Create Labels and text Field
		lblStreetNumber = new JLabel("Street Number");
		topLeftPanel.add(lblStreetNumber);
		txFInputStreetNumber= new JTextField();
		topLeftPanel.add(txFInputStreetNumber);
	//Create Labels and text Field
		lblStreetName = new JLabel("Street Name");
		topLeftPanel.add(lblStreetName);
		txFInputStreetName= new JTextField();
		topLeftPanel.add(txFInputStreetName);
	//Create Labels and text Field
		lblCity = new JLabel("City");
		topLeftPanel.add(lblCity);
		txFInputCity= new JTextField();
		topLeftPanel.add(txFInputCity);
	//Create Labels and text Field
		lblProvince= new JLabel("Province");
		topLeftPanel.add(lblProvince);
		txFInputProvince= new JTextField();
		topLeftPanel.add(txFInputProvince);
	//Create Labels and text Field
		lblPostalCode = new JLabel("Postal Code");
		topLeftPanel.add(lblPostalCode);
		txFInputPostalCode= new JTextField();
		topLeftPanel.add(txFInputPostalCode);	
	//Create Labels and text Field
		lblCslLoanAmount = new JLabel("CSL Loan Amount ($)");
		topLeftPanel.add(lblCslLoanAmount);
		txFInputCslLoanAmount= new JTextField("0.0");
		txFInputCslLoanAmount.addKeyListener(new KeyAdapter() {
      //Condition that stops uses from inputing anything but numbers
			public void keyPressed(KeyEvent k)
      {
      	boolean hasDecimal = false; // boolean to register if number already has a decimal point
        if ((k.getKeyChar() >= '0' && k.getKeyChar() <= '9') || k.getKeyChar() == '-'|| k.getKeyCode()== KeyEvent.VK_BACK_SPACE|| k.getKeyCode()== KeyEvent.VK_DELETE)
        	 txFInputCslLoanAmount.setEditable(true);           
         else if(k.getKeyChar() == '.' )
         {
         	String tempString = txFInputCslLoanAmount.getText();
         	for (int i = 0; i < tempString.length(); i++)
 					{
         		if(tempString.charAt(i) == '.')
         			hasDecimal = true;
 					}
         	if(hasDecimal)
         		txFInputCslLoanAmount.setEditable(false);
         	else
         		txFInputCslLoanAmount.setEditable(true);            
         }
         else 
        	 txFInputCslLoanAmount.setEditable(false);            
      }
		 });
		topLeftPanel.add(txFInputCslLoanAmount);
	//Create Labels and text Field
		lblOslLoanAmount = new JLabel("OSL Loan Amount ($)");
		topLeftPanel.add(lblOslLoanAmount);
		txFInputOslLoanAmount= new JTextField("0.0");
		txFInputOslLoanAmount.addKeyListener(new KeyAdapter() {
			//Condition that stops uses from inputing anything but numbers
			public void keyPressed(KeyEvent k)
      {
        boolean hasDecimal = false; // boolean to register if number already has a decimal point
        
      	if ((k.getKeyChar() >= '0' && k.getKeyChar() <= '9') || k.getKeyChar() == '-'|| k.getKeyCode()== KeyEvent.VK_BACK_SPACE|| k.getKeyCode()== KeyEvent.VK_DELETE)
        	 txFInputOslLoanAmount.setEditable(true);
        else if(k.getKeyChar() == '.' )
        {
        	String tempString = txFInputOslLoanAmount.getText();
        	for (int i = 0; i < tempString.length(); i++)
					{
        		if(tempString.charAt(i) == '.')
        			hasDecimal = true;
					}
        	if(hasDecimal)
        		txFInputOslLoanAmount.setEditable(false);
        	else
        		txFInputOslLoanAmount.setEditable(true);            
        }
        else 
        	 txFInputOslLoanAmount.setEditable(false);            
      }
		 });
		topLeftPanel.add(txFInputOslLoanAmount);
		
	}
	/*Method Name: buildCenterPanel
	*Purpose: Build the center panel
	*Accepts: 
	*Returns: Void
	*/
	public void buildCenterPanel()
	{
	//set up the panel
		centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		
	//function to build part of the left panel
		buildtopCenterPanel();
	//add the panel
		centerPanel.add(topCenterPanel, BorderLayout.CENTER);
		//Panel for the buttons to cycle the students
		bottomCenterPanel = new JPanel();
		bottomCenterPanel.setLayout(new GridLayout(1,2));
	//create the button to cycle the Student object
		btnPreviousStudent = new JButton("Previous Student");
		btnPreviousStudent.addActionListener(new populateStudentButtonListener());
		bottomCenterPanel.add(btnPreviousStudent);
		btnNextStudent = new JButton("Next Student");
		btnNextStudent.addActionListener(new populateStudentButtonListener());
		bottomCenterPanel.add(btnNextStudent);
		
		centerPanel.add(bottomCenterPanel, BorderLayout.SOUTH);
		
	}
	/*Method Name: buildtopCenterPanel
	*Purpose: Build the top part of the Center panel
	*Accepts: 
	*Returns: Void
	*/
	public void buildtopCenterPanel()
	{
	//Declares JLabels
		JLabel lblStudentID, lblSurname, lblMiddleName, lblFirstName, lblAptNumber,
		lblStreetNumber, lblStreetName, lblCity, lblProvince, lblPostalCode,
		lblCslLoanAmount, lblOslLoanAmount;
	//Instantiate the panel
		topCenterPanel = new JPanel();
		topCenterPanel.setLayout(new GridLayout(12,2,2,5));
	//Create Labels and text Field
		lblStudentID = new JLabel("Student ID");
		topCenterPanel.add(lblStudentID);
		txFOutputStudentID = new JTextField();
		txFOutputStudentID.setEditable(false);
		topCenterPanel.add(txFOutputStudentID);
		
		lblSurname = new JLabel("Surname");
		topCenterPanel.add(lblSurname);
		txFOutputSurname= new JTextField();
		txFOutputSurname.setEditable(false);
		topCenterPanel.add(txFOutputSurname);
		
		lblMiddleName = new JLabel("Middle Name");
		topCenterPanel.add(lblMiddleName);
		txFOutputMiddleName= new JTextField();
		txFOutputMiddleName.setEditable(false);
		topCenterPanel.add(txFOutputMiddleName); 

		lblFirstName = new JLabel("First Name");
		topCenterPanel.add(lblFirstName);
		txFOutputFirstName= new JTextField();
		txFOutputFirstName.setEditable(false);
		topCenterPanel.add(txFOutputFirstName);

		lblAptNumber= new JLabel("Apt Number");
		topCenterPanel.add(lblAptNumber);
		txFOutputAptNumber= new JTextField();
		txFOutputAptNumber.setEditable(false);
		topCenterPanel.add(txFOutputAptNumber);	

		lblStreetNumber = new JLabel("Street Number");
		topCenterPanel.add(lblStreetNumber);
		txFOutputStreetNumber= new JTextField();
		txFOutputStreetNumber.setEditable(false);
		topCenterPanel.add(txFOutputStreetNumber);

		lblStreetName = new JLabel("Street Name");
		topCenterPanel.add(lblStreetName);
		txFOutputStreetName= new JTextField();
		txFOutputStreetName.setEditable(false);
		topCenterPanel.add(txFOutputStreetName);

		lblCity = new JLabel("City");
		topCenterPanel.add(lblCity);
		txFOutputCity= new JTextField();
		txFOutputCity.setEditable(false);
		topCenterPanel.add(txFOutputCity);

		lblProvince= new JLabel("Province");
		topCenterPanel.add(lblProvince);
		txFOutputProvince= new JTextField();
		txFOutputProvince.setEditable(false);
		topCenterPanel.add(txFOutputProvince);

		lblPostalCode = new JLabel("Postal Code");
		topCenterPanel.add(lblPostalCode);
		txFOutputPostalCode= new JTextField();
		txFOutputPostalCode.setEditable(false);
		topCenterPanel.add(txFOutputPostalCode);	

		lblCslLoanAmount = new JLabel("CSL Loan Amount ");
		topCenterPanel.add(lblCslLoanAmount);
		txFOutputCslLoanAmount= new JTextField("0.0");
		txFOutputCslLoanAmount.setEditable(false);
		topCenterPanel.add(txFOutputCslLoanAmount);

		lblOslLoanAmount = new JLabel("OSL Loan Amount ");
		topCenterPanel.add(lblOslLoanAmount);
		txFOutputOslLoanAmount= new JTextField("0.0");
		txFOutputOslLoanAmount.setEditable(false);
		topCenterPanel.add(txFOutputOslLoanAmount);
		
	}
	
	/*Method Name: buildRightPanel
	*Purpose: Build the Right panel
	*Accepts: 
	*Returns: Void
	*/
	public void buildRightPanel()
	{
		//Instantiate the panel and set the layout
		mainRightPanel = new JPanel();
		mainRightPanel.setLayout(new BorderLayout());
		//function to build panel of the top part 
		buildTopRightPanel();
		mainRightPanel.add(rightPanel, BorderLayout.CENTER);
		
		//add button that call the function for the calculation
		btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new CalculateButtonListener());
		mainRightPanel.add(btnCalculate, BorderLayout.SOUTH);
	}
	/*Method Name: buildTopRightPanel
	*Purpose: Build the top part of the right panel
	*Accepts: 
	*Returns: Void
	*/
	
	public void buildTopRightPanel()
	{
		//declares the labels
		JLabel lblCslPrime, lblOslPrime, lbAmortizationPeriod, lbCslMonthlyPayments, lbOslMonthlyPayments, 
					 lbTotalMonthlyPayments, lbTotalWithInterest, lbOriginalBorrowed, lbTotalInterest ;
		//Instantiate the panel and set the layout
		rightPanel = new JPanel();
		rightPanel.setLayout(new GridLayout(12,2));
		
	//Create Labels and text Field
		lblCslPrime = new JLabel("CSL Prime (%)");
		rightPanel.add(lblCslPrime);
		//Creates panel to hold text field and buttons
		buildPrimePanel1();
		rightPanel.add(primePanel1);
	//Create Labels and text Field
		lblOslPrime= new JLabel("OSL Prime (%)");
		rightPanel.add(lblOslPrime);
		//Creates panel to hold text field and buttons
		buildPrimePanel2();
		rightPanel.add(primePanel2);
	//Create Labels and text Field
		lbAmortizationPeriod = new JLabel("Amortization Period");
		rightPanel.add(lbAmortizationPeriod);
		txFAmortizationPeriod = new JTextField("40");
		txFAmortizationPeriod.addKeyListener(new KeyAdapter() {
      public void keyPressed(KeyEvent k)//Condition that stops uses from inputing anything but numbers
      {
         if ((k.getKeyChar() >= '0' && k.getKeyChar() <= '9')|| k.getKeyChar() == '.' || k.getKeyCode()== KeyEvent.VK_BACK_SPACE|| k.getKeyCode()== KeyEvent.VK_DELETE)
        	 txFAmortizationPeriod.setEditable(true);           
         else 
        	 txFAmortizationPeriod.setEditable(false);            
      }
		 });
		rightPanel.add(txFAmortizationPeriod);
		//Create Labels and text Field
		lbCslMonthlyPayments = new JLabel("Csl Monthly Payments");
		rightPanel.add(lbCslMonthlyPayments);
		txFCslMonthlyPayments = new JTextField();
		txFCslMonthlyPayments.setEditable(false);
		rightPanel.add(txFCslMonthlyPayments);
		//Create Labels and text Field
		lbOslMonthlyPayments= new JLabel("Osl Monthly Payments");
		rightPanel.add(lbOslMonthlyPayments);
		txFOslMonthlyPayments = new JTextField();
		txFOslMonthlyPayments.setEditable(false);
		rightPanel.add(txFOslMonthlyPayments);
		//Create Labels and text Field
		lbTotalMonthlyPayments= new JLabel("Total Monthly Payments");
		rightPanel.add(lbTotalMonthlyPayments);
		txFTotalMonthlyPayments = new JTextField();
		txFTotalMonthlyPayments.setEditable(false);
		rightPanel.add(txFTotalMonthlyPayments);
		//Create Labels and text Field
		lbTotalWithInterest= new JLabel("Total With Interest");
		rightPanel.add(lbTotalWithInterest);
		txFTotalWithInterest = new JTextField();
		txFTotalWithInterest.setEditable(false);
		rightPanel.add(txFTotalWithInterest);
		//Create Labels and text Field
		lbOriginalBorrowed= new JLabel("Original Borrowed");
		rightPanel.add(lbOriginalBorrowed);
		txFOriginalBorrowed = new JTextField();
		txFOriginalBorrowed.setEditable(false);
		rightPanel.add(txFOriginalBorrowed);
		//Create Labels and text Field
		lbTotalInterest= new JLabel("Total Interest");
		rightPanel.add(lbTotalInterest);
		txFTotalInterest = new JTextField();
		txFTotalInterest.setEditable(false);
		rightPanel.add(txFTotalInterest);
						
		
	}
	
	
	/*Method Name: buildPrimePanel1
	*Purpose: Build the small panel to hold the text field and buttons for the prime rates
	*Accepts: 
	*Returns: Void
	*/
	public void buildPrimePanel1()
	{
		//Creates the Text fields and buttons and add the listener
 		primePanel1 = new JPanel();
		primePanel1.setLayout(new GridLayout(1,3));
		btnIncrPrime1 = new JButton("+");
		btnIncrPrime1.addActionListener(new changePrime1ButtonListener());
		btnDecrPrime1 = new JButton("-");
		btnDecrPrime1.addActionListener(new changePrime1ButtonListener());
		txFPrime1 = new JTextField("4.5");
		txFPrime1.setEditable(false);
		primePanel1.add(btnDecrPrime1);
		primePanel1.add(txFPrime1);
		primePanel1.add(btnIncrPrime1);		
		
	}
	/*Method Name: buildPrimePanel2
	*Purpose: Build the small panel to hold the text field and buttons for the prime rates
	*Accepts: 
	*Returns: Void
	*/
	public void buildPrimePanel2()
	{
	//Creates the Text fields and buttons and add the listener
		primePanel2 = new JPanel();
		primePanel2.setLayout(new GridLayout(1,3));
		btnIncrPrime2 = new JButton("+");
		btnIncrPrime2.addActionListener(new changePrime2ButtonListener());
		btnDecrPrime2 = new JButton("-");
		btnDecrPrime2.addActionListener(new changePrime2ButtonListener());
		txFPrime2 = new JTextField("4.5");
		txFPrime2.setEditable(false);
		primePanel2.add(btnDecrPrime2);
		primePanel2.add(txFPrime2);
		primePanel2.add(btnIncrPrime2);		
	}
	
	
	/*Inner Class Name: createStudentButtonListener
	*Purpose: Takes the text from the text fields and creates a new Student object	
	*/
	private class createStudentButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			 double tempCSL = 0;
			 double tempOSL = 0;		
			//try catch block for catching problems when converting the text numbers to double
			 try
			{
				tempCSL = Double.parseDouble(txFInputCslLoanAmount.getText());
				tempOSL = Double.parseDouble(txFInputOslLoanAmount.getText());
				//Throws custom exception if any value is negative
				if(tempCSL<0)
				{
					 throw new V_V_A_NegativeValueException("CSL Loan Amount");					 					 			 
				}
				if(tempOSL<0)
				{
					 throw new V_V_A_NegativeValueException("CSL Loan Amount");					 
				}
			}
			 //handles the exception
			catch(Exception error)
			{
				tempCSL = Math.abs(tempCSL);
				tempOSL = Math.abs(tempOSL);
				JOptionPane.showMessageDialog(null, error.getMessage()+"\nThe value was converted to a positive value",
						"Input Error", JOptionPane.OK_OPTION);
			}
			//Creates the student object
			Student newStudent = new Student(txFInputStudentID.getText(), txFInputSurname.getText() , txFInputMiddleName.getText(),
					txFInputFirstName.getText(), txFInputAptNumber.getText(), txFInputStreetNumber.getText(),
					txFInputStreetName.getText(), txFInputCity.getText(), txFInputProvince.getText(),  
					txFInputPostalCode.getText(), round(tempCSL), round(tempOSL));
			//add new student to the list		
			studentList.add(newStudent);
			
			//if this is the first object in the list, call method to populate the form with the new student object
			if (emptyList)
			{
				emptyList = false;
				populateStudent();
			}
		}		
	}
	
	/*Inner Class Name: populateStudentButtonListener
	*Purpose: Adjust the index and populates  the form with the data from the list of Student objects	
	*/
	private class populateStudentButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//Checks if the list is not empty
			if(studentList.size()>0)
			{
				String input = e.getActionCommand();//get the reference for what button was pressed
				//if its the previous Student button
				if (input.equals("Previous Student"))
				{
					//adjust the index
					if (index > 0)
						index--;
					else//if its already the first entry, goes to the last one
						index = studentList.size()-1;
				}
			//if its the next Student button
				else
				{
				//adjust the index
					if (index < (studentList.size()-1))
						index++;
					else//if its already the last entry, goes to the first one
						index = 0;
				}
				//call method that populates the form
				populateStudent();
				
			}
			else// if the list is empty
			{
				System.out.println("no data");
			}
			
		}		
	}
	
	/*Inner Class Name: CalculateButtonListener
	*Purpose: Makes the Loan calculations	
	*/
	private class CalculateButtonListener implements ActionListener 
	{

		public void actionPerformed(ActionEvent e)
		{
			//takes data from the text fields
			double principalAmountCsl = studentList.get(index).getCslLoanAmount();
			double principalAmountOsl= studentList.get(index).getOslLoanAmount();
			double annualPrimeInterestRateCsl = Double.parseDouble(txFPrime1.getText());
			double annualPrimeInterestRateOsl = Double.parseDouble(txFPrime2.getText());
			int amortizationPeriodMonths = Integer.parseInt(txFAmortizationPeriod.getText()); 
			//Calls method to run calculations
			double montlyCsl = calculateLoanPayment(principalAmountCsl, annualPrimeInterestRateCsl+2.5, amortizationPeriodMonths);
			double montlyOsl = calculateLoanPayment(principalAmountOsl, annualPrimeInterestRateOsl+1.0, amortizationPeriodMonths);
			//Makes the calculations and  display results in text Fields
			txFCslMonthlyPayments.setText(String.format("$%.2f",montlyCsl));
			txFOslMonthlyPayments.setText(String.format("$%.2f",montlyOsl));
			txFTotalMonthlyPayments.setText(String.format("$%.2f",(montlyOsl + montlyCsl)));
			txFTotalWithInterest.setText(String.format("$%.2f",(montlyOsl + montlyCsl)*amortizationPeriodMonths));
			txFOriginalBorrowed.setText(String.format("$%.2f", principalAmountCsl+principalAmountOsl));
			txFTotalInterest.setText(String.format("$%.2f", ((montlyOsl + montlyCsl)*amortizationPeriodMonths)-(principalAmountCsl+principalAmountOsl) ));
			
		}
		
	}
	/*Method Name: populateStudent
	*Purpose: Populates the from with data from the list of objects
	*Accepts: 
	*Returns: Void
	*/
	public void populateStudent()
	{
		txFOutputStudentID.setText(studentList.get(index).getStudentID());
		txFOutputSurname.setText(studentList.get(index).getSurname());
		txFOutputMiddleName.setText(studentList.get(index).getMiddleName());
		txFOutputFirstName.setText(studentList.get(index).getFirstName());
		txFOutputAptNumber.setText(studentList.get(index).getAptNumber());
		txFOutputStreetNumber.setText(studentList.get(index).getStreetNumber());
		txFOutputStreetName.setText(studentList.get(index).getStreetName());
		txFOutputCity.setText(studentList.get(index).getCity()); 
		txFOutputProvince.setText(studentList.get(index).getProvince());
		txFOutputPostalCode.setText(studentList.get(index).getPostalCode());
		txFOutputCslLoanAmount.setText(String.format("$%.2f",studentList.get(index).getCslLoanAmount()));
		txFOutputOslLoanAmount.setText(String.format("$%.2f",studentList.get(index).getOslLoanAmount()));
		
	}
	
	/*Inner Class Name: changePrime1ButtonListener
	*Purpose: increase of decrease the Prime interest value
	*/
	private class changePrime1ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String input = e.getActionCommand();
			double tempDouble =  Double.parseDouble(txFPrime1.getText());
			//Finds if the button is for increase or decrease, changes the value and set on the text field
			if (input.equals("+"))
			{
				tempDouble += 0.25;
				txFPrime1.setText(Double.toString(tempDouble));
			}				
			else
			{
				if(tempDouble>=0.25)
				{
					tempDouble -= 0.25;
					txFPrime1.setText(Double.toString(tempDouble));
				}				
			}
		}
	}
	
	/*Inner Class Name: changePrime2ButtonListener
	*Purpose: increase of decrease the Prime interest value
	*/
	private class changePrime2ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			String input = e.getActionCommand();
			double tempDouble =  Double.parseDouble(txFPrime2.getText());
			if (input.equals("+"))
			{
				tempDouble += 0.25;
				txFPrime2.setText(Double.toString(tempDouble));
			}				
			else
			{
				if(tempDouble>=0.25)
				{
					tempDouble -= 0.25;
					txFPrime2.setText(Double.toString(tempDouble));
				}				
			}
		}
	}
	
	/*Method Name: calculateLoanPayment
	*Purpose: Calculates the montly loan payments
	*Accepts: double, double, int
	*Returns: double
	*/
	public double calculateLoanPayment(double principalAmount, double annualPrimeInterestRate,
			int amortizationPeriodMonths)
	{
		//Converts from annual to monthly
		double monthlyInterestRate = annualPrimeInterestRate*ANNUAL_RATE_TO_MONTHLY_RATE;
		//Makes the calculations
		double montlyPayment = (principalAmount*monthlyInterestRate*Math.pow(1+monthlyInterestRate, amortizationPeriodMonths))/
													 (Math.pow(1+monthlyInterestRate, amortizationPeriodMonths)-1);
		//returns the rounded result
		return round(montlyPayment);
	}
	
	/*Method Name: round
	*Purpose: Rounds the number to 2 decimal places
	*Accepts: double
	*Returns: double
	*/
	public double round(double input)
	{		
		return ((int)((input*100)+.5))/100.0;
	}
	
	//Main method for testing the frame
	public static void main(String[] args)
	{
		StudentLoanApp frame = new StudentLoanApp();
		if (frame != null);
	}


}
