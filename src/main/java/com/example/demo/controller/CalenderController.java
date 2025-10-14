package com.example.demo.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class CalenderController {

    @GetMapping
    public String showCalender(

            // Refer to the year and month set in the request parameters in the URI and display the calendar for that year and month
            @RequestParam(value = "year", required = false) Integer year,
            @RequestParam(value = "month", required = false) Integer month,
            Model model) {

        /* If no values are set in the request parameters, get the current date and return the corresponding year and month
        (Example: when accessing the page for the first time) */
        LocalDate today = LocalDate.now();
        int currentYear = (year != null) ? year : today.getYear();
        int currentMonth = (month != null) ? month : today.getMonthValue();

        // Get the data for the first day of the specified year and month
        LocalDate firstDay = LocalDate.of(currentYear, currentMonth, 1);

        // Get the day of the week for the first day of the specified month
        int firstDayOfWeek = firstDay.getDayOfWeek().getValue();
        /* When displaying the calendar, we want each week to start with Sunday.
        If we use getDayOfWeek and then getValue, Sunday corresponds to 7, which results in a calendar starting with Monday.
        (Example: 1 2 3 4 5 6 7 → Mon Tue Wed Thu Fri Sat Sun)
        By converting Sunday’s value to 0, we can display a calendar starting with Sunday.
        (Example: 0 1 2 3 4 5 6 → Sun Mon Tue Wed Thu Fri Sat) */
        firstDayOfWeek = (firstDayOfWeek == 7) ? 0 : firstDayOfWeek;

        int daysInMonth = firstDay.lengthOfMonth();

        model.addAttribute("year", currentYear);
        model.addAttribute("month", currentMonth);
        model.addAttribute("firstDayOfWeek", firstDayOfWeek);
        model.addAttribute("daysInMonth", daysInMonth);

        return "calender";
    }

}