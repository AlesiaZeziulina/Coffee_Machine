import java.util.Map;
import java.util.Scanner;

public class CoffeeMachineWorker {
    private final Map<String, Coffee> coffeeMap;
    private Scanner input = new Scanner(System.in);
    private int waterValueLeft = 400;
    private int milkValueLeft = 540;
    private int beansValueLeft = 120;
    private int disposableCupsLeft = 9;
    private int moneyLeft = 550;

    public CoffeeMachineWorker(Map<String, Coffee> coffeeMap) {
        this.coffeeMap = coffeeMap;
    }

    public void makeAction() {
        while (true) {
            System.out.println("Write action (buy / fill / take / remaining / exit):");
            String action = input.nextLine();
            if ("buy".equals(action)) {
                makeBuyAction();
            } else if ("fill".equals(action)) {
                makeFillAction();
            } else if ("take".equals(action)) {
                makeTakeAction();
            } else if ("remaining".equals(action)) {
                printRemainingResources();
            } else if ("exit".equals(action)) {
                return;
            } else {
                System.out.println("Please enter a valid action: ");
            }
        }
    }

    public void printRemainingResources() {
        System.out.println("The coffee machine has:");
        System.out.println(waterValueLeft + " of water\n" +
                milkValueLeft + " of milk\n" +
                beansValueLeft + " of coffee beans\n" +
                disposableCupsLeft + " of disposable cups\n" +
                moneyLeft + " of money");
    }

    private void makeBuyAction() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        while (true) {
            String choice = input.nextLine();
            Coffee coffeeType = coffeeMap.get(choice);
            if (coffeeType != null) {
                String resourceLack = getResourcesLack(coffeeType);
                if (resourceLack != null) {
                    System.out.println("Sorry, not enough " + resourceLack + "!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    makeAndBuyCoffee(coffeeType);
                }
                return;
            } else if (choice.equalsIgnoreCase("back")) {
                return;
            } else {
                System.out.println("Please make a correct choice: ");
            }
        }
    }

    private void makeFillAction() {
        System.out.println("Write how many ml of water do you want to add: ");
        waterValueLeft += input.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        milkValueLeft += input.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        beansValueLeft += input.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        disposableCupsLeft += input.nextInt();
    }

    private void makeTakeAction() {
        System.out.println("I gave you $" + moneyLeft);
        moneyLeft = 0;
    }

    private void makeAndBuyCoffee(Coffee coffee) {
        waterValueLeft -= coffee.getWaterNeeded();
        milkValueLeft -= coffee.getMilkNeeded();
        beansValueLeft -= coffee.getBeansNeeded();
        moneyLeft += coffee.getCost();
        disposableCupsLeft -= 1;
    }

    private String getResourcesLack(Coffee coffee) {
        String resourceLack = null;
        if (waterValueLeft - coffee.getWaterNeeded() < 0) {
            resourceLack = "water";
        } else if (milkValueLeft - coffee.getMilkNeeded() < 0) {
            resourceLack = "milk";
        } else if (beansValueLeft - coffee.getBeansNeeded() < 0) {
            resourceLack = "coffee beans";
        } else if (disposableCupsLeft - 1 < 0) {
            resourceLack = "disposable cups";
        }
        return resourceLack;
    }
}
