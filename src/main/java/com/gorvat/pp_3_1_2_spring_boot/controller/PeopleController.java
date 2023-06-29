package com.gorvat.pp_3_1_2_spring_boot.controller;

import com.gorvat.pp_3_1_2_spring_boot.model.Person;
import com.gorvat.pp_3_1_2_spring_boot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonService personService;

    @Autowired
    public PeopleController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping()
    public String index(ModelMap model) {
        model.addAttribute("people", personService.getAllPeople());
        return "pages/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, ModelMap model) {
        model.addAttribute("person", personService.getPersonById(id));
        return "pages/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("person") Person person) {
        return "pages/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("person") Person person) {
        personService.addPerson(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(ModelMap model, @PathVariable("id") int id) {
        model.addAttribute("person", personService.getPersonById(id));
        return "pages/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Person person, @PathVariable("id") int id) {
        personService.updatePerson(id, person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        personService.removePerson(id);
        return "redirect:/people";
    }
}
