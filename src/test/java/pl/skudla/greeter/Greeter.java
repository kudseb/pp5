package pl.skudla.greeter;

public class Greeter {
    public String hello(String input_name) {
        return String.format( "Hello %s", input_name);
    }
}
