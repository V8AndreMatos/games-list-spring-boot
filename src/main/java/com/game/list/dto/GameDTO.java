package com.game.list.dto;

import com.game.list.entities.Game;
import com.game.list.projection.GameProjection;
import jakarta.persistence.Column;

public class GameDTO {

    //Versão do game com 5 dados
    private Long id;
    private String title;
    private Integer year;
    private String imgUrl;
    private String shortDescription;

    public GameDTO() {
    }

    public GameDTO(Game entity) {
        id = entity.getId();
        title = entity.getTitle();
        year = entity.getYear();
        imgUrl = entity.getImgUrl();
        shortDescription = entity.getShortDescription();
    }

    public GameDTO(GameProjection gameProjection) {
        id = gameProjection.getId();
        title = gameProjection.getTitle();
        year = gameProjection.getYear();
        imgUrl = gameProjection.getImgUrl();
        shortDescription = gameProjection.getShortDescription();
    }

    public Long getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

}
