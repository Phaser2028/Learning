package Stepik;

import java.util.NoSuchElementException;
import java.util.Objects;

class Pair<T,P>{
    private static final Pair<?,?> EMPTY = new Pair<>((Object)null,(Object)null);
    private final T firstValue;
    private final P secondValue;

    private Pair(T firstValue,P secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    public static<T, P> Pair<T, P> of(T key, P value) {
        return new Pair<>(key, value);
    }

    public T getFirst() {
        if (this.firstValue == null) {
            throw new NoSuchElementException("No value present");
        } else {
            return this.firstValue;
        }
    }
    public P getSecond() {
        if (this.secondValue == null) {
            throw new NoSuchElementException("No value present");
        } else {
            return this.secondValue;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else {
            boolean var10000;
            if (obj instanceof Pair) {
                Pair<?,?> other = (Pair)obj;
                if (Objects.equals(this.firstValue, other.firstValue)&&Objects.equals(this.secondValue, other.secondValue)) {
                    var10000 = true;
                    return var10000;
                }
            }

            var10000 = false;
            return var10000;
        }
    }

    public int hashCode() {
        return Objects.hashCode(this.firstValue);
    }
}