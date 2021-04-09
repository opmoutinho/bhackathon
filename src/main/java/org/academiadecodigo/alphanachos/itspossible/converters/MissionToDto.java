package org.academiadecodigo.alphanachos.itspossible.converters;

import org.academiadecodigo.alphanachos.itspossible.command.MissionDto;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MissionToDto {

    public QuimToDto quimToDto;

    @Autowired
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
        missionDto.setDate(mission.getDate());
        missionDto.setOwner(mission.getOwner() != null ? mission.getOwner().getId() : null);
        missionDto.setHelper(mission.getHelper() != null ? mission.getHelper().getId() : null);

        return missionDto;
    }


    // Simulates a lazy request
    public MissionDto convertSimple(Mission mission) {

        MissionDto missionDto = new MissionDto();

        missionDto.setId(mission.getId());

        return missionDto;
    }


    public List<MissionDto> convertList(List<Mission> missions) {

        return missions.stream().map((elem) -> {
            System.out.println(convert(elem));
            return convert(elem);
        }).collect(Collectors.toList());

    }



}
