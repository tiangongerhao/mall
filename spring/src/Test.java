import com.test.config.FirstDao;
import com.test.service.FirstService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by yyb on 2017/9/12 0012.
 */
public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext cxt = new ClassPathXmlApplicationContext("spring-config.xml");
        FirstService fs = cxt.getBean(FirstService.class);
        System.out.println(fs.print());
    }
}
