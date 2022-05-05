package br.com.fiap.bean;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;

import org.primefaces.model.file.UploadedFile;

import br.com.fiap.dao.SetupDao;
import br.com.fiap.model.Setup;

@Named
@RequestScoped
public class SetupBean {

	private Setup setup = new Setup();
	private List<Setup> list;
	private UploadedFile image;
	
	private SetupDao setupDao = new SetupDao();
	
	public SetupBean() {
		list = this.list();
	}
	
	public String save() throws IOException {
		System.out.println(this.setup);
				
		System.out.println(image.getFileName());
		
		ServletContext  serveletContext= (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		
		String serveletPath = serveletContext.getRealPath("/");
		
		
		System.err.println(serveletPath);
		
		FileOutputStream out = new FileOutputStream(serveletPath + "\\images\\" + image.getFileName());
		
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Setup cadastrado com sucesso"));
		out.write(image.getContent());
		out.close();
		
		setup.setImagePath("\\images\\" + image.getFileName());
		
		setupDao.create(setup);
		
		return "setups";
	}
	
	public List<Setup> list() {
		return setupDao.listAll();
	}

	public List<Setup> getList() {
		return list;
	}

	public void setList(List<Setup> list) {
		this.list = list;
	}

	public Setup getSetup() {
		return setup;
	}

	public void setSetup(Setup setup) {
		this.setup = setup;
	}

	public UploadedFile getImage() {
		return image;
	}

	public void setImage(UploadedFile image) {
		this.image = image;
	}

}
