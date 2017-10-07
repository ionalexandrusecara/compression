package Arithmetic;

public class Interval {
    public double low;
    public double high;

    public Interval(double l, double h){
        low = l;
        high = h;
    }

    public double getLow() {
        return low;
    }

    public double getHigh() {
        return high;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public void setHigh(double high) {
        this.high = high;
    }
}
