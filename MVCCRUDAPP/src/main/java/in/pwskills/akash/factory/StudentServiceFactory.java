package in.pwskills.akash.factory;

import in.pwskills.akash.service.IStudentService;
import in.pwskills.akash.service.StudentServiceImpl;

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
