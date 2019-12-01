import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Problem statement
 * Implement a FIFO queue with limited size.
 *
 * It should support the following commands:
 *
 * SIZE
 * OFFER x
 * TAKE
 * x can be any string.
 *
 * Input
 * N C
 * command 1
 * command 2...
 * Where N is the number of commands (1 <= N <= 10000) and C the capacity of the queue (0 <= C <= 10000).
 *
 * Output
 * For SIZE command, the number of items currently in the queue followed by a newline.
 * For TAKE command, the item taken followed by a newline if the queue was not empty. Nothing otherwise.
 * For OFFER command, "true" if the item was accepted by the queue, or "false" otherwise, followed by a newline.
 * Input example
 * 5 2
 * OFFER hello
 * OFFER world
 * OFFER !
 * TAKE
 * SIZE
 * Output example
 * For the above input,
 *
 * true
 * true
 * false
 * hello
 * 1
 */
public class LineQueueCyclic {
    public static void main (String[] args) throws java.lang.Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] tempArray1 = input.split(" ");
        int N = Integer.parseInt(tempArray1[0]);
        int C = Integer.parseInt(tempArray1[1]);
        Queue q = new Queue(C);
        /**
         * As we are executing only one loop, that is to take input, and then executing any statement
         *         at complexity of O(1),
         *         Only time consuming part of this is to split the input strings in every instance of the loop
         *         But even with that each input goes through one cycle of processing on the Queue Object
         *         So as per my understanding O(n) will be the time complexity of this program where it will increase
         *         linearly with increase of input commands.
         */
        for(int i=0; i<N; i++){
            input = br.readLine();
            String[] tempArray = input.split(" ");
            //System.out.println(tempArray[0]);
            if(tempArray[0].equals("SIZE")){
                System.out.println(q.size());
            }else if(tempArray[0].equals("OFFER")){
                System.out.println(q.offer(tempArray[1]));
            }else if(tempArray[0].equals("TAKE")){
                String taken = q.take();
                if(taken!="-1"){
                    System.out.println(taken);
                }else{
                    continue;
                }
            }
        }

        //System.out.println(input);
    }
}

class Queue
{
    String[] fifoQueue;
    int tail = 0;
    int head = 0;
    Queue(int size)
    {
        fifoQueue = new String[size];
    }

    public int size()
    {
        return (tail-head)>=0?(tail-head):0;
    }

    public boolean offer(String input)
    {
        if(this.tail >=fifoQueue.length){
            return false;
        }else{
            fifoQueue[tail]=input;
            tail++;
            return true;
        }
    }

    public String take(){
        if(fifoQueue[head]!=null){
            head++;
            return fifoQueue[head-1];
        }else{
            return "-1";
        }
    }
}