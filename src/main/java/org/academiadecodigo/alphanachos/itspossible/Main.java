package org.academiadecodigo.alphanachos.itspossible;

import org.academiadecodigo.alphanachos.itspossible.persistence.dao.MissionDao;
import org.academiadecodigo.alphanachos.itspossible.persistence.dao.QuimDao;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();

        MissionDao missionDao = new MissionDao();
        QuimDao quimDao = new QuimDao();

        missionDao.setEm(em);
        quimDao.setEm(em);

        Quim quim = new Quim();
        quim.setName("Me");
        quim.setAboutMe("Whatever");
        quim.setLocation(Location.FARO);
        quim.setEmail("abc.abc");
        quim.setPhone("909090");
        Quim quim1 = new Quim();
        quim1.setAboutMe("LLALALALA");
        quim1.setEmail("lolol.lolol");
        quim1.setPhone("9090110");
        quim1.setLocation(Location.OPORTO);
        quim1.setName("Pablo");
        Quim quim2 = new Quim();
        quim2.setAboutMe("Strange");
        quim2.setEmail("meman.merman");
        quim2.setPhone("9133113");
        quim2.setLocation(Location.LISBON);
        quim2.setName("RUI");


        Mission mission = new Mission();
        Mission mission1 = new Mission();
        Mission mission2 = new Mission();
        mission.setLocation(Location.OPORTO);
        mission.setOwner(quim1);
        mission.setDescription("Help me dumb");
        mission.setSkill(Skill.ERRANDS);
        quim1.createRequestMission(mission);

        em.getTransaction().begin();
        quim = quimDao.saveOrUpdate(quim);
        quim1 = quimDao.saveOrUpdate(quim1);
        quim2 = quimDao.saveOrUpdate(quim2);
        em.getTransaction().commit();

        mission = missionDao.getById(quim1.getRequestMission().getId());
        quim2.setMissionToExecute(mission);

        em.getTransaction().begin();
        quim2 = quimDao.saveOrUpdate(quim2);
        em.getTransaction().commit();

        quim2.executeMission();

        em.getTransaction().begin();
        quim2 = quimDao.saveOrUpdate(quim2);
        em.getTransaction().commit();

        System.out.println("Executing mission!!");

        //quim2.executeMission();

        System.out.println(quimDao.listAll());
        System.out.println(missionDao.listAllCreatedMissions(2));
    }

}
