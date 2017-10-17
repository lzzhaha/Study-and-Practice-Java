package practice.form_validate;

import com.opensymphony.xwork2.ActionSupport;

public class ValidateAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private User user;
	
	public String execute(){
		return "success";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
