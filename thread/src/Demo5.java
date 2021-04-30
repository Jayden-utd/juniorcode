/**
 * @Description:
 * @author: Jayden
 * @date:4/23/21 10:59 PM
 */
public class Demo5 {
    public static void main(String[] args) {
        Thread t = new Thread(new MyThread());
        t.start(); // 启动新线程

        System.out.println(Thread.currentThread().getName());
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("start new thread!");
    }
}
