package JADVDefiningClasses.P09CatLady;

public class Cat {

    private final String breed;
    private String name;
    private double value;

    @Override
    public String toString() {
        return breed + " " + name + " " + String.format("%.2f", value);
    }

    public Cat(String breed, String name, double value) {
        this.breed = breed;
        this.name = name;
        this.value = value;
    }


    public String getBreed() {
        return breed;
    }
    public String getName() {
        return name;
    }

    public double getValue() {
        return value;
    }

}
