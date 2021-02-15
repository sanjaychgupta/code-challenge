@FunctionalInterface
public interface MyFuctionalInterface {
    /* All the methods are public abstract by default
     * As you see they have no body
     */
    void method1();

    default void run() {
        System.out.println("My Interface default method is called from : " + this.getClass());
    }

}