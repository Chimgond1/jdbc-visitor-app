package com.ty.visitot.service;

import com.ty.visitor.dao.VisitorDao;
import com.ty.visitot.dto.Visitor;
import com.ty.visitot.util.AES;
import static com.ty.visitot.util.AppConstant.*;

public class VisitorService {
	VisitorDao dao = new VisitorDao();

	public int saveVisitor(Visitor visitor) {
		String encName = AES.encrypt(visitor.getName(), SECRETE_KEY);
		String encmail = AES.encrypt(visitor.getEmail(), SECRETE_KEY);
		String encphone = AES.encrypt(visitor.getPhone(), SECRETE_KEY);

		visitor.setName(encName);
		visitor.setEmail(encmail);
		visitor.setPhone(encphone);
		return dao.saveVisitor(visitor);
	}

}
