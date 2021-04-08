package org.academiadecodigo.alphanachos.itspossible.persistence.dao;

import org.academiadecodigo.alphanachos.itspossible.persistence.model.Quim;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class QuimDao implements QuimDaoInterface {

    @PersistenceContext
    private EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Quim> listAll(){

        CriteriaQuery<Quim> criteriaQuery = em.getCriteriaBuilder().createQuery(Quim.class);
        Root<Quim> root = criteriaQuery.from(Quim.class);
        return em.createQuery(criteriaQuery).getResultList();

    }

    public Quim getById(Integer id){
        return em.find(Quim.class, id);
    }

    public Quim saveOrUpdate(Quim quim){
        return em.merge(quim);
    }

    public void delete(Integer id){
        em.remove(em.find(Quim.class,id));
    }
}
