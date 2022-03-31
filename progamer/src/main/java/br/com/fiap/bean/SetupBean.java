package br.com.fiap.bean;


import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.fiap.model.Setup;

@Named
@RequestScoped
public class SetupBean {

	private Setup setup = new Setup();

	public void save() {
		System.out.println(this.setup);
	}

	public Setup getSetup() {
		return setup;
	}

	public void setSetup(Setup setup) {
		this.setup = setup;
	}
	
	
}
