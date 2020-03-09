package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.CategoryConverter;
import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	CategoryConverter categoryConverter;
	
	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryEntity> entities = categoryRepository.findAll();
		List<CategoryDTO> models = new ArrayList<>();
		for(CategoryEntity item : entities) {
			CategoryDTO temp = categoryConverter.toDto(item);
			models.add(temp);
		}
		return models;
	}

}
