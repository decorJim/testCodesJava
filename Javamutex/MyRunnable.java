

public class MyRunnable implements Runnable {

    public MyRunnable() {}

    public void run() {
       
        try {
            while (true) {
                Zigzag.sem.acquire();
                System.out.println(" ".repeat(Zigzag.compteur) + Thread.currentThread().getId());
                if (Zigzag.direction) {
                    Zigzag.semCounter.acquire();
                    Zigzag.sem.release();
                    Zigzag.compteur++;
                    if (Zigzag.compteur == 5) {
                        Zigzag.direction = false;
                    }
                    Zigzag.semCounter.release();
                } else {
                    Zigzag.semCounter.acquire();
                    Zigzag.sem.release();
                    Zigzag.compteur--;
                    Zigzag.semCounter.release();
                    if (Zigzag.compteur == 0) {
                        Zigzag.direction = true;
                    }
                    Zigzag.semCounter.release();
                }
                Thread.sleep(100);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
