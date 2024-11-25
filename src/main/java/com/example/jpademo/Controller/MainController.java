package com.example.jpademo.Controller;

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
    public String search(String keyword, Model model) {
        List<CocktailDTO> searchResults = cocktailService.findByKeyword(keyword);
        model.addAttribute("cocktails", searchResults);
        return "list";
    }

    @GetMapping("/filter")
    public String filter(@RequestParam(value = "price", required = false) String price, Model model) {
        List<CocktailDTO> searchResults;

        if (price != null) {
            switch (price) {
                case "under_10000":
                    searchResults = cocktailService.findByPriceLessThanEqual(10000);
                    break;
                case "over_10000":
                    searchResults = cocktailService.findByPriceGreaterThanEqualAndLessThan(10000, 20000);
                    break;
                case "over_20000":
                    searchResults = cocktailService.findByPriceGreaterThanEqualAndLessThan(20000, 30000);
                    break;
                case "over_30000":
                    searchResults = cocktailService.findByPriceGreaterThanEqualAndLessThan(30000, 40000);
                    break;
                case "over_40000":
                    searchResults = cocktailService.findByPriceGreaterThanEqual(40000);
                    break;
                default:
                    searchResults = cocktailService.findAll();  // 기본적으로 모든 데이터 반환
                    break;
            }
        } else {
            searchResults = cocktailService.findAll();
        }

        model.addAttribute("cocktails", searchResults);
        model.addAttribute("selectedPrice", price);
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
        model.addAttribute("cocktail", cocktailService.findById(idx));
        return "read";
    }

    @RequestMapping("/delete/{idx}")
    public String delete(@PathVariable long idx)  {
        cocktailService.deleteById(idx);
        return "redirect:/cocktail/";
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
