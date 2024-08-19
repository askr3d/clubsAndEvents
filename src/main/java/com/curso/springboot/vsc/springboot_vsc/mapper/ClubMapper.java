package com.curso.springboot.vsc.springboot_vsc.mapper;

import static com.curso.springboot.vsc.springboot_vsc.mapper.EventMapper.mapToEventDto;

import java.util.stream.Collectors;

import com.curso.springboot.vsc.springboot_vsc.dto.ClubDto;
import com.curso.springboot.vsc.springboot_vsc.models.Club;

public class ClubMapper {

    public static Club mapToClub(ClubDto clubDto) {
        Club club = Club.builder()
                        .id(clubDto.getId())
                        .title(clubDto.getTitle())
                        .photoUrl(clubDto.getPhotoUrl())
                        .content(clubDto.getContent())
                        .createdOn(clubDto.getCreatedOn())
                        .updatedOn(clubDto.getUpdatedOn())
                        .build();
        return club;
    }

    public static ClubDto mapToClubDto(Club club) {
        ClubDto clubDto = ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .events(club.getEvents().stream().map(event -> mapToEventDto(event)).collect(Collectors.toList()))
                .build();

        return clubDto;
    }

}
