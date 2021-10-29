package pl.skudla;

import org.junit.jupiter.api.Test;

public class BlaBlaTest {
    @Test
    public void itAllowsToHandleCreditCardWithDrawFromMultipleCards(){
        String cardNumber1 = thereIsCardWithiTheSystem(1000);
        String cardNumber2 = thereIsCardWithiTheSystem(2000);

        Bankingsysem system = thereisBankingSystem();

        system.handleWithdraw(cardNumber1,500, "asdas", "Dsa");
        system.handleWithdraw(cardNumber2,1000);

        balanceOfCardEquals(cardNumber1,500);
        balanceOfCardEquals(cardNumber2,1000);


    }
}
