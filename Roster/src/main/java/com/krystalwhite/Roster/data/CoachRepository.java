package com.krystalwhite.Roster.data;

import com.krystalwhite.Roster.models.Coach;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoachRepository extends CrudRepository<Integer, Coach> {
}
