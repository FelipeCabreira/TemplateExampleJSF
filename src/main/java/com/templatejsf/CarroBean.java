package com.templatejsf;

import com.templatejsf.persistencia.dao.CarroDAO;
import com.templatejsf.persistencia.modelos.Carro;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class CarroBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Carro carroSelecionado;
	private boolean nadaSelecionado = true;
	private List<Carro> listaCarros;

	@Inject
	private CarroDAO carroDAO;

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
		System.out.println("SELECIONOU");
		nadaSelecionado = false;
		this.carroSelecionado = carroSelecionado;
	}

	public void deletar() {
//	    if(getCarroSelecionado() == null)
//            System.out.println("NULL");
//	    else
//		    System.out.println(getCarroSelecionado().getName());
		System.out.println("ANTES: " + listaCarros.size());
		for (int i = 0; i < listaCarros.size(); i++) {
			 if(listaCarros.get(i).getId() == getCarroSelecionado().getId()) {
				 listaCarros.remove(i);
				 break;
			 }
		}
		System.out.println("DEPOIS: " + listaCarros.size());
	}

	public boolean isNadaSelecionado() {
		return nadaSelecionado;
	}
}