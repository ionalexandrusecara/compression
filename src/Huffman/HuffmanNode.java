package Huffman;

public class HuffmanNode implements Comparable<HuffmanNode>{
    public int frequency;
    public char data;
    public HuffmanNode left;
    public HuffmanNode right;

    public HuffmanNode(int freq, char d, HuffmanNode left, HuffmanNode right){
        frequency = freq;
        data = d;
        this.left = left;
        this.right = right;
    }

    /*public int compareTo(HuffmanNode node){
        return frequency - node.frequency;
    }*/

    public int compareTo(HuffmanNode node){
        /*if(node.right == null && node.left == null && left == null && right == null){
            //System.out.println("@@@ " + node.toString());
            //System.out.println("@@@ " + frequency + " : " + data);
            return frequency - node.frequency;
        }*/
        if(frequency == node.frequency){
            return 1;
        } else {
            return frequency - node.frequency;
        }
    }

    /*public int compareTo(HuffmanNode node){
        if(frequency == node.frequency){
            return node.data - data;
        } else {
            return frequency - node.frequency;
        }
    }*/

    public String toString(){
        if(left==null && right == null){
            return "F: " + frequency + " D: " + data + " L: " + null + " R: " + null;
        } else {
            return "F: " + frequency + " D: " + data + " Left Node: " + left.toString() + " Right Node: " + right.toString();
        }

    }

}
