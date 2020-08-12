package ThreadProblem;


public class MultiThreading extends Thread {
    @Override
    public void run() {
        int i = 1;
        while (i <= 5) {
            // put thread sleep at odd values for i
            if ((i & 1) != 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("FIRST way " + i + "th  Iteration for " + Thread.currentThread().getName());
            i++;
        }
    }

    public static void main(String[] args) {
        // Normal way to define logic in run method in side your class which extends Thread .
        MultiThreading mt1 = new MultiThreading();
        MultiThreading mt2 = new MultiThreading();

        mt1.start();
        mt2.start();
        //mt1.run();   // This will run as normal function calling in java by main thread.


        // Another way to define logic which you want to run in single threaded using lambda
        Thread t = new Thread(() -> {
            int i = 1;
            while (i <= 5) {
                // put thread sleep at odd values for i
                if ((i & 1) != 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("SECOND way " + i + "th  Iteration for " + Thread.currentThread().getName());
                i++;
            }
        });
        t.start();

        // Instead of extending Thread  class, we implemented Runnable interface
        Thread R1 = new Thread(new MutliThreading2());
        R1.start();

    }

}

class MutliThreading2 implements Runnable {

    @Override
    public void run() {
        int i = 1;
        while (i <= 5) {
            // put thread sleep at odd values for i
            if ((i & 1) != 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Third way " + i + "th  Iteration for " + Thread.currentThread().getName());
            i++;
        }
    }
}
