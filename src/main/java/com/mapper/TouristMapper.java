package com.mapper;

import com.model.dto.TouristDTO;
import com.model.entity.Tourist;
import org.springframework.stereotype.Component;

@Component
public class TouristMapper implements Mapper<Tourist,TouristDTO> {
    @Override
    public TouristDTO map(Tourist from) {
        return new TouristDTO
                .Builder()
                .name(from.getName())
                .lastName(from.getLastName())
                .gender(from.getGender())
                .country(from.getCountry())
                .dateOfBirth(from.getDateOfBirth())
                .builder();
    }

    @Override
    public Tourist revers(TouristDTO to) {
        return null;
    }
}
