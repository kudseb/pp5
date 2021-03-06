package pl.skudla.greeter;

import org.junit.jupiter.api.Test;
import pl.skudla.greeter.Greeter;

import static org.junit.jupiter.api.Assertions.*;

public class GreeterTest {
    @Test
    public void itGreetsByName(){
        //Arrange / Given
        String name = "sebastian";
        Greeter greeter = new Greeter();
        //Act / When
        String greetingText = greeter.hello(name);
        //Assert / Then
        assertEquals("Hello sebastian", greetingText);
    }
}
