import java.util.concurrent.Semaphore;

public class Zigzag {

    public static Semaphore sem; // access to function
    public static Semaphore turn; 
    public static Semaphore semCounter; 
    public static boolean direction = true;

    public static int compteur = 0;

    public static void main(String[] args) {
        sem=new Semaphore(1);
        semCounter=new Semaphore(1);
        Thread threads[]=new Thread[4];
        
        for(int i=0;i<4;i++) {
            threads[i]=new Thread(new MyRunnable());
            threads[i].setName(String.valueOf(i));
            threads[i].start();
        }

        /*for(int i=0;i<4;i++) {
            threads[i].run();
        }
        */
       
        /*for (int j = 0; j< 4; j++) {
           try {
                threads[j].join(); //todo add catch exception
           }
           catch(InterruptedException e) {}
        
        }
        */
        
        
        
    }
}

