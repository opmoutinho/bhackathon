package org.academiadecodigo.alphanachos.itspossible.persistence.dao;

import org.academiadecodigo.alphanachos.itspossible.persistence.model.Location;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.Mission;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MissionDao {

    @PersistenceContext
    private EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Mission saveOrUpdate(Mission mission){
        return em.merge(mission);
    }

    public List<Mission> listAllActiveMissions(){
        return em.createQuery("SELECT m FROM Mission m " +
                "WHERE m.status = org.academiadecodigo.alphanachos.itspossible.persistence.model.MissionStatus.OPEN",
                Mission.class).getResultList();
    }

    public List<Mission> listAllHelpedMissions(Integer id){
        return em.createQuery("SELECT m FROM Mission m WHERE m.helper.id="+id,Mission.class).getResultList();
    }

    public List<Mission> listAllCreatedMissions(Integer id){
        return em.createQuery("SELECT m FROM Mission m WHERE m.owner.id="+id,Mission.class).getResultList();
    }

    public List<Mission> listAllActiveMissionsByLocation(Location location){
        return em.createQuery("SELECT m FROM Mission m WHERE m.location="+location,Mission.class).getResultList();
    }

    public void delete(Integer id){
        em.remove(em.find(Mission.class,id));
    }

    public Mission getById(Integer id){
        return em.find(Mission.class, id);
    }
}
