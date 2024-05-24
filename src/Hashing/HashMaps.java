package Hashing;

import java.util.*;

public class HashMaps {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 120);
        map.put("China", 150);
        map.put("USA", 30);
        map.put("India", 140);

        if (map.containsKey("India")) {
            System.out.println("India population is: " + map.get("India"));
        } else {
            System.out.println("India is not present");
        }

//        Iterator i = map.entrySet().iterator();
//        while(i.hasNext()){
//            System.out.println(i.next());
//            // hs.add(i.next().getValue());
//        }
//        map.remove("China");
//        for (Map.Entry<String, Integer> element : map.entrySet()) {
//            System.out.print(element.getKey() + " : ");
//            System.out.println(element.getValue());
//        }
        for(String ele: map.keySet()){
            System.out.println(ele);
        }
        for(Integer ele: map.values()){
            System.out.println(ele);
        }
    }
}
