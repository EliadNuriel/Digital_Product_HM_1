import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank {

    private List<IAccount> bankAccounts;

    public Bank()
    {
        this.bankAccounts = new ArrayList<IAccount>();
    }

    @Override
    public void OpenAccount(IAccount account)
    {
        bankAccounts.add(account);
    }

    @Override
    public void CloseAccount(int accountNumber)
    {
        boolean foundAcount = false;
        IAccount accountToClose = null;
        for(IAccount account : bankAccounts)
        {
            if(account.GetAccountNumber() == accountNumber)
            {
                foundAcount = true;
                accountToClose = account;
                break;
            }
        }

        if(foundAcount)
        {
            if (accountToClose.GetCurrentBalance() >= 0)
            {
                bankAccounts.remove(accountToClose);
            }
            else
            {
                System.out.println("The account is not closed due to debt");
            }
        }
    }

    @Override
    public List<IAccount> GetAllAccounts() {
        return bankAccounts;
    }

    @Override
    public List<IAccount> GetAllAccountsInDebt() {

        List<IAccount> accountInDebt = new ArrayList<IAccount>();
        for(IAccount account : bankAccounts)
        {
            if (account.GetCurrentBalance() < 0)
            {
                accountInDebt.add(account);
            }
        }

        return accountInDebt;

    }

    @Override
    public List<IAccount> GetAllAccountsWithBalance(double balanceAbove)
    {
        List<IAccount> accountsWithBalance = new ArrayList<IAccount>();
        for(IAccount account : bankAccounts)
        {
            if (account.GetCurrentBalance() > balanceAbove)
            {
                accountsWithBalance.add(account);
            }
        }

        return accountsWithBalance;
    }
}
