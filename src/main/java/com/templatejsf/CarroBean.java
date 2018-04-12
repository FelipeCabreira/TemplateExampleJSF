package com.templatejsf;

import com.templatejsf.persistencia.dao.CarroDAO;
import com.templatejsf.persistencia.modelos.Carro;
import org.omnifaces.util.Messages;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class CarroBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Carro carroSelecionado;
	private boolean nadaSelecionado = true;
	private List<Carro> listaCarros;
//	@Inject
	private CarroDAO carroDAO = new CarroDAO();

	@PostConstruct
	public void inicializa(){
		setListaCarros();
	}

	public void setListaCarros() {
		listaCarros = carroDAO.selectAll();
	}

	public List getListaCarros(){
		return listaCarros;
	}

	public Carro getCarroSelecionado() {
		return carroSelecionado;
	}

	public void setCarroSelecionado(Carro carroSelecionado) {
		nadaSelecionado = false;
		this.carroSelecionado = carroSelecionado;
	}

	public void deletar() {
		Carro carro = carroDAO.selectById(carroSelecionado.getId());
        carroDAO.delete(carro);

		for (int i = 0; i < listaCarros.size(); i++) {
			 if(listaCarros.get(i).getId() == carro.getId()){
			 	listaCarros.remove(i);
			 	break;
			 }
		}

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Successful",  "Your message: " + "Teste de mensagem") );

	}

	public boolean isNadaSelecionado() {
		return nadaSelecionado;
	}
}