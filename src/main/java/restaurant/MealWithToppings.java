package restaurant;

public class MealWithToppings implements Meal {
    private Meal decoratedFood;
    private String topping;

    public MealWithToppings(Meal decoratedFood, String topping) {
        this.decoratedFood = decoratedFood;
        this.topping = topping;
    }

    @Override
    public String getName() {
        return decoratedFood.getName();
    }

    @Override
    public String getProtein() {
        return decoratedFood.getProtein();
    }

    @Override
    public String getCarbs() {
        return decoratedFood.getCarbs();
    }

    @Override
    public String getFats() {
        return decoratedFood.getFats();
    }

    @Override
    public String toString() {
        return decoratedFood.toString() + ", added " + topping;
    }
}