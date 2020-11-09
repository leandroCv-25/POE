package com.ifsp.instalamento.model.dao;

import javax.persistence.EntityManager;

import com.ifsp.instalamento.model.models.User;

public class UserDao extends GenericDao<User,Integer> {
	public UserDao(EntityManager entityManager) {
		super(entityManager);
	}
}
