package org.academiadecodigo.alphanachos.itspossible.persistence.dao;

import org.academiadecodigo.alphanachos.itspossible.persistence.model.Quim;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public interface QuimDaoInterface {

    public List<Quim> listAll();

    public Quim getById(Integer id);

    public Quim saveOrUpdate(Quim quim);

    public void delete(Integer id);

}
