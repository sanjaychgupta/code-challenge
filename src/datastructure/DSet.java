package datastructure;

import org.junit.*;
import org.junit.runner.*;

public class DSet {

    @Test
    public void testNoop() {
        Set s = new Set();

        Assert.assertEquals(s.add(2),0 );
        Assert.assertEquals(s.getSize(),1 );
        Assert.assertEquals(s.add(3),1 );
        Assert.assertEquals(s.getSize(),2);
        Assert.assertEquals(s.add(3),-1 );
        Assert.assertEquals(s.getSize(),2);
    }

    @Test
    public void testIsDuplicate() {
        Set s = new Set();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);

        Assert.assertEquals(s.isDuplicate(4),true);
        Assert.assertEquals(s.isDuplicate(5),false);
    }

     class Set {
        int arr[];
        int iniSize = 20;
        int size;
        public Set(){
            arr= new int[iniSize];
            size=0;
        }
        int getSize(){
            return size;
        }

        int add(int i){
            if(size==0){
                arr[0]=i;
                size++;
                return 0;
            }else{
                if(isDuplicate(i)){
                    return -1;
                }
                else{
                    arr[size]=i;
                    size++;
                    return size-1;
                }

            }

        }

        boolean isDuplicate(int val){
            for (int i = 0; i<size;i++){
                if(arr[i] == val)
                    return true; // if dublicate exist
            }
            return false;

        }
    }

    public static void main(String[] args) {

        JUnitCore.main("DSet");
        System.out.println("Done!.....");
    }
}