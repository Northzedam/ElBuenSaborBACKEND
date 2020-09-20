package com.example.demo.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import com.example.demo.dtos.ClienteDto;
import com.example.demo.dtos.DetallePedidoDto;
import com.example.demo.dtos.FacturaDto;

public class PedidoDto {
	
	private long id;
	
	
	private Date fecha;
	
	
	private int numero;
	
	
	private String estado;

	
	private Date horaFin;
	
	
	private int tipoEnvio;

	
	private List<DetallePedidoDto> detallePedidos = new ArrayList<DetallePedidoDto>();

	
	private ClienteDto cliente;
	
	
	private FacturaDto factura;


	public PedidoDto() {
		super();
	}


	public PedidoDto(long id, Date fecha, int numero, String estado, Date horaFin, int tipoEnvio,
			List<DetallePedidoDto> detallePedidos, ClienteDto cliente, FacturaDto factura) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.numero = numero;
		this.estado = estado;
		this.horaFin = horaFin;
		this.tipoEnvio = tipoEnvio;
		this.detallePedidos = detallePedidos;
		this.cliente = cliente;
		this.factura = factura;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero(int numero) {
		this.numero = numero;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}


	public Date getHoraFin() {
		return horaFin;
	}


	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}


	public int getTipoEnvio() {
		return tipoEnvio;
	}


	public void setTipoEnvio(int tipoEnvio) {
		this.tipoEnvio = tipoEnvio;
	}


	public List<DetallePedidoDto> getDetallePedidos() {
		return detallePedidos;
	}


	public void setDetallePedidos(List<DetallePedidoDto> detallePedidos) {
		this.detallePedidos = detallePedidos;
	}


	public ClienteDto getCliente() {
		return cliente;
	}


	public void setCliente(ClienteDto cliente) {
		this.cliente = cliente;
	}


	public FacturaDto getFactura() {
		return factura;
	}


	public void setFactura(FacturaDto factura) {
		this.factura = factura;
	}



	
	
}
