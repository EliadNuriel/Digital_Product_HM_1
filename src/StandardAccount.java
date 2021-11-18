public class StandardAccount implements IAccount {
    private int accountNumber;
    private  double creditLimit;
    private double balance;

    public StandardAccount(int accountNumber , double creditLimit) {
        this.accountNumber = accountNumber;
        if(creditLimit < 0) {
            this.creditLimit = creditLimit;
        }
        else
        {
            this.creditLimit = 0;
        }
        this.balance = 0 ;
    }

    @Override
    public void Deposit(double amount) {
        if(amount > 0) {
            balance += amount;
        }
    }

    @Override
    public double Withdraw(double amount) {

        if(amount < 0)
        {
            return 0;
        }

        double newBalance = balance - amount;
        double withDraw;

        if(newBalance < creditLimit)
        {
            withDraw = balance - creditLimit;
            this.balance = creditLimit;
        }
        else
        {
            this.balance = newBalance;
            withDraw = amount;
        }

        return withDraw;
    }

    @Override
    public double GetCurrentBalance() {
        return this.balance;
    }

    @Override
    public int GetAccountNumber() {
        return this.accountNumber;
    }

}
