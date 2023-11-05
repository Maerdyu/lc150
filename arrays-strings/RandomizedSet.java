import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 380. O(1) 时间插入、删除和获取随机元素
 * https://leetcode.cn/problems/insert-delete-getrandom-o1/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class RandomizedSet {

    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random random;

    public RandomizedSet() {
        this.list = new ArrayList<>();
        this.map = new HashMap<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        Integer index = map.get(val);
        if(index != null){
            return false;
        }

        this.list.add(val);
        map.put(val, list.size()-1);
        return true;
    }

    public boolean remove(int val) {
        Integer index = map.get(val);
        if(index == null){
            return false;
        }
        int last = list.get(list.size()-1);
        list.set(index, last);
        list.remove(list.size()-1);
        map.put(last, index);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int nextInt = random.nextInt(list.size());
        return list.get(nextInt);
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(0);
        randomizedSet.insert(1);
        randomizedSet.remove(0);
        randomizedSet.insert(2);
        randomizedSet.remove(1);
        int random2 = randomizedSet.getRandom();
        System.out.println(random2);
    }
}
