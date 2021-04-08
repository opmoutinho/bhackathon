package org.academiadecodigo.alphanachos.itspossible.persistence.dao;

import org.academiadecodigo.alphanachos.itspossible.persistence.model.Location;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.Mission;

import java.util.List;

public interface MissionDaoInterface {

    Mission saveOrUpdate(org.academiadecodigo.alphanachos.itspossible.persistence.model.Mission mission);

    List<Mission> listAllActiveMissions();

    List<Mission> listAllHelpedMissions(Integer id);

    public List<Mission> listAllCreatedMissions(Integer id);

    public List<Mission> listAllActiveMissionsByLocation(Location location);

    public void delete(Integer id);

    public Mission getById(Integer id);

}
