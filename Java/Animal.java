/**
 * The Animal class is an abstract class that represents an animal.
 * @author Julian Chattopadhyay
 * @version 1.0
 */
public abstract class Animal implements Comparable<Animal> {
    // An abstract class allows you to define a class that other classes can inherit from
    // but you can't create an instance of the abstract class itself.
    // Think about how this is useful in this scenario. We want the fish and bird to have
    // all these properties and methods, but we don't want to create an instance of an animal.
    // Why? Well simply put, there is no such species called an Animal, but we do have fish and birds

    // These variables are protected because we want the subclasses to be able to access them
    // but not the outside world
    protected String name;
    protected int age;
    protected String color;

    /**
     * This is the constructor for the Animal class
     * @param name The name of the animal
     * @param age The age of the animal
     * @param color The color of the animal
     */
    public Animal(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    /**
     * Setter method for the name variable
     * @param name The name of the animal
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Setter method for the age variable
     * @param age The age of the animal
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Setter method for the color variable
     * @param color The color of the animal
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Getter method for the name variable
     * @return The name of the animal
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for the age variable
     * @return The age of the animal
     */
    public int getAge() {
        return age;
    }

    /**
     * Getter method for the color variable
     * @return The color of the animal
     */
    public String getColor() {
        return color;
    }

    /**
     * This method makes the animal eat
     * It doesn't do anything right now, but you could create a hunger value
     * and update it when this method is called
     */
    public void eat() {
        System.out.println(name + " is eating");
    }

    /**
     * This method is required to implement the Comparable interface
     * It compares the age of two animals
     * @param animal The animal to compare to
     * @return 1 if this animal is older, -1 if the animal is younger, 0 if they are the same age
     */
    public int compareTo(Animal animal) {
        if (animal == null) return 1;
        if (age > animal.getAge()) return 1;
        if (age < animal.getAge()) return -1;
        return 0;
    }

    /**
     * Prints out the name, age, and color of the animal
     * @return A string representation of the animal
     */
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Color: " + color;
    }
}
