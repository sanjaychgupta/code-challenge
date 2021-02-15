package datastructure;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class FirstUnique {

    @Test
    public void findFirstUniqueTest(){
        FirstUnique s = new FirstUnique();
        List <Integer> list = new ArrayList();
        Assert.assertEquals(Integer.valueOf(-1),s.findFirstUnique(list));

        list = new ArrayList(Arrays.asList(2,3,5,5));
        Assert.assertEquals((Integer) 2,s.findFirstUnique(list) );

        list = new ArrayList(Arrays.asList(2,3,5,5,2));
        Assert.assertEquals((Integer) 3,s.findFirstUnique(list) );

        list = new ArrayList(Arrays.asList(2,3,5,5,2,3));
        Assert.assertEquals(Integer.valueOf(-1),s.findFirstUnique(list) );



    }
    public Integer findFirstUnique(List <Integer> list) {
        if(list.isEmpty()){
            return -1;
        }
        Map <Integer, Boolean> map = new HashMap <>();
        for (Integer element : list) {
            if(!map.containsKey(element)){
                map.put(element,false);
            }else {
                map.put(element,true);
            }
        }
        for (Integer element : list) {
            if(map.get(element) == false){
                return element;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUnique firstUnique = new FirstUnique();
        List <Integer> list = new ArrayList (Arrays.asList(2,3,5,5,3,2));
        System.out.println(firstUnique.findFirstUnique(list));
    }
}
