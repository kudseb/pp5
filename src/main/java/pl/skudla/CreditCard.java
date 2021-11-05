package pl.skudla;

import java.math.BigDecimal;

public class CreditCard {
    public static final int CREDIT_LOW_LIMIT = 100;
    private final String cardNumber;
    private BigDecimal creditLimit;
    private BigDecimal balance;

    public CreditCard(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void assingCredit(BigDecimal creditLimit) {
        if (isBelowCredtLimit(creditLimit))
        {
            throw new CreditBelowThresholdException();
        }
        this.creditLimit = creditLimit;
        this.balance = creditLimit;
    }

    private boolean isBelowCredtLimit(BigDecimal creditLimit) {
        return creditLimit.compareTo(BigDecimal.valueOf(CREDIT_LOW_LIMIT)) < 0;
    }

    public BigDecimal getCurrentLimit() {
        return this.creditLimit;
    }

    public void withdraw(BigDecimal money) {
        if (balance.compareTo(money) < 0){
            throw new NotEnoughMoney();
        }
        this.balance = balance.subtract(money);
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public String getNumber() {
        return this.cardNumber;
    }
}
