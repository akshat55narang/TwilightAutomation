package customwait;

import org.openqa.selenium.WebDriverException;

import java.util.concurrent.TimeUnit;

public class AssertEventually {

    public static void assertEventually(long timeout, long pause, Runnable runnable) {
        long start = System.currentTimeMillis();
        long end = start + TimeUnit.SECONDS.toMillis(timeout);
        while (System.currentTimeMillis() <= end) {
            try {
                runnable.run();
                return;
            } catch (WebDriverException | AssertionError exception) {
                try {
                    Thread.sleep(TimeUnit.SECONDS.toMillis(pause));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
