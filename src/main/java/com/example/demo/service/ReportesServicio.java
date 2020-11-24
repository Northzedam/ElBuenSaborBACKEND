package com.example.demo.service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.PedidoDto;
import com.example.demo.dtos.ReporteGananciasDto;
import com.example.demo.dtos.ReporteMasVendidosDto;
import com.example.demo.entity.Articulo;
import com.example.demo.entity.DetallePedido;
import com.example.demo.entity.Pedido;
import com.example.demo.repository.ArticuloRepository;
import com.example.demo.repository.PedidoRepository;

@Service
public class ReportesServicio {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	ArticuloRepository articuloRepository;
	
	public List<ReporteMasVendidosDto> findArticulosMasVendidos(String fechaDesdeHasta) throws Exception{

		String fechaDedeHastaConEspacios = fechaDesdeHasta.replace('%',' ');
		String fechaDesde = fechaDesdeHasta.substring(0,19);
		String fechaHasta = fechaDesdeHasta.substring(20,39);
		
		System.out.println("Fecha Desde: " + fechaDesde + " --- Fecha Hasta: " + fechaHasta);
		
		Date dateFechaDesde = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechaDesde);
		Date dateFechaHasta = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechaHasta);
		
		System.out.println("Fecha Desde convertida a tipo Date: " + dateFechaDesde);

		System.out.println("Fecha Hasta convertida a tipo Date: " + dateFechaHasta);

		
		List<Articulo>articulos = new ArrayList<Articulo>();
		try {
			articulos = articuloRepository.findAll();

		} catch (Exception e) {
			System.out.println("Error al obtener todos los articulos");
		}
		
		HashMap<String,Integer>statsArticulo = new HashMap<String,Integer>(); //almacena las clave-valor de articulo y cantidad vendida
		
		List<ReporteMasVendidosDto>dtos = new ArrayList<ReporteMasVendidosDto>();
		List<Pedido>pedidos = new ArrayList<Pedido>();
		try {
			pedidos = pedidoRepository.findPedidosByFecha(dateFechaDesde, dateFechaHasta);
		} catch (Exception e) {
			System.out.println("Error al obtener todos los pedidos por fecha");
		}
		
		List<DetallePedido>detalles = new ArrayList<DetallePedido>();
		for(Pedido pedido : pedidos) {
			for(DetallePedido detallePedido : pedido.getDetalles()) {
				detalles.add(detallePedido);
			}
		}
		
		// ahora que ya obtuve toda la lista de articulos y todos los detalles por fecha, calculo los totales para cada art
		
		for(Articulo art : articulos) {
			for(DetallePedido detalle : detalles) {
				if(detalle.getArticulo().getDenominacion() == art.getDenominacion()) { // si coincide el nombre del articulo del detalle con el articulo en analisis
					try {
						if(statsArticulo.containsKey(art.getDenominacion())) {
							statsArticulo.put(art.getDenominacion(), statsArticulo.get(art.getDenominacion()) + detalle.getCantidad()); // suma el valor de la cantidad del detalle a lo que ya tenía el valor de esa clave
						}else {
							statsArticulo.put(art.getDenominacion(), detalle.getCantidad()); // suma el valor de la cantidad del detalle a lo que ya tenía el valor de esa clave
						}
					} catch (Exception e) {
						System.out.println("No se pudo setear el hashMap");
					}
				}
			}
		}
		
		// ahora que ya tengo los totales, armo los dto
		
		statsArticulo.forEach((k,v) -> System.out.println("Clave: "+k + "Valor: "+v));
		
		statsArticulo.forEach((k,v) -> {
			ReporteMasVendidosDto nuevoReporte = new ReporteMasVendidosDto();
			nuevoReporte.setDenominacion(k);
			nuevoReporte.setCantidad(v);
			nuevoReporte.setFechaDesde(fechaDesde);
			nuevoReporte.setFechaHasta(fechaHasta);
			dtos.add(nuevoReporte);
			
		});
		for(ReporteMasVendidosDto nuevoReporte : dtos) {
			System.out.println("Reporte:");
			System.out.println("Denominacion: "+nuevoReporte.getDenominacion() + " - Cantidad: " + nuevoReporte.getCantidad());
		}
		return dtos;
	}
	
	public List<ReporteGananciasDto>findGanancias(String fechaDesdeHasta) throws Exception{
		
		String fechaDedeHastaConEspacios = fechaDesdeHasta.replace('%',' ');
		String fechaDesde = fechaDesdeHasta.substring(0,19);
		String fechaHasta = fechaDesdeHasta.substring(20,39);
		
		System.out.println("Fecha Desde: " + fechaDesde + " --- Fecha Hasta: " + fechaHasta);
		
		Date dateFechaDesde = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechaDesde);
		Date dateFechaHasta = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechaHasta);
		
		List<Pedido>pedidos = new ArrayList<Pedido>();
		
		try {
			pedidos = pedidoRepository.findPedidosByFecha(dateFechaDesde, dateFechaHasta);
		} catch (Exception e) {
			System.out.println("Error al obtener todos los pedidos por fecha");
		}
		
		HashMap<String,Double>gananciasPorFecha = new HashMap<String,Double>();
		
		List<DetallePedido>detalles = new ArrayList<DetallePedido>();
		for(Pedido pedido : pedidos) {
			double totalGananciasPedido=0.0;
			for(DetallePedido detallePedido : pedido.getDetalles()) {
				totalGananciasPedido+= detallePedido.getArticulo().getPrecioVenta()-detallePedido.getArticulo().getPrecioCompra();
			}
			if(gananciasPorFecha.containsKey(pedido.getFecha().toString())) {
				gananciasPorFecha.put(pedido.getFecha().toString()  ,  gananciasPorFecha.get(pedido.getFecha())+totalGananciasPedido );

			}else {
				gananciasPorFecha.put(pedido.getFecha().toString(), totalGananciasPedido);
			}
		}
		
		//ahora que obtuve todos los detalles de la fecha, y las ganancias por fecha calculadas en el map, seteamos el dto
		
		gananciasPorFecha.forEach((k,v) -> {
			ReporteGananciasDto reporteGanancias = new ReporteGananciasDto(); 
			try {
				reporteGanancias.setFecha(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(k));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			reporteGanancias.setMonto(v);
		});
		
		return null;
		
	}
}
