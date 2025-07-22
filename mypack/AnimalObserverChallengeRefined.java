import java.util.*;

public class AnimalObserverChallengeRefined {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Animal> animals = new HashSet<>();

        System.out.print("Enter the name of the animal >> ");
        String animalName = scanner.nextLine().trim();

        System.out.println("\nAnimal Types:\nType 1: General animal\nType 2: Bird\nType 3: Penguin");
        System.out.print("Enter the type (number) of the animal >> ");
        int inputType = scanner.nextInt();
        scanner.nextLine(); 

        String animalType;
        Animal animal;

        switch (inputType) {
            case 2 -> {
                animalType = "bird";
                System.out.print("Can it fly (yes or no)? ");
                String response = scanner.nextLine().trim().toLowerCase();
                boolean canFly = response.startsWith("y");

                Bird bird = new Bird(animalName, canFly);
                bird.setType(animalType);
                animals.add(bird);

                Zookeeper.greetAnimal();
                bird.speak();
            }
            case 3 -> {
                animalType = "penguin";
                Penguin penguin = new Penguin(animalName);
                penguin.setType(animalType);
                animals.add(penguin);

                Zookeeper.greetAnimal("Penguin!");
                penguin.speak();
            }
            default -> {
                animalType = "animal";
                animal = new Animal(animalName);
                animal.setType(animalType);
                animals.add(animal);

                Zookeeper.greetAnimal("Animal!");
                animal.speak();
            }
        }

        System.out.println("\nAnimal behaviors:");
        for (Animal a : animals) {
            String type = a.getType().toLowerCase();
            switch (type) {
                case "bird" -> {
                    Bird b = Bird.parseBird(a);
                    b.walk();
                }
                case "penguin" -> Penguin.parsePenguin(a).walk();
            }
            System.out.println(a);
        }

        scanner.close();
    }
}



class Animal {
    private String type = "ANIMAL";
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public String getType() { return type; }

    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }

    public void speak() {
        System.out.println("Animal speaking!");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Animal other)) return false;
        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Animal: " + name;
    }
}

class Bird extends Animal implements Walkable {
    private boolean canFly;

    public Bird(String name, boolean canFly) {
        super(name);
        this.canFly = canFly;
    }

    @Override
    public void walk() {
        System.out.println("Bird walking!");
    }

    @Override
    public void speak() {
        System.out.println("Bird speaking!");
    }

    public boolean getCanFly() { return canFly; }
    public void setCanFly(boolean canFly) { this.canFly = canFly; }

    public static Bird parseBird(Animal animal) {
        return new Bird(animal.getName(), false); // Default: cannot fly
    }

    @Override
    public String toString() {
        return String.format("Bird Name: %s | Can Fly: %b", getName(), canFly);
    }
}

class Penguin extends Animal implements Walkable {
    public Penguin(String name) {
        super(name);
    }

    @Override
    public void walk() {
        System.out.println("Penguin walking!");
    }

    @Override
    public void speak() {
        System.out.println("Penguin speaking!");
    }

    public static Penguin parsePenguin(Animal animal) {
        return new Penguin(animal.getName());
    }

    @Override
    public String toString() {
        return "Penguin Name: " + getName();
    }
}

class Zookeeper {
    public static void greetAnimal() {
        System.out.println("Hello Bird!");
    }

    public static void greetAnimal(String animal) {
        System.out.println("Hello " + animal + "!");
    }
}

interface Walkable {
    void walk();
}
