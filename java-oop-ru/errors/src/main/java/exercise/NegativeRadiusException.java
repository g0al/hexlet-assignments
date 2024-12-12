package exercise;

// BEGIN
public class NegativeRadiusException extends Exception {

    NegativeRadiusException(String error) {
    }

    public String getErrorDescription() {
        return "Не удалось посчитать площадь";
    }
}
// END
