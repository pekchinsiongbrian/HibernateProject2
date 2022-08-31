package com.dxc.service;

import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.dxc.Bean.Student;
import com.dxc.FactoryDesign.HibernateFactory;

public class StudentService implements StudentServiceInterface {
	public Integer insert(Student s) {
		Integer sid;
		SessionFactory factory = HibernateFactory.getFactoryObject();
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			sid = Integer.parseInt((String)session.save(s));
			tx.commit();
			
			return sid;
		} catch (HibernateException e) {
			if (tx != null) {
    			tx.rollback();
    		}
    		e.printStackTrace();
		} finally {
    		session.close();
    	}
		return 0;
	}
	
	public void list() {
		SessionFactory factory = HibernateFactory.getFactoryObject();
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			List students = session.createQuery("FROM Student").list();
			Iterator iter = students.iterator();
			while (iter.hasNext()) {
				System.out.println((Student) iter.next());
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
    			tx.rollback();
    		}
    		e.printStackTrace();
		} finally {
    		session.close();
    	}
	}
	
	public Student get(int id) {
		SessionFactory factory = HibernateFactory.getFactoryObject();
		Session session = factory.openSession();
		Transaction tx = null;
    	
    	try {
    		tx = session.beginTransaction();
    		Student student = (Student) session.get(Student.class, String.valueOf(id));
    		tx.commit();
    		return student;
    	} catch (HibernateException e) {
    		if (tx != null) {
    			tx.rollback();
    		}
    		e.printStackTrace();
    	} catch (NullPointerException np) {
    		System.err.println("There is no student with id: " + id);
    	} finally {
    		session.close();
    	}
    	return null;
	}
	
	public void update(Student s) {
		SessionFactory factory = HibernateFactory.getFactoryObject();
		Session session = factory.openSession();
		Transaction tx = null;
		
		try {
	       tx = session.beginTransaction();
	       Student student = (Student) session.get(Student.class, String.valueOf(s.getSid())); 
	       student.setSname(s.getSname());
	       student.setSaddr(s.getSaddr());
	       session.update(student);
	       tx.commit();
	    } catch (HibernateException e) {
	       if (tx != null) {
	    	   tx.rollback();
	       }
	       e.printStackTrace(); 
	    } finally {
	       session.close(); 
	    }
	}
	
	public void delete(int id) {
		SessionFactory factory = HibernateFactory.getFactoryObject();
		Session session = factory.openSession();
		Transaction tx = null;
    	
		try {
	       tx = session.beginTransaction();
	       Student student = (Student) session.get(Student.class, String.valueOf(id)); 
	       session.delete(student);
	       tx.commit();
	    } catch (HibernateException e) {
	       if (tx != null) {
	    	   tx.rollback();
	       }
	       e.printStackTrace(); 
	    } finally {
	       session.close(); 
	    }
	}
}
