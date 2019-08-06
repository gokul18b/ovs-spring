package com.ovs.dao.voter;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ovs.model.Voter;

@Repository
public class VoterDaoImpl implements VoterDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public long add_voter(Voter voter) {
		sessionFactory.getCurrentSession().save(voter);
		return voter.getId();
	}

	@Override
	public Voter get_voter(int id) {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().get(Voter.class, id);
	}

	@Override
	public List<Voter> get_all() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Voter> cq = builder.createQuery(Voter.class);
		Root<Voter> root = cq.from(Voter.class);
		cq.select(root);
		Query<Voter> query = session.createQuery(cq);
		return query.getResultList();

	}

	@Override
	public void update_voter(int id, Voter voter) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Voter old_voter = session.find(Voter.class, id);
		old_voter.setAadharNo(voter.getAadharNo());
		old_voter.setAddress(voter.getAddress());
		old_voter.setFirstName(voter.getFirstName());
		old_voter.setLastName(voter.getLastName());
		old_voter.setMobileNumber(voter.getMobileNumber());
		session.update(old_voter);
	}

	@Override
	public void delete_voter(int id) {
		Session session = sessionFactory.getCurrentSession();
		Voter voter = session.find(Voter.class, id);
		session.delete(voter);
	}

	@Override
	public List<Voter> get_active_voters() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Voter.class);
		Criterion criterion = Restrictions.eq("status", 1);
		criteria.add(criterion);
		List<Voter> a = criteria.list();
		return a;
	}

}
