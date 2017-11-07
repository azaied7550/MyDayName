package com.example.demo;

import org.springframework.stereotype.Controller;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
    public String homepage(@RequestParam("date") String date, Model model){

        DateTimeFormatter weekF= DateTimeFormatter.ofPattern("EEEE");
        DateTimeFormatter actualDate= DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateNow=LocalDate.parse(date, actualDate);
        String dateWeek= dateNow.format(weekF);


        String femaleName="";
        String maleName="";

        if (dateWeek.equalsIgnoreCase("Sunday")){
            femaleName="Akosua";
            maleName="Kwesi";
        }
        if (dateWeek.equalsIgnoreCase("Monday")){
            femaleName="Adjoa";
            maleName="Kojo";
        }
        if (dateWeek.equalsIgnoreCase("Tuesday")){
            femaleName="Abena";
            maleName="Kwabena";
        }
        if (dateWeek.equalsIgnoreCase("Wednesday")){
            femaleName="Akua";
            maleName="Kweku";
        }
        if (dateWeek.equalsIgnoreCase("Thursday")){
            femaleName="Yaa";
            maleName="Yaw";
        }
        if (dateWeek.equalsIgnoreCase("Friday")){
            femaleName="Afua";
            maleName="Kofi";
        }
        if (dateWeek.equalsIgnoreCase("Saturday")){
            femaleName="Ama";
            maleName="Kwame";
        }

        model.addAttribute("dateval", dateWeek);
        model.addAttribute("femaleval", femaleName);
        model.addAttribute("maleval", maleName);

        return "dayofweek";
    }

}
