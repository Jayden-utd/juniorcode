import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Description:
 * @author: Jayden
 * @date:3/5/21 10:35 AM
 */
//Future使用
public class Demo3 {
    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(4);
        Future<BigDecimal> future = es.submit(new Task("601857"));
        System.out.println(future.get());
        es.shutdown();
    }
    static class Task implements Callable<BigDecimal> {

        public Task(String code) {
        }

        @Override
        public BigDecimal call() throws Exception {
            Thread.sleep(1000);
            double d = 5 + Math.random() * 20;
            return new BigDecimal(d).setScale(2, RoundingMode.DOWN);
        }
    }
}



