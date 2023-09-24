package com.data.controllers;

import com.data.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.data.services.PeopleServices;

import javax.validation.Valid;


@Controller
@RequestMapping("/people")
public class PeopleController {
    private final PeopleServices peopleServices;
@Autowired
    public PeopleController(PeopleServices peopleServices) {
        this.peopleServices = peopleServices;
    }
    @GetMapping()
    public String index (Model model){
    model.addAttribute("people", peopleServices.findAll());
    return "people/index";
    }

    @GetMapping("/{id}")
    public String show (@PathVariable("id") int id, Model model){
    model.addAttribute("person", peopleServices.findById(id));
    return "people/show";
    }

    @DeleteMapping ("/{id}")
    public String delete (@PathVariable("id") int id){
    peopleServices.deletePersonById(id);
    return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit (Model model, @PathVariable("id") int id){
    model.addAttribute("person", peopleServices.findById(id));
    return "people/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult, @PathVariable("id") int id){
    if (bindingResult.hasErrors()){
        return "people/edit";
    }
    peopleServices.updatePersonById(id, person);
    return "redirect:/people";

    }
}
