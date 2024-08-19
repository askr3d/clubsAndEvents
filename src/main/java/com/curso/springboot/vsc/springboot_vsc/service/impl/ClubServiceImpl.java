package com.curso.springboot.vsc.springboot_vsc.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.curso.springboot.vsc.springboot_vsc.dto.ClubDto;
import com.curso.springboot.vsc.springboot_vsc.models.Club;
import com.curso.springboot.vsc.springboot_vsc.repository.ClubRepository;
import com.curso.springboot.vsc.springboot_vsc.service.ClubService;

import static com.curso.springboot.vsc.springboot_vsc.mapper.ClubMapper.mapToClub;
import static com.curso.springboot.vsc.springboot_vsc.mapper.ClubMapper.mapToClubDto;

@Service
public class ClubServiceImpl implements ClubService {

    private ClubRepository clubRepository;

    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();

        return clubs.stream().map((club) -> mapToClubDto(club) ).collect(Collectors.toList());
    }

    @Override
    public Club saveClub(ClubDto clubdDto) {
        Club club = mapToClub(clubdDto);
        return clubRepository.save(club);
    }

    @Override
    public ClubDto findClubById(long clubId) {
        Club club = clubRepository.findById(clubId).get();

        return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
        clubRepository.save(club);
    }

    @Override
    public void delete(Long clubId) {
        clubRepository.deleteById(clubId);
    }

    @Override
    public List<ClubDto> searchClubs(String query) {
        List<Club> clubs = clubRepository.searClubs(query);

        return clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
    }

}
