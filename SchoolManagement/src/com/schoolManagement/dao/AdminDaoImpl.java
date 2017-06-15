package com.schoolManagement.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.schoolManagement.bean.AddSchool;
import com.schoolManagement.bean.AddStudent;
import com.schoolManagement.bean.Login;
import com.schoolManagement.bean.NewCategory;
import com.schoolManagement.bean.NewClass;
import com.schoolManagement.bean.NewDivision;
import com.schoolManagement.bean.SenderName;

@Component("adminDao")
public class AdminDaoImpl implements AdminDao{
	private static SessionFactory sf = HibernateUtil.getSessionFactory();

	@Override
	public boolean addSchoolDao(AddSchool addSchool) {
		Session session = null;
		Transaction tx=null;
		Session session1 = null;
		Transaction tx1=null;
		Session session2 = null;
		Transaction tx2=null;
		try
		{
			session = sf.openSession();
			tx=session.beginTransaction();
			
			Login lg=new Login();
			lg.setRole("school");
			lg.setEmail(addSchool.getEmailSchool());
			lg.setPassword(addSchool.getPasswordSchool());
			session.saveOrUpdate(addSchool);
			session.saveOrUpdate(lg);
			tx.commit();
			// Setting Approver 1 Email and Password
			session1 = sf.openSession();
			tx1=session1.beginTransaction();
			lg.setRole("approver");
			lg.setEmail(addSchool.getApproverEmail1());
			lg.setPassword(addSchool.getApproverPassword1());
			session1.saveOrUpdate(lg);
			tx1.commit();
			// Setting Approver 2 Email and Password
			session2 = sf.openSession();
			tx2=session2.beginTransaction();
			lg.setRole("approver");
			lg.setEmail(addSchool.getApproverEmail2());
			lg.setPassword(addSchool.getApproverPassword2());
			session2.saveOrUpdate(lg);
			tx2.commit();
			return true;

		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return false;
		}
		finally 
		{
			/*if (session != null)*/
				session.close();
				session1.close();
				session2.close();

				
		}

	}

	@Override
	public String getSchoolId() {
		Session session = null;

		try
		{
			session = sf.openSession();
			String sql="SELECT schoolId FROM school ORDER BY schoolId DESC LIMIT 1";
			SQLQuery query = session.createSQLQuery(sql);
			String schoolId = (String)query.uniqueResult();
			if(null==schoolId)
			{
				return "SCH101";
			}

			int schId=Integer.parseInt(schoolId.substring(3,schoolId.length()));
			schId++;
			return "SCH"+schId;
		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return null;
		}
		finally 
		{
			if (session != null)
				session.close();
		}
	}
	@Override
	public Map<String,String> getSchoolNameDao() {
		Map<String,String> schoolData=new HashMap<String,String>();

		Session session = null;

		try
		{
			session = sf.openSession();
			String sql="SELECT  schoolId,schoolName FROM school";
			SQLQuery query = session.createSQLQuery(sql);

			@SuppressWarnings("unchecked")
			List<Object[]>list = query.list();
			for(Object[] obj:list)
			{
				schoolData.put((String)obj[0], (String)obj[1]);
			}
			return schoolData;


		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return null;
		}
		finally 
		{
			if (session != null)
				session.close();
		}
	}

	@Override
	public List<NewClass> getSchoolClassDao(String schoolId) {
		Session session = null;

		try
		{
			session = sf.openSession();
			String sql="SELECT className FROM newclass where schoolId='"+schoolId+"'";
			SQLQuery query = session.createSQLQuery(sql);

			@SuppressWarnings("unchecked")
			List<NewClass>list = query.list();

			return list;


		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return null;
		}
		finally 
		{
			if (session != null)
				session.close();
		}

	}

	@Override
	public List<NewDivision> getSchoolDivDao(String schoolId) {
		Session session = null;

		try
		{
			session = sf.openSession();
			String sql="SELECT newDivision FROM division where schoolId='"+schoolId+"'";
			SQLQuery query = session.createSQLQuery(sql);

			@SuppressWarnings("unchecked")
			List<NewDivision>list = query.list();

			return list;


		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return null;
		}
		finally 
		{
			if (session != null)
				session.close();
		}
	}

	
	@Override
	public List<NewClass> getClassListFilterDao(String schId) {
		Session session = null;

		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM newclass where schoolId='"+schId+"'";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(NewClass.class);
			@SuppressWarnings("unchecked")
			List<NewClass>list = query.list();

			return list;


		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return null;
		}
		finally 
		{
			if (session != null)
				session.close();
		}
	}

	

	@Override
	public List<AddStudent> showApprovedStudentDetailsDao( ) {
		Session session = null;

		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM student where  approver1Status='Approved' AND approver2Status='Approved'";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(AddStudent.class);
@SuppressWarnings("unchecked")
List<AddStudent> list=query.list();			
			return list;


		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return null;
		}
		finally 
		{
			if (session != null)
				session.close();
		}
	}

	@Override
	public List<AddStudent> showPendingStudentDetailsDao( ) {
		Session session = null;

		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM student where  approver1Status='pending' AND approver2Status='pending'";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(AddStudent.class);
@SuppressWarnings("unchecked")
List<AddStudent> list=query.list();			
			return list;


		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return null;
		}
		finally 
		{
			if (session != null)
				session.close();
		}
	}

	@Override
	public List<NewDivision> getDivListFilterDao(String schId) {
		Session session = null;

		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM division where schoolId='"+schId+"'";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(NewDivision.class);
			@SuppressWarnings("unchecked")
			List<NewDivision>list = query.list();

			return list;


		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return null;
		}
		finally 
		{
			if (session != null)
				session.close();
		}
	}

	@Override
	public List<AddStudent> showApprovedStudentDetailsDao(String schoolId) {
		Session session = null;

		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM student where schoolId='"+schoolId+"'AND approver1Status='Approved' AND approver2Status='Approved'";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(AddStudent.class);
@SuppressWarnings("unchecked")
List<AddStudent> list=query.list();			
			return list;


		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return null;
		}
		finally 
		{
			if (session != null)
				session.close();
		}
	}

	@Override
	public List<AddStudent> showPendingStudentDetailsDao(String schoolId) {
		Session session = null;

		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM student where schoolId='"+schoolId+"'AND approver1Status='pending' AND approver2Status='pending'";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(AddStudent.class);
@SuppressWarnings("unchecked")
List<AddStudent> list=query.list();			
			return list;


		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return null;
		}
		finally 
		{
			if (session != null)
				session.close();
		}
	}

	@Override
	public List<AddStudent> approvedStudentDetailsSchClassFilterDao(String schoolId, String schClass) {
		Session session = null;

		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM student where schoolId='"+schoolId+"'AND approver1Status='Approved' AND approver2Status='Approved' AND standard='"+schClass+"'";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(AddStudent.class);
@SuppressWarnings("unchecked")
List<AddStudent> list=query.list();			
			return list;


		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return null;
		}
		finally 
		{
			if (session != null)
				session.close();
		}
	}

	@Override
	public List<AddStudent> pendingStudentDetailsSchClassFilterDao(String schoolId, String schClass) {
		Session session = null;

		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM student where schoolId='"+schoolId+"'AND approver1Status='pending' AND approver2Status='pending' AND standard='"+schClass+"'";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(AddStudent.class);
@SuppressWarnings("unchecked")
List<AddStudent> list=query.list();			
			return list;


		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return null;
		}
		finally 
		{
			if (session != null)
				session.close();
		}
	}

	@Override
	public List<AddStudent> approvedStudentDetailsSchDivFilterDao(String schoolId, String schClass, String schDiv) {
		Session session = null;

		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM student where schoolId='"+schoolId+"'AND approver1Status='Approved' AND approver2Status='Approved' AND standard='"+schClass+"'AND division='"+schDiv+"'";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(AddStudent.class);
@SuppressWarnings("unchecked")
List<AddStudent> list=query.list();			
			return list;


		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return null;
		}
		finally 
		{
			if (session != null)
				session.close();
		}
	}

	@Override
	public List<AddStudent> pendingStudentDetailsSchDivFilterDao(String schoolId, String schClass, String schDiv) {
		Session session = null;

		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM student where schoolId='"+schoolId+"'AND approver1Status='pending' AND approver2Status='pending' AND standard='"+schClass+"' AND division='"+schDiv+"'";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(AddStudent.class);
@SuppressWarnings("unchecked")
List<AddStudent> list=query.list();			
			return list;


		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return null;
		}
		finally 
		{
			if (session != null)
				session.close();
		}
	}

	@Override
	public List<AddStudent> approvedStudentDetailsOtherFilterDao(String schoolId, String rollNoFilter,
			String mobileFilter) {
		Session session = null;

		try
		{
			session = sf.openSession();
			String sql;
			if(rollNoFilter!="" &&mobileFilter!="")
			sql="SELECT * FROM student where schoolId='"+schoolId+"'AND approver1Status='Approved' AND approver2Status='Approved' AND rollNo='"+rollNoFilter+"'AND mobileNo='"+mobileFilter+"'";
			else if(rollNoFilter!="")
				sql="SELECT * FROM student where schoolId='"+schoolId+"'AND approver1Status='Approved' AND approver2Status='Approved' AND rollNo='"+rollNoFilter+"'";
			else if(mobileFilter!="")
				sql="SELECT * FROM student where schoolId='"+schoolId+"'AND approver1Status='Approved' AND approver2Status='Approved' AND mobileNo='"+mobileFilter+"'";
			else
				sql="SELECT * FROM student where schoolId='"+schoolId+"'AND approver1Status='Approved' AND approver2Status='Approved' AND rollNo='"+rollNoFilter+"'AND mobileNo='"+mobileFilter+"'";

			
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(AddStudent.class);
@SuppressWarnings("unchecked")
List<AddStudent> list=query.list();			
			return list;


		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return null;
		}
		finally 
		{
			if (session != null)
				session.close();
		}
	}

	@Override
	public List<AddStudent> pendingStudentDetailsOtherFilterDao(String schoolId, String rollNoFilter,
			String mobileFilter) {
		Session session = null;

		try
		{
			session = sf.openSession();
			String sql;
			if(rollNoFilter!="" &&mobileFilter!="")
			sql="SELECT * FROM student where schoolId='"+schoolId+"'AND approver1Status='pending' AND approver2Status='pending' AND rollNo='"+rollNoFilter+"'AND mobileNo='"+mobileFilter+"'";
			else if(rollNoFilter!="")
				sql="SELECT * FROM student where schoolId='"+schoolId+"'AND approver1Status='pending' AND approver2Status='pending' AND rollNo='"+rollNoFilter+"'";
			else if(mobileFilter!="")
				sql="SELECT * FROM student where schoolId='"+schoolId+"'AND approver1Status='pending' AND approver2Status='pending' AND mobileNo='"+mobileFilter+"'";
			else
				sql="SELECT * FROM student where schoolId='"+schoolId+"'AND approver1Status='pending' AND approver2Status='pending' AND rollNo='"+rollNoFilter+"'AND mobileNo='"+mobileFilter+"'";

			
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(AddStudent.class);
@SuppressWarnings("unchecked")
List<AddStudent> list=query.list();			
			return list;


		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return null;
		}
		finally 
		{
			if (session != null)
				session.close();
		}
	}

	@Override
	public boolean addStudentDao(AddStudent newStudent) {
		Session session = null;
		Transaction tx=null;
		
		try
		{
			session = sf.openSession();
			tx=session.beginTransaction();
			newStudent.setApprover1Status("pending");
			newStudent.setApprover2Status("pending");
			session.saveOrUpdate(newStudent);
		
			tx.commit();
			
			return true;

		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return false;
		}
		finally 
		{
			if (session != null)
				session.close();

				
		}
	}

	@Override
	public AddStudent editStudentDao(String schoolId, String rollNo) {
		Session session = null;
		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM student where rollNo='"+rollNo+"'AND schoolId='"+schoolId+"'";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(AddStudent.class);
			AddStudent stu = (AddStudent) query.uniqueResult();
			
			return stu;


		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return null;
		}
		finally 
		{
			if (session != null)
				session.close();
		}
	}

	@Override
	public AddStudent showStudentDao(String schId, String rollNo) {
		Session session = null;

		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM student where schoolId='"+schId+"'AND rollNo='"+rollNo+"'";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(AddStudent.class);
			AddStudent stu = (AddStudent) query.uniqueResult();
			
			return stu;


		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return null;
		}
		finally 
		{
			if (session != null)
				session.close();
		}
	}

	@Override
	public boolean addClassDao(NewClass newClass) {
		Session session = null;
		Transaction tx=null;
		try
		{
			for(int i=0;i<newClass.getSubjectAdd().size();i++)
			{

				if(0!=newClass.getSubjectAdd().get(i).getSrNo())
				{	

					newClass.getSubjectAdd().get(i).setAddClass(newClass);

				}

				else{

					newClass.getSubjectAdd().remove(i);
					i--;
				}
			}
			session = sf.openSession();
			tx=session.beginTransaction();
			session.saveOrUpdate(newClass);
			tx.commit();
			return true;

		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return false;
		}
		finally 
		{
			if (session != null)
				session.close();
		}
	}

	@Override
	public boolean addDivisionDao(NewDivision newDivision) {
		Session session = null;
		Transaction tx=null;
		try
		{
			session = sf.openSession();
			tx=session.beginTransaction();
			session.saveOrUpdate(newDivision);
			tx.commit();
			return true;

		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return false;
		}
		finally 
		{
			if (session != null)
				session.close();
		}
	}

	@Override
	public boolean addCategoryDao(NewCategory newCategory) {
		Session session = null;
		Transaction tx=null;
		try
		{
			session = sf.openSession();
			tx=session.beginTransaction();
			session.saveOrUpdate(newCategory);
			tx.commit();
			return true;

		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return false;
		}
		finally 
		{
			if (session != null)
				session.close();
		}
	}

	@Override
	public List<AddSchool> getSchoolListDao() {
		Session session = null;

		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM school ";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(AddSchool.class);
			@SuppressWarnings("unchecked")
			List<AddSchool>list = query.list();

			return list;


		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return null;
		}
		finally 
		{
			if (session != null)
				session.close();
		}
	}

	@Override
	public AddSchool editSchoolDao(String schoolId) {
		Session session = null;

		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM school where schoolId='"+schoolId+"'";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(AddSchool.class);
			AddSchool editList = (AddSchool) query.uniqueResult();

			return editList;


		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return null;
		}
		finally 
		{
			if (session != null)
				session.close();
		}
	}

	@Override
	public boolean editStudentAdminDao(AddStudent newStudent) {
		Session session = null;
		Transaction tx=null;
		
		try
		{
			session = sf.openSession();
			tx=session.beginTransaction();
			
			session.saveOrUpdate(newStudent);
		
			tx.commit();
			
			return true;

		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return false;
		}
		finally 
		{
			if (session != null)
				session.close();

				
		}
	}

	@Override
	public boolean editSchoolAdminDao(AddSchool addSchool) {
		Session session = null;
		Transaction tx=null;
		
		try
		{
			session = sf.openSession();
			tx=session.beginTransaction();
			
			session.saveOrUpdate(addSchool);
		
			tx.commit();
			
			return true;

		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return false;
		}
		finally 
		{
			if (session != null)
				session.close();

				
		}
	}

	@Override
	public List<NewCategory> getCategoryDao(String schoolId) {
		Session session = null;

		try
		{
			session = sf.openSession();
			String sql="SELECT categoryName FROM category where schoolId='"+schoolId+"'";
			SQLQuery query = session.createSQLQuery(sql);

			@SuppressWarnings("unchecked")
			List<NewCategory>list = query.list();

			return list;


		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return null;
		}
		finally 
		{
			if (session != null)
				session.close();
		}
	}

	@Override
	public boolean newSenderAddDao(SenderName newSender) {
		Session session = null;
		Transaction tx=null;
		
		try
		{
			session = sf.openSession();
			tx=session.beginTransaction();
			
			session.saveOrUpdate(newSender);
		
			tx.commit();
			
			return true;

		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return false;
		}
		finally 
		{
			if (session != null)
				session.close();

				
		}
	}

	@Override
	public List<SenderName> getSenderNameDao() {
		Session session = null;

		try
		{
			session = sf.openSession();
			String sql="SELECT senderName FROM sendername ";
			SQLQuery query = session.createSQLQuery(sql);

			@SuppressWarnings("unchecked")
			List<SenderName>list = query.list();

			return list;


		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return null;
		}
		finally 
		{
			if (session != null)
				session.close();
		}
	}

	@Override
	public String getSchoolNameDao(String schoolId) {
		Session session = null;

		try
		{
			session = sf.openSession();
			String sql="SELECT schoolName FROM school where schoolId='"+schoolId+"'";
			SQLQuery query = session.createSQLQuery(sql);

String schoolName=(String) query.uniqueResult();
			return schoolName;


		} 
		catch (HibernateException ex) 
		{
			ex.printStackTrace();
			return null;
		}
		finally 
		{
			if (session != null)
				session.close();
		}
	}

	
	}

	
	




