/**
 * @Description:
 * @author: Jayden
 * @date:3/4/21 6:29 PM
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//wait notify 的使用
public class Demo2 {

    public static void main(String[] args) throws InterruptedException {
        TaskQueen q = new TaskQueen();
        List<Thread> rList = new ArrayList<Thread>();
        for (int i = 0; i < 5; i++) {
            var getT = new Thread("threadGet" + i) {
                @Override
                public void run() {
                    while (true) {
                        try {
                            System.out.println("开启线程" + Thread.currentThread().getName());
                            String s = q.getTask();
                            System.out.println(Thread.currentThread().getName() + "线程-获取的东东是：" + s);
                        } catch (InterruptedException e) {
                            System.out.println(Thread.currentThread().getName() + "线程被阻断，执行结束……");
                            return;//被阻断就结束该线程
                        }
                    }
                }
            };
            getT.start();
            rList.add(getT);
        }

        var add = new Thread("athread") {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    String s = "add-" + Math.random();
                    q.addTask(s);
                }
            }
        };

        add.start();
        add.join();
        Thread.sleep(100);
        for (int i = 0; i < rList.size(); i++) {
            rList.get(i).interrupt();
        }
    }
    static class TaskQueen {
        Queue<String> s = new LinkedList();

        public synchronized String getTask() throws InterruptedException {
            while (s.isEmpty()) {
                System.out.println("线程进入等待：" + Thread.currentThread().getName());
                this.wait();
                System.out.println("线程被唤醒之后：" + Thread.currentThread().getName());
            }
            System.out.println("getTask-当前正在消费的线程：" + Thread.currentThread().getName());
            return s.remove();
        }

        public synchronized void addTask(String a) {
            s.add(a);
            System.out.println("addTask-正在加加加，当前线程是：" + Thread.currentThread().getName());
            this.notifyAll();//唤醒这个锁的所有等待的对象
        }
    }
}



