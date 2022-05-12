public class BankAccount {
    private String name;
    private double balance;
    private double accNumber;

    public BankAccount() {}

    public BankAccount(String name, double balance, double accNumber) {
        this.name = name;
        this.balance = balance;
        this.accNumber = accNumber;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public double getBalance() {
        return balance;
    }
    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }    
    public double getAccNumber() {
        return accNumber;
    }
    public void deposit(double depositAmt) {
        balance += depositAmt;
    }
    public void withdrawal(double withdrawalAmt) {
        balance -= withdrawalAmt;
    }
    public void transfer(BankAccount checking, double amount) {
        this.withdrawal(amount);
        checking.deposit(amount);
    }

}