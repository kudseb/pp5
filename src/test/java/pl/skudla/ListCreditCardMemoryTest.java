package pl.skudla;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pl.skudla.CreditCard;
import pl.skudla.ListCreditCardMemory;

public class ListCreditCardMemoryTest {
    @Test
    public void itStoreCard(){

        ListCreditCardMemory memory = new ListCreditCardMemory();
        CreditCard card = new CreditCard("123");

        memory.save(card);

        CreditCard loaded = memory.findbyNumber("123")
                .get();

        assertEquals(card.getNumber(),loaded);
    }
}
