package com.dxc.FactoryDesign;

import com.dxc.service.StudentService;

public class ServiceFactory {
	private static final StudentService service;
	
	static {
		service = new StudentService();
	}
	
	public static StudentService getServiceObject() {
		return service;
	}
}
