package Exercise1;

public class Main {
    public static void main(String[] args) {
        try {
            throw new Exception("Exception occurred!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Finally block executed.");
        }
    }
}