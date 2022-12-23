package com.project.ATM;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	private int customerNumber;
	private int pinNumber;
	private double checkingBalance;
	private double savingsBalance;

	// set customerNumber
	public int setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
		return customerNumber;
	}

	public int setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
		return pinNumber;
	}

	public int getCustomerNumber() {
		return customerNumber;
	}

	public int getPinNumber() {
		return pinNumber;
	}

	public double getCheckingBalance() {
		return checkingBalance;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	// calculate checking account withdaraw
	public double calCheckingWithdrawal(double amount) {
		checkingBalance = (checkingBalance - amount);
		return checkingBalance;
	}

	// calculate savings account withdraw
	public double calSavingsWithdrawal(double amount) {
		savingsBalance = (savingsBalance - amount);
		return savingsBalance;
	}

	// calculate checking account deposit
	public double calCheckingDeposit(double amount) {
		checkingBalance = (checkingBalance + amount);
		return checkingBalance;
	}

	// calculate savings account deposit
	public double calSavingsDeposit(double amount) {
		savingsBalance = (savingsBalance + amount);
		return savingsBalance;
	}

	// customer checking account withdrawal input
	public void getCheckingWithdrawalInput() {
		System.out.println("Checking account balance :" + moneyFormat.format(checkingBalance));
		System.out.println("Input withdrawal amount");
		double amount = input.nextDouble();
		if ((checkingBalance - amount) >= 0) {
			calCheckingWithdrawal(amount);
			System.out.println("New Checking account balance :" + moneyFormat.format(checkingBalance));
		} else {
			System.out.println("Insufficient funds" + "\n");
		}
	}

	// customer savings account withdrawal input
	public void getSavingsWithdrawalInput() {
		System.out.println("Savings account balance :" + moneyFormat.format(savingsBalance));
		System.out.println("Input withdrawal amount");
		double amount = input.nextDouble();
		if ((savingsBalance - amount) >= 0) {
			calSavingsWithdrawal(amount);
			System.out.println("New Savings account balance :" + moneyFormat.format(savingsBalance));
		} else {
			System.out.println("Insufficient funds" + "\n");
		}
	}

	// customer checking account deposit input
	public void getCheckingDepositInput() {
		System.out.println("Checking account balance :" + moneyFormat.format(checkingBalance));
		System.out.println("Input deposit amount");
		double amount = input.nextDouble();
		if ((checkingBalance + amount) >= 0) {
			calCheckingDeposit(amount);
			System.out.println("New Checking account balance :" + moneyFormat.format(checkingBalance));
		} else {
			System.out.println("Insufficient funds" + "\n");
		}
	}

	// customer savings account deposit input
	public void getSavingsDepositInput() {
		System.out.println("Savings account balance :" + moneyFormat.format(savingsBalance));
		System.out.println("Input deposit amount");
		double amount = input.nextDouble();
		if ((savingsBalance + amount) >= 0) {
			calSavingsDeposit(amount);
			System.out.println("New Savings account balance :" + moneyFormat.format(savingsBalance));
		} else {
			System.out.println("Insufficient funds" + "\n");
		}
	}

}
