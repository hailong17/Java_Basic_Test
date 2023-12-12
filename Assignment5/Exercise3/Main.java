package Exercise3;

class LevelOneException extends Exception {
    LevelOneException(String message) {
		/* Call constructor of super class */
        super(message);
    }
}

class LevelTwoException extends LevelOneException {
    LevelTwoException(String message) {
		/* Call constructor of super class */
        super(message);
    }
}

class LevelThreeException extends LevelTwoException {
    LevelThreeException(String message) {
		/* Call constructor of super class */
        super(message);
    }
}

class A {
    void throwException() throws LevelOneException {
        throw new LevelOneException("Exception occurred at level one.");
    }
}

class B extends A {
    @Override
    void throwException() throws LevelTwoException {
        throw new LevelTwoException("Exception occurred at level two.");
    }
}

class C extends B {
    @Override
    void throwException() throws LevelThreeException {
        throw new LevelThreeException("Exception occurred at level three.");
    }
}

public class Main {
    public static void main(String[] args) {
		/* Upcasting C to A */
        A printMessage = new C();
        try {
            printMessage.throwException();
        } catch (LevelOneException e) {
            System.out.println(e.getMessage());
        }
    }
}
