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

	public class Factura extends EntidadGenerica implements Serializable{
		private static final long serialVersionUID = 1L;

		@Column(name = "Fecha")
		private Date Fecha;
		
		@Column(name = "Numero")
		private int numero;

		@Column(name = "MontoDescuento")
		private double montoDescuento;

		@Column(name = "Total")
		private double total;

		@Column(name = "FormaDePago")
		private String formaDePago;

		@Column(name = "NTarjeta")
		private String nroTarjeta;

		public Factura() {
			super();
		}

		public Factura(Date fecha, int numero, double montoDescuento, double total, String formaDePago,
				String nroTarjeta) {
			super();
			Fecha = fecha;
			this.numero = numero;
			this.montoDescuento = montoDescuento;
			this.total = total;
			this.formaDePago = formaDePago;
			this.nroTarjeta = nroTarjeta;
		}

		public Date getFecha() {
			return Fecha;
		}

		public void setFecha(Date fecha) {
			Fecha = fecha;
		}

		public int getNumero() {
			return numero;
		}

		public void setNumero(int numero) {
			this.numero = numero;
		}

		public double getMontoDescuento() {
			return montoDescuento;
		}

		public void setMontoDescuento(double montoDescuento) {
			this.montoDescuento = montoDescuento;
		}

		public double getTotal() {
			return total;
		}

		public void setTotal(double total) {
			this.total = total;
		}

		public String getFormaDePago() {
			return formaDePago;
		}

		public void setFormaDePago(String formaDePago) {
			this.formaDePago = formaDePago;
		}

		public String getNroTarjeta() {
			return nroTarjeta;
		}

		public void setNroTarjeta(String nroTarjeta) {
			this.nroTarjeta = nroTarjeta;
		}
		
		

		
	}