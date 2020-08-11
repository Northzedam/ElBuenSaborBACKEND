package com.example.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.RubroGeneral;
import com.example.demo.service.RubroGeneralServicio;



@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
@RequestMapping(path = "api/v1/rubroGeneral")
public class RubroGeneralController extends ControllerGenerico<RubroGeneral, RubroGeneralServicio>{

}
