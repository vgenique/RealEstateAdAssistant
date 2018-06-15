package com.capgemini.imagereco.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	private List<String> myList = this.getMyList();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public void initController() {
		

	}
	
	//
	
	public ModelAndView api() {
		ModelAndView test = new ModelAndView("ApiForm");
		return test;
	}

	public List<String> getMyList() {
		String[] rooms = new String[] { "living room", "bed room", "shower", "kitchen", "water closet" };
		myList = Arrays.asList(rooms);
		return myList;
	}

	public void setMyList(List<String> myList) {
		this.myList = myList;
	}

}
