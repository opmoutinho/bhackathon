package org.academiadecodigo.alphanachos.itspossible.converters;

import org.academiadecodigo.alphanachos.itspossible.command.QuimDto;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.Quim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuimToDto {

    private MissionToDto missionToDto;

    @Autowired
    public void setMissionToDto(MissionToDto missionToDto) {
        this.missionToDto = missionToDto;
    }


    public QuimDto convert(Quim quim) {

        QuimDto quimDto = new QuimDto();

        quimDto.setId(quim.getId());
        quimDto.setEmail(quim.getEmail());
        quimDto.setAboutMe(quim.getAboutMe());
        quimDto.setPhone(quim.getPhone());
        quimDto.setName(quim.getName());
        quimDto.setLocation(quim.getLocation());
        quimDto.setSkills(quim.getSkills());

        quimDto.setMissionRequest(missionToDto.convertSimple(quim.getRequestMission()));
        quimDto.setMissionToExecute(missionToDto.convertSimple(quim.getCurrentMission()));

        return quimDto;
    }


    public QuimDto convertSimple(Quim quim) {

        QuimDto quimDto = new QuimDto();

        quimDto.setId(quim.getId());

        return quimDto;

    }

    public List<QuimDto> convertList(List<Quim> quins) {

        return quins.stream().map(this::convert).collect(Collectors.toList());

    }

}
