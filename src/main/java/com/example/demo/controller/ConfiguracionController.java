package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Configuracion;
import com.example.demo.service.ConfiguracionServicio;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
@RequestMapping(path = "api/v1/configuracion")
public class ConfiguracionController extends ControllerGenerico<Configuracion, ConfiguracionServicio>{

}
