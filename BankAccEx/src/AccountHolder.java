public class AccountHolder implements Runnable {
    private Account account;

    public AccountHolder(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 4; i++) {
            makeWithdraw(2000);
            if (account.getBalance() < 0)
                System.out.println("Account is overdrawn!");
        }
    }

    /*private void makeWithdraw(int withdrawAmount) {
        if (account.getBalance() >= withdrawAmount) {
            System.out.println(Thread.currentThread().getName() + " is going to withdraw...");
            try {
                Thread.sleep(3000);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            account.withdraw(withdrawAmount);
            System.out.println(Thread.currentThread().getName() + " complete the withdraw\n" + "Current amount: " + account.getBalance() + "\n");
        } else {
            System.out.println("Not enough in account for " + Thread.currentThread().getName() + " " + account.getBalance());
        }
    }*/
    private synchronized void makeWithdraw(int withdrawAmount) {
        if (account.getBalance() >= withdrawAmount) {
            System.out.println(Thread.currentThread().getName() + " is going to withdraw...");
            try {
                Thread.sleep(3000);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            account.withdraw(withdrawAmount);
            System.out.println(Thread.currentThread().getName() + " complete the withdraw\n" + "Current amount: " + account.getBalance() + "\n");
        } else {
            System.out.println("Not enough in account for " + Thread.currentThread().getName() + " " + account.getBalance());
        }
    }
}
