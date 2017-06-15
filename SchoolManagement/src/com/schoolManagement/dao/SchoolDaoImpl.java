package com.schoolManagement.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Controller;

import com.schoolManagement.bean.AddStudent;
import com.schoolManagement.bean.NewCategory;
import com.schoolManagement.bean.NewClass;
import com.schoolManagement.bean.NewDivision;

@Controller("schoolDao")
public class SchoolDaoImpl implements SchoolDao{
	private static SessionFactory sf = HibernateUtil.getSessionFactory();

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
	public String getLoginSchoolDao(String schoolId) {
		Session session = null;

		try
		{
			session = sf.openSession();
			String sql="SELECT schoolName FROM school where schoolId='"+schoolId+"'";
			SQLQuery query = session.createSQLQuery(sql);

String schName=(String) query.uniqueResult();			
			return schName;


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
	public List<AddStudent> showApprovedStudentDetailsDao(String schoolId) {
		Session session = null;

		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='Approved' AND approver2Status='Approved'";
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
	public AddStudent editStudentDao(String rollNo) {
		Session session = null;
		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM student where rollNo='"+rollNo+"'";
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
	public List<AddStudent> showPendingStudentDetailsDao(String schoolId) {
		Session session = null;

		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='pending' AND approver2Status='pending'";
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
	public List<AddStudent> showApprovedStudentDetailsDao(String schoolId, String classFilter,String divFilter,String rollNoFilter,String mobileFilter) {
		Session session = null;

		try
		{
			session = sf.openSession();
			String sql;
			
			 if(classFilter!="" && divFilter!="" &&rollNoFilter!="")
				sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='Approved' AND approver2Status='Approved' And division='"+divFilter+"' AND rollNo='"+rollNoFilter+"' AND standard='"+classFilter+"'";
			
			else if(classFilter!="" && divFilter!="" &mobileFilter!="")
				sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='Approved' AND approver2Status='Approved' And division='"+divFilter+"' AND mobileNo='"+mobileFilter+"' AND standard='"+classFilter+"'";

			
			else if(divFilter!="" && rollNoFilter!="" && mobileFilter!="")
				sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='Approved' AND approver2Status='Approved' And division='"+divFilter+"' AND rollNo='"+rollNoFilter+"' AND mobileNo='"+mobileFilter+"'";
		
			else if(classFilter!="" && divFilter!="")
				sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='Approved' AND approver2Status='Approved' And standard='"+classFilter+"' AND division='"+divFilter+"'";
				
				else if(classFilter!="" && rollNoFilter!="")
				sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='Approved' AND approver2Status='Approved' And standard='"+classFilter+"' AND rollNo='"+rollNoFilter+"'";
				
				else if(classFilter!="" && mobileFilter!="")
				sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='Approved' AND approver2Status='Approved' And standard='"+classFilter+"' AND mobileNo='"+mobileFilter+"'";
				
				else if(divFilter!="" && rollNoFilter!="")
				sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='Approved' AND approver2Status='Approved' And division='"+divFilter+"' AND rollNo='"+rollNoFilter+"'";
				
				else if(divFilter!="" && mobileFilter!="")
					sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='Approved' AND approver2Status='Approved' And division='"+divFilter+"' AND mobileNo='"+mobileFilter+"'";
				
				else if(rollNoFilter!=""&& mobileFilter!="")
					sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='Approved' AND approver2Status='Approved' And rollNo='"+rollNoFilter+"' AND mobileNo='"+mobileFilter+"'";
				
			else if(classFilter!="")
				 sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='Approved' AND approver2Status='Approved' And standard='"+classFilter+"'";
			else if(divFilter!="")
			 sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='Approved' AND approver2Status='Approved' And division='"+divFilter+"'";
			else if(rollNoFilter!="")
				 sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='Approved' AND approver2Status='Approved' And rollNo='"+rollNoFilter+"'";
			else if(mobileFilter!="")
			sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='Approved' AND approver2Status='Approved' And mobileNo='"+mobileFilter+"'";
			
			
				
			else
				sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='Approved' AND approver2Status='Approved' And division='"+divFilter+"' AND rollNo='"+rollNoFilter+"' AND standard='"+classFilter+"' AND mobileNo='"+mobileFilter+"'";

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
	public List<AddStudent> showPendingStudentDetailsDao(String schoolId, String classFilter,String divFilter,String rollNoFilter,String mobileFilter) {
		Session session = null;

		try
		{
			session = sf.openSession();
			String sql;
			 if(classFilter!="" && divFilter!="" &&rollNoFilter!="")
					sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='pending' AND approver2Status='pending' And division='"+divFilter+"' AND rollNo='"+rollNoFilter+"' AND standard='"+classFilter+"'";
				
				else if(classFilter!="" && divFilter!="" &mobileFilter!="")
					sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='pending' AND approver2Status='pending' And division='"+divFilter+"' AND mobileNo='"+mobileFilter+"' AND standard='"+classFilter+"'";

				
				else if(divFilter!="" && rollNoFilter!="" && mobileFilter!="")
					sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='pending' AND approver2Status='pending' And division='"+divFilter+"' AND rollNo='"+rollNoFilter+"' AND mobileNo='"+mobileFilter+"'";
			
				else if(classFilter!="" && divFilter!="")
					sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='pending' AND approver2Status='pending' And standard='"+classFilter+"' AND division='"+divFilter+"'";
					
					else if(classFilter!="" && rollNoFilter!="")
					sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='pending' AND approver2Status='pending' And standard='"+classFilter+"' AND rollNo='"+rollNoFilter+"'";
					
					else if(classFilter!="" && mobileFilter!="")
					sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='pending' AND approver2Status='pending' And standard='"+classFilter+"' AND mobileNo='"+mobileFilter+"'";
					
					else if(divFilter!="" && rollNoFilter!="")
					sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='pending' AND approver2Status='pending' And division='"+divFilter+"' AND rollNo='"+rollNoFilter+"'";
					
					else if(divFilter!="" && mobileFilter!="")
						sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='pending' AND approver2Status='pending' And division='"+divFilter+"' AND mobileNo='"+mobileFilter+"'";
					
					else if(rollNoFilter!=""&& mobileFilter!="")
						sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='pending' AND approver2Status='pending' And rollNo='"+rollNoFilter+"' AND mobileNo='"+mobileFilter+"'";
					
				else if(classFilter!="")
					 sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='pending' AND approver2Status='pending' And standard='"+classFilter+"'";
				else if(divFilter!="")
				 sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='pending' AND approver2Status='pending' And division='"+divFilter+"'";
				else if(rollNoFilter!="")
					 sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='pending' AND approver2Status='pending' And rollNo='"+rollNoFilter+"'";
				else if(mobileFilter!="")
				sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='pending' AND approver2Status='pending' And mobileNo='"+mobileFilter+"'";
				
				
					
				else
					sql="SELECT * FROM student where schoolId='"+schoolId+"' AND approver1Status='pending' AND approver2Status='pending' And division='"+divFilter+"' AND rollNo='"+rollNoFilter+"' AND standard='"+classFilter+"' AND mobileNo='"+mobileFilter+"'";
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
	public AddStudent showStudentDao(String schoolId, String rollNo) {
		Session session = null;

		try
		{
			session = sf.openSession();
			String sql="SELECT * FROM student where schoolId='"+schoolId+"'AND rollNo='"+rollNo+"'";
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

	//Approver Functions 
	
	@Override
	public boolean approveStuDao(String email,String rollNo) {
		Session session = null;
		Transaction tx=null;
		try
		{
			session = sf.openSession();
			
			tx=session.beginTransaction();
			String approver=checkApprover(email);
			String sql;
			if(approver=="approver1")
			{
				 sql="update AddStudent set approver1Status =:changeStat" +" where rollNo=:rollNo";

			}
			else
			{	
				 sql="update AddStudent set approver2Status =:changeStat" +" where rollNo=:rollNo";
			}
//			String res="Approved";
			Query query = session.createQuery(sql);
			
			query.setParameter("changeStat", "Approved");
			query.setParameter("rollNo", rollNo);
				int i=query.executeUpdate();	
				tx.commit();
		System.out.println("rows Affected = "+i);	
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
		}	}

	public String checkApprover(String email)
	{
		Session session=null;

		try 
		{
			
			session=sf.openSession();
			
			String sql="select approverEmail1 from school where approverEmail1 ='"+email+"'";
			SQLQuery query=session.createSQLQuery(sql);
			String appName=(String) query.uniqueResult();
			if(appName!=null)
				
			return "approver1";

			
			else
				return "approver2";
			
		}
		catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
		finally {
				
			if(session!=null){
				session.close();

			}

	}

	}

	@Override
	public List<AddStudent> getStudentDetailsDao(String schoolId, String login) {
		Session session=null;
		try 
		{
			String approverCheck=checkApprover(login);
			session=sf.openSession();
			String sql;
			if(approverCheck=="approver1")
			{		
				sql="select * from student where schoolId='"+schoolId+"' AND approver1Status='pending'";			
			}
			else
			{
				sql="select * from student where schoolId='"+schoolId+"' AND approver2Status='pending'";			

			}
			SQLQuery query=session.createSQLQuery(sql);
			query.addEntity(AddStudent.class);
			@SuppressWarnings("unchecked")
			List<AddStudent> list=query.list();
			return list;

		}
		catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
		finally {

			if(session!=null){
				session.close();

			}

		}	}

	@Override
	public boolean editStudentSchDao(AddStudent addStudent) {
		Session session = null;
		Transaction tx=null;
		
		try
		{
			session = sf.openSession();
			tx=session.beginTransaction();
			
			session.saveOrUpdate(addStudent);
		
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
	}


