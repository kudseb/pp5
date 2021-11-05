package pl.skudla;

import java.math.BigDecimal;

public class BankingSystem {

    private final CreditCardMemory memory;

    public BankingSystem(CreditCardMemory memory){
        this.memory= memory;

    }
    public void handleWithdraw(String cardNumber, int money){
        CreditCard card = memory.findByNumber(cardNumber).get();
        card.withdraw(BigDecimal.valueOf(money));


        memory.save(card);
    }
}
