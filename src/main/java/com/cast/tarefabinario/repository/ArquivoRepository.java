package com.cast.tarefabinario.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.cast.tarefabinario.model.Arquivo;

public interface ArquivoRepository extends PagingAndSortingRepository<Arquivo, String>{

	Arquivo findById(Long id);

}
