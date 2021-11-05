package pl.skudla;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardApiTest {

    private CreditCardHashMapMemory cardMemory;

    @Test
    public void itAllowsToHandleCreditCardWithdrawFromMultipleCards() {

        thereIsCreditCardMemory();

        String cardNumber1 = thereIsCardWithLimitInTheSystem(1000);
        String cardNumber2 = thereIsCardWithLimitInTheSystem(2000);

        BankingSystem system = thereIsBankingSystem();

        system.handleWithdraw(cardNumber1, 500);
        system.handleWithdraw(cardNumber2, 1000);

        balanceOfCardEquals(cardNumber1, 500);
        balanceOfCardEquals(cardNumber2, 1000);
    }

    private BankingSystem thereIsBankingSystem() {
        return new BankingSystem(cardMemory);
    }

    private void balanceOfCardEquals(String cardNumber, int expectedBalance) {
        CreditCard loaded = cardMemory.findByNumber(cardNumber)
                .orElseGet(() -> new CreditCard(cardNumber));

        assertEquals(BigDecimal.valueOf(expectedBalance), loaded.getBalance());
    }

    private String thereIsCardWithLimitInTheSystem(int creditLimit) {
        CreditCard card = new CreditCard(UUID.randomUUID().toString());
        card.assingCredit(BigDecimal.valueOf(creditLimit));

        cardMemory.save(card);
        return card.getNumber();
    }

    private void thereIsCreditCardMemory() {

        cardMemory = new CreditCardHashMapMemory();
    }
}