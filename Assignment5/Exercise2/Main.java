package Exercise2;

class MyException extends Exception {
    public MyException() {
    }
}

public class Main {
    public static void main(String[] args)  {
        try {
            Divide();
        } catch (MyException e) {
            System.out.println("My exception occurred!");
        }
    }

    public static void Divide() throws MyException {
        try {
            int a = 5/0;
        } catch (Exception e) {
            throw new MyException();
        }
    }
}

