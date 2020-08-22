import java.util.Arrays;
import java.util.LinkedList;

final class Immutable{
    private final String str;
    private final LinkedList<Integer> list;

    // Constructor
    public Immutable(String str, LinkedList<Integer> list){
        this.str= str;
        this.list= (LinkedList <Integer>) list.clone();
    }

    public String getStr() {
        return str;
    }

    public LinkedList <Integer> getList() {
        return (LinkedList <Integer>) list.clone();

    }

    public static void main(String[] args) {
        LinkedList<Integer> llll = new LinkedList <>(Arrays.asList(1, 2, 3, 4, 5, 3));
        Immutable immutable = new Immutable("Sanjay",llll );

        LinkedList <Integer> list1 = immutable.getList();
        list1.add(12345);
        System.out.println("object in get" + immutable.getList());
        System.out.println("object in get" + list1);

        list1.add(1234567890);

        System.out.println("object in get" + immutable.getList());
        System.out.println("object in get" + list1);


    }

}