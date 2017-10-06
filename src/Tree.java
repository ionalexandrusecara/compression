public class Tree implements Comparable<Tree>{
        public final int frequency; // the frequency of this tree
        public final char value;

        public Tree(int freq, char val) {
            frequency = freq;
            value = val;
        }

        // compares on the frequency
        public int compareTo(Tree tree) {
            return frequency - tree.frequency;
        }

        public String toString(){
            return value + " " + frequency;
        }
}
