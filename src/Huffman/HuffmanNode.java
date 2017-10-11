package Huffman;

public class HuffmanNode implements Comparable<HuffmanNode>{
    public int frequency;
    public char data;
    public HuffmanNode left;
    public HuffmanNode right;
    public String code;

    public HuffmanNode(int freq, char d, HuffmanNode left, HuffmanNode right){
        frequency = freq;
        data = d;
        this.left = left;
        this.right = right;
    }

    public int compareTo(HuffmanNode node){
        if(frequency == node.frequency){
            return 1;
        } else {
            return frequency - node.frequency;
        }
    }

    public String toString(){
        if(left==null && right == null){
            return "F: " + frequency + " D: " + data + " L: " + null + " R: " + null;
        } else {
            return "F: " + frequency + " D: " + data + " Left Node: " + left.toString() + " Right Node: " + right.toString();
        }

    }

}
