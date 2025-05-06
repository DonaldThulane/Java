package p;
/**
*Donald Thulane Makhubela
* @author EDUV4972952
* 2024/07/24
*/
 
import java.util.Scanner;
 
public class P {
    private String[] toppings= {"cheese; tomato; pesto; ham; spinach; bacon; sausage; mushroom; beef; pineaple"}; // Corrected to individual toppings
    private int toppingCount;
    public static final int MAX_TOPPINGS = 10;
    private static final double BASE_PRICE = 14.0;
    private static final double TOPPINGS_PRICE = 2.0;
    private Scanner scanner;
 
    public P() {
        this.toppings = new String[MAX_TOPPINGS];
        this.toppingCount = 0;
        this.scanner = new Scanner(System.in);
    }
 
    public void displayMenu() {
        while (true) {
            System.out.println("\nMenu:cheese; tomato; pesto; ham; spinach; bacon; sausage; mushroom; beef; pineaple");
            System.out.println("1. Add Topping:cheese; tomato; pesto; ham; spinach; bacon; sausage; mushroom; beef; pineaple");
            System.out.println("2. View Order:cheese; tomato; pesto; ham; spinach; bacon; sausage; mushroom; beef; pineaple");
            System.out.println("3. Place Order and Exit");
            System.out.print("Enter your choice:");
 
            int choice = getUserChoice();
 
            switch (choice) {
                case 1:
                    addToppingsFromInput();
                    break;
                case 2:
                    System.out.println(this);
                    break;
                case 3:
                    System.out.println("Total Cost: $" + calculateCost());
                    System.out.println("Thank you for your order!");
                    return; // Exit the method, effectively ending the program
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 3.");
            }
        }
    }
 
    private int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }
 
    public void addTopping(String topping) {
        if (toppingCount < MAX_TOPPINGS) {
            if (topping == null || topping.trim().isEmpty()) {
                throw new IllegalArgumentException("Invalid topping entered. Please try again.");
            }
            toppings[toppingCount++] = topping.trim();
        } else {
            throw new IllegalStateException("Maximum number of toppings reached.");
        }
    }
 
    public double calculateCost() {
        return BASE_PRICE + toppingCount * TOPPINGS_PRICE;
    }
 
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pizza with ");
 
        if (toppingCount == 0) {
            sb.append("no toppings");
        } else {
            for (int i = 0; i < toppingCount; i++) {
                sb.append(toppings[i]);
                if (i < toppingCount - 1) {
                    sb.append(", ");
                }
            }
        }
 
        sb.append(". Price: $");
        sb.append(String.format("%.2f", calculateCost())); // Format the price to two decimal places
 
        return sb.toString();
    }
 
    public void addToppingsFromInput() {
        scanner.nextLine(); // Consume newline left by nextInt()
 
        System.out.println("Enter toppings(;cheese; tomato; pesto; ham; spinach; bacon; sausage; mushroom; beef; pineaple for the pizza (enter 'done' to finish):");
        String toppingInput;
        while (true) {
            toppingInput = scanner.nextLine().trim();
            if (toppingInput.equalsIgnoreCase("done")) {
                break;
            }
            try {
                addTopping(toppingInput);
                System.out.println("Topping '" + toppingInput + "' added.");
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }
 
    public static void main(String[] args) {
        P p = new P();
        p.displayMenu();
        p.scanner.close(); // Close the scanner when done
    }
}
