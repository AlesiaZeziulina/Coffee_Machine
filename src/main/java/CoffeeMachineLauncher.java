import java.util.HashMap;
import java.util.Map;

public class CoffeeMachineLauncher {
    public static void main(String[] args) {
        Map<String, Coffee> coffeeMap = new HashMap();
        coffeeMap.put("1", new Coffee(250, 0, 16, 4));
        coffeeMap.put("2", new Coffee(350, 75, 20, 7));
        coffeeMap.put("3", new Coffee(200, 100, 12, 6));
        CoffeeMachineWorker coffeeMachineWorker = new CoffeeMachineWorker(coffeeMap);
        coffeeMachineWorker.makeAction();
    }
}