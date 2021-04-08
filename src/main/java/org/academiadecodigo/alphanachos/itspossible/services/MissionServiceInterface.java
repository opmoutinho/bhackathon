package org.academiadecodigo.alphanachos.itspossible.services;

import org.academiadecodigo.alphanachos.itspossible.command.MissionDto;
import org.academiadecodigo.alphanachos.itspossible.exception.NoMissionToExecuteException;
import org.academiadecodigo.alphanachos.itspossible.persistence.dao.MissionDao;
import org.academiadecodigo.alphanachos.itspossible.persistence.dao.QuimDao;

public interface MissionServiceInterface {


    void createMission (MissionDao missionDao, Integer id);

    void executeMission(QuimDao quimDao);

    void requestMission(QuimDao quimDao);


}
