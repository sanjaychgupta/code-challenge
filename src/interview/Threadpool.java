package interview;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Threadpool {
    private final int nThreads;
    private final LinkedBlockingQueue queue;
    private final PoolWorker[] threads;
    private  Boolean isRun = true;
    public Threadpool(int nThreads){
        this.nThreads=nThreads;
        queue = new LinkedBlockingQueue();
        threads=new PoolWorker[nThreads];
        for (int i = 0; i < nThreads; i++) {
            threads[i] = new PoolWorker();
            threads[i].setName("Threadpool-" + (i+1));
            threads[i].start();
        }
    }

    public void execute(Runnable task){
        synchronized (queue){
            queue.add(task);
            queue.notify();
        }
    }


   private class PoolWorker extends Thread{

        public void run(){
            Runnable task;
            while(isRun){
                synchronized (queue){
                    if(queue.isEmpty()){
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    task= (Runnable) queue.poll();
                }
                task.run();
            }
        }

   }

    public static void main(String[] args) {



        // My executor pool
        Threadpool threadpool = new Threadpool(3);
        for (int i = 0; i < 12; i++) {
            Task task = new Task("[MyTP]");
            threadpool.execute(task);
        }

    }

    public static class Task extends Thread{
        String  taskName;
        public Task( String  taskName){
            this.taskName =  taskName;
        }
        public void run(){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(taskName + " " + Thread.currentThread().getName());
        }

    }
}
