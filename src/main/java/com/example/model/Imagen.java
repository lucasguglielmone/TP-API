package modelo;

@Entity
@Table(name = "imagenes")
public class Imagen {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int numero;
	@Column
	private String path;
	@Column
	private String tipo;
	@ManyToOne
	@JoinColumn(name = "idReclamo")
	private Reclamo idReclamo;

	public Imagen(String direccion, String tipo) {
		this.direccion = direccion;
		this.tipo = tipo;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
