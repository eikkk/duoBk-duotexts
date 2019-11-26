package com.plainprog.duotexts.repository;

import com.plainprog.duotexts.model.SharedDuoTextModel;
import org.springframework.data.repository.CrudRepository;

public interface SharedTextRepository extends CrudRepository<SharedDuoTextModel, Integer>  {
}
