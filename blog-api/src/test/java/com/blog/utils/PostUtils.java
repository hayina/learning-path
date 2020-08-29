package com.blog.utils;

import com.blog.models.PostDto;

public class PostUtils {

    private static String getTitle(){
        return "Streams";
    }
    private static String getDescription(){
        return "Streams description";
    }
    private static Integer getType(){
        return 1000;
    }

    private static PostDto dtoRequiredOnlyInit(PostDto postDto){
        postDto.setTitle(getTitle());
//        postDto.setType(getType());
        return postDto;
    }

    private static PostDto dtoOptionalOnlyInit(PostDto postDto){
        postDto.setDescription(getDescription());
        return postDto;
    }

    private static PostDto dtoFullInit(PostDto postDto){
        dtoRequiredOnlyInit(postDto);
        dtoOptionalOnlyInit(postDto);
        return postDto;
    }

    public static PostDto dtoInit(InitMode initMode){
        var postDto = new PostDto();

        switch (initMode) {

            case FULL:
                dtoFullInit(postDto);
                break;

            case REQUIRED_ONLY:
                dtoRequiredOnlyInit(postDto);
                break;

            case EMPTY:
                break;

            default:
                throw new IllegalArgumentException();

        }


        return postDto;
    }
}
