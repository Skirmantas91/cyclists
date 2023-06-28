package com.spring.cyclists.service;

import com.spring.cyclists.model.Rank;
import com.spring.cyclists.model.RankDAO;
import com.spring.cyclists.model.RankDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RankServiceImpl implements RankService {
    // autowire- naudojamas automatinei priklausomybių injekcijai
    // Kad panaudoti @Autowired anotaciją, reikia pirmiausiai turėti apsirašius @Bean @Configuration klasėje
    @Autowired
    // @Qualifier anotacija kartu su @Autowired patikslina su kuriuo konkrečiai bean susieti priklausomybę.
    // Jeigu @Configuration klasėje yra daugiau negu vienas bean, @Qualifier anotacija yra privaloma,
    // kitu atveju metama klaida:
    // 'Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans,
    // or using @Qualifier to identify the bean that should be consumed'
    @Qualifier("RankDAOImpl")
    private RankDAO rankDAO;


    @Override
    public List<Rank> getAllRanks() {
        return rankDAO.getAllRanks();
    }

    @Override
    public void save(Rank rank) { rankDAO.saveRank(rank);
    }

    @Override
    public Rank getById(long id) { return rankDAO.getRankById(id);
    }

    @Override
    public void update(Rank rank) {
        rankDAO.updateRank(rank);
    }

    @Override
    public void delete(long id) {
        rankDAO.deleteRank(id);
    }


}
