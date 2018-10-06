package lt.vianet.tomcat;

import lt.vianet.tomcat.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {

    /**
     * Simply selects the home view to render by returning its name.
     */

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
    
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate );

        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Locale locale, Model model) {
        return "login";
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String login(@Validated User user, Model model) {
        model.addAttribute("userName", user.getUserName());
        return "user";
    }
}










/*

@Controller
public class ControllerServlet {

    private static final String VIEW_INDEX = "index";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap modelMap) {

        modelMap.addAttribute("message", "");

        return VIEW_INDEX;

    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String welcomeName(@PathVariable String name, ModelMap modelMap){

        modelMap.addAttribute("message", "Welcome " + name);

        return VIEW_INDEX;
*/


//        https://www.journaldev.com/2433/spring-mvc-tutorial
//      https://crunchify.com/simplest-spring-mvc-hello-world-example-tutorial-spring-model-view-controller-tips/
//      https://www.mkyong.com/ant/ant-spring-mvc-and-war-file-example/

//      The helloWorld() method returns ModelAndView object. The ModelAndView object tries to resolve to a view
//      named “welcome” and the data model is being passed back to the browser so we can access the data within the JSP.
//      The logical view name will resolve to /WEB-INF/jsp/welcome.jsp . Logical name “welcome” which is return
//      in ModelAndView object is mapped to path /WEB-INF/jsp/welcome.jsp.

//      The ModelAndView object also contains a message with key “message” and Detailed value.
//      This is the data that we are passing to our view. Normally this will be a value object in form
//      of java bean that will contain the data to be displayed on our view. Here we are simply passing a string.


//
//    }
//}