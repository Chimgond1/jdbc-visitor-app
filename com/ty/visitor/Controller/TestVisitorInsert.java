package com.ty.visitor.Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.ty.visitor.dao.VisitorDao;
import com.ty.visitot.dto.Visitor;
import com.ty.visitot.service.VisitorService;

public class TestVisitorInsert {
	public static void main(String[] args) {
		Visitor visitor=new Visitor();
		visitor.setId(2);
		visitor.setName("bhomgond");
		visitor.setEmail("bhomgond@gmail.com");
		visitor.setGender("male");
		visitor.setPhone(1555233333+"");
		visitor.setAge(22);
		visitor.setDob(LocalDate.now());
		visitor.setVisitorDateTime(LocalDateTime.now());
		VisitorDao visitorDao=new VisitorDao();
		visitorDao.saveVisitor(visitor);
		
//		VisitorService service=new VisitorService();
//		int result=service.saveVisitor(visitor);
	//	if(result>0) {
		//	System.out.println("data saved");
	//	}
//		else {
//			System.out.println("data not saved");
//		}
	}

}
