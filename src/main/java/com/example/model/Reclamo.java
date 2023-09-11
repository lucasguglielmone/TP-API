package modelo;

import java.util.ArrayList;
import java.util.List;

import views.Estado;

@Entity
@Table(name = "reclamos")
public class Reclamo {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReclamo;
	@ManyToOne
	@JoinColumn(name = "documento", referencedColumnName = documento)
	private Persona documento;
	@OneToMany
	@JoinColumn(name = "codigo", referencedColumnName = "codigo")
	private Edificio codigo;
	@Column
	private String ubicacion;
	@Column
	private String descripcion;
	@ManyToOne
	@JoinColumn(name = "identificador")
	private Unidad identificador;
	@Column
	private Estado estado;
	@OneToMany
	private List<Imagen> imagenes;
	
	public Reclamo(Persona documento, Edificio codigo, String ubicacion, String descripcion, Unidad identificador) {
		this.documento = documento;
		this.codigo = codigo;
		this.ubicacion = ubicacion;
		this.descripcion = descripcion;
		this.identificador = identificador;
		this.estado = Estado.nuevo;
		imagenes = new ArrayList<Imagen>();
	}

	public void agregarImagen(String direccion, String tipo) {
		Imagen imagen = new Imagen(direccion, tipo);
		imagenes.add(imagen);
	}
	
	public int getNumero() {
		return idReclamo;
	}

	public void setNumero(int idReclamo) {
		this.idReclamo = idReclamo;
	}

	public Persona getUsuario() {
		return documento;
	}

	public Edificio getEdificio() {
		return codigo;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Unidad getUnidad() {
		return identificador;
	}

	public Estado getEstado() {
		return estado;
	}
	
	public List<Imagen> getImagenes(){
		return this.imagenes;
	}
	
	public void cambiarEstado(Estado estado) {
		this.estado = estado;
	}

}
