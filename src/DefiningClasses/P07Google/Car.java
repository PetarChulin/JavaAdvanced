package DefiningClassesExercise.P07Google;

public class Car {

    private String model;
    private int speed;

    public Car(String model, int speed) {
        this.model = model;
        this.speed = speed;
    }

    public static Car setCar(Person person, String[] data) {
        String carModel = data[2];
        int speed = Integer.parseInt(data[3]);
        Car car = new Car(carModel, speed);
        person.setCar(car);
        return car;
    }

    public String carInfo() {
        return model + " " + speed;
    }
}
