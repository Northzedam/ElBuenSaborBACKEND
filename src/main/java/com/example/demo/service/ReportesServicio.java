package com.example.demo.service;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.PedidoDto;
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
	
	public List<ReporteMasVendidosDto> findArticulosMasVendidos(Date fechaDesde, Date fechaHasta) throws Exception{
		
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
			pedidos = pedidoRepository.findPedidosByFecha(fechaDesde, fechaHasta);
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
}
