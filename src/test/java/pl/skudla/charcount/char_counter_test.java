package pl.skudla.charcount;

import org.junit.jupiter.api.Test;
import pl.skudla.charcount.CharCounter;

import static  org.junit.jupiter.api.Assertions.*;

public class char_counter_test {
    @Test
    public void it_counts_chars_in_input_string(){
        //Arrange

        String input_str = "Ala ma kota a kot ma mysz";
        CharCounter char_counter = new CharCounter();
        //Act

        int chars_count = char_counter.count('a',input_str);
        //Assert
        assertEquals(6 , chars_count);
    }
}
