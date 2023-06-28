package com.spring.cyclists.model;
import java.util.List;

public interface RankDAO {

    void saveRank(Rank rank);

    void updateRank(Rank rank);

    void deleteRank(Long rankId);

    Rank getRankById(Long rankId);

    List<Rank> getAllRanks();

    List<Rank> getRanksByRank(int rank);
}
