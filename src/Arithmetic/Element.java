package Arithmetic;

public class Element {
    private char value;
    private double probability;
    private double low, high;
    private double lowBinary, highBinary;

    public Element(char val, double prob){
        value = val;
        probability = prob;
    }

    public char getValue() {
        return value;
    }

    public double getProbability() {
        return probability;
    }

    public double getLow() {
        return low;
    }

    public double getHigh() {
        return high;
    }

    public double getLowBinary() {
        return lowBinary;
    }

    public double getHighBinary() {
        return highBinary;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public void setLowBinary(double lowBinary) {
        this.lowBinary = lowBinary;
    }

    public void setHighBinary(double highBinary) {
        this.highBinary = highBinary;
    }

    public void setInterval(double l, double h){
        low = l;
        high = h;
    }

    public String toString(){
        return "V: " + value + "| P: " + probability + "| L: " + low + "| H: " + high + "| LB: " + lowBinary + "| HB: " + highBinary;
    }
}
