package com.curso.springboot.vsc.springboot_vsc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.springboot.vsc.springboot_vsc.models.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
