package com.curso.springboot.vsc.springboot_vsc.service;

import java.util.List;

import com.curso.springboot.vsc.springboot_vsc.dto.EventDto;

public interface EventService {
    void createEvent(Long clubId, EventDto eventDto);
    List<EventDto> findAllEvents();
}
