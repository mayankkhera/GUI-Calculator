package calculator;

/**
 * File Name:       CalculatorModel.java
 * Author:          Mayank Khera
 * Student ID:		040912734
 * Course:          CST8221 - JavaApplicationProgramming
 * Lab Section: 	311
 * Assignment:      1, Part 2
 * Date:            November 2, 2019
 * Professor:       Daniel Cormier
 * Purpose:         This class is responsible for all the calculations done by the calculator
 * Class list:      Calculator                 
 */

/**
 * This class is responsible for all the calculations done by the program
 * 
 * @author Mayank Khera
 * @version 1
 * @see calculator
 * @since 1.8.0_121
 */
public class CalculatorModel {
	/**String variable for first operand*/
	private String operand1;
	/**String variable for second operand*/
	private String operand2;
	/**String variable to store arithemtic operation*/
	private String aOperation;
	/**String variable to store operational mode*/
	private String oMode;
	/**String variable for float-point precision*/
	private String fpp;
	
	
	public CalculatorModel() {
		operand1 = "";
		operand2 = "";
		aOperation = "";
		oMode = "Float";
		fpp = ".00";
		
	}
	
	/**
	 * Setter for first operand
	 * @return N/A
	 * @param operand1
	 */
	public void setOperand1(String operand1) {
		this.operand1 = operand1;
	}
	
	/**
	 * Setter for second operand
	 * @return N/A
	 * @param operand2
	 */
	public void setOperand2(String operand2) {
		this.operand2 = operand2;
	}
	
	/**
	 * Setter for arithmetic operation
	 * @return N/A 
	 * @param aOperation
	 */
	public void setAOperation(String aOperation) {
		this.aOperation = aOperation;
	}
	
	/**
	 * Setter for operational mode
	 * @return N/A
	 * @param oMode
	 */
	public void setOMode(String oMode) {
		this.oMode = oMode;
	}
	
	/**
	 * Setter for Float-point precision
	 * @return N/A
	 * @param fpp
	 */
	public void setFpp(String fpp) {
		this.fpp = fpp;
	}
	
	/**
	 * This method return the String result from calculate() method based on the oMode and fpp
	 * @return String result from private method calculate()
	 * @param N/A
	 */
	public String getResult() {
		return calculate();
	}
	
	/**boolean to store error state*/
	private boolean eState = false;
	
	/**
	 * Setter for error state
	 * @return void
	 * @param eState
	 */
	public void setEState(boolean eState) {
		this.eState = eState;
	}
	
	/**
	 * Getter for error state
	 * @return eState
	 * @param N/A
	 */
	public boolean getEState() {
		return eState;
	}
	
	/**
	 * this program calculates the result based on oMode and then converts them back into string based on fpp
	 * @return a result converted into formated into a string based on the fpp
	 * @param N/A
	 */
	private String calculate() {
		String retVal = "";
		
		if(oMode.equals("Float")) {
			float op1 = Float.parseFloat(operand1);
			float op2 = Float.parseFloat(operand2);
			float result = 0;
			
			switch(aOperation) {
			case "+":
				result = op1 + op2;
				break;
			case "-":
				result = op1 - op2;
				break;
			case "*":
				result = op1 * op2;
				break;
			case "/":
				if(op2 == 0) {
					setEState(true);
					if(op1 == 0)
						return "NAN";
					else
						return "Division by zero";
				}
				result = op1 / op2;
				break;
			default:
				System.err.println("Check first swtich calculate()");
				break;
			}
			
			switch(fpp) {
			case ".00":
				retVal = String.format("%.2f", result);
				break;
			case ".0":
				retVal = String.format("%.1f", result);
				break;
			default:
				retVal = String.format("%E", result);
			}
			
		}else {
			long op1 = Long.parseLong(operand1, 16);
			long op2 = Long.parseLong(operand2, 16);
			long result = 0;
			
			switch(aOperation) {
			case "+":
				result = op1 + op2;
				break;
			case "-":
				result = op1 - op2;
				break;
			case "*":
				result = op1 * op2;
				break;
			case "/":
				if(op2 == 0) {
					setEState(true);
					if(op1 == 0)
						return "NAN";
					else
						return "Divsion by zero";
				}
				result = op1 / op2;
				break;
			default:
				System.err.println("Check second switch calculate()");
				break;
			}
			
			retVal = String.format("%X", result);
			
		}
		
		return retVal;
	}
}
