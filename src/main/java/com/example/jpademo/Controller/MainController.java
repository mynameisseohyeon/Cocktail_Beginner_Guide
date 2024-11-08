package com.example.jpademo.Controller;

import com.example.jpademo.Entity.CocktailDTO;
import com.example.jpademo.Service.CocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cocktail")
public class MainController {


    @Autowired
    CocktailService cocktailService;

    @RequestMapping("/")
    public String list(Model model) {// 데이터 확인
        model.addAttribute("cocktails", cocktailService.findAll());
//        System.out.println(cocktailService.findAll());
        return "list";
    }

    @RequestMapping("/addform")
    public String addform()  {
        return "addform";
    }

    @RequestMapping("/add")
    public String add(@ModelAttribute CocktailDTO cocktail)  {
        cocktailService.save(cocktail);
        return "redirect:/cocktail/";
    }

    @RequestMapping("/{idx}")
    public String read(@PathVariable long idx, Model model) {
        model.addAttribute("cocktails", cocktailService.findById(idx));
        System.out.println(cocktailService.findById(idx));
        return "read";
    }

    @RequestMapping("/delete/{idx}")
    public String delete(@PathVariable long idx)  {
        cocktailService.deleteById(idx);
        return "redirect:/cocktails";
    }


    @RequestMapping("/updateform/{idx}")
    public String updatecocktail(@PathVariable Long idx, Model model) {
        CocktailDTO cocktail = cocktailService.findById(idx);
        model.addAttribute("cocktails", cocktail);
        return "updateform";
    }

    @RequestMapping("/update")
    public String update(@ModelAttribute CocktailDTO cocktail)  {
        cocktailService.save(cocktail);
        return "redirect:/cocktail/";
    }

}
