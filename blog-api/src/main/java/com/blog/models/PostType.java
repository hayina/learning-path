package com.blog.models;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.stream.Stream;

public enum PostType {

    TIPS(1),
    STRUGGLE(2);

    private Integer type;

    private PostType(Integer type){
        this.type=type;
    }


    public Integer value() {
        return this.type;
    }



//    public static PostType enumFromName(String name) {
//        return PostType.valueOf(name);
//    }



    @JsonCreator
    public static PostType of(Integer value) {

        return Stream.of(PostType.values())
                .filter(typeEnum -> typeEnum.value().equals(value))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);


    }
}
