package in.pwskills.akash.factory;

import in.pwskills.akash.repository.IStudentRepo;
import in.pwskills.akash.repository.StudentRepoImpl;

public class StudentRepoFactory {

	private static StudentRepoImpl studentRepo = null;

	private StudentRepoFactory() {

	}

	// Singleton pattern
	public static IStudentRepo getStudentRepo() {
		if (studentRepo == null) {
			studentRepo = new StudentRepoImpl();
		}
		return studentRepo;
	}
}
