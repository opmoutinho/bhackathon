package org.academiadecodigo.alphanachos.itspossible.converters;

import org.academiadecodigo.alphanachos.itspossible.command.MissionDto;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.Mission;
import org.academiadecodigo.alphanachos.itspossible.services.QuimService;

public class DtoToMission {

    private QuimService quimService;

    public void setQuimService(QuimService quimService) {
        this.quimService = quimService;
    }

    /*public Mission convert(MissionDto missionDto) {

        Mission mission = new Mission();

        mission.setDescription(missionDto.getDescription());
        mission.setStatus(missionDto.getStatus());
        mission.setSkill(missionDto.getSkill());
        mission.setLocation(missionDto.getLocation());

        // no mission is created without owner
        mission.setOwner();
        mission.setHelper(dtoToQuim.convert(missionDto.getHelper()));

        return mission;

    }*/

}
