package 设计题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="https://github.com/Matthew-Han">Matthew Han</a >
 * @date 2021/6/20 6:20 上午
 * @since 1.0
 **/
public class No1600 {

    static class Fuck {

        public String name;
        public boolean death;
        public List<Fuck> children;

        public Fuck(String name) {
            this.name = name;
            this.death = false;
            this.children = new ArrayList<>();
        }
    }

    Fuck fuck;
    Map<String, Fuck> cache;

    public No1600(String kingName) {
        this.cache = new HashMap<>();
        this.fuck = new Fuck(kingName);
        this.cache.put(kingName, fuck);
    }

    public void birth(String parentName, String childName) {
        birth(this.cache.get(parentName), parentName, childName);
    }

    public void birth(Fuck node, String parentName, String childName) {
        Fuck curr = new Fuck(childName);
        node.children.add(curr);
        this.cache.put(childName, curr);
    }

    public void death(String name) {
        this.cache.get(name).death = true;
    }

    public List<String> getInheritanceOrder() {
        ArrayList<String> ans = new ArrayList<>();
        getInheritanceOrder(this.fuck, ans);
        return ans;
    }

    public void getInheritanceOrder(Fuck node, List<String> ans) {
        if (node == null) {
            return;
        }
        if (!node.death) {
            ans.add(node.name);
        }
        for (Fuck child : node.children) {
            getInheritanceOrder(child, ans);
        }
    }


}


