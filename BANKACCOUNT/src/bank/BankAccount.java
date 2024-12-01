package bank;
import java.util.ArrayList;
import java.util.List;



	
	// BankAccount class
	public class BankAccount {
	    private double balance;
	    private List<String> transactionHistory;

	    public BankAccount() {
	        this.balance = 0.0;
	        this.transactionHistory = new ArrayList<>();
	    }

	    public double getBalance() {
	        return balance;
	    }

	    public List<String> getTransactionHistory() {
	        return transactionHistory;
	    }

	    public void deposit(double amount) {
	        if (amount > 0) {
	            balance += amount;
	            transactionHistory.add("Deposited: " + amount);
	        } else {
	            throw new IllegalArgumentException("Deposit amount must be positive.");
	        }
	    }

	    public void withdraw(double amount) {
	        if (amount > 0 && amount <= balance) {
	            balance -= amount;
	            transactionHistory.add("Withdrew: " + amount);
	        } else {
	            throw new IllegalArgumentException("Withdrawal amount must be positive and not exceed balance.");
	        }
	    }
	}

	// BankAccountTest class
	 class BankAccountTest {
	    private BankAccount account;

	    public BankAccountTest() {
	        account = new BankAccount();
	    }

	    public void testInitialBalance() {
	        assertEqual(0.0, account.getBalance(), "Initial balance test");
	    }

	    public void testDeposit() {
	        account.deposit(100.0);
	        assertEqual(100.0, account.getBalance(), "Deposit test");
	        assertTrue(account.getTransactionHistory().contains("Deposited: 100.0"), "Deposit transaction history test");
	    }

	    public void testDepositNegativeAmount() {
	        try {
	            account.deposit(-50.0);
	            System.out.println("Deposit negative amount test failed.");
	        } catch (IllegalArgumentException e) {
	            System.out.println("Deposit negative amount test passed.");
	        }
	    }

	    public void testWithdraw() {
	        account.deposit(100.0);
	        account.withdraw(50.0);
	        assertEqual(50.0, account.getBalance(), "Withdraw test");
	        assertTrue(account.getTransactionHistory().contains("Withdrew: 50.0"), "Withdraw transaction history test");
	    }

	    public void testWithdrawNegativeAmount() {
	        try {
	            account.withdraw(-50.0);
	            System.out.println("Withdraw negative amount test failed.");
	        } catch (IllegalArgumentException e) {
	            System.out.println("Withdraw negative amount test passed.");
	        }
	    }

	    public void testWithdrawExceedingBalance() {
	        account.deposit(50.0);
	        try {
	            account.withdraw(100.0);
	            System.out.println("Withdraw exceeding balance test failed.");
	        } catch (IllegalArgumentException e) {
	            System.out.println("Withdraw exceeding balance test passed.");
	        }
	    }

	    public void testBalanceInquiry() {
	        account.deposit(200.0);
	        assertEqual(200.0, account.getBalance(), "Balance inquiry test");
	    }

	    public void testTransactionHistory() {
	        account.deposit(100.0);
	        account.withdraw(50.0);
	        assertTrue(account.getTransactionHistory().contains("Deposited: 100.0"), "Transaction history deposit test");
	        assertTrue(account.getTransactionHistory().contains("Withdrew: 50.0"), "Transaction history withdraw test");
	    }

	    private void assertEqual(double expected, double actual, String testName) {
	        if (Math.abs(expected - actual) < 0.001) {
	            System.out.println(testName + " passed.");
	        } else {
	            System.out.println(testName + " failed. Expected: " + expected + ", Actual: " + actual);
	        }
	    }

	    private void assertTrue(boolean condition, String testName) {
	        if (condition) {
	            System.out.println(testName + " passed.");
	        } else {
	            System.out.println(testName + " failed.");
	        }
	    }

	    public static void main(String[] args) {
	        BankAccountTest test = new BankAccountTest();
	        test.testInitialBalance();
	        test.testDeposit();
	        test.testDepositNegativeAmount();
	        test.testWithdraw();
	        test.testWithdrawNegativeAmount();
	        test.testWithdrawExceedingBalance();
	        test.testBalanceInquiry();
	        test.testTransactionHistory();
	    }
	}



