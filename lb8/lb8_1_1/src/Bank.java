public class Bank {
    private int balance;

    public Bank(int initialBalance) {
        this.balance = initialBalance;
    }

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Пополнение: +" + amount + " | Баланс: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Снятие: -" + amount + " | Баланс: " + balance);
        } else {
            System.out.println("Недостаточно денежных средств.");
        }
    }
}
