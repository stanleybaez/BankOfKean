import java.util.Scanner;
public class BankOfKean {
	public static void main(String[] args) {
		//variables + scanner
		Scanner input = new Scanner(System.in);
		double balance = 0, rate = 0;
		int x = 1;
		//account creation
		System.out.printf("%55s\n","===========Welcome to Bank of Kean===========");
		System.out.println();
		System.out.println("Please create an account");
		System.out.print("Enter a 4 digit pin: ");
		int pin = input.nextInt();
		while (pin < 999 || pin > 9999) {
			System.out.print("Invalid Pin. Please enter a 4 digit pin: ");
			pin = input.nextInt();
		}
		
		//login page
		while (x == 1) {
			System.out.print("Please log in with your pin: ");
			int pinGuess = input.nextInt();
			while (pin != pinGuess) {
				System.out.println("Invalid pin try again");
				pinGuess = input.nextInt();
			}	
		
		//Selecting an account type (Checking or Savings) Should only happen once.
			if (balance == 0) {
				System.out.println();
				System.out.println("Please select a type of account you'd like to open.");
				System.out.println("1. Checkings   2. Savings");
				int account = input.nextInt();
				while (account < 1 || account > 2) {
					System.out.print("Invalid Selection. Please input a valid option. ");
					account = input.nextInt();
				}
				if (account == 1) {
					System.out.print("An initial deposit is required. Please enter initial deposit: $");
					balance = input.nextDouble();
					rate = 0.0006;
				}
				if (account == 2) {
					System.out.print("An initial deposit of $1,000 is required. Please enter deposit: $");
					balance = input.nextDouble();
					rate = 0.0009;
					while (balance < 1000) {
						System.out.print("Invalid entry. $1,000 is required. Please enter a valid deposit: $");
						balance = input.nextDouble();
					}
				}
				System.out.println("You qualify for " + rate * 100 + "% interest rate");
			}
			//Main Menu
			int choice = 0;
			while (choice !=5) {
				System.out.printf("%55s\n","============Menu============");
				System.out.println();
				System.out.printf("%s%12s%12s%12s%12s\n", "    1.Deposit", "  2.Withdraw ", "  3.Calculate Interest", "  4.Current Balance", "5.Log Out");
				System.out.println();
				System.out.println();
				System.out.print("Please select an option: ");
				choice = input.nextInt();
			
				//Options
				switch(choice) {
					case 1:
						System.out.print("How much would you like to deposit? $");		
						double deposit = input.nextDouble();
						balance = deposit(balance, deposit);
						System.out.printf("Your new current balance is $%.2f\n", balance);
						break;	
					case 2: 
						System.out.print("How much would you like to withdraw? $");
						double withdraw = input.nextDouble();
						balance = withdraw(balance, withdraw);
						System.out.printf("Your Current Balance is $%.2f\n", balance);
						break;
					case 3:
						System.out.print("Enter the number of years you would like to calculate: ");
						int yearsInterest = input.nextInt();
						Double Interest = balance * Math.pow(1 + rate, yearsInterest);
						System.out.printf("In the next " + yearsInterest + " years, your current total will be $%.2f at %.2f%% interest rate\n", Interest, rate * 100);  //fixed so it only prints 2 decimals 
						break;		
					case 4:
						System.out.printf ("Current Balance is  $%.2f\n", balance);
						break;
					case 5:
						System.out.println("Thank you for banking with the Bank of Kean.");
						System.out.println();
				}
			}
		} 
}	
	public static double deposit(double balance, double deposit) {
		balance = balance + deposit; 
		return balance;
	}
	public static double withdraw(double balance, double withdraw){
		balance = balance - withdraw; 
		return balance;
	}
}