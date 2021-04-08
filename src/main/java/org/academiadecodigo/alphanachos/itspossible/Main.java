package org.academiadecodigo.alphanachos.itspossible;

import org.academiadecodigo.alphanachos.itspossible.persistence.model.Mission;
import org.academiadecodigo.alphanachos.itspossible.persistence.model.Quim;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) throws Exception {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();
        Quim quim = new Quim();
        Mission mission = new Mission();

        quim.createRequestMission(mission);

        em.getTransaction().begin();
        em.persist(quim);
        em.getTransaction().commit();

        quim.completeMissionRequest();

        em.getTransaction().begin();
        em.merge(quim);
        em.getTransaction().commit();
    }

}
