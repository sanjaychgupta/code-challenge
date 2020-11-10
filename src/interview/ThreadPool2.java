package interview;

import java.util.concurrent.LinkedBlockingQueue;

public class ThreadPool2{
    private final int nThreads;
    private final LinkedBlockingQueue queue;
    private final WorkerPool[] threads;

    public ThreadPool2(int nThreads){
        this.nThreads = nThreads;
        queue = new LinkedBlockingQueue();
        threads = new WorkerPool[nThreads];
        for (int i=0;i<nThreads;i++){
            threads[i]= new WorkerPool();
            threads[i].start();
        }

    }
    public void execute(Runnable task){
        synchronized (queue){
            queue.add(task);
            queue.notify();
        }

    }
    private class WorkerPool extends Thread{
        public void run(){
            Runnable task ;
            while(true){
                synchronized(queue){
                    if(queue.isEmpty()){
                        try{
                            queue.wait();
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                    task = (Runnable)queue.poll();
                }

                try{
                    task.run();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }

        }
    }

    public static void main(String[] args) {
        ThreadPool2 threadPool2 = new ThreadPool2(5);
        for(int i = 0 ; i < 15; i++){
            threadPool2.execute(new Task());
        }
    }
    public static class Task extends Thread{
        public void run(){
            try{
                Thread.sleep(1000);
            }catch(Exception e){
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName());
        }
    }
}
