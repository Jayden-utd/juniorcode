/**
 * @Description:
 * @author: Jayden
 * @date:3/4/21 3:33 PM
 */
//守护线程 在JVM中，所有非守护线程都执行完毕后，无论有没有守护线程，虚拟机都会自动退出。
public class Demo1 {
    public static void main(String[] args) {
        Thread t = new Thread1();
        // 如果注释下一行，观察Thread1的执行情况:
        //t.setDaemon(true);
        t.start();
        System.out.println("main: wait 3 sec...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
        }
        System.out.println("main: end.");
    }
    static class Thread1 extends Thread {
        @Override
        public void run() {
            for (;;) {
                System.out.println("Thread-1: running...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}




