package alquileres.modelo;


/**
 * 
 * @author Christian
 * 
 * Representa a un vehículo en alquiler
 * De esta clase no se crearán instancias
 * 
 * De un vehículo se conoce su matrícula, marca, modelo y el precio a pagar por
 * día de alquiler
 * 
 * Para todo vehículo se puede calcular su coste de alquiler que depende del nº
 * de días que se alquile (llamaremos a esta operación calcularPrecioAlquiler() )
 * 
 * Dos vehículos pueden compararse por su matrícula (es su orden natural)
 * 
 * Dos vehículos son iguales si además de pertenecer a la misma clase tienen la
 * misma matrícula
 * 
 */
public abstract class Vehiculo implements Comparable<Vehiculo>{
	private String matricula;
	private String marca;
	private String modelo;
	private double precioDia;
	
	/**
	 * Constructor
	 */
	public Vehiculo(String matricula, String marca, String modelo,
	        double precioDia) {
		this.matricula = matricula.toUpperCase();
		this.marca = marca.toUpperCase();
		this.modelo = modelo.toUpperCase();
		this.precioDia = precioDia;
	}
	
	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the precioDia
	 */
	public double getPrecioDia() {
		return precioDia;
	}

	/**
	 * @param precioDia the precioDia to set
	 */
	public void setPrecioDia(double precioDia) {
		this.precioDia = precioDia;
	}
	/**
	 * Nos calcula el precio de alquiler en base a unos d�as y el precio por d�a del veh�culo.
	 */
	public double calcularPrecioAlquiler(int dias) {
		return dias * this.getPrecioDia();
	}
	/**
	 * Redefinici�n de este m�todo
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
		{
		return false;
		}
		if (obj == this)
		{
		return true;
		}
		if (this.getClass() != obj.getClass())
		{
		return false;
		}
		Vehiculo v = (Vehiculo) obj;
		return v.getMatricula().equals(this.getMatricula());
	}
	/**
	 * Redefinici�n del criterio natural de comparaci�n
	 */
	@Override
	public int compareTo(Vehiculo o) {
		return this.getMatricula().compareTo(o.getMatricula());
	}
	/**
	 * Redefinici�n de hashCode()
	 * 
	 */
	@Override
	public int hashCode() {
		return matricula.hashCode() * 13;
	}
	/**
	 * Muestra la informaci�n del veh�culo
	 */
	@Override
	public String toString() {
		return this.getClass().getSimpleName().toUpperCase() +
				"\nMatr�cula: " + this.getMatricula() + " | " +
				"Marca: " + this.getMarca() + " | " +
				"Modelo: " + this.getModelo() +
				"\nPrecio d�a alquiler: " + this.getPrecioDia() + "� | ";
	}
}