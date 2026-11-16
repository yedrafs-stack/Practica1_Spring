package es.studium.practica;

public class ArticuloAComprar
{
	private String descripcion;
	private int cantidad;
	private String unidad;
	
	public ArticuloAComprar(String descripcion, int cantidad, String unidad)
	{
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.unidad = unidad;
	}
	public String getDescripcion()
	{
		return descripcion;
	}
	public int getCantidad()
	{
		return cantidad;
	}
	public String getUnidad()
	{
		return unidad;
	}
}