package com.curso.springboot.vsc.springboot_vsc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.curso.springboot.vsc.springboot_vsc.dto.EventDto;
import com.curso.springboot.vsc.springboot_vsc.models.Event;
import com.curso.springboot.vsc.springboot_vsc.service.EventService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class EventController {
    private EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public String eventList(Model model) {
        List<EventDto> events = eventService.findAllEvents();
        model.addAttribute("events", events);
        return "events-list";
    }
    
    
    @GetMapping("/events/{clubId}/create")
    public String createEventForm(@PathVariable("clubId") Long clubId, Model model) {
        Event event = new Event();
        model.addAttribute("clubId", clubId);
        model.addAttribute("event", event);
        return "events-create";
    }
    
    @PostMapping("/events/{clubId}/store")
    public String createEvent(@PathVariable("clubId") Long clubId, @ModelAttribute("event") EventDto eventDto) {
        eventService.createEvent(clubId, eventDto);
        
        return "redirect:/clubs/" + clubId;
    }
    
}
