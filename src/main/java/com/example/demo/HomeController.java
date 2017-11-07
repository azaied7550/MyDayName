package com.example.demo;

import org.springframework.stereotype.Controller;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.format.DateTimeFormatter;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String homepage (Model model){
        return "dates";
    }

    @RequestMapping("/processform")
    public String homepage(@RequestParam("date") String date, @RequestParam("gender") String gender, Model model){

        DateTimeFormatter weekF= DateTimeFormatter.ofPattern("EEEE");
        DateTimeFormatter actualDate= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateNow=LocalDate.parse(date, actualDate);
        String dateWeek= dateNow.format(weekF);


        String femaleName="";
        String maleName="";
        String character="";

        if (dateWeek.equalsIgnoreCase("Sunday")){
            femaleName="Akosua";
            maleName="Kwesi";
            character="Born leader, guide, protector";
        }
        if (dateWeek.equalsIgnoreCase("Monday")){
            femaleName="Adjoa";
            maleName="Kojo";
            character="Calm,peaceful";
        }
        if (dateWeek.equalsIgnoreCase("Tuesday")){
            femaleName="Abena";
            maleName="Kwabena";
            character="Warrior, fierce, compassionate";
        }
        if (dateWeek.equalsIgnoreCase("Wednesday")){
            femaleName="Akua";
            maleName="Kweku";
            character="Advocate, controlling";
        }
        if (dateWeek.equalsIgnoreCase("Thursday")){
            femaleName="Yaa";
            maleName="Yaw";
            character="Confrontational, aggressive";


        }
        if (dateWeek.equalsIgnoreCase("Friday")){
            femaleName="Afua";
            maleName="Kofi";
            character="Adventurous, creative, innovative";
        }
        if (dateWeek.equalsIgnoreCase("Saturday")){
            femaleName="Ama";
            maleName="Kwame";
            character="The ancient wise one.";
        }
        if (gender.equalsIgnoreCase("male"))
        {
            model.addAttribute("dateval", dateWeek);
            model.addAttribute("maleval", maleName);
            model.addAttribute("characterval",character);
        }
        if (gender.equalsIgnoreCase("female")){
            model.addAttribute("dateval", dateWeek);
            model.addAttribute("femaleval", femaleName);
            model.addAttribute("characterval",character);
        }
        if (gender.equalsIgnoreCase("both")){
            model.addAttribute("dateval", dateWeek);
            model.addAttribute("femaleval", femaleName);
            model.addAttribute("maleval", maleName);
            model.addAttribute("characterval",character);
        }

        return "dayofweek";
    }

}
