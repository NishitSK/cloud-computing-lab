public class HelloApex {

    public static String greet(String name) {

        String message = 'Welcome to Apex programming, ' + name + '!';

        System.debug(message);

        return message;
    }
}
