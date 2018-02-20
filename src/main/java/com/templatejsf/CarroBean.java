package com.templatejsf;

import com.templatejsf.persistencia.dao.CarDAO;
import com.templatejsf.persistencia.modelos.Car;
import org.omnifaces.cdi.ViewScoped;

import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class CarroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private List listaCarros;
	private Car carroSelecionado;

	public String getName() {
		CarDAO carDAO = new CarDAO();
		List<Car> listaCars = carDAO.selectAll();

		System.out.println("TAM LISTA: " + listaCars.size());

		for (Car car : listaCars) {
			System.out.println(car.getId() + ", " + car.getName() + ", " + car.getModel() + ", " + car.getPrice());
//			System.out.println(car.getId() + " - " + car.getDescricaomenu());
		}

		return "Allan";
	}

	public void setName(String name) {
		this.name = name;
	}

	public List getListaCarros(){
		return new CarDAO().selectAll();
	}

	public Car getCarroSelecionado() {
		return carroSelecionado;
	}

	public void setCarroSelecionado(Car carroSelecionado) {
		this.carroSelecionado = carroSelecionado;
	}

}