
package com.Fet.app.controller;

import java.io.IOException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Fet.model.Student;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@RestController
public class XmlToJsonController {

	@GetMapping(path="/testing")
	public Student XmlToJson1() 
	{
		Student student = new Student();
		
		student.setId(12);
		student.setName("kelson");
		student.setAge(11);
		
		return student;
	}
	
	@GetMapping("/xml")
	 public String xmlToJson2()
	    {
	        String data = "<?xml version='1.0' encoding='UTF-8'?>"+
	                "<student>"+
	                "<age>11</age>"+
	                "<id>12</id>"+
	                "<name>Kelson</name>"+
	             "</student>";
	        

	            // Create a new XmlMapper to read XML tags
	            XmlMapper xmlMapper = new XmlMapper();
	            
	            //Reading the XML
	            JsonNode jsonNode = null;
				try {
					jsonNode = xmlMapper.readTree(data.getBytes());
					
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	            //Create a new ObjectMapper
	            ObjectMapper objectMapper = new ObjectMapper();
	            
	            //Get JSON as a string
	            String value = null;
				try {
					value = objectMapper.writeValueAsString(jsonNode);
		            return value;

				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return value;
	            
}}
	