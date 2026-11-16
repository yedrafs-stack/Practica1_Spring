package es.studium.practica;

import java.util.ArrayList;
import java.util.List;

public class ListaDeLaCompra
{
	private String nombreLista;
	private List<ArticuloAComprar> articulos;

	public ListaDeLaCompra()
	{
		this.nombreLista = "";
		this.articulos = new ArrayList<ArticuloAComprar>();
	}
	public ListaDeLaCompra(String nombreLista)
	{
		this.nombreLista = nombreLista;
		this.articulos = new ArrayList<ArticuloAComprar>();
	}
	public String getNombreLista()
	{
		return nombreLista;
	}
	public void setNombreLista(String nombreLista)
	{
		this.nombreLista = nombreLista;
	}
	public void agregarProductoAComprar(ArticuloAComprar articulo)
	{
		articulos.add(articulo);
	}
	public void eliminarArticulo(String descripcionArticulo)
	{
		for (int i = 0; i < articulos.size(); i++)
		{
			if (articulos.get(i).getDescripcion().equals(descripcionArticulo))
			{
				articulos.remove(i);
				return;
			}
		}
	}
	public List<ArticuloAComprar> getArticulos()
	{
		return articulos;
	}
}