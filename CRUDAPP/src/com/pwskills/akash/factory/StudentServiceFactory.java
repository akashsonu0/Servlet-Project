package com.pwskills.akash.factory;

import com.pwskills.akash.service.IStudentService;
import com.pwskills.akash.service.StudentServiceImpl;

public class StudentServiceFactory {

	private static IStudentService studentService = null;

	private StudentServiceFactory() {

	}

	public static IStudentService getStudentService() {
		if (studentService == null) {
			studentService = new StudentServiceImpl();
		}
		return studentService;
	}

}
