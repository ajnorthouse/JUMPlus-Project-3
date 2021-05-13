package com.cognixia.jumplus.project3.anorthouse.controller;

import java.util.ArrayList;

import com.cognixia.jumplus.project3.anorthouse.model.User;

//TODO - JavaDoc description
public class DollarsBankController {
	
	static ArrayList<User> users = new ArrayList<User>();
	private static UserController uController = new UserController();
	
	//TODO - JavaDoc description
	public static User attemptLogin(String userId, String password) {
		
		//for loop to iterate over all users
		//	- not enhanced because users can be empty at this point
		for (int counter = 0; counter < users.size(); counter++) {
			var tempUser = users.get(counter);
			
			//checks for matching userId
			if (uController.getUsername(tempUser).equals(userId)) {
				
				//then checks if the passwords are equal
				if (tempUser.getPassword().equals(password)) {
					return tempUser;
				}
				
				//this breaks the loop, as a matching userId was found
				return null;
			}
		}
		return null;
	}
	
	//TODO - JavaDoc description
	public static String createUser(String username, String password, String name, String contactNumber, double balance) throws Exception {
		
		//first checks for any matching userId
		for (int counter = 0; counter < users.size(); counter++) {
			if (uController.getUsername(users.get(counter)).equals(username)) {
				throw new Exception("That username already exists!");
			}
		}
		
		//then just creates the user
		var newUser = new User(username, password, name, contactNumber, balance);
		uController.updateLog(newUser, "Created Account with initial balance of: $" + balance + ".");
		users.add(newUser);
		
		return username;
	}
	
	//TODO - JavaDoc description
	public static void addDeposit(User currentUser, double userInput) {
		var oldBalance = uController.getBalance(currentUser);
		uController.setBalance(currentUser, oldBalance + userInput);
		var newBalance = uController.getBalance(currentUser);
		
		//update log
		String message = "Deposited $" + userInput + " to bring Balance to: $" + newBalance + ".";
		uController.updateLog(currentUser, message);
	}
	
	//TODO - JavaDoc description
	public static void subtractWithdrawal(User currentUser, double userInput) throws Exception {
		var oldBalance = uController.getBalance(currentUser);
		
		//checks if the account has enough funds
		if (oldBalance < userInput) {
			throw new Exception("Not enough funds!");
		}
		
		//subtracts withdrawal
		uController.setBalance(currentUser, oldBalance - userInput);
		var newBalance = uController.getBalance(currentUser);
		
		//update log
		String message = "Withdrew $" + userInput + " to bring Balance to: $" + newBalance + ".";
		uController.updateLog(currentUser, message);
	}
	
	//TODO - JavaDoc description
	public static void attemptTransfer(User currentUser, String transferUserId, double amount) throws Exception {
		//temp user for the transfer
		User tempUser = null;
		
		//checks if the user is attempting to transfer funds to themselves
		if (uController.getUsername(currentUser).equals(transferUserId)) {
			throw new Exception("Can't transfer to yourself!");
		}
		
		//then checks for any matching userId
		for (int counter = 0; counter < users.size(); counter++) {
			
			//stops loop if a matching userId is found
			if (uController.getUsername(users.get(counter)).equals(transferUserId)) {
				tempUser = users.get(counter);
				break;
			}
			
			//returns false if no matching userIds were found
			if (counter - 1 == users.size()) {
				throw new Exception("Username not found!");
			}
		}
		
		//subtracts withdrawal and then adds deposit
		transferWithdrawal(currentUser, uController.getUsername(tempUser), amount);
		transferDeposit(tempUser, uController.getUsername(currentUser), amount);
	}
	//TODO - JavaDoc description
	public static void transferDeposit(User user, String transferUserId, double userInput) {
		var oldBalance = uController.getBalance(user);
		uController.setBalance(user, oldBalance + userInput);
		var newBalance = uController.getBalance(user);
		
		//update log
		String message = "Received $" + userInput + " from " + transferUserId + ", Balance now: $" + newBalance + ".";
		uController.updateLog(user, message);
	}
	//TODO - JavaDoc description
	public static void transferWithdrawal(User user, String transferUserId, double userInput) throws Exception {
		var oldBalance = uController.getBalance(user);
		
		//checks if the account has enough funds
		if (oldBalance < userInput) {
			throw new Exception("Not enough funds!");
		}
		
		//subtracts withdrawal
		uController.setBalance(user, oldBalance - userInput);
		var newBalance = uController.getBalance(user);
		
		//update log
		String message = "Transfered $" + userInput + " to " + transferUserId + ", Balance now: $" + newBalance + ".";
		uController.updateLog(user, message);
	}
	
}
