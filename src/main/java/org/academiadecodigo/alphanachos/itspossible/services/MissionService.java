package org.academiadecodigo.alphanachos.itspossible.services;

import org.academiadecodigo.alphanachos.itspossible.exception.NoMissionToExecuteException;
import org.academiadecodigo.alphanachos.itspossible.persistence.dao.MissionDao;
import org.academiadecodigo.alphanachos.itspossible.persistence.dao.MissionDaoInterface;
import org.academiadecodigo.alphanachos.itspossible.persistence.dao.QuimDao;
import org.academiadecodigo.alphanachos.itspossible.persistence.dao.QuimDaoInterface;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.Mission;
import org.springframework.stereotype.Service;

@Service
public class MissionService implements MissionServiceInterface{

    MissionDaoInterface missionDao;
    QuimDaoInterface quimDao;

    public void setMissionDao (MissionDaoInterface missionDao){
        this.missionDao = missionDao;
    }

    public void setQuimDao (QuimDaoInterface quimDao){
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
