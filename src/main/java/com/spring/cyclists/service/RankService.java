package com.spring.cyclists.service;

import com.spring.cyclists.model.Rank;

import java.util.List;

public interface RankService {

    List<Rank> getAllRanks();

    void save(Rank rank);

    Rank getById(long id);

    void update(Rank rank);

    void delete(long id);


}
