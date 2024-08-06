/**
 * The Bird class is a class that represents a Bird.
 * It is a subclass (extends) of the Animal class.
 * This means it inherits all the fields and methods of the Animal class.
 * @author Julian Chattopadhyay
 * @version 1.0
 */
public class Bird extends Animal {
    private boolean canFly;

    /**
     * This is the constructor for the Bird class
     * @param name The name of the bird
     * @param age The age of the bird
     * @param color The color of the bird
     * @param canFly Whether the bird can fly or not
     */
    public Bird(String name, int age, String color, boolean canFly) {
        super(name, age, color); // super calls the corresponding constructor (or method) in the superclass (Animal)
        this.canFly = canFly;
    }

    /**
     * Setter method for the canFly variable
     * @param canFly Whether the bird can fly or not
     */
    public void setCanFly(boolean canFly) {
        this.canFly = canFly;
    }

    /**
     * Getter method for the canFly variable
     * @return Whether the bird can fly or not
     */
    public boolean getCanFly() {
        return canFly;
    }

    /**
     * This method makes the bird fly
     */
    public void fly() {
        if (canFly) {
            System.out.println(name + " is flying");
        } else {
            System.out.println(name + " is not able to fly");
        }
    }
    
    /**
     * This method overrides the toString method in the Animal class
     * @return A string representation of the bird
     */
    public String toString() {
        // super.toString() calls the toString method in the superclass (Animal)
        return super.toString() + ", Can Fly: " + canFly;
    }
}
