package com.poo.ifsp.poo_hotel_project.mappers.checkouts;

import com.poo.ifsp.poo_hotel_project.domain.entities.Checkout;
import com.poo.ifsp.poo_hotel_project.dtos.checkouts.GetCheckoutDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GetCheckoutMapper {
  GetCheckoutDto toDto(Checkout checkout);

  List<GetCheckoutDto> toDtoList(List<Checkout> checkouts);
}
