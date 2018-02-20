package com.templatejsf;

import com.templatejsf.persistencia.dao.CarDAO;
import com.templatejsf.persistencia.modelos.Car;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
public class HelloBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

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

}