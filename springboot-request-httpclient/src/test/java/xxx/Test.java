package xxx;

import com.lix.Application_App;
import com.lix.config.KeyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = Application_App.class)
public class Test {
    @Autowired
    private KeyConfig keyConfig;

   @org.junit.jupiter.api.Test
    public void test() {
       System.out.println(keyConfig.getServiceSecret());
       System.out.println(keyConfig.getUserSecret());

   }
}
