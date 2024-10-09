package lab8.lab8_1.lab7_2;

public class SavingsAccount extends BaseAccount {
    private FixedSalary owner;
    private Card card;
    protected double balance = 0;

    public SavingsAccount(FixedSalary a) {
        this.owner = a;
        card = new DebitCard(this);
    }

    public Card getCard() {
        return card;
    }

    public void setDebit(DebitCard debit) {
        card = debit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else
            return false;
    }

    @Override
    public boolean deposit(double amount) {
        if (amount >= 0) {
            balance += amount;
            return true;
        } else
            return false;
    }

    public void setAcc(FixedSalary owner) {
        this.owner = owner;
    }

    public void setCard(DebitCard card) {
        this.card = card;
    }

    public double getBalance() {
        return balance;
    }

    public FixedSalary getOwner() {
        return owner;
    }
    
    public class DebitCard extends Card {
        private SavingsAccount ownerAccount;
        private String cardNumber;

        public DebitCard(SavingsAccount personAcc) {
            setOwner(personAcc);
            ownerAccount.getOwner().setCard(this);
            setCardNumber(ownerAccount.getOwner().getSecurityNumber());
        }

        @Override
        public boolean withdraw(double amount) {
            return true;
        }

        @Override
        public String type() {
            return "VISA";
        }

        @Override
        public double discount() {
            return 0.975;
        }

        public SavingsAccount getOwnerAccount() {
            return ownerAccount;
        }

        public void setOwner(SavingsAccount ownerCard) {
            ownerAccount = ownerCard;
        }

        public String getCardNumber() {
            return cardNumber;
        }

        public void setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
        }

    }
}
