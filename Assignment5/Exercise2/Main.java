package Exercise2;

class CustomException extends Exception {
    private String message;

    public CustomException(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            throw new CustomException("My exception occurred!");
        } catch (CustomException e) {
            e.printMessage();
        }
    }
}

