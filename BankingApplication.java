package simpleBankingApplication;

import java.util.Scanner;

class BankDetails {
	private String Accno;
	private String Name;
	private String Acctype;
	private long Balance;

	Scanner sc = new Scanner(System.in);

	// Method to open New Account

	public void openAccount() {
		System.out.println("Enter the Account No: ");
		Accno = sc.next();
		System.out.println("Enter Account type: ");
		Acctype = sc.next();
		System.out.println("Enter Name: ");
		Name = sc.next();
		System.out.println("Enter Balance: ");
		Balance = sc.nextLong();
	}

	// Method to display Account Details

	public void showAccount() {
		System.out.println("Name of Account Holder: " + Name);
		System.out.println("Account No: " + Accno);
		System.out.println("Account Type: " + Acctype);
		System.out.println("Balance: " + Balance);
	}

	// Method to deposit money

	public void deposit() {
		long Amt;
		System.out.println("Enter the Amount that you want to deposit: ");
		Amt = sc.nextLong();
		Balance = Balance + Amt;
		System.out.println("Balance after deposit: " + Balance);
	}

	// Method to withdraw money

	public void withdrawal() {
		long Amount;
		System.out.println("Enter the Amount you want to withdraw: ");
		Amount = sc.nextLong();
		if (Balance >= Amount) {
			Balance = Balance - Amount;
			System.out.println("Balance after withdrawal: " + Balance);
		} else {
			System.out.println("Your Balance is less than " + Amount + "\n Transaction Failed...!!!");
		}
	}

	// Method to Search an Account

	public boolean search(String Ac_no) {
		if (Accno.equals(Ac_no)) {
			showAccount();
			return (true);
		}
		return (false);
	}
}

public class BankingApplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Create initial Accounts

		System.out.println("How many customers want to create new account?");
		int n = sc.nextInt();
		BankDetails b[] = new BankDetails[n];
		for (int i = 0; i < b.length; i++) {
			b[i] = new BankDetails();
			b[i].openAccount();
		}
		System.out.println("Account created Successfully...!!!");
		// Loop runs until 5 is not pressed to exit

		int ch;
		do {
			System.out.println("\n\n         Welcome to Banking System Application            ");
			System.out.println("1.Display all Account details");
			System.out.println("2.Search an Account by Account No");
			System.out.println("3.Deposit Amount ");
			System.out.println("4.Withdrawal Amount ");
			System.out.println("5.Exit");
			System.out.println("\n Enter your choice: ");
			ch = sc.nextInt();

			switch (ch) {
			case 1:
				for (int i = 0; i < b.length; i++) {
					b[i].showAccount();
				}
				break;
			case 2:
				System.out.println("Enter Account no you want to search");
				String Ac_no = sc.next();
				boolean found = false;
				for (int i = 0; i < b.length; i++) {
					found = b[i].search(Ac_no);
					if (found) {
						break;
					}
				}
				if (!found) {
					System.out.println("Search failed!!!");
				}
				break;
			case 3:
				System.out.println("Enter Account no: ");
				Ac_no = sc.next();
				found = false;
				for (int i = 0; i < b.length; i++) {
					found = b[i].search(Ac_no);
					if (found) {
						b[i].deposit();
						break;
					}
				}
				if (!found) {
					System.out.println("Search failed!!!");
				}
				break;
			case 4:
				System.out.println("Enter Account no: ");
				Ac_no = sc.next();
				found = false;
				for (int i = 0; i < b.length; i++) {
					found = b[i].search(Ac_no);
					if (found) {
						b[i].withdrawal();
						break;
					}
				}
				if (!found) {
					System.out.println("Search failed!!!");
				}
				break;
			case 5:
				System.out.println("Exit ");
				System.out.println("Thank You!! ");
                break;
			default:
				System.out.println("Invalid Choice...");
				break;
			}
		} while (ch != 5);
	}

}
