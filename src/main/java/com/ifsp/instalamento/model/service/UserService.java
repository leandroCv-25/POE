package com.ifsp.instalamento.model.service;

import java.util.List;

import javax.persistence.EntityTransaction;

import com.ifsp.instalamento.estrutura.util.VariaveisProjeto;
import com.ifsp.instalamento.model.dao.UserDao;
import com.ifsp.instalamento.model.models.User;

public class UserService extends ConexaoBancoService {
	private UserDao userDao;

	public UserService() {
		this.userDao = new UserDao(this.getEntityManager());
	}

	public Integer save(User user) {

		Integer toReturn = 0;

		EntityTransaction trx = this.getTransaction();

		if ( validarDigitacao(user) == VariaveisProjeto.DIGITACAO_OK) {

			try {

				trx.begin();
				this.getUserDao().save(user);
				trx.commit();

			} catch (Exception ex) {
				ex.printStackTrace();
				if ( trx.isActive() ) {
					trx.rollback();
				}
				toReturn = VariaveisProjeto.ERRO_INCLUSAO;

			} finally {
				this.close();
			}
		} else {
			toReturn = VariaveisProjeto.CAMPO_VAZIO;
		}
		return toReturn; 
	}

	public Integer update(User user) {

		Integer toReturn = 0;

		EntityTransaction trx = this.getTransaction();

		if ( validarDigitacao(user) == VariaveisProjeto.DIGITACAO_OK) {

			try {

				trx.begin();
				this.getUserDao().update(user);
				trx.commit();

			} catch (Exception ex) {
				ex.printStackTrace();
				if ( trx.isActive() ) {
					trx.rollback();
				}
				toReturn = VariaveisProjeto.ERRO_ALTERACAO;

			} finally {
				this.close();
			}
		} else {
			toReturn = VariaveisProjeto.CAMPO_VAZIO;
		}
		return toReturn; 
	}

	public Integer delete(User user) {
		Integer toReturn = 0;
		EntityTransaction trx = this.getTransaction();
		try {

			trx.begin();
			User userEncontrado = this.getUserDao().findById(user.getId());
			this.getUserDao().remove(userEncontrado);;
			trx.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			if ( trx.isActive() ) {
				trx.rollback();
			}
			toReturn = VariaveisProjeto.ERRO_EXCLUSAO;

		} finally {
			this.close();
		}

		return toReturn; 
	}


	public User findById(Integer id) {
		return this.getUserDao().findById(id);
	}

	public List<User> findAll(){
		return this.getUserDao().findAll(User.class);
	}

	public Integer validarDigitacao(User user) {
		if ( VariaveisProjeto.digitacaoCampo(user.getUsername())) {
			return VariaveisProjeto.CAMPO_VAZIO;
		}
		return VariaveisProjeto.DIGITACAO_OK;
	}


	public UserDao getUserDao() {
		return userDao;
	}

}
