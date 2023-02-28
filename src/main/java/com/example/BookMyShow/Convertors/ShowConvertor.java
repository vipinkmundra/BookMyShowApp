package com.example.BookMyShow.Convertors;

import com.example.BookMyShow.Dto.ShowEntryDto;
import com.example.BookMyShow.Entities.ShowEntity;

public class ShowConvertor {
    public static ShowEntity convertDtoToShowEntity(ShowEntryDto showEntryDto){
        ShowEntity showEntity = ShowEntity.builder().showDate(showEntryDto.getShowDate())
                .showTime(showEntryDto.getShowTime()).showType(showEntryDto.getShowType()).build();

        return showEntity;
    }
}
