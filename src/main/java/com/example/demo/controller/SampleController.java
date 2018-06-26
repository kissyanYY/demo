package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.bean.Person;
import com.example.demo.bean.User;
import com.example.demo.service.PersonServiceInterface;

@Controller  
@EnableAutoConfiguration  
public class SampleController {
	
	@Autowired
    private PersonServiceInterface service;
	
	@RequestMapping("/insert")  
    @ResponseBody  
    public String home(String name) {  
        User p = new User();
        p.setUsername(name);
        p.setPassword("123456");
        service.insertObj(p);
        return "Hello World!";  
    }  
	
	@RequestMapping("/create")  
    @ResponseBody  
    public String create(String tablename) {  
		if(tablename.equals("User")){
			service.createTable(User.class);
		}
        return "tableCreate";  
    }  
	
	@RequestMapping("/getP")  
    @ResponseBody  
    public String getPerson() { 
		Person p = (Person)service.getPersonByPropertis(Person.class,"GG");
		int a =  p.getAge();
		return "GG age:"+a;
	}
  
    public static void main(String[] args) throws Exception {  
        SpringApplication.run(SampleController.class, args);  
    }  
    
    
    @RequestMapping(value = "/index")
    public String index(Model  model)
    {
        Person single = new Person("hyj",21);
        List<Person> people = new ArrayList<Person>();
        Person p1 = new Person("dlp",21);
        Person p2 = new Person("tq",21);
        Person p3 = new Person("mk",21);
        people.add(p1);
        people.add(p2);
        people.add(p3);
        model.addAttribute("singlePerson",single);
        model.addAttribute("people",people);
        return "index";
    }
    
    @RequestMapping(value = "/init")
    public String init(Model  model)
    {
    	System.out.println("init");
        return "login";
    }
    
    @RequestMapping(value = "/login")
    @ResponseBody
    public  User login(@Valid User user,BindingResult result, Model  model)
    {
    	   if (result.hasErrors()) {
               List<ObjectError> error = result.getAllErrors();
               for (ObjectError e : error) {
                   System.out.println(e);
               }
               return null;
           }
    	   System.out.println("TO LOGIN"+user.getUsername());
    	   User u  =service.getPersonByPropertis(User.class,user.getUsername());
    	   	
           return user;
    }
    
}
