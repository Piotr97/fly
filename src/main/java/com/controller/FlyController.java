/*
package com.controller;

import com.model.entity.Flight;
import com.model.entity.Tourist;
import com.service.FlyService;
import com.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("flyapp")
public class FlyController {

    private FlyService flyService;
    private TouristService touristService;

    public FlyController(FlyService flyService, TouristService touristService) {
        this.flyService = flyService;
        this.touristService = touristService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("flights", flyService.getAllFlight());
        model.addAttribute("turists", touristService.getAllTurist());
        return "index";
    }

    @PostMapping("/add/turist")
    public String addTurists(@ModelAttribute Tourist tourist){
        Tourist tourist1 = new Tourist();
        tourist1.setFlyList(tourist.getFlyList());
        tourist1.setNote(tourist.getNote());
        tourist1.setCountry(tourist.getCountry());
        tourist1.setDateOfBirth(tourist.getDateOfBirth());
        tourist1.setLastName(tourist.getLastName());
        tourist1.setGender(tourist.getGender());
        tourist1.setName(tourist.getName());
        String result = touristService.addTurist(tourist).getName();
        return "redirect:/index";
    }
    @PostMapping("/add/fly")
    public String addFlights(@ModelAttribute Flight flight){
        Flight flight1 = new Flight();
        flight1.setPriceTicket(flight.getPriceTicket());
        flight1.setTouristList(flight.getTouristList());
        flight1.setFlyStart(flight.getFlyStart());
        flight1.setFlyEnd(flight.getFlyEnd());
        flight1.setNumberOfSeats(flight.getNumberOfSeats());
        int result = flyService.addFlight(flight).getNumberOfSeats();
        return "redirect:/index";
    }

    @GetMapping("/delete/turist")
    public String deleteTurist(@RequestParam long id){
        touristService.deleteTurist(id);
        return "index";
    }

    @GetMapping("/delete/fly")
    public String deleteFlight(@RequestParam long id){
       flyService.deleteFlight(id);
        return "index";
    }

    @PostMapping("/update/turist")
    public String updateTurist(@ModelAttribute Tourist tourist){
        Tourist tourist1 = new Tourist();
        tourist1.setFlyList(tourist.getFlyList());
        tourist1.setNote(tourist.getNote());
        tourist1.setCountry(tourist.getCountry());
        tourist1.setDateOfBirth(tourist.getDateOfBirth());
        tourist1.setLastName(tourist.getLastName());
        tourist1.setGender(tourist.getGender());
        tourist1.setName(tourist.getName());
        String result = touristService.updateTurist(tourist.getId(), tourist).getName();
        return "redirect:/index";
    }

    @GetMapping("/update/fly")
    public String updateFlight(Model model, @RequestParam long id) {
        Flight flight = flyService.updateFlightById(id);
        if (flight == null) {
            return "Can't find fly!";
        }
        model.addAttribute("flight", flight);
        return "update-page";
    }

    @PostMapping("/update/fly/confirm")
    public String updateFlightsConfirm(@ModelAttribute Flight flight){
        Flight flight1 = new Flight();
        flight1.setPriceTicket(flight.getPriceTicket());
        flight1.setTouristList(flight.getTouristList());
        flight1.setFlyStart(flight.getFlyStart());
        flight1.setFlyEnd(flight.getFlyEnd());
        flight1.setNumberOfSeats(flight.getNumberOfSeats());
        int result = flyService.updateFlight(flight,flight.getId()).getNumberOfSeats();
        return "redirect:/index";
    }
}
*/
