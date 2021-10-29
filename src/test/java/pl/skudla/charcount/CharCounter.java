package pl.skudla.charcount;

public class CharCounter {
    public int count(char char_to_be_counted, String input_str) {
        return (int) input_str
                .toLowerCase()
                .chars()
                .filter(c -> c == char_to_be_counted )
                .count();

    }
}
