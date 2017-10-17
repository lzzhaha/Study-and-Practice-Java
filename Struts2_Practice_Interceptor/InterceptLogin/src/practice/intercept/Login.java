package practice.intercept;

import java.util.Map;
import com.opensymphony.xwork2.ActionContext;

public class Login {
	
	//The message after successful login
	private String message;
	
	private String inputCode;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getInputCode() {
		return inputCode;
	}

	public void setInputCode(String inputCode) {
		this.inputCode = inputCode;
	}
	
	public String execute() throws Exception{
		
		//obtain session code
		Map map = ActionContext.getContext().getSession();
		
		String code = (String)map.get("code");
		
		if(code != null){
			
			if(getInputCode().equals("") || getInputCode() == null){
				
				map.put("messageSession", "Empty code!");
				
				return "login";
			}
		}else if(!getInputCode().equals(code)){
			map.put("messageSession", "Invalide code!");
			
			return "login";
			
		}else{
			message = "Congratulations! You have logged in!";
			return "success";
		}
		
		message = "Congratulations! You have logged in!";
		return "success";
	}
}
