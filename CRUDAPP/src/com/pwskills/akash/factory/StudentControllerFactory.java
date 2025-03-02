package com.pwskills.akash.factory;

import com.pwskills.akash.controller.IStudentController;
import com.pwskills.akash.controller.StudentControllerImpl;

public class StudentControllerFactory {

	private static IStudentController controller = null;

	public static IStudentController getStudentControllerObj() {
		if (controller == null) {
			controller = new StudentControllerImpl();
		}
		return controller;
	}

}
