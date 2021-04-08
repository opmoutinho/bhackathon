package org.academiadecodigo.alphanachos.itspossible.converters;

import org.academiadecodigo.alphanachos.itspossible.command.MissionDto;
import org.academiadecodigo.alphanachos.itspossible.command.QuimDto;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.Quim;

import java.util.List;
import java.util.stream.Collectors;


public class QuimToDto {

    private MissionToDto missionToDto;

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
        quimDto.setMissionRequest(missionToDto.convert(quim.getRequestMission()));
        quimDto.setMissionToExecute(missionToDto.convert(quim.getCurrentMission()));

        return quimDto;
    }

    public List<QuimDto> convertList(List<Quim> quins) {

        return quins.stream().map(this::convert).collect(Collectors.toList());

    }

}
