package ThreadProblem;

public class DeadLock {
    final static String resource1 = "sanjay";
    final static String resource2 = "gupta";

    public static void main(String args[]) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("TH1R1");
                try {
                    Thread.sleep(1000);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                synchronized (resource2) {
                    System.out.println("TH1R2");
                }

            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("TH2R2");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                synchronized (resource1) {
                    System.out.println("TH2R1");
                }

            }
        });
        t1.start();
        t1.join(); // Solution to remove deadlock
        t2.start();

    }

}