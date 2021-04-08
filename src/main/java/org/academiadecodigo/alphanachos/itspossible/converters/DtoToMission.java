package org.academiadecodigo.alphanachos.itspossible.converters;

import org.academiadecodigo.alphanachos.itspossible.command.MissionDto;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.Mission;
import org.academiadecodigo.alphanachos.itspossible.services.QuimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DtoToMission {

    private QuimService quimService;

    @Autowired
    public void setQuimService(QuimService quimService) {
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
