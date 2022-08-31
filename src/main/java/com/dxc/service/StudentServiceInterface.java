package com.dxc.service;

import com.dxc.Bean.Student;

public interface StudentServiceInterface {
	public Integer insert(Student s);
	
	public void list();
	
	public Student get(int id);
	
	public void update(Student s);
	
	public void delete(int id);
}
