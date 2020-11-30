package com.example.demo.service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.ArticuloDto;
import com.example.demo.dtos.InsumoDto;
import com.example.demo.dtos.PedidoDto;
import com.example.demo.dtos.ReporteGananciasDto;
import com.example.demo.dtos.ReporteMasVendidosDto;
import com.example.demo.dtos.ReportePedidosPorClienteDto;
import com.example.demo.dtos.UnidadMedidaDto;
import com.example.demo.entity.Articulo;
import com.example.demo.entity.Cliente;
import com.example.demo.entity.DetallePedido;
import com.example.demo.entity.Insumo;
import com.example.demo.entity.Pedido;
import com.example.demo.repository.ArticuloRepository;
import com.example.demo.repository.ClienteRepository;
import com.example.demo.repository.InsumoRepository;
import com.example.demo.repository.PedidoRepository;

@Service
public class ReportesServicio {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	ArticuloRepository articuloRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	InsumoRepository insumoRepository;
	
	public List<ReporteMasVendidosDto> findArticulosMasVendidos(String fechaDesdeHasta) throws Exception{
		
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
			pedidos = pedidoRepository.findPedidosByFecha(obtenerFechasDesdeHasta(fechaDesdeHasta)[0],obtenerFechasDesdeHasta(fechaDesdeHasta)[1]);
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
		
		//ordenamiento del hashMap en orden descendente:
		final Map<String, Integer> statsArticuloOrdenadasDesc = statsArticulo.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		
		statsArticuloOrdenadasDesc.forEach((k,v) -> {
			ReporteMasVendidosDto nuevoReporte = new ReporteMasVendidosDto();
			nuevoReporte.setDenominacion(k);
			nuevoReporte.setCantidad(v);
		try {
			nuevoReporte.setFechaDesde(obtenerFechasDesdeHasta(fechaDesdeHasta)[0].toString());
			nuevoReporte.setFechaHasta(obtenerFechasDesdeHasta(fechaDesdeHasta)[1].toString());
		} catch (Exception e) {
			System.out.println("no se pudo parsear las fechas a String");
		}
			
			dtos.add(nuevoReporte);
			
		});
		
		return dtos;
	}
	
	public List<ReporteGananciasDto>findGanancias(String fechaDesdeHasta) throws Exception{
		List<ReporteGananciasDto>dtos = new ArrayList<ReporteGananciasDto>();
		
		List<Pedido>pedidos = new ArrayList<Pedido>();
		
		try {
			pedidos = pedidoRepository.findPedidosByFecha(obtenerFechasDesdeHasta(fechaDesdeHasta)[0],obtenerFechasDesdeHasta(fechaDesdeHasta)[1]);
		} catch (Exception e) {
			System.out.println("Error al obtener todos los pedidos por fecha");
		}
		
		HashMap<String,Double>gananciasPorFecha = new HashMap<String,Double>();
		
		List<DetallePedido>detalles = new ArrayList<DetallePedido>();
		for(Pedido pedido : pedidos) {
			double totalGananciasPedido=0.0;
			for(DetallePedido detallePedido : pedido.getDetalles()) {
				totalGananciasPedido+= (detallePedido.getArticulo().getPrecioVenta()-detallePedido.getArticulo().getPrecioCompra())*detallePedido.getCantidad();
			}
			if(gananciasPorFecha.containsKey(pedido.getFecha().toString())) {
				gananciasPorFecha.put(pedido.getFecha().toString()  ,  gananciasPorFecha.get(pedido.getFecha())+totalGananciasPedido );

			}else {
				gananciasPorFecha.put(pedido.getFecha().toString(), totalGananciasPedido);
			}
		}
		
		//ahora que obtuve todos los detalles de la fecha, y las ganancias por fecha calculadas en el map, seteamos el dto
		HashMap<String,Double>gananciasPorMes = new HashMap<String,Double>();

		gananciasPorFecha.forEach((k,v) -> {
			ReporteGananciasDto reporteGanancias = new ReporteGananciasDto(); 
			//seteo el map de ganancias por mes que irá en el dto
			
			if(gananciasPorMes.containsKey(setMesPorFecha(k))) {
				gananciasPorMes.put(setMesPorFecha(k), gananciasPorMes.get(setMesPorFecha(k))+v);
			}else {
				gananciasPorMes.put(setMesPorFecha(k), v);
			}
			
			
			// ahora seteo el dto
			
			
			try {
				reporteGanancias.setFecha(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(k));
				reporteGanancias.setFechaDesde(obtenerFechasDesdeHasta(fechaDesdeHasta)[0].toString());
				reporteGanancias.setFechaHasta(obtenerFechasDesdeHasta(fechaDesdeHasta)[1].toString());

			} catch (ParseException e) {
				e.printStackTrace();
			}
			reporteGanancias.setMonto(v);
			dtos.add(reporteGanancias);
		});
		
		//reporteGanancias.setMapGananciasPorMes(gananciasPorMes);
		//reporteGanancias.setMapGananciasPorFecha(gananciasPorFecha);
		
	
		return dtos;
	
	}
	
	public String setMesPorFecha(String fecha) {
		String nombreMes;
		System.out.println("NumeroDelMes: " + fecha.substring(5,7));

		switch(fecha.substring(5,7)) {
		case "01": nombreMes="Enero";
		break;
		case "02": nombreMes="Febrero";
		break;
		case "03": nombreMes="Marzo";
		break;
		case "04": nombreMes="Abril";
		break;
		case "05": nombreMes="Mayo";
		break;
		case "06": nombreMes="Junio";
		break;
		case "07": nombreMes="Julio";
		break;
		case "08": nombreMes="Agosto";
		break;
		case "09": nombreMes="Septiembre";
		break;
		case "10": nombreMes="Octubre";
		break;
		case "11": nombreMes="Noviembre";
		break;
		case "12": nombreMes="Diciembre";
		break;
		
		default: nombreMes="Error";
		}
		return nombreMes;
	}
	
	public Date[] obtenerFechasDesdeHasta(String fechaDesdeHasta) throws ParseException {

		String fechaDedeHastaConEspacios = fechaDesdeHasta.replace('%',' ');
		String fechaDesde = fechaDesdeHasta.substring(0,19);
		String fechaHasta = fechaDesdeHasta.substring(20,39);
		
		Date dateFechaDesde = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechaDesde);
		Date dateFechaHasta = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechaHasta);
		Date fechas[] = {dateFechaDesde,dateFechaHasta};
		return fechas;
	}
	
public List<ReportePedidosPorClienteDto> findPedidosPorCliente(String fechaDesdeHasta) throws Exception{
		
		List<Cliente>clientes = new ArrayList<Cliente>();
		try {
			clientes = clienteRepository.findAll();
			clientes.forEach(k -> System.out.println(k.getNombre() + " " + k.getApellido()));
		} catch (Exception e) {
			System.out.println("Error al obtener todos los clientes");
		}
		
		HashMap<String,Integer>cantidadPedidosPorCliente = new HashMap<String,Integer>(); //almacena las clave-valor de articulo y cantidad vendida
		
		List<ReportePedidosPorClienteDto>dtos = new ArrayList<ReportePedidosPorClienteDto>();
		List<Pedido>pedidos = new ArrayList<Pedido>();
		try {
			pedidos = pedidoRepository.findPedidosByFecha(obtenerFechasDesdeHasta(fechaDesdeHasta)[0],obtenerFechasDesdeHasta(fechaDesdeHasta)[1]);
		} catch (Exception e) {
			System.out.println("Error al obtener todos los pedidos por fecha");
		}
		
		
		
		// ahora que ya obtuve toda la lista de clientes y todos los pedidos por fecha, calculo la cantidad de pedidos por cada cliente
		
		for(Cliente cliente : clientes) {
			//double montoTotalGastado=0.0;
			for(Pedido pedido : pedidos) {
				//montoTotalGastado+=pedido.getFactura().getTotal();
				
				if(pedido.getCliente().getEmail().equals(cliente.getEmail())) { // si coincide el nombre del articulo del detalle con el articulo en analisis
					
					if(cantidadPedidosPorCliente.containsKey(cliente.getEmail())) {
						cantidadPedidosPorCliente.put(pedido.getCliente().getEmail(), cantidadPedidosPorCliente.get(cliente.getEmail())+1);
					}else {
						cantidadPedidosPorCliente.put(pedido.getCliente().getEmail(),1);
					}
			
				}
			}
			
			ReportePedidosPorClienteDto nuevoReporte = new ReportePedidosPorClienteDto();
			nuevoReporte.setNombre(cliente.getNombre());
			nuevoReporte.setApellido(cliente.getApellido());
			if(cantidadPedidosPorCliente.get(cliente.getEmail()) != null) {
				nuevoReporte.setCantidadPedidos(cantidadPedidosPorCliente.get(cliente.getEmail()));
			}
			nuevoReporte.setEmail(cliente.getEmail());
			nuevoReporte.setTelefono(cliente.getTelefono());
			//nuevoReporte.setMontoTotalGastado(montoTotalGastado);
			

			dtos.add(nuevoReporte);
			
		}
		
		
		return dtos;
	}

public List<InsumoDto>findInsumosDebajoDeStockMinimo(){
	
	List<Insumo>insumosDebajoDeStockMinimo = new ArrayList<>();
	List<InsumoDto>insumos = new ArrayList<InsumoDto>();
	
	insumosDebajoDeStockMinimo = insumoRepository.findInsumosStockDebajoDelMinimo();
	for(Insumo i : insumosDebajoDeStockMinimo) {
		System.out.println("InsumoObtenido: " + i.getDenominacion() + "UnidadMedidaObtenida: " + i.getUnidadMedida().getUnidadMedida());
		InsumoDto insumoDto = new InsumoDto();
		insumoDto.setDenominacion(i.getDenominacion());
		insumoDto.setStockActual(i.getStockActual());
		insumoDto.setStockMinimo(i.getStockMinimo());
		insumoDto.setPrecioCompra(i.getPrecioCompra());
		UnidadMedidaDto unidadMedidaDto = new UnidadMedidaDto();
		unidadMedidaDto.setUnidadMedida(i.getUnidadMedida().getUnidadMedida());
		insumoDto.setUnidadMedida(unidadMedidaDto);
		insumos.add(insumoDto);
	}

	return insumos;
}
}

