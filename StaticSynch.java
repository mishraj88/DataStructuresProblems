/**
 * Created by jmishra on 02-07-2017.
 */
public class StaticSynch {
    public  synchronized static void sm(){
        System.out.println("static");
    }
    public synchronized void m(){
        System.out.println("non-static");
    }
    public static void main(String args[]){
        StaticSynch s1 = new StaticSynch();
        StaticSynch s2 = new StaticSynch();
        Thread t1 = new Thread(){
            public void run(){
                s1.sm();
            }
        };

        Thread t2 = new Thread(){
            public void run(){
                System.out.println("Thread: "+Thread.currentThread().getName());
                s1.m();
            }
        };
        t1.start();
        t2.start();
    }
}
