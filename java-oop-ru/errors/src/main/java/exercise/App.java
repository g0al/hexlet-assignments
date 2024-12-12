package exercise;

// BEGIN
public class App {
    public static void main(String[] args) {
        //main
    }

    public static void printSquare(Circle circle) {
        try {
            System.out.println(Math.round(circle.getSquare()));
        } catch (NegativeRadiusException e) {
            System.out.println(e.getErrorDescription());
        } finally {
            System.out.println("Вычисление окончено");
        }
    }
}
// END
