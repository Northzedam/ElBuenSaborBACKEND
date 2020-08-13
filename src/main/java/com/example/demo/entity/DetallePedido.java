package com.example.demo.entity;
	
	import java.io.Serializable;
	import java.util.Date;

	import javax.persistence.CascadeType;
	import javax.persistence.Column;
	import javax.persistence.FetchType;
	import javax.persistence.JoinColumn;
    import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

	public class DetallePedido extends EntidadGenerica implements Serializable{
		private static final long serialVersionUID = 1L;

		@Column(name = "Cantidad")
		private int cantidad;
		
		@Column(name = "Subtotal")
		private double subtotal;
		
		@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		@JoinColumn(name="ArticuloConsumo")
		private ArticuloConsumo articuloConsumo;
		
		@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		@JoinColumn(name="ArticuloManufacturado")
		private ArticuloManufacturado articuloManufacturado;
		
		
		
}
