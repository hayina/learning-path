package com.blog.converters;

import com.blog.models.PostType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


@Converter(autoApply = true)
public class PostTypeConverter implements AttributeConverter<PostType, Integer> {

    @Override
    public Integer convertToDatabaseColumn(PostType type) {
        return type.value();
    }

    @Override
    public PostType convertToEntityAttribute(Integer value) {
        return PostType.of(value);
    }
}
