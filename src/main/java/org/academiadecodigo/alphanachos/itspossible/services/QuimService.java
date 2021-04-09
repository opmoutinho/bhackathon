package org.academiadecodigo.alphanachos.itspossible.services;

import org.academiadecodigo.alphanachos.itspossible.command.MissionDto;
import org.academiadecodigo.alphanachos.itspossible.persistence.dao.MissionDao;
import org.academiadecodigo.alphanachos.itspossible.persistence.dao.MissionDaoInterface;
import org.academiadecodigo.alphanachos.itspossible.persistence.dao.QuimDao;
import org.academiadecodigo.alphanachos.itspossible.persistence.dao.QuimDaoInterface;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.Location;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.Mission;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.Quim;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuimService implements QuimServiceInterface{

    private MissionDaoInterface missionDao;
    private QuimDaoInterface quimDao;


    @Autowired
    public void setMissionDao(MissionDaoInterface missionDao) {
        this.missionDao = missionDao;
    }

    @Autowired
    public void setQuimDao(QuimDaoInterface quimDao) {
        this.quimDao = quimDao;
    }

    @Override
    public List<Quim> list(){
        return quimDao.listAll();
    }

    @Transactional
    @Override
    public void createMission(Mission mission, Integer id) {
            Quim quim = quimDao.getById(id);
            if (quim == null){
                throw new UnsupportedOperationException();
            }
            quim.createRequestMission(mission);
            quimDao.saveOrUpdate(quim);
    }

    @Transactional
    @Override
    public void requestMission(Integer mid, Integer qid) {
            Quim quim = quimDao.getById(qid);
            if(quim == null){
                throw new UnsupportedOperationException();
            }

            Mission mission = missionDao.getById(mid);
            if(mission == null){
                throw new UnsupportedOperationException();
            }

            quim.setMissionRequest(mission);
            mission.setHelper(quim);
            quimDao.saveOrUpdate(quim);
            missionDao.saveOrUpdate(mission);
    }

    @Transactional
    @Override
    public void executeMission(Integer id) {
        Quim quim = quimDao.getById(id);
        if (quim == null){
            throw new UnsupportedOperationException();
        }
        quim.executeMission();
        quimDao.saveOrUpdate(quim);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Mission> listActiveMissions() {

        return missionDao.listAllActiveMissions();
    }

    @Transactional(readOnly = true)
    @Override
    public List<Mission> listQuimHelpedMissions(Integer id) {

        return missionDao.listAllHelpedMissions(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Mission> listQuimRequestedMissions(Integer id) {

        return missionDao.listAllCreatedMissions(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Mission> listActiveMissionsByLocation(Location location) {
        return missionDao.listAllActiveMissionsByLocation(location);
    }

    @Transactional(readOnly = true)
    public Quim getQuimByID (Integer id){
        return quimDao.getById(id);
    }

    @Transactional
    @Override
    public Quim saveOrUpdate(Quim toSave) {

        return quimDao.saveOrUpdate(toSave);
    }

    @Transactional(readOnly = true)
    @Override
    public Mission getQuimCurrentMission(Integer id) {
        Quim quim = quimDao.getById(id);
        return quim.getCurrentMission();
    }

    @Transactional(readOnly = true)
    @Override
    public Mission getQuimRequestMission(Integer id) {
        Quim quim = quimDao.getById(id);
        return quim.getRequestMission();
    }

    @Transactional(readOnly = true)
    @Override
    public Mission missionToRequest(Integer id) {
        return missionDao.getById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Quim getQuimByMission(Integer id){
        id.intValue();
        return missionDao.getById(id).getOwner();
    };
}
