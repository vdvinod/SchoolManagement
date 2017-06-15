package com.schoolManagement.dao;


import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.schoolManagement.bean.AddStudent;
import com.schoolManagement.bean.Login;

@Component("loginDao")
public class LoginDaoImpl implements LoginDao{
	private SessionFactory sf=HibernateUtil.getSessionFactory();
	@Override
	public String validLoginDao(Login login) {
		Session session=null;
		try 
		{

			session=sf.openSession();
			String sql="select email,password,role from login where email='"+login.getEmail()+"'and password='"+login.getPassword()+"'";			
			SQLQuery query=session.createSQLQuery(sql);
			query.addEntity(Login.class);
			@SuppressWarnings("unchecked")
			List<Login> list=query.list();
			String info=null;
			if((list!=null)&&(list.size()>0))
			{
				for(Login log:list)
				{

					if(log.getRole().equals("admin"))

						info= "admin";


					else if(log.getRole().equals("school"))
						info="school";
					else if(log.getRole().equals("approver"))
						info="approver";
					else
						info="distributor";
				}
			}
			return info;

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
	public String getSchIdDao(Login login) {
		Session session=null;
		try 
		{

			session=sf.openSession();

			String sql="select schoolId from school where emailSchool='"+login.getEmail()+"'";
			SQLQuery query=session.createSQLQuery(sql);
			String schId=(String) query.uniqueResult();

			return schId;
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
	public List<AddStudent> getStudentDetailsDao(String schoolId,Login login) {
		Session session=null;
		try 
		{
			String approverCheck=checkApprover(login.getEmail());
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

		}
	}

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
				{
					return "approver1";
				}
			
			else
			{

				return "approver2";
			}
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
	public String getSchIdAppDao(Login login) {
		Session session=null;
		try 
		{

			session=sf.openSession();

			String sql="select schoolId from school where approverEmail1 ='"+login.getEmail()+"' Or approverEmail2='"+login.getEmail()+"'";

			SQLQuery query=session.createSQLQuery(sql);
			String schId=(String) query.uniqueResult();

			return schId;
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
}
