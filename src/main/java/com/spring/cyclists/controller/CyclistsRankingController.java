package com.spring.cyclists.controller;

import com.spring.cyclists.model.Rank;
import com.spring.cyclists.model.User;
import com.spring.cyclists.service.RankService;
import com.spring.cyclists.service.SecurityService;
import com.spring.cyclists.service.UserService;
import com.spring.cyclists.validator.RankValidator;
import com.spring.cyclists.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;


// @RestController negrąžina view.
// Kadangi mums reikia grąžinti view pagal Spring MVC, naudojame @Controller
@Controller
//  @EnableAutoConfiguration - žymi konfigūracijos komponentą. Viduje leidžia kurti bean per metodus su @Bean
//  Ši klasės lygio anotacija nurodo Spring karkasui “atspėti” konfigūraciją,
//  remiantis priklausomybėmis (jar bibliotekos), kurias programuotojas įtraukė į projektą.
//  Šiuo atveju ji veikia kartu su main metodu.
@EnableAutoConfiguration
public class CyclistsRankingController {

    @Autowired
    private UserService userService;
    @Autowired
    private RankService rankService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private RankValidator rankValidator;

    @GetMapping({"/", "/ranks"})
    String home(Model model) {
        // Jeigu Model 'rank' nepraeina validacijos - per jį grąžinamos validacijos klaidos į View
        model.addAttribute("ranks", rankService.getAllRanks());
        // grąžiname JSP failą, turi būti talpinami 'webapp -> WEB-INF -> jsp' aplanke
        return "ranks";
    }


    @GetMapping("/registruoti")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registruoti";
    }

    @PostMapping("/registruoti")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registruoti";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/ranks";
    }

    @GetMapping("/prisijungti")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi");

        if (logout != null)
            model.addAttribute("message", "Sėkmingai atsijungėte");

        return "prisijungti";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/atnaujinti{id}")
    public String update(@RequestParam("id") long id, Model model) {
        model.addAttribute("rank", rankService.getById(id));
        return "atnaujinti";
    }

    // Kadangi atnaujinti rank forma naudoja POST metodą, čia irgi nurodome POST
    @RequestMapping(method = RequestMethod.POST, value = "/atnaujintiRank")
    public String updateRank(@ModelAttribute("rank") Rank rank) {
        rankService.update(rank);
        return "redirect:/rodyti?id=" + rank.getId();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/rodyti{id}")
    public String getById(@RequestParam("id") long id, Model model) {
        model.addAttribute("rank", rankService.getById(id));
        return "rank";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/trinti{id}")
    public String delete(@RequestParam("id") long id, Model model) {
        rankService.delete(id);
        model.addAttribute("ranks", rankService.getAllRanks());
        return "ranks";
    }

    @PostMapping("/add-new-rank")
    public String addNew(@Valid @ModelAttribute("rank") Rank rank,
                         BindingResult bindingResult,
                         @RequestParam HashMap<String, String> inputForm,
                         ModelMap outputForm) {

        rankValidator.validate(rank, bindingResult);
        if (bindingResult.hasErrors()) {
            return "add-new";
        }
        String name = inputForm.get("name");
        int rank2 = Integer.parseInt(inputForm.get("rank"));

        outputForm.put("name", name);
        outputForm.put("rank", rank);

        rankService.save(new Rank(name, rank2));
        return "redirect:/ranks";
    }

    @GetMapping("/add-new")
    public String addNew(Model model) {

        model.addAttribute("rank", new Rank());
        //grąžiname JSP failą, kuris turi būti talpinamas "webapp -> WEB-INF ->  JSP" folderi
        return "add-new";
    }

    @GetMapping("/403")
    public String _403() {
        return "403";
    }

}
