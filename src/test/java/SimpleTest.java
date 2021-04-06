import nowcoder.huawei.R1;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class SimpleTest {
    @Test
    public void haha() throws IOException {
        Class<?>[] classes = R1.class.getDeclaredClasses();
        System.out.println(classes[0].getName());
    }
}
