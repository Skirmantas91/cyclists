package com.spring.cyclists.model;

import com.spring.cyclists.config.JPAUtil;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RankDAOImpl implements RankDAO {


    @Override
    public void saveRank(Rank rank) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        entityManager.persist(rank);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void updateRank(Rank rank) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Rank rank2 = entityManager.find(Rank.class, rank.getId());
        rank2.setName(rank.getName());
        rank2.setRank(rank.getRank());
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void deleteRank(Long rankId) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        Rank rank = entityManager.find(Rank.class, rankId);
        entityManager.remove(rank);

        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public Rank getRankById(Long rankId) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        List<Rank> ranks = entityManager.
                createQuery("SELECT n FROM Rank n WHERE n.id = :id")
                .setParameter("id", rankId)
                .getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return ranks.get(0);
    }

    @Override
    public List<Rank> getAllRanks() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        entityManager.getTransaction().begin();

        List<Rank> ranks = entityManager.
                createQuery("SELECT n FROM Rank n ORDER BY rank ASC")
                .getResultList();

        entityManager.getTransaction().commit();
        entityManager.close();

        return ranks;
    }

    @Override
    public List<Rank> getRanksByRank(int rank) {
        return null;
    }
}