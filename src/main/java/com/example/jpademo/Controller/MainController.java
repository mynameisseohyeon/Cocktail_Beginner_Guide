package com.example.jpademo.Controller;

import com.example.jpademo.Entity.Cocktail;
import com.example.jpademo.Entity.CocktailDTO;
import com.example.jpademo.Service.CocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cocktail")
public class MainController {


    @Autowired
    CocktailService cocktailService;

    @RequestMapping
    public String redirectToList() {
        return "redirect:/cocktail/";
    }

    @RequestMapping("/")
    public String list(Model model) {
        // 모든 칵테일 데이터를 모델에 추가
        model.addAttribute("cocktails", cocktailService.findAll());
        return "list";
    }

    @GetMapping("/search")
    public String search(String keyword, Model model) { // 칵테일 검색
        List<CocktailDTO> searchResults = cocktailService.findByKeyword(keyword);
        model.addAttribute("cocktails", searchResults);
        return "list";
    }

    @GetMapping("/filter")
    public String filter(@RequestParam(value = "price", required = false) String price,
                         @RequestParam(value = "abv", required = false) String abv,
                         @RequestParam(value = "ageGroup", required = false) String ageGroup,
                         Model model) {
        List<CocktailDTO> cocktails = cocktailService.filterBySelect(price, abv, ageGroup);

        model.addAttribute("cocktails", cocktails);
        model.addAttribute("selectedPrice", price);
        model.addAttribute("selectedAlcohol", abv);
        model.addAttribute("selectedageGroup", ageGroup);

        return "list";
    }

    @GetMapping("/today")
    public String today(Model model) {
        model.addAttribute("cocktails", cocktailService.findAll());
        return "today";
    }

    @RequestMapping("/addform")
    public String addform()  {
        return "addform";
    }

    @RequestMapping("/add")
    public String add(@ModelAttribute CocktailDTO cocktail) {
        if (cocktail.getIngredients() == null) {
            cocktail.setIngredients(new ArrayList<>());
        }
        cocktailService.save(cocktail);
        return "redirect:/cocktail/";
    }


    @RequestMapping("/{idx}")
    public String read(@PathVariable long idx,
                       @RequestParam(value = "button_text", required = false) String buttonText,
                       Model model) {

        CocktailDTO cocktail = cocktailService.findById(idx);
        model.addAttribute("cocktail", cocktail);

        if (buttonText != null) {
            model.addAttribute("buttonText", buttonText);
        }

        System.out.println(cocktail);
        return "read";
    }

    @RequestMapping("/delete/{idx}")
    public String delete(@PathVariable long idx)  { // idx에 해당하는 칵테일 삭제
        cocktailService.deleteById(idx);
        return "redirect:/cocktail/";
    }


    @RequestMapping("/updateform/{idx}")
    public String updatecocktail(@PathVariable Long idx, Model model) { // idx에 해당하는 칵테일 수정
        CocktailDTO cocktail = cocktailService.findById(idx);
        model.addAttribute("cocktails", cocktail);
        return "updateform";
    }

    @RequestMapping("/update")
    public String update(@ModelAttribute CocktailDTO cocktail)  {
        if (cocktail.getIngredients() == null) {
            cocktail.setIngredients(new ArrayList<>());
        }
        cocktailService.save(cocktail);
        return "redirect:/cocktail/";

    }

}