import java.util.ArrayList;

public class Animal {
    private String color;
    private double size;

    public Animal() {
    }

    public Animal(String color, double size) {
        this.color = color;
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
class Dog extends Animal {
    private String breed;
    private boolean pet;
    public Dog() {
    }
    public Dog(String breed , String color , double size , boolean pet) {
        super(color, size);
        this.breed = breed;
        this.pet = pet;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isPet() {
        return pet;
    }

    public void setPet(boolean pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "color is "+getColor()+", size is "+getSize() + "kg , bread is "+getBreed()+" and is "+ (pet ? "pet" : "not pet");
    }
}
class human {
    private String name;
    Dog dog;


    public human(String name) {
        this.name = name;
    }
    ArrayList<Dog> dogs = new ArrayList<>();
    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Dog dog : dogs) {
            sb.append(name).append(" has a dog with the following properties: ").append(dog.toString()).append("\n");
        }
        return sb.toString();
    }
}
 class TestAnimals {
    public static void main(String[] args) {
        Dog dog1 = new Dog("husky", "White", 10.0, true);
        Dog dog2 = new Dog("German", "black", 15.0, false);

        human person = new human("Omar");
        person.addDog(dog1);
        person.addDog(dog2);
        System.out.println(person);
    }
}
