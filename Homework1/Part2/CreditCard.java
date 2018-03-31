package Homework1.Part2;
/*  CSE 214 Fall 2017, Professor Shebuti Rayana
 *  Ivan Tinov
 *  ID# 110255332
 *  Homework 1
 */

/* CreditCard class and its methods */
public class CreditCard {

	// variables
	private String creditCardNumber;
	private String cardHolderName;
	private String bank;
	private int limit;
	private double balance;
	// added custom date variable 
	private int date;
	
	/* Constructor that has parameters creditCardNumber, cardHolderName, bank as strings, limit as int, and balance as double */
	public CreditCard(String creditCardNumber, String cardHolderName, String bank, int limit, double balance) {
		this.creditCardNumber = creditCardNumber;
		this.cardHolderName = cardHolderName;
		this.bank = bank;
		this.limit = limit;
		this.balance = balance;		
	}
	
	/* Accessor Methods */
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	
	public String getCardHolderName() {
		return cardHolderName;
	}
	
	public String getBank() {
		return bank;
	}
	
	public int getLimit() {
		return limit;
	}
	
	public double getBalance() {
		return balance;
	}
	
	/* modified toString method */
	public String toString() {
		return "CreditCard [creditCardNumber = " + creditCardNumber + ", cardHolderName = " + cardHolderName + ", bank = "
				+ bank + ", limit = " + limit + ", balance = " + balance + "]";
	}
	
	/* setDate method to allow you to set a date value for the month between 0 and 31 */
	public void setDate(int date) {
		if(date > 0 && date < 31) {
			this.date = date;
		} else {
			System.out.println("Invalid input for date.");
		}
	}
	
	/* getDate method that returns the date */
	public int getDate() {
		return date;
	}

	
	
	/* Added homework methods */
	
	/* This method below takes price as argument and returns whether transaction was successful or not. If the
	   purchase makes the balance exceed the limit, transaction should fail. 
	*/
	public boolean chargeIt(int price) {
		if (balance > price) {
			this.balance -= price;
			System.out.println("Your balanace now is: " + balance);
			return true;
		} else {
			System.out.println("Not enough money in bank to to make the transaction of $ " + price + ". "
					+ "Your balance is: " + balance);
			return false;
		}
	}

	/* payment method which is called when a cardholder makes a payment*/
	// added date parameter to indicate when the payment was made
	public void payment(int amount, int date) {
		if(date > 0 && date < 31) {
			if(lateFee(date) == true) {
				if(amount > 0) {
				this.balance += amount;
				this.balance -= 50; // late fee = $50
				}
			} else {
				this.balance += amount;
			}
		} else {
			System.out.println("Invalid input for date.");
		}
	}
	
	/* lateFee method that adds a fee if payment is done after 15th of every month */
	public static boolean lateFee(int date) {
		if(date > 15) {
			System.out.println("Your payment is past the due date. A late fee of $50 will apply.");
			return true;
		}
		return false;
	}
	
	/* Main method with custom testing variables to show desired output and that the program is indeed working */
	public static void main(String[] args) {
		
		CreditCard test = new CreditCard("3808-5631-7832-7656", "Ivan", "Chase", 5000, 1000); // default amount of $1000 added to account
		
		System.out.println(test.chargeIt(500)); // remove $500 from account, now balance is $500
		test.payment(750, 23); // input payment amount ($750) as well as the date(23rd of month) in which payment was done.
		
		System.out.println("Balance after adding amount: " + test.getBalance());
		
		/* Total Calculations:
		 * 1000 initially in bank after test object created
		 * 500 charged, 1000-500 = 500 left
		 * 750 payment added on 23rd of month
		 * 50 late fee applies
		 * 500 + (750 - 50) = 1200 in account.
		 */
		
		System.out.println(test.toString()); // toString method to return information about account
		
	}	
}

