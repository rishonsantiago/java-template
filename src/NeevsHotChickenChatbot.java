import java.util.Scanner;
import java.util.Random;

public class NeevsHotChickenChatbot {
    // Define color codes
    private static final String RESET = "\033[0m";  // Reset color
    private static final String RED = "\033[31m";
    private static final String GREEN = "\033[32m";
    private static final String YELLOW = "\033[33m";
    private static final String BLUE = "\033[34m";
    private static final String CYAN = "\033[36m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Create menu items
        Food item1 = new Food("Classic Chicken Sandwich", 7.99, "Mild");
        Food item2 = new Food("Spicy Chicken Wings", 9.99, "Hot");
        Food item3 = new Food("Loaded Fries", 5.49, "Not Spicy");

        // Array of food objects
        Food[] menu = {item1, item2, item3};

        // Array of "I don't understand" responses
        String[] confusedResponses = {
            "Hmm, I'm not sure about that!",
            "Can you try asking that differently?",
            "Sorry, I didn't catch that.",
            "I wish I knew the answer to that!",
            "I'm still learning, so I don't understand that yet."
        };

        // Welcome message with color
        System.out.println(GREEN + "Welcome to Neev's Hot Chicken!");
        System.out.println(CYAN + "You can ask me about our menu, spice levels, locations, prices, dietary options, and hours.");
        System.out.println(YELLOW + "Type 'exit' to leave the chat.");

        boolean running = true;
        while (running) {
            System.out.print("\nYou: ");
            String userInput = normalizeInput(scanner.nextLine());

            if (userInput.equals("exit")) {
                System.out.println(RED + "Thanks for chatting! Come back to Neev's Hot Chicken soon!");
                running = false;
            } else if (userInput.contains("menu")) {
                displayMenu(menu);
            } else if (userInput.contains("spice")) {
                displaySpiceLevels(menu);
            } else if (userInput.contains("price") || userInput.contains("cost")) {
                displayPrices(menu);
            } else if (userInput.contains("location") || userInput.contains("area")) {
                System.out.println(CYAN + "We have locations in Pleasanton, New York City, Los Angeles, Miami, and Cleveland.");
            } else if (userInput.contains("time") || userInput.contains("open") || userInput.contains("hours")) {
                System.out.println(GREEN + "Monday-Friday: 10am - 7pm, Weekends: 12pm - 6pm.");
            } else if (userInput.contains("vegan") || userInput.contains("gluten")) {
                System.out.println(YELLOW + "We offer gluten-free buns and vegan loaded fries!");
            } else if (userInput.contains("best") || userInput.contains("popular")) {
                System.out.println(GREEN + "Our Spicy Chicken Wings are a fan favorite!");
            } else if (userInput.contains("promotion") || userInput.contains("special")) {
                System.out.println(BLUE + "Today's special: Buy one Classic Chicken Sandwich, get a free drink!");
            } else if (userInput.contains("delivery")) {
                System.out.println(CYAN + "We offer delivery through Uber Eats and DoorDash.");
            } else if (userInput.contains("seating")) {
                System.out.println(GREEN + "We have both indoor and outdoor seating available.");
            } else if (userInput.contains("catering")) {
                System.out.println(YELLOW + "Yes, we offer catering services for events!");
            } else if (userInput.contains("customize")) {
                System.out.println(BLUE + "You can customize your sandwich with extra toppings and sauces.");
            } else if (userInput.contains("recommend")) {
                recommendDish(menu);
            } else {
                String randomResponse = confusedResponses[random.nextInt(confusedResponses.length)];
                System.out.println(RED + randomResponse);
            }

            // Leading question with color
            System.out.println(CYAN + "Tip: Try asking about our 'menu', 'spice levels', 'prices', 'locations', or 'hours'.");
        }
        scanner.close();
    }

    // Normalize user input: Removes extra spaces, punctuation, and converts to lowercase
    public static String normalizeInput(String input) {
        return input.trim().toLowerCase().replaceAll("[^a-zA-Z0-9 ]", "").replaceAll("\\s+", " ");
    }

    // Method to display the menu
    public static void displayMenu(Food[] menu) {
        System.out.println(GREEN + "Here's our menu:");
        for (Food item : menu) {
            System.out.println("- " + item.getName() + " ($" + item.getPrice() + ")");
        }
    }

    // Method to display spice levels
    public static void displaySpiceLevels(Food[] menu) {
        System.out.println(YELLOW + "Spice levels of our menu items:");
        for (Food item : menu) {
            System.out.println("- " + item.getName() + ": " + item.getSpiceLevel());
        }
    }

    // Method to display prices
    public static void displayPrices(Food[] menu) {
        System.out.println(GREEN + "Prices of our menu items:");
        for (Food item : menu) {
            System.out.println("- " + item.getName() + ": $" + item.getPrice());
        }
    }

    // Method to recommend a dish
    public static void recommendDish(Food[] menu) {
        System.out.println(CYAN + "I recommend trying our " + menu[1].getName() + ". It's delicious and has the perfect kick of spice!");
    }
}

class Food {
    private String name;
    private double price;
    private String spiceLevel;

    public Food(String name, double price, String spiceLevel) {
        this.name = name;
        this.price = price;
        this.spiceLevel = spiceLevel;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getSpiceLevel() {
        return spiceLevel;
    }
}
