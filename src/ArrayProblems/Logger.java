package ArrayProblems;

import java.lang.reflect.Constructor;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Logger {
    private Logger() {
        // private constructor
    }

    // static inner class - inner classes are not loaded until they are
    // referenced.
    private static class LoggerHolder {
        private static Logger logger = new Logger();
    }


    // global access point
    public static Logger getInstance() {
        return LoggerHolder.logger;
    }

    //Other methods

    private static void loggerSingletonBreak() {
        Logger instance1 = Logger.getInstance();
        Logger instance2 = null;
        Logger instance3 = null;
        try {
            Constructor[] cstr = Logger.class.getDeclaredConstructors();
            Constructor constructor = instance1.getClass().getDeclaredConstructor();
            cstr[1].setAccessible(true);
            constructor.setAccessible(true);
            instance2
                    = (Logger) cstr[1].newInstance();
            instance3
                    = (Logger) constructor.newInstance();

        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
        System.out.println(instance3.hashCode());
        System.out.println(instance1 == (instance2));
    }

    public static void binaryAdd(long binary1, long binary2){
        int remainder=0;
        List<Integer> sum = new ArrayList<>();
        while(binary1 != 0 || binary2 != 0){
            int temp = (int)(binary1%10+binary2%10+remainder);
            sum.add(temp%2);
            remainder=temp/2;
            binary1/=10;
            binary2/=10;

        }
        if (remainder != 0) {
            sum.add(remainder);
        }
        Collections.reverse(sum);
        sum.forEach(System.out::print);
    }

    public enum SingletonEnum {
        INSTANCE;
        int value;

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public enum Denomination {
        ONE_HUNDRED(100.00f),
        FIFTY(50.00f),
        TWENTY(20.00f),
        TEN(10.00f),
        FIVE(5.00f),
        TWO(2.00f),
        ONE(1.00f),
        HALF_DOLLAR(0.50f),
        QUARTER(0.25f),
        DIME(0.10f),
        NICKEL(0.05f),
        PENNY(0.01f);

        private final float value;
        private final String description;

        Denomination(float value) {
            this.value = value;
            this.description = this.name().replace("_", " ");
        }

        public float getValue() {
            return this.value;
        }

        @Override
        public String toString() {
            return this.description;
        }
    }

    public static boolean oddOrNot(int num) {
        return (num & 1) != 0;
    }
    public static void addBinary(long binary1, long binary2){
        int remainder = 0;
        StringBuilder sum = new StringBuilder();
        while (binary1 != 0 || binary2 != 0)
        {
            sum= sum.append((binary1 % 10 + binary2 % 10 + remainder) % 2);
            remainder = (int)((binary1 % 10 + binary2 % 10 + remainder) / 2);
            binary1 = binary1 / 10;
            binary2 = binary2 / 10;
        }
        if (remainder != 0) {
            sum.append(remainder);
        }
        sum.reverse();

            System.out.print(sum);

    }

    public static void main(String[] args) {
        System.out.println("binary addition");
        String input="1111,1111";
        String s[]=input.split(",");
        binaryAdd(Long.parseLong(s[0]),Long.parseLong(s[1]));
        System.out.println();
        addBinary(Long.parseLong(s[0]),Long.parseLong(s[1]));
        System.out.println();
        System.out.println("My Practise ++++ SINGLETON ");
        System.out.println(Logger.getInstance());
        System.out.println(Logger.getInstance());
        System.out.println(Logger.getInstance());
        Logger.loggerSingletonBreak();
        System.out.println(Denomination.values()[0].getValue());

        //String Practise
        String s1 = "Joey";
        String s2 = "Joe" + "y";
        String s3 = new String("Joey").intern();
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());
        System.out.println(s2 == s3);


        System.out.println("My Practise ++++ COLLECTION");

        Map m = new HashMap <String, Integer>();
        m.put("qwer", 1);
        m.put("qwer1", 2);
        m.put("qwer2", 3);
        m.forEach((k, v) -> System.out.println("Key = " + k + " Value = " + v));

        List <String> list = new ArrayList <>();
        list.add("aaa");
        list.add("asdfghjkl");
        list.add("qwertyuio");
        list.add("zxcvbnm");
        list.add("123456");
        list.add("qqq");
        list.add("aaa");

        list.forEach(new Consumer <String>() {

            @Override
            public void accept(String t) {
                System.out.print(t + " ------> ");
            }
        });
        System.out.println();

        list.parallelStream().
                filter(e -> e.length() > 3).collect(Collectors.toList()).forEach(e -> System.out.print(e + " ------> "));
        System.out.println();

        list.stream().filter(e -> e.length() > 3).collect(Collectors.toList()).forEach(e -> System.out.print(e + " ------> "));
        System.out.println();


        System.out.println("My Practise");
        Derived d = new Derived();
        d.get();
        d.get(1);
        d.get("sanjay");
        String temp = "Lambada is interesting thing i am learning in java 8 on ward i am happy";

        Lambdable lambdable = (e) -> {
            System.out.println(e);
            System.out.println("next new line");
        };
        lambdable.runLambda(temp);
        Lambdable.print("qwertyuiop");

        HashMapConcurrentDemo.task();

        Map <String, String> map = new HashMap <>();
        map.put("C", "c");
        map.put("B", "b");
        map.put("Z", "z");
        map.put("A", "a");
        List <Map.Entry <String, String>> sortedByKey = map.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toList());
        sortedByKey.forEach(System.out::println);

        String val = map.getOrDefault("D", "Nah!");
        System.out.println(val); // prints Nah!


        // Iterator
        List <String> words = new ArrayList <>(Arrays.asList("pen", "dog", "pencil",
                "sky", "blue", "sky", "dog"));
        Iterator <String> i = words.iterator();
        while (i.hasNext()) {
            String str = i.next();

            if ("sky".equals(str)) {
                i.remove();
            }
        }
        System.out.println(words);


        words.stream().filter(e -> !e.equals("dog")).collect(Collectors.toList()).forEach(System.out::println);


        Lambdable l = new Base("123");
        l.runLambda("234");


    }


}

@FunctionalInterface
interface Lambdable<T> {
    void runLambda(T t);

    static void print(String str) {
        System.out.println("Printing " + str);
    }

}


class Base implements Lambdable {
    private Base() {
    }

    public Base(String s) {

    }

    public void get() {
        System.out.println("Base");
    }

    public void get(Integer num) {
        System.out.println("Base " + num);
    }

    public void get(String name) {
        System.out.println("Base " + name);
    }

    @Override
    public void runLambda(Object o) {
        System.out.println("implemented method in base");
    }
}

class Derived extends Base {
    public Derived() {
        super("qwertyui");

    }

    public void get() {
        System.out.println("Derived");
    }

    public void get(Integer num) {
        System.out.println("Derived " + num);
    }

}

class HashMapDemo extends Thread {
    static HashMap <Integer, String> l = new HashMap <Integer, String>();

    public void run() {
        try {
            Thread.sleep(1000);
            // Child thread trying to add
            // new element in the object
            l.put(103, "D");
        } catch (InterruptedException e) {
            System.out.println("Child Thread going to add element");
        }
    }

    public static void task() {
        l.put(100, "A");
        l.put(101, "B");
        l.put(102, "C");
        HashMapDemo t = new HashMapDemo();
        t.start();

        for (Object o : l.entrySet()) {
            Object s = o;
            System.out.println(s);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(l);
    }
}

class HashMapConcurrentDemo extends Thread {
    static ConcurrentHashMap <Integer, String> l =
            new ConcurrentHashMap <Integer, String>();

    public void run() {

        // Child add new element in the object
        l.put(103, "D");

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("Child Thread going to add element");
        }
    }

    public static void task() {
        l.put(100, "A");
        l.put(101, "B");
        l.put(102, "C");
        HashMapConcurrentDemo t = new HashMapConcurrentDemo();
        t.start();

        for (Object o : l.entrySet()) {
            Object s = o;
            System.out.println(s);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(l);
    }
}
