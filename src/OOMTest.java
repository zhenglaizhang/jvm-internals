import java.util.ArrayList;
import java.util.List;

/*
java -Xms100m -Xmx100m -XX:+UseSerialGC -cp /Volumes/ramdisk/Zhenglai/compileroutput/production/jvm-internals/ OOMTest
 */
public class OOMTest {
    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }

    private static void fillHeap(int num) throws InterruptedException {

        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }
}