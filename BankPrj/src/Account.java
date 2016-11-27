
public class Account {
    private double iBalance;
    
    public double getBalance() {
        return iBalance;
    }
    
    public void deposit(double amt) {
    	iBalance = iBalance + amt;
    }
    
    public void withdraw(double amt) {
        if (iBalance >= amt) {
        	iBalance = iBalance - amt;
        }
    }

    public Account(double aBalance) {
    	iBalance = aBalance;
    }

}
