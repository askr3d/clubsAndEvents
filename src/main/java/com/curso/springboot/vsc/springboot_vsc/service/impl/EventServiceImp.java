package com.curso.springboot.vsc.springboot_vsc.service.impl;

import static com.curso.springboot.vsc.springboot_vsc.mapper.EventMapper.mapToEvent;
import static com.curso.springboot.vsc.springboot_vsc.mapper.EventMapper.mapToEventDto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.curso.springboot.vsc.springboot_vsc.dto.EventDto;
import com.curso.springboot.vsc.springboot_vsc.models.Club;
import com.curso.springboot.vsc.springboot_vsc.models.Event;
import com.curso.springboot.vsc.springboot_vsc.repository.ClubRepository;
import com.curso.springboot.vsc.springboot_vsc.repository.EventRepository;
import com.curso.springboot.vsc.springboot_vsc.service.EventService;

@Service
public class EventServiceImp implements EventService {
    private EventRepository eventRepository;
    private ClubRepository clubRepository;

    public EventServiceImp(EventRepository eventRepository, ClubRepository clubRepository) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public void createEvent(Long clubId, EventDto eventDto) {
        Club club = clubRepository.findById(clubId).get();
        Event event = mapToEvent(eventDto);
        event.setClub(club);
        eventRepository.save(event);
    }

    @Override
    public List<EventDto> findAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map(event -> mapToEventDto(event)).collect(Collectors.toList());
    }

}
