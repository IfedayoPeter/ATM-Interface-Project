package com.project.ATM;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Menu extends Account {
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.0");
	HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

	public void getLogin() throws IOException {
		int x = 1;
		do {
			try {
				data.put(22024, 5140);
				data.put(22023, 5141);
				System.out.println("Welcome to ATM project");
				System.out.println("Enter customer number");
				setCustomerNumber(menuInput.nextInt());
				System.out.println("Enter pin number");
				setPinNumber(menuInput.nextInt());

			} catch (Exception e) {
				System.out.println("Invalid credentials" + "\n");
				x = 2;
			}
			for (Entry<Integer, Integer> entry : data.entrySet()) {
				if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
					getAccountType();
				}
			}
			System.out.println("Invalid Customer ID" + "\n");
		} while (x == 1);
	}

	int selection;

	// display account type menu
	public void getAccountType() throws IOException {
		System.out.println("select your account type");
		System.out.println("Type 1: Checking Account");
		System.out.println("Type 2: Savings Account");
		System.out.println("Type 3: Exit!");
		System.out.println("Choice:");
		selection = menuInput.nextInt();
		switch (selection) {
		case 1:
			getChecking();
			break;
		case 2:
			getSavings();
			break;
		case 3:
			System.out.println("Thank you for using this ATM");
			getLogin();
			break;
		default:
			System.out.println("Invalid choice" + "\n");
			getAccountType();
		}
	}

	// display checking account menu with selection
	public void getChecking() throws IOException {
		System.out.println("Checking Account");
		System.out.println("Type 1: Check account balance");
		System.out.println("Type 2: Withdraw funds");
		System.out.println("Type 3: Deposit Funds");
		System.out.println("Type 4: Exit");
		System.out.println("Type 5: Choice");
		selection = menuInput.nextInt();
		switch (selection) {
		case 1:
			System.out.println("Account balance: " + moneyFormat.format(getCheckingBalance()));
			getChecking();
			break;
		case 2:
			getCheckingWithdrawalInput();
			getChecking();
			break;
		case 3:
			getCheckingDepositInput();
			getChecking();
			break;
		case 4:
			System.out.println("Thank you");
			getAccountType();
			break;
		default:
			System.out.println("Invalid choice" + "\n");
			getChecking();
		}
	}

	// display savings account menu with selection
	public void getSavings() throws IOException {
		System.out.println("Savings Account");
		System.out.println("Type 1: Check account balance");
		System.out.println("Type 2: Withdraw funds");
		System.out.println("Type 3: Deposit Funds");
		System.out.println("Type 4: Exit");
		System.out.println("Type 5: Choice");
		selection = menuInput.nextInt();
		switch (selection) {
		case 1:
			System.out.println("Account balance: " + moneyFormat.format(getSavingsBalance()));
			getSavings();
			break;
		case 2:
			getCheckingWithdrawalInput();
			getSavings();
			break;
		case 3:
			getCheckingDepositInput();
			getSavings();
			break;
		case 4:
			System.out.println("Thank you");
			getAccountType();
			break;
		default:
			System.out.println("Invalid choice" + "\n");
			getSavings();
		}
	}
}
