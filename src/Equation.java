public class Equation {


    public static double F(double x) {
        return Math.cos(Math.pow(x, 5)) + (Math.pow(x, 4)) - (345.3 * x) - 23;
    }

    public static void solve(double l, double r) {
        double c = (l + r) / 2;
        double eps = 0.001;

        if (F(l) == 0) {
            System.out.println(l);
        }
        if (F(r) == 0) {
            System.out.println(r);
        }


        while (r - l >= eps) {

            c = (l + r) / 2;
            if (Math.signum(F(l)) != Math.signum(F(c))) {
                r = c;
            } else {
                l = c;
            }

        }
        System.out.println(c);
    }

}
