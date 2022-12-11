package com.krystalwhite.Roster.data;

import com.krystalwhite.Roster.models.Player;
import lombok.Data;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Integer, Player> {
}