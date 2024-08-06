/**
 * The Fish class is a class that represents a Fish.
 * It is a subclass (extends) of the Animal class.
 * This means it inherits all the fields and methods of the Animal class.
 * @author Julian Chattopadhyay
 * @version 1.0
 */
public class Fish extends Animal {
    private boolean canSwim;

    /**
     * This is the constructor for the Fish class
     * @param name The name of the fish
     * @param age The age of the fish
     * @param color The color of the fish
     * @param canSwim Whether the fish can swim or not
     */
    public Fish(String name, int age, String color, boolean canSwim) {
        super(name, age, color);
        this.canSwim = canSwim;
    }

    /**
     * Setter method for the canSwim variable
     * @param canSwim Whether the fish can swim or not
     */
    public void setCanSwim(boolean canSwim) {
        this.canSwim = canSwim;
    }

    /**
     * Getter method for the canSwim variable
     * @return Whether the fish can swim or not
     */
    public boolean getCanSwim() {
        return canSwim;
    }

    /**
     * This method makes the fish swim
     */
    public void swim() {
        if (canSwim) {
            System.out.println(name + " is swimming");
        } else {
            System.out.println(name + " is not able to swim");
        }
    }

    /**
     * This method overrides the toString method in the Animal class
     * @return A string representation of the fish
     */
    public String toString() {
        // super.toString() calls the toString method in the superclass (Animal)
        return super.toString() + ", Can Swim: " + canSwim;
    }
}
