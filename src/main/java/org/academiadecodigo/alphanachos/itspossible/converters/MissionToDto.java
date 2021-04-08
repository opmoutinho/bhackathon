package org.academiadecodigo.alphanachos.itspossible.converters;

import org.academiadecodigo.alphanachos.itspossible.command.MissionDto;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.Mission;

import java.util.List;
import java.util.stream.Collectors;

public class MissionToDto {

    public QuimToDto quimToDto;

    public void setQuimToDto(QuimToDto quimToDto) {
        this.quimToDto = quimToDto;
    }

    public MissionDto convert(Mission mission) {

        MissionDto missionDto = new MissionDto();

        missionDto.setId(mission.getId());
        missionDto.setDescription(mission.getDescription());
        missionDto.setStatus(mission.getStatus());
        missionDto.setSkill(mission.getSkill());
        missionDto.setLocation(mission.getLocation());
        missionDto.setOwner(quimToDto.convertSimple(mission.getOwner()));
        missionDto.setHelper(quimToDto.convertSimple(mission.getHelper()));

        return missionDto;
    }


    // Simulates a lazy request
    public MissionDto convertSimple(Mission mission) {

        MissionDto missionDto = new MissionDto();

        missionDto.setId(mission.getId());

        return missionDto;
    }


    public List<MissionDto> convertList(List<Mission> missions) {

        return missions.stream().map(this::convert).collect(Collectors.toList());

    }



}
