/**
 * Created by ias4 on 21/09/17.
 */
public class Node extends Tree{
    public final Tree left, right; // subtrees

    public Node(Tree l, Tree r) {
        super(l.frequency + r.frequency, l.value);

        left = l;
        right = r;
    }
}
