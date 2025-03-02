package in.pwskills.nitin.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.pwskills.nitin.bean.StudentBO;
import in.pwskills.nitin.util.HibernateUtil;

//ORM -> Hibernate
public class StudentRepoImpl implements IStudentRepo {

	@Override
	public String insertRecord(StudentBO stdBo) {
		String status = "";
		Transaction transaction = null;
		Boolean flag = false;
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(stdBo);
			flag = true;
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					status = "success";
				} else {
					transaction.rollback();
					status = "failure";
				}
			}
			if (session != null)
				session.close();
		}
		return status;
	}

	@Override
	public StudentBO readRecord(Integer sid) {
		StudentBO bo = null;

		try {
			Session session = HibernateUtil.getSession();
			bo = session.get(StudentBO.class, sid);
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bo;
	}

	@Override
	public String deleteRecord(Integer sid) {

		String status = "";
		Transaction transaction = null;
		Boolean flag = false;
		Session session = null;

		StudentBO bo = readRecord(sid);
		if (bo != null) {
			// perform delete operation
			try {
				session = HibernateUtil.getSession();
				transaction = session.beginTransaction();
				session.delete(bo);
				flag = true;
			} catch (HibernateException he) {
				he.printStackTrace();
			} finally {
				if (transaction != null) {
					if (flag) {
						transaction.commit();
						status = "success";
					} else {
						transaction.rollback();
						status = "failure";
					}
				}
				if (session != null) {
					session.close();
				}
			}

		} else {
			status = "Record not found for the id :: " + sid;
		}

		return status;
	}

	@Override
	public String updateRecord(StudentBO stdBo) {
		String status = "";
		Transaction transaction = null;
		Boolean flag = false;
		Session session = null;
		try {
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(stdBo);
			flag = true;
		} catch (HibernateException he) {
			he.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
					status = "success";
				} else {
					transaction.rollback();
					status = "failure";
				}
			}
			if (session != null) {
				session.close();
			}
		}
		return status;
	}

}
