package com.templatejsf;

import com.templatejsf.persistencia.dao.CarDAO;
import com.templatejsf.persistencia.modelos.Car;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class CarroBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Car carroSelecionado;
	private boolean nadaSelecionado = true;

	public List getListaCarros(){
		return new CarDAO().selectAll();
	}

	public Car getCarroSelecionado() {
		return carroSelecionado;
	}

	public void setCarroSelecionado(Car carroSelecionado) {
		System.out.println("SELECIONOU");
		nadaSelecionado = false;
		this.carroSelecionado = carroSelecionado;
	}

	public void deletar() {
	    if(getCarroSelecionado() == null)
            System.out.println("NULL");
	    else
		    System.out.println(getCarroSelecionado().getName());
	}

	public boolean isNadaSelecionado() {
		return nadaSelecionado;
	}
}