public class BasicAccount extends StandardAccount{

    private double withdrawLimit;

    public BasicAccount(int accountNumber, double withdrawlLimit)
    {
        super(accountNumber, 0);
        if (withdrawlLimit > 0)
        {
            this.withdrawLimit = withdrawlLimit;
        }
        else
        {
            this.withdrawLimit = 0;
        }
    }

    @Override
    public double Withdraw(double amount) {

        if(amount > this.withdrawLimit)
        {
            amount = this.withdrawLimit;
        }

        return super.Withdraw(amount);
    }

}
