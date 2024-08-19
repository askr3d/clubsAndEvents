package com.curso.springboot.vsc.springboot_vsc.service;

import java.util.List;

import com.curso.springboot.vsc.springboot_vsc.dto.ClubDto;
import com.curso.springboot.vsc.springboot_vsc.models.Club;

public interface ClubService {
    List<ClubDto> findAllClubs();
    Club saveClub(ClubDto club);
    ClubDto findClubById(long clubId);
    void updateClub(ClubDto club);
    void delete(Long clubId);
    List<ClubDto> searchClubs(String query);
}
