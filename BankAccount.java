public class BankAccount {
    public static double balance;
    public static long password;

    public BankAccount(long password, double initialbalance) {
        if (password > 0)
            this.password = password;
        if (initialbalance >= 0.0)
            this.balance = initialbalance;
    }

    public boolean deposit(double amount) {
        if(amount>0) {
            this.balance = balance + amount;
            return true;
        }
        else
            return false;
    }

    public boolean withdraw(double amount) {
        if (amount>0&&amount<=balance) {
            this.balance = balance - amount;
            return true;
        }
        else
            return false;
        }

    public double getBalance() {
        return this.balance;
    }

}