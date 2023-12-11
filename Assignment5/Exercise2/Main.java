package Exercise2;

class MyException extends Exception {
    private String message;

    public MyException(String message) {
        this.message = message;
    }

    public void printMessage() {
        System.out.println(message);
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            throw new MyException("My exception occurred!");
        } catch (MyException e) {
            e.printMessage();
        }
    }
}

