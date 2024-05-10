package restaurant;

public class Meal {
    protected String name;
    protected String protein;
    protected String carbs;
    protected String fats;

    public Meal(){}


    public Meal(String name, String protein, String carbs, String fats) {
        this.name = name;
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
    }

    public String getName() {
        return name;
    }

    public String getProtein() {
        return protein;
    }

    public String getCarbs() {
        return carbs;
    }

    public String getFats() {
        return fats;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "name='" + name + '\'' +
                ", protein='" + protein + '\'' +
                ", carbs='" + carbs + '\'' +
                ", fats='" + fats + '\'' +
                '}';
    }
}
