package com.trs.miniproject.Repository;

import org.springframework.data.repository.CrudRepository;

import com.trs.miniproject.Model.Train;

public interface TrainRepository extends CrudRepository<Train, Integer> {

	Train findBytrainId(Integer id);



}
