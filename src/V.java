import java.util.Vector;

public class V {

    private double y;
    private double z;
    private double x;

    public V(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double l() {
        return Math.sqrt((x * x) + (y * y) + (z * z));
    }

    public double scalar(V v) {
        return v.x * x + v.y * y + v.z * z;
    }

    public V vp(V v) {
        return new V(y * v.z - z * v.y, z * v.x - x * v.z, x * v.y - y * v.x);
    }

    public double cos(V v) {
        return scalar(v) / Math.abs(l() * v.l());
    }

    public V sum(V v) {
        return new V(x + v.x, y + v.y, z + v.z);
    }

    public V sub(V v) {
        return new V(x - v.x, y - v.y, z - v.z);
    }

    public static V[] generate(int n) {
        V[] vectors = new V[n];
        for (int i = 0; i < n; i++) {
            vectors[i] = new V(Math.random(), Math.random(), Math.random());
        }
        return vectors;
    }

    @Override
    public String toString() {
        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }
}
