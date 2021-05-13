package com.cognixia.jumplus.project3.anorthouse.utility;

//TODO - JavaDoc description
public class InputParserUtil {

	//TODO - JavaDoc description
	public static int parseInt(String rawInput, String inputName) throws Exception {
		String tempString = rawInput;
		int tempInt = 0;
		
		try {
			//attempts to parse input
			tempString = tempString.trim();
			tempInt = Integer.parseInt(tempString);

			//then checks for non-negative
			if (tempInt < 0) {
				throw new Exception("The " + inputName + " can't be negative!");
			}
		//throws generic exception to allow for caller to handle issue
		} catch (NumberFormatException e) {
			throw new Exception("The " + inputName + " can't empty!");
		}catch (Exception e) {
			throw e;
		}
		
		//returns parsed input
		return tempInt;
	}


	//TODO - JavaDoc description
	public static double parseDouble(String rawInput, String inputName) throws Exception {
		String tempString = rawInput;
		double tempDouble = 0.00;
		
		try {
			//attempts to parse input
			tempString = tempString.trim();
			tempDouble = Double.parseDouble(tempString);

			//then checks for non=negative
			if (tempDouble < 0.00) {
				throw new Exception("The " + inputName + " can't be negative!");
			}
		//throws generic exception to allow for caller to handle issue
		} catch (NumberFormatException e) {
			throw new Exception("The " + inputName + " can't empty!");
		}catch (Exception e) {
			throw e;
		}
		
		//returns parsed input
		return tempDouble;
	}


	//TODO - JavaDoc description
	public static String parseString(String rawInput, String inputName) throws Exception {
		String tempString = rawInput;
		
		try {
			//attempts to parse input
			tempString = tempString.trim();
			
			//checks for empty string
			if (tempString.equals("")) {
				throw new Exception("Your " + inputName + " is empty!");
			}
		//throws generic exception to allow for caller to handle issue
		} catch (Exception e) {
			throw e;
		}
		
		//returns parsed input
		return tempString;
	}
	

	//TODO - JavaDoc description
	public static String parseUsername(String rawInput, String inputName) throws Exception {
		rawInput = parseString(rawInput, inputName);
		return rawInput.toLowerCase();
	}
	
}
