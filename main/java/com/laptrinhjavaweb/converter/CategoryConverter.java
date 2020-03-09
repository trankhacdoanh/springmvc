package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;

@Component
public class CategoryConverter {

	public CategoryDTO toDto(CategoryEntity categoryEntity) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(categoryEntity.getId());
		categoryDTO.setCode(categoryEntity.getCode());
		categoryDTO.setName(categoryEntity.getName());
		return categoryDTO;
	}
	
	public CategoryEntity toEntity(CategoryDTO categoryDTO) {
		CategoryEntity categoryEntity = new CategoryEntity();
		categoryEntity.setCode(categoryDTO.getCode());
		categoryEntity.setName(categoryDTO.getName());
		return categoryEntity;
	}
}
