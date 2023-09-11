package com.example.modelo;

import java.util.ArrayList;
import java.util.List;

import exceptions.UnidadException;
import views.EdificioView;
import views.UnidadView;

@Entity
@Table(name = "unidades")
public class Unidad {
	@Id
	@Column(name = "identificador")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int identificador;
	@Column
	private String piso;
	@Column
	private String numero;
	@Column(nullable = false, columnDefinition = "varchar(1) default''")
	private boolean habitado;
	@JoinColumn(name = "codigoEdificio")
	private Edificio codigoEdificio;
	@ManyToMany
	@JoinTable(name = "duenios", joinColumns = @JoinColumn(name = "identificador"), inverseJoinColumns = @JoinColumn(name = "documento"))
	@OrderColumn(name = "id")
	private List<Persona> duenios;
	@ManyToMany
	@JoinTable(name = "inquilinos", joinColumns = @JoinColumn(name = "identificador"), inverseJoinColumns = @JoinColumn(name = "documento"))
	@OrderColumn(name = "id")
	private List<Persona> inquilinos;
	
	public Unidad(int identificador, String piso, String numero, Edificio codigoEdificio) {
		this.identificador = identificador;
		this.piso = piso;
		this.numero = numero;
		this.habitado = false;
		this.codigoEdificio = codigoEdificio;
		this.duenios = new ArrayList<Persona>();
		this.inquilinos = new ArrayList<Persona>();
	}

	public void transferir(Persona nuevoDuenio) {
		duenios = new ArrayList<Persona>();
		duenios.add(nuevoDuenio);
	}
	
	public void agregarDuenio(Persona duenio) {
		duenios.add(duenio);
	}
	
	public void alquilar(Persona inquilino) throws UnidadException {
		if(!this.habitado) {
			this.habitado = true;
			inquilinos = new ArrayList<Persona>();
			inquilinos.add(inquilino);
		}
		else
			throw new UnidadException("La unidad esta ocupada");
	}

	public void agregarInquilino(Persona inquilino) {
		inquilinos.add(inquilino);
	}
	
	public boolean estaHabitado() {
		return habitado;
	}
	
	public void liberar() {
		this.inquilinos = new ArrayList<Persona>();
		this.habitado = false;
	}
	
	public void habitar() throws UnidadException {
		if(this.habitado)
			throw new UnidadException("La unidad ya esta habitada");
		else
			this.habitado = true;
	}
	
	public int getId() {
		return identificador;
	}

	public String getPiso() {
		return piso;
	}

	public String getNumero() {
		return numero;
	}

	
	public Edificio getEdificio() {
		return codigoEdificio;
	}

	public List<Persona> getDuenios() {
		return duenios;
	}

	public List<Persona> getInquilinos() {
		return inquilinos;
	}

	public UnidadView toView() {
		EdificioView auxEdificio = codigoEdificio.toView();
		return new UnidadView(identificador, piso, numero, habitado, auxEdificio);
	}
}
