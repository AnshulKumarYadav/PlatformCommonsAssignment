package com.app.Util;

import com.app.Model.Admin;
import com.app.Model.CurrentAdminSession;

public interface GetAdminCurrentSession {
	
    public CurrentAdminSession getCurrentAdminSession(String key);
	
	public Integer getCurrentAdminSessionAdminId(String key);
	
	public Admin getCurrentAdmin(String key);

}
