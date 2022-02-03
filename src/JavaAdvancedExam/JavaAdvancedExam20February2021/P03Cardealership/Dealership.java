package dealership;



import java.util.ArrayList;
import java.util.List;

public class Dealership {

    public String name;
    public int capacity;
    public List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCount() {
        return data.size();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }


    public void add(Car car) {
        if (this.getCapacity() > this.getCount()) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                this.data.remove(car);
                return true;
            }
        }
        return false;
    }


    public Car getLatestCar() {
        int oldestCar = 0;
        int index = 0;

        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getYear() >= oldestCar) {
                index = i;
                oldestCar = this.data.get(i).getYear();
            }
        }
        return this.data.get(index);
    }

    public Car getCar(String manufacturer, String model) {

        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer)
                    && car.getModel().equals(model)) {
                return car;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder build = new StringBuilder();
        build.append(String.format("The cars are in a car dealership %s:\n", getName()));
        for (Car car : data) {
            build.append(car.toString()).append("\n");
        }
        return build.toString();
    }
}
