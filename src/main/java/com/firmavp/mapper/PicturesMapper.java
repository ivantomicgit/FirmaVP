package com.firmavp.mapper;

import java.util.List;

import com.firmavp.dto.PicturesDTO;
import com.firmavp.entity.Pictures;

public interface PicturesMapper {
 
    PicturesDTO toPicturesDTO(Pictures Pictures);
    Pictures toPictures(PicturesDTO PicturesDTO);
    List<PicturesDTO>toPicturesDTOs(List<Pictures>listaSlika);
    List<Pictures>toPictures(List<PicturesDTO>listaslikaDTO);
}
