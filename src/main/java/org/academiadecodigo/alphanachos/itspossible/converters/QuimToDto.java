package org.academiadecodigo.alphanachos.itspossible.converters;

import org.academiadecodigo.alphanachos.itspossible.command.QuimDto;
import org.academiadecodigo.alphanachos.itspossible.persistence.dao.QuimDao;
import org.academiadecodigo.alphanachos.itspossible.persistence.dao.QuimDaoInterface;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.Quim;
import org.academiadecodigo.alphanachos.itspossible.services.QuimServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class QuimToDto {

    private MissionToDto missionToDto;
    private QuimServiceInterface service;

    @Autowired
    public void setMissionToDto(MissionToDto missionToDto) {
        this.missionToDto = missionToDto;
    }

    @Autowired
    public void setService(QuimServiceInterface service) {
        this.service = service;
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

        quimDto.setMissionToExecute(quim.getCurrentMission() != null ? quim.getCurrentMission().getId() : null);
        quimDto.setMissionRequest(quim.getRequestMission() != null ? quim.getRequestMission().getId() : null);
        return quimDto;
    }


    public QuimDto convertSimple(Quim quim) {

        QuimDto quimDto = new QuimDto();

        quimDto.setId(quim.getId());

        return quimDto;

    }

    public List<QuimDto> convertList(List<Quim> quins) {
        return quins.stream().map((elem) -> {
            System.out.println(convert(elem));
            return convert(elem);
        }).collect(Collectors.toList());

    }

}
