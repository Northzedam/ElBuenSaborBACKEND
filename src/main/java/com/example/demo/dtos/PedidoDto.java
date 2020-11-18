package com.example.demo.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;



import com.example.demo.entity.Cliente;
import com.example.demo.entity.DetallePedido;
import com.example.demo.entity.Factura;
import com.example.demo.entity.Pedido;

public class PedidoDto {
		

	public Date getHoraFin() {
		return horaFin;
	}



	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}


	private long id;
	
	
	private Date fecha;
	
	
	private int numero;
	
	
	private String estado;

	
	private int tiempoRequerido;
	
	
	private boolean conEnvio;

	
	private List<DetallePedidoDto> detalles = new ArrayList<DetallePedidoDto>();

	
	private Cliente cliente;
	
	
	private Factura factura;
	
	private Pedido pedido;
	
	private Date horaFin;
	
	
	//Los siguientes son datos que se van a mostrar en la recepción
	
	
	private long idEstadoPedido;
		
	private String nombreCliente;
		
	private String stringDetallePedido;	
	
	private int telCliente;	
	
	private String domicilioCliente;
	
	private String emailCliente;	
	
	private String stringEstadoPedido;	
	
	private Date fechaAnulado;
	
	

	public PedidoDto() {
		super();
	}



	public PedidoDto(long id, Date fecha, int numero, String estado, Date horaFin ,int tiempoRequerido, boolean conEnvio,
			List<DetallePedidoDto> detalles, Cliente cliente, Factura factura) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.numero = numero;
		this.estado = estado;
		this.tiempoRequerido = tiempoRequerido;
		this.horaFin = horaFin;
		this.conEnvio = conEnvio;
		this.detalles = detalles;
		this.cliente = cliente;
		this.factura = factura;
	}
	
	



	public PedidoDto(long id, Date fecha, int numero, String estado, Date horaFin, boolean conEnvio,
			List<DetallePedidoDto> detalles, Cliente cliente, Factura factura, Pedido pedido, long idEstadoPedido,
			String nombreCliente, String stringDetallePedido, int telCliente, String domicilioCliente,
			String stringEstadoPedido, Date fechaAnulado) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.numero = numero;
		this.estado = estado;
		this.horaFin = horaFin;
		this.conEnvio = conEnvio;
		this.detalles = detalles;
		this.cliente = cliente;
		this.factura = factura;
		this.pedido = pedido;
		this.idEstadoPedido = idEstadoPedido;
		this.nombreCliente = nombreCliente;
		this.stringDetallePedido = stringDetallePedido;
		this.telCliente = telCliente;
		this.domicilioCliente = domicilioCliente;
		this.stringEstadoPedido = stringEstadoPedido;
		this.fechaAnulado = fechaAnulado;
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


	public int getTiempoRequerido() {
		return tiempoRequerido;
	}


	public void setTiempoRequerido(int tiempoRequerido) {
		this.tiempoRequerido = tiempoRequerido;
	}


	public boolean getConEnvio() {
		return conEnvio;
	}


	public void setConEnvio(boolean conEnvio) {
		this.conEnvio = conEnvio;
	}


	public List<DetallePedidoDto> getDetalles() {
		return detalles;
	}


	public void setDetalles(List<DetallePedidoDto> detalles) {
		this.detalles = detalles;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public Factura getFactura() {
		return factura;
	}


	public void setFactura(Factura factura) {
		this.factura = factura;
	}


	public long getIdEstadoPedido() {
		return idEstadoPedido;
	}


	public void setIdEstadoPedido(long idEstadoPedido) {
		this.idEstadoPedido = idEstadoPedido;
	}


	public String getNombreCliente() {
		return nombreCliente;
	}


	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}


	public String getStringDetallePedido() {
		return stringDetallePedido;
	}


	public void setStringDetallePedido(String stringDetallePedido) {
		this.stringDetallePedido = stringDetallePedido;
	}


	public int getTelCliente() {
		return telCliente;
	}


	public void setTelCliente(int telCliente) {
		this.telCliente = telCliente;
	}


	public String getDomicilioCliente() {
		return domicilioCliente;
	}


	public void setDomicilioCliente(String domicilioCliente) {
		this.domicilioCliente = domicilioCliente;
	}


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	public String getStringEstadoPedido() {
		return stringEstadoPedido;
	}


	public void setStringEstadoPedido(String stringEstadoPedido) {
		this.stringEstadoPedido = stringEstadoPedido;
	}


	public Date getFechaAnulado() {
		return fechaAnulado;
	}


	public void setFechaAnulado(Date fechaAnulado) {
		this.fechaAnulado = fechaAnulado;
	}



	public String getEmailCliente() {
		return emailCliente;
	}



	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}
	
	
	
	
	
	
}
