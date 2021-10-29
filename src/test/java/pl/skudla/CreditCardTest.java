package pl.skudla;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardTest {
    @Test
    public void itAllowsAssagningCreditLimitToCard(){
        //Arrange
        CreditCard card = new CreditCard("1234-5678");
        //Act
        card.assingCredit(BigDecimal.valueOf(1000));
        //Assert
        assertEquals(BigDecimal.valueOf(1000), card.getCurrentLimit());
    }
    @Test
    public void limitBelowThresholdCantBeAssigned(){
        //arrange
        CreditCard card = new CreditCard("1234-567");
        //act

        //assert
        try{
            card.assingCredit(BigDecimal.valueOf(50));
            Assertions.fail("Exception shuld be trhown");
        } catch (CreditBelowThresholdException e){
            assertTrue(true);
        }
    }
    @Test
    public void limitBelowThresholdCantBeAssignedV2(){
        CreditCard card = new CreditCard("1234-567");
        assertThrows(CreditBelowThresholdException.class, () -> {
            card.assingCredit(BigDecimal.valueOf(50));
        });
    }
    @Test
    public void itAllowWithdraw(){
        //arange
        CreditCard card = new CreditCard("1234-567");
        card.assingCredit(BigDecimal.valueOf(1000));
        //act
        card.withdraw(BigDecimal.valueOf(500));
        card.withdraw(BigDecimal.valueOf(500));

        //assert
        assertThrows(NotEnoughMoney.class, () ->{
            card.withdraw(BigDecimal.valueOf(500));
        });
        assertEquals(BigDecimal.valueOf(0), card.getBalance());
    }

}
