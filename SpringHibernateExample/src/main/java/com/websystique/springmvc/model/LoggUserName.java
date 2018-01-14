package com.websystique.springmvc.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
//@Scope("singleton")
//@Scope("prototype")
//@Scope("global")
public class LoggUserName {
	
	
	private String loginuser;

	public String getLoginuser() {
		return loginuser;
	}

	public void setLoginuser(String loginuser) {
		this.loginuser = loginuser;
	}

	public LoggUserName(String loginuser) {
		super();
		this.loginuser = loginuser;
	}

	public LoggUserName() {
		super();
	}

	@Override
	public String toString() {
		return "LoggUserName [loginuser=" + loginuser + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loginuser == null) ? 0 : loginuser.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoggUserName other = (LoggUserName) obj;
		if (loginuser == null) {
			if (other.loginuser != null)
				return false;
		} else if (!loginuser.equals(other.loginuser))
			return false;
		return true;
	}

}
