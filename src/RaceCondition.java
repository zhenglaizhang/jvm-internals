/**
 * Created by Zhenglai on 7/26/16.
 */
public class RaceCondition {

    // we need volatile here to prevent race condition
    // the result depends on the jvm client/server class for JIT optimization
    private static boolean done;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            int i = 0;
            while (!done) {
                i++;
            }
            System.out.println("Done!");
        }).start();

        System.out.println("OS: " + System.getProperty("os.name"));
        Thread.sleep(2000);
        done = true;
        System.out.println("flag done set to true");
    }
}
