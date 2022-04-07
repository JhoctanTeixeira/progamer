package br.com.fiap.bean;


import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.fiap.dao.SetupDao;
import br.com.fiap.model.Setup;

@Named
@RequestScoped
public class SetupBean {

	private Setup setup = new Setup();
	
	public void save() {
		System.out.println(this.setup);
		SetupDao setupDao = new SetupDao();
		setupDao.create(setup);
	}
	
	public void list() {
		SetupDao setupDao = new SetupDao();
		List<Setup> list = setupDao.listAll();
		list.forEach(setup -> System.out.println(setup));
	}

	public Setup getSetup() {
		return setup;
	}

	public void setSetup(Setup setup) {
		this.setup = setup;
	}

}
