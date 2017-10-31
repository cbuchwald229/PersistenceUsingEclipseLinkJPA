package beans;

//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartProgram
{
	public static void main(String[] args)
	{
		//AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans/beans.xml");
		
		AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
		
		System.out.println("Before money transfer");
		System.out.println("Account 1 Balance: " + accountService.getAccount(1).getBalance());
		System.out.println("Account 2 Balance: " + accountService.getAccount(2).getBalance());
		
		accountService.transferMoney(1,  2,  5);
		
		System.out.println("After money transfer");
		System.out.println("Account 1 Balance: " + accountService.getAccount(1).getBalance());
		System.out.println("Account 2 Balance: " + accountService.getAccount(2).getBalance());
	}
}
