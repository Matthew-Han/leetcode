package 默认模板;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a>
 * @date 2022/4/29 11:16 29
 * @since 1.0
 **/
public class QuadTree {
    public boolean val;
    public boolean isLeaf;
    public QuadTree topLeft;
    public QuadTree topRight;
    public QuadTree bottomLeft;
    public QuadTree bottomRight;


    public QuadTree() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public QuadTree(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }

    public QuadTree(boolean val, boolean isLeaf, QuadTree topLeft, QuadTree topRight, QuadTree bottomLeft, QuadTree bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }


    @Override
    public String toString() {
        return "QuadTree{" +
                "val=" + val +
                ", isLeaf=" + isLeaf +
                ", topLeft=" + topLeft +
                ", topRight=" + topRight +
                ", bottomLeft=" + bottomLeft +
                ", bottomRight=" + bottomRight +
                '}';
    }
}
