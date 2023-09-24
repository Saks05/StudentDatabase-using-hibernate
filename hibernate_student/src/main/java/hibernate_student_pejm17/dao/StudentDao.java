package hibernate_student_pejm17.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import hibernate_student_pejm17.dto.Student;

public class StudentDao {
    public EntityManager getEntityManager()
    {
    	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("sakshi");
     	EntityManager entityManager = entityManagerFactory.createEntityManager();
    	return entityManager;
    	
    	//return Persistence.createEntityManagerFactory("sakshi").createEntityManager();
    	}
    
    public void saveStudent(Student student)
    {
    	EntityManager entityManager = getEntityManager();
    	EntityTransaction entityTransaction = entityManager.getTransaction();
    	
    	entityTransaction.begin();
    	entityManager.persist(student);
    	entityTransaction.commit();
    }
      public void findStudent(int id){
    	  EntityManager  entityManager =getEntityManager();
    	  Student student = entityManager.find(Student.class,id); 
    	  
    	  if(student!= null)
    	  {
    		  System.out.println(student);
    	  }
    	  else
    	  {
    		  System.out.println("Studenyt with given id" +id+"not found" );
    	  }
    	
    }
      public void findAll()
      {   EntityManager entityManager = getEntityManager();
    	  Query query = entityManager.createQuery("SELECT s FROM Student s ");
    			  List<Student> list =query.getResultList();
    	  System.out.println(list);
      }
      
      public void findByPhone(long phone)
      {   EntityManager entityManager = getEntityManager();
    	  Query query = entityManager.createQuery("SELECT s FROM Student s WHERE s.phone=?1");
    	  query.setParameter(1, phone);
    	  try
    	  {
    			 Student student =(Student) query.getSingleResult();
    	  System.out.println(student);
    	  }
    	  catch(Exception e) {
    		  System.out.println("Student with given phone no not found.");
    	  }
      }
      public void updateStudent(int id, Student student)
      {
    	  EntityManager entityManager = getEntityManager();
    	  Student dbStudent = entityManager.find(Student.class, id);
    	  if(dbStudent != null)
    	  {
    		  EntityTransaction entityTransaction = entityManager.getTransaction();
    		  student.setId(id);
    		  
    		  entityTransaction.begin();
    		  entityManager.merge(student);
    		  entityTransaction.commit();
    		  
    	  }
    	  else {
    		  System.out.println("Id not found");
    	  }
      }
      
      public void deleteStudent(int id)
      {   
    	  EntityManager entityManager = getEntityManager();
    	  Student s = entityManager.find(Student.class, id);
    	 
    	  if(s!= null)
    	  {   EntityTransaction entityTransaction = entityManager.getTransaction();
    		  s.setId(id);
    		  entityTransaction.begin();
    		  entityManager.remove(s);
    		  entityTransaction.commit();
    	  }
      }
      
    }
