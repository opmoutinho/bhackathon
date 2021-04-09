package org.academiadecodigo.alphanachos.itspossible.converters;

import org.academiadecodigo.alphanachos.itspossible.command.MissionDto;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.Mission;
import org.academiadecodigo.alphanachos.itspossible.services.QuimService;
import org.academiadecodigo.alphanachos.itspossible.services.QuimServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DtoToMission {

    private QuimServiceInterface quimService;

    @Autowired
    public void setQuimService(QuimServiceInterface quimService) {
        this.quimService = quimService;
    }


    public Mission convert(MissionDto missionDto) {



        Mission mission = new Mission();

        mission.setDescription(missionDto.getDescription());
        mission.setStatus(missionDto.getStatus());
        mission.setSkill(missionDto.getSkill());
        mission.setLocation(missionDto.getLocation());
        mission.setDate(new Date());

        return mission;

    }

}
