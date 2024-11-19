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

import java.util.Arrays;
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

    @GetMapping("/search")  // 검색 시 메인 화면과 같은 ui에서 검색한 칵테일 명만 표시되도록 수정
    public String search(String keyword, Model model) {
        List<String> names = Arrays.asList("마가리타", "모히토", "올드 패션드", "피나 콜라다", "마티니");
        names.stream()
                .filter(n -> n.contains(keyword)) // 칵테일 name에 대한 검색 결과 제공
                .forEach(System.out::println); // 검색 결과 출력
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
