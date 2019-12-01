public class Challenge {
    static void solve(double meal_cost, int tip_percent, int tax_percent) {
        System.out.println(Math.round(meal_cost + (meal_cost * (tip_percent + tax_percent)/ 100)));
    }
    public static void main(String[] args) {

    }
}
