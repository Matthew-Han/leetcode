import java.util.Arrays;

/**
 * @ClassName DesignHashSet
 * @Description #705 设计哈希集合
 * @Author MatthewHan
 * @Date 2019/8/8 19:23
 * @Version 1.0
 **/
public class DesignHashSet {

    int[] data = null;

    public static void main(String[] args) {

        DesignHashSet hashSet = new DesignHashSet();
        hashSet.add(1);
        hashSet.add(1);
        hashSet.add(2);
        hashSet.contains(1); // 返回 true
        hashSet.contains(3); // 返回 false (未找到)
        hashSet.add(2);
        hashSet.contains(2); // 返回 true
        hashSet.contains(2); // 返回  false (已经被删除)
        System.out.println(hashSet);

    }

    /**
     * Initialize your data structure here.
     */
    public DesignHashSet() {
        data = new int[1000001];
        for (int i = 0; i < data.length; i++) {
            data[i] = -1;
        }
    }

    public void add(int key) {
        data[key] = key;
    }

    public void remove(int key) {
        data[key] = -1;
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        return data[key] != -1;
    }

    @Override
    public String toString() {
        return "DesignHashSet{" +
                "data=" + Arrays.toString(data) +
                '}';
    }

}

/*
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */