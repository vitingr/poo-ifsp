package com.poo.ifsp.poo_hotel_project.mappers.checkouts;

import com.poo.ifsp.poo_hotel_project.domain.entities.Checkout;
import com.poo.ifsp.poo_hotel_project.dtos.checkouts.CreateCheckoutDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateCheckoutMapper {
  Checkout toEntity(CreateCheckoutDto dto);

  Checkout toDto(Checkout checkout);
}
