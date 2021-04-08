package org.academiadecodigo.alphanachos.itspossible.services;

import org.academiadecodigo.alphanachos.itspossible.exception.NoMissionToExecuteException;
import org.academiadecodigo.alphanachos.itspossible.persistence.dao.MissionDao;
import org.academiadecodigo.alphanachos.itspossible.persistence.dao.QuimDao;
import org.springframework.stereotype.Service;

@Service
public class MissionService implements MissionServiceInterface{

    MissionDao missionDao;
    QuimDao quimDao;

    public void setMissionDao (MissionDao missionDao){
        this.missionDao = missionDao;
    }

    public void setQuimDao (QuimDao quimDao){
        this.quimDao = quimDao;
    }


    @Override
    public void createMission(MissionDao missionDao, Integer id) {

    }



    @Override
    public void executeMission(QuimDao quimDao) {

    }

    @Override
    public void requestMission(QuimDao quimDao) {


    }
}
