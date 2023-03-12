import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> dataset = new HashMap<>( );
        dataset.put("Chennai", "Banglore");
        dataset.put("Bombay", "Delhi");
        dataset.put("Goa", "Chennai");
        dataset.put("Delhi", "Goa");

        Map<String, String> reverseMap = new HashMap<>();
        for (Map.Entry<String, String> entry : dataset.entrySet()) {
            reverseMap.put(entry.getValue(), entry.getKey());
        }

        String startingPoint = null;
        for (Map.Entry<String, String> entry : dataset.entrySet()) {
            if (!reverseMap.containsKey(entry.getKey())) {
                startingPoint = entry.getKey();
                break;
            }
        }

        if (startingPoint == null) {
            System.out.println("Invalid input");
            return;
        }

        String to = dataset.get(startingPoint);
        while (to != null) {
            System.out.print(startingPoint + "->" + to + ", ");
            startingPoint = to;
            to = dataset.get(startingPoint);
        }
    }
}