package in.pwskills.nitin.dao;

import in.pwskills.nitin.bean.*;

public interface IStudentRepo {
	public String insertRecord(StudentBO stdBo);
	public StudentBO readRecord(Integer sid);
	public String deleteRecord(Integer sid);
	public String updateRecord(StudentBO stdBo);

}
