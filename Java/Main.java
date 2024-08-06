import java.util.Scanner;

/**
 * This is the Main class
 * @author Julian Chattopadhyay
 * @version 1.0
 */
public class Main {
    /**
     * This is the Main method
     * This is where the program runs and is the main place you will be
     * interacting with the program 
     * 
     * To run this sample program first compile the program using:
     * javac *.java 
     * This calls the program javac which compiles the programs following it
     * *.java means it will compile files in the directory with the .java extension
     * 
     * Then run the program using 
     * java Main
     */
    public static void main(String[] args) {
        Animal[] animals = new Animal[5];
        /**
         * This is an example of polymorphism
         * We are creating an array of type Animal, but filling it with 
         * objects that aren't called 'Animal'
         * 
         * This is a nice feature of object oriented programming because it allows
         * us to simplify our code and make it more readable
         * 
         * Take a look at the other files in this directory to see how this works
         * and how each of the 3 types of classes are defined and interact with each other
         */
        animals[0] = new Fish("Tuna", 1, "Silver", true);
        animals[1] = new Bird("Ostrich", 5, "Gray", false);
        animals[2] = new Fish("Salmon", 3, "Orange", true);
        animals[3] = new Bird("Blue Jay", 4, "Blue", true);
        /* 
            animal[4] = new Animal("Animal", 0, "Black");  
            
            This will not work because Animal is an abstract class. 
            Read more about why this doesn't work in the Animal.java file
        */
        
        // We can sort the array of animals with 'Arrays.sort(animals)' because we implemented the Comparable interface
        // This tells the compiler that all objects of type Animal can be compared to each other
        // which is necessary to be able to sort them

        
        // This allows you took get input from the user, don't worry about how it works just
        // know that you can use it
        Scanner scan = new Scanner(System.in); 

        // This while loop will run forever until the user decides to quit
        while (true) {
            printMenu();

            // This gets the user's choice from the menu as an integer. Be careful, because if the user 
            // enters something that isn't an integer, the program will crash. 
            // We can fix this with error handling through try-catch blocks and type checking
            // but that is beyond the scope of this
            int choice = scan.nextInt(); 

            // this is a switch statement, it behaves like a series of if-else statements 
            // but is more efficient
            switch (choice) {
                case 1: // List all animals
                    for (Animal animal : animals) {
                        if (animal != null) {
                            System.out.println(animal);
                        }
                    }
                    break; // we need to make sure we break out or it will continue onto the next case
                case 2: // List all birds
                    for (Animal animal : animals) {
                        if (animal != null && animal instanceof Bird) { // need to check that the animal is a bird 
                            System.out.println(animal);
                        }
                    }
                    break;
                case 3: // List all fish
                    for (Animal animal : animals) {
                        if (animal != null && animal instanceof Fish) {
                            System.out.println(animal);
                        }
                    }
                    break;
                case 4: // Feed all animals
                    for (Animal animal : animals) {
                        if (animal != null) animal.eat();
                    }
                    break;
                case 5: // Feed all birds
                    for (Animal animal : animals) {
                        if (animal != null && animal instanceof Bird) {
                            animal.eat();
                        }
                    }
                    break;
                case 6: // Feed all fish
                    for (Animal animal : animals) {
                        if (animal != null && animal instanceof Fish) {
                            animal.eat();
                        }
                    }
                    break;
                case 7: // Swim all fish
                    for (Animal animal : animals) {
                        if (animal != null && animal instanceof Fish) {
                            ((Fish) animal).swim(); // we need to tell the compiler that the animal is a fish
                        }
                    }
                    break;
                case 8: // Fly all birds
                    for (Animal animal : animals) {
                        if (animal != null && animal instanceof Bird) {
                            ((Bird) animal).fly();
                        }
                    }
                    break;
                case 9: // Add an animal
                    animals[4] = createNewAnimal(scan);
                    break;
                case 10: // Quit
                    scan.close();
                    System.exit(0);
                    break;
                default: // This default statement handles the case when the user enters an invalid choice
                    System.out.println("Invalid choice");
            }

        }
    }

    /**
     * This method prints the menu for the user to see
     */
    private static void printMenu() {
        System.out.println("1. List all animals");
        System.out.println("2. List all birds");
        System.out.println("3. List all fish");
        System.out.println("4. Feed all animals");
        System.out.println("5. Feed all birds");
        System.out.println("6. Feed all fish");
        System.out.println("7. Swim all fish");
        System.out.println("8. Fly all birds");
        System.out.println("9. Add an animal");
        System.out.println("10. Quit");
    }

    // This is an example of javaDoc comments, you should document all java code this way
    // You'll notice that if you hover over a method in an IDE like VSCode/IntelliJ, 
    // it will show you the documentation for that method. This makes it easier for 
    // you and other developers to understand what your code does without having to
    // read through the entire codebase. When you get to CSE 216 this style of 
    // documentation will also make it so you can automatically generate documentation
    // websites with one command (looks like this: https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html)
    // Some IDEs will also automatically generate this documentation for you
    /** 
     * This method creates a new animal based on user input
     * @param scan the scanner object to get user input
     * @return the new animal object
    */
    private static Animal createNewAnimal(Scanner scan) {
        Animal animal = null;
        System.out.println("Enter the type of the animal");
        System.out.println("1. Bird");
        System.out.println("2. Fish");
        int type = scan.nextInt(); // get the user input

        System.out.println("Enter the name, age, and color");
        String name = scan.next();
        int age = scan.nextInt();
        String color = scan.next();

        if (type == 1) {
            System.out.println("Can the bird fly? (true/false)");
            boolean canFly = scan.nextBoolean();
            animal = new Bird(name, age, color, canFly); // instantiate a new bird
        } else if (type == 2) {
            System.out.println("Can the fish swim? (true/false)");
            boolean canSwim = scan.nextBoolean();
            animal = new Fish(name, age, color, canSwim); // instantiate a new fish
        } 
        
        return animal;
    }
}