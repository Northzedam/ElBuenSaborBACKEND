package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.ArticuloManufacturado;
import com.example.demo.service.ArticuloManufacturadoServicio;


@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
@RequestMapping(path = "api/v1/articuloManufacturado")
public class ArticuloManufacturadoController extends ControllerGenerico<ArticuloManufacturado, ArticuloManufacturadoServicio> {

}


