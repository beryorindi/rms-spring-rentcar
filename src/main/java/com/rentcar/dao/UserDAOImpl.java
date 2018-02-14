package com.rentcar.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.rentcar.entity.User;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUserList() {
		String hql = "FROM User as user JOIN user.roles userrole WHERE userrole.role = 'USER' ORDER BY user.userdetail.name";
		return (List<User>)em.createQuery(hql).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAdminList() {
		String hql = "FROM User as user JOIN user.roles userrole WHERE userrole.role = 'ADMIN' ORDER BY user.userdetail.name";
		return (List<User>)em.createQuery(hql).getResultList();
	}

	@Override
	public void addUser(User user) {
		em.persist(user);
	}

	@Override
	public void updateUser(User user) {
		em.merge(user);
	}

	@Override
	public void deleteUser(int id) {
		em.remove(getUserById(id));
	}

	@Override
	public User getUserById(int id) {
		return em.find(User.class, id);
	}

	@Override
	public User getUserByEmail(String email) {
		String hql = "FROM User as user WHERE user.email = ?";
		return (User)em.createQuery(hql)
						.setParameter(1, email)
						.getSingleResult();
	}

}
