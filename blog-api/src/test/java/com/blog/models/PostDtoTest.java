package com.blog.models;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Post DTO")
class PostDtoTest {

    @Test
    @DisplayName("[live] field when dto not initialized")
    void isLive() {

        var postDtp = new PostDto();

        assertThat(postDtp.isLive()).isFalse();
    }
}