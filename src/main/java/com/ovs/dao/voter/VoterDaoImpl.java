package com.ovs.dao.voter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ovs.dao.EmployeeResponse;
import com.ovs.model.Student;
import com.ovs.model.StudentDetails;

@Repository
public class VoterDaoImpl implements VoterDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public List<EmployeeResponse> get_employees() {
		List<EmployeeResponse> employeeResponsesList = new ArrayList<EmployeeResponse>();
		Session em = sessionFactory.getCurrentSession();

		String hql = "SELECT emp.name, dept.name FROM Employee emp JOIN Department dept ON dept.id=emp.did";
		List<Object[]> results = em.createQuery(hql).getResultList();
		for (Object[] result : results) {
			System.out.println(result[0] + " " + result[1]);
			String name = (String) result[0];
			String deptname = (String) result[1];
			employeeResponsesList.add(new EmployeeResponse(name, deptname));
		}

		return employeeResponsesList;
	}

	@Override
	public List<EmployeeResponse> get_students() {
//		EntityManager entityManagerFactory = sessionFactory.createEntityManager();
//		CriteriaBuilder builder = entityManagerFactory.getCriteriaBuilder();
//		CriteriaQuery<Student> query = builder.createQuery(Student.class);
//		Root<Student> fromStudent = query.from(Student.class);
//		Join<Student, StudentDetails> joinStudentDetails = fromStudent.join("studentDetails");
		
		CriteriaBuilder builder = sessionFactory.createEntityManager().getCriteriaBuilder();
	    CriteriaQuery<Tuple> criteria = builder.createTupleQuery();
	    Root<Student> entityARoot= criteria.from(Student.class);
	    Root<StudentDetails> entityBRoot = criteria.from(StudentDetails.class);
	    
	    List<Predicate> predicates = new ArrayList<>();
	    
	    List<Predicate> andPredicates = new ArrayList<>();
	    andPredicates.add(builder.equal(entityARoot.get("id"), entityBRoot.get("id")));
	    andPredicates.add(builder.and(predicates.toArray(new Predicate[0])));
	    
	    criteria.multiselect(entityARoot, entityBRoot);
	    criteria.where(andPredicates.toArray(new Predicate[0]));
	    
	    
	    TypedQuery<Tuple> query = sessionFactory.createEntityManager().createQuery(criteria);

	    List<Tuple> result = query.getResultList();
	    
	    
	    
		
		return null;
	}

}
