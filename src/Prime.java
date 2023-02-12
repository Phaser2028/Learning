public class Prime {



    public static boolean p(int n) {
        int q = 0;
        int d = 2;

        while (d<n){
            if(n%d==0){
                q++;
            }
            d++;

        }
        return q <= 0;
    }
}