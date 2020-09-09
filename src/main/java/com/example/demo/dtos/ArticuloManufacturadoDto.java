
package com.example.demo.dtos;

import java.util.ArrayList;
import java.util.List;

public class ArticuloManufacturadoDto  {

	

	
	private long id;
	
	
	private int tiempoEstimadoCocina;
	
	
	private String denominacion;
	
	
	private double precioVenta;
	
	
	private RubroGeneralDto rubroGeneral;
	
	
	private List<DetallePedidoDto> detallePedido = new ArrayList<DetallePedidoDto>();
	

	private List<DetalleFacturaDto> detalleFactura = new ArrayList<DetalleFacturaDto>();
    
	
	private List<ArticuloManufacturadoDetalleDto> articuloManufacturadoDetalle = new ArrayList<ArticuloManufacturadoDetalleDto>();
		
	//Constructores
	
	public ArticuloManufacturadoDto() {
		//super();
	}


	public ArticuloManufacturadoDto(long id, int tiempoEstimadoCocina, String denominacion, double precioVenta) {
		super();
		this.id = id;
		this.tiempoEstimadoCocina = tiempoEstimadoCocina;
		this.denominacion = denominacion;
		this.precioVenta = precioVenta;
		
	}

	
	//GETTERS Y SETTERS ------------------------------------------------------------------------

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public int getTiempoEstimadoCocina() {
		return tiempoEstimadoCocina;
	}


	public void setTiempoEstimadoCocina(int tiempoEstimadoCocina) {
		this.tiempoEstimadoCocina = tiempoEstimadoCocina;
	}


	public String getDenominacion() {
		return denominacion;
	}


	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}


	public double getPrecioVenta() {
		return precioVenta;
	}


	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}


	/*public RubroGeneral getRubroGeneral() {
		return rubroGeneral;
	}


	public void setRubroGeneral(RubroGeneral rubroGeneral) {
		this.rubroGeneral = rubroGeneral;
	}
	*/

	
	
}
