package com.cognixia.jumplus.project3.anorthouse.utility;

import com.cognixia.jumplus.project3.anorthouse.model.User;
import jakarta.servlet.http.HttpServletRequest;

public class WebHelperUtil {
	
	public static enum RESULT_CLASS {
		ERROR("is-error"),
		SUCCESS("is-success");
		
		public final String value;
		
		RESULT_CLASS(String value) {
			this.value = value;
		}
	}
	
	public static boolean checkBadLogin(HttpServletRequest request) {
		if (request.getSession(false) == null || request.getSession(false).getAttribute("current_user") == null) {
			destroySession(request);
			return true;
		}
		return false;
	}
	
	public static boolean checkLoggedIn(HttpServletRequest request) {
		if (!(request.getSession(false) == null || request.getSession(false).getAttribute("current_user") == null)) {
			destroySession(request);
			return true;
		}
		return false;
	}
	
	public static void setResult(HttpServletRequest request, RESULT_CLASS resultClass, String error) {
		request.setAttribute("resultClass", resultClass.value);
		request.setAttribute("result", error);
	}
	
	public static void setSessionUser(HttpServletRequest request, User user) {
		request.getSession(true).setAttribute("current_user", user);
	}
	
	public static void destroySession(HttpServletRequest request) {
		try {
			var session = request.getSession(false);
			session.invalidate();
			session = null;
		} catch (NullPointerException e) {
			
		}
	}

}
