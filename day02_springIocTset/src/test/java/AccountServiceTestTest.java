import com.itheima.config.SpringConfigruation;
import com.itheima.domain.Account;
import com.itheima.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class AccountServiceTestTest {
    @Test
    public void findAll() {

        //ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext ac=new AnnotationConfigApplicationContext(SpringConfigruation.class);
        IAccountService accountService = (IAccountService) ac.getBean("accountService");
        List<Account> allAccount = accountService.findAllAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }


    }
}