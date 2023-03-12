package HabrTasks;

public class Equation {


    public static double F(double x) {
        return Math.cos(Math.pow(x, 5)) + (Math.pow(x, 4)) - (345.3 * x) - 23;
    }

    public static void solve(double l, double r, double eps) {

        double c = (l + r) / 2;

        if (r - l > eps) {

            if (Math.signum(F(l)) != Math.signum(F(c))) {
                r = c;
            } else {
                l = c;
            }

            solve(l, r, eps);

        } else if (r - l <= eps) {
            System.out.println(c);
        }


    }

}
