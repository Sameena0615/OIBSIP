public class Bank {

    private Account account;

    public Bank() {
        account = new Account("1001", "1234", 5000);
    }

    public Account getAccount() {
        return account;
    }
}