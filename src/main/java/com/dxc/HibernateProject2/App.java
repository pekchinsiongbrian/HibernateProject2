package com.dxc.HibernateProject2;

import com.dxc.Bean.Student;
import com.dxc.FactoryDesign.ServiceFactory;
import com.dxc.service.StudentService;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
        System.out.println("Press 1 -> To insert a student record");
        System.out.println("Press 2 -> To get details of a student");
        System.out.println("Press 3 -> To list all student details");
        System.out.println("Press 4 -> To update a student's details");
        System.out.println("Press 5 -> To delete a student record");
        System.out.println("Press 6 -> To exit app");
        int input = sc.nextInt();
        sc.nextLine();
        
        StudentService service = ServiceFactory.getServiceObject();
        Student s;
        int id;
        switch(input) {
        case 1: // insert
        	System.out.println("Enter student name and hit enter:");
        	String name = sc.nextLine();
        	System.out.println("Enter address and hit enter:");
        	String addr = sc.nextLine();
        	s = new Student();
        	s.setSname(name);
        	s.setSaddr(addr);
        	
        	System.out.println((service.insert(s)) != 0 ? "Student details uploaded" : "Insertion unsuccessful");
        	break;
        case 2: // get details
        	System.out.println("Enter student id and hit enter:");
        	id = sc.nextInt();
        	sc.nextLine();
        	
        	s = service.get(id);
        	System.out.println(s != null ? s : "No such student id");
        	break;
        case 3: // list
        	service.list();
        	break;
        case 4: //update
        	System.out.println("Enter id of student you wish to update:");
			id = sc.nextInt();
			sc.nextLine();
			
			s = service.get(id);
			if (s == null) {
				System.err.println("There is no student with id: " + id);
				break;
			}
			
			System.out.println("Enter new name. If no new name, just hit enter:");
			String newName = sc.nextLine();
			if (newName != null && !newName.equals("")) {
				s.setSname(newName);
			}
			
			System.out.println("Enter new address. If no new address, just hit enter:");
			String newAddr = sc.nextLine();
			if (newAddr != null && !newAddr.equals("")) {
				s.setSaddr(newAddr);
			}
			
			service.update(s);
			System.out.println("Updated");
        	break;
        case 5: // delete
        	System.out.println("Enter student id to delete:");
        	id = sc.nextInt();
        	sc.nextLine();
        	
        	service.delete(id);
        	System.out.println("Deleted");
        	break;
        case 6:
        	System.out.println("Goodbye!");
        	System.exit(0);
        default:
        	break;
        }
    }
}
