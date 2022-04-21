package chap20;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ServletContextListener02
 *
 */
@WebListener
public class ServletContextListener02 implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ServletContextListener02() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         System.out.println("ServletContextListener02.contextDestroyed() 메소드 실행");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  {
    	System.out.println("ServletContextListener02.contextInitialized() 메소드 실행");
    }
	
}
