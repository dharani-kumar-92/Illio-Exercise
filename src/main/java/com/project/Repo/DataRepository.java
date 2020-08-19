package com.project.Repo;

import com.project.Model.Data;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends CrudRepository<Data,Long> {
}
