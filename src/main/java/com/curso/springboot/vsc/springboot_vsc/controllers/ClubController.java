package com.curso.springboot.vsc.springboot_vsc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.curso.springboot.vsc.springboot_vsc.dto.ClubDto;
import com.curso.springboot.vsc.springboot_vsc.models.Club;
import com.curso.springboot.vsc.springboot_vsc.service.ClubService;

import jakarta.validation.Valid;




@Controller
public class ClubController {
    private ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    public String listClubs(Model model){
        List<ClubDto> clubs = clubService.findAllClubs();

        model.addAttribute("clubs", clubs);

        return "clubs-list";
    }

    @GetMapping("/clubs/{clubId}")
    public String getMethodName(@PathVariable("clubId") long clubId, Model model) {
        ClubDto clubDto = clubService.findClubById(clubId);
        model.addAttribute("club", clubDto);

        return "clubs-detail";
    }
    
    
    @GetMapping("/clubs/new")
    public String createClubForm(Model model) {
        Club club = new Club();
        model.addAttribute("club", club);

        return "clubs-create";
    }

    @PostMapping("/clubs/new")
    public String storeClub(@Valid @ModelAttribute("club") ClubDto clubDto, BindingResult result){
        if (result.hasErrors()) {
            return "clubs-create";
        }
        clubService.saveClub(clubDto);
        return "redirect:/clubs";
    }

    @GetMapping("/clubs/{clubId}/delete")
    public String deleteClub(@PathVariable("clubId") Long clubId){
        clubService.delete(clubId);

        return "redirect:/clubs";
    }

    @GetMapping("/clubs/search")
    public String searchClub(@RequestParam(value = "query") String query, Model model){
        List<ClubDto> clubs = clubService.searchClubs(query);
        model.addAttribute("clubs", clubs);
        
        return "clubs-list";
    }
    
    @GetMapping("/clubs/{clubId}/edit")
    public String editClubForm(@PathVariable("clubId") long clubId, Model model) {
        ClubDto club = clubService.findClubById(clubId);
        model.addAttribute("club", club);

        return "clubs-edit";
    }

    @PostMapping("/clubs/{clubId}/edit")
    public String updateClub(@PathVariable("clubId") long clubId,
                            @Valid @ModelAttribute("club") ClubDto club,
                            BindingResult result) {
        if (result.hasErrors()) {
            return "clubs-edit";
        }
        club.setId(clubId);
        clubService.updateClub(club);

        return "redirect:/clubs";
    }
    
}
