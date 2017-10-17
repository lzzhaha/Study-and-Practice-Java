package practice.intercept;

import java.util.Map;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;		

public class ApplyCode implements Interceptor{
	
	private static final long serialVersionID = 1L;
	
	@Override
	public void destroy(){
		
	}
	
	@Override
	public void init(){
		
	}
	
	@Override 
	public String intercept(ActionInvocation arg) throws Exception{
		
		//obtain the inputCode from session
		Map session = arg.getInvocationContext().getSession();
		
		String code = (String) session.get("code");
		
		
		if(code != null && code.equals("HAHA")){//The inputCode is correct
			
			//Leave it to invoke()
			return arg.invoke();
		}
		
		//Ask the user to apply for a code first
		session.put("messageSession", "Apply for a code first!");
		return "login";
	}
}
