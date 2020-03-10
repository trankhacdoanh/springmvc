package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.NewEntity;

@Component
public class NewConverter {
	public NewDTO toDto(NewEntity newEntity) {
		NewDTO newDTO = new NewDTO();
		newDTO.setId(newEntity.getId());
		newDTO.setTitle(newEntity.getTitle());
		newDTO.setShortDescription(newEntity.getShortDescription());
		newDTO.setContent(newEntity.getContent());
		newDTO.setThumbnail(newEntity.getThumbnail());
		newDTO.setCategoryCode(newEntity.getCategory().getCode());
		return newDTO;
	}
	
	public NewEntity toEntity(NewDTO dto) {
		NewEntity newEntity = new NewEntity();
		newEntity.setTitle(dto.getTitle());
		newEntity.setShortDescription(dto.getShortDescription());
		newEntity.setContent(dto.getContent());
		newEntity.setThumbnail(dto.getThumbnail());
		return newEntity;
	}
	
	public NewEntity toEntity(NewEntity newEntity,NewDTO dto) {
		newEntity.setTitle(dto.getTitle());
		newEntity.setShortDescription(dto.getShortDescription());
		newEntity.setContent(dto.getContent());
		newEntity.setThumbnail(dto.getThumbnail());
		return newEntity;
	}
}
