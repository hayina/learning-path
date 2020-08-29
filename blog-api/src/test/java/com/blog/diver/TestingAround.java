package com.blog.diver;

import com.blog.models.PostType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestingAround {



    @Test
    void testEnum(){
        Assertions.assertThat(PostType.valueOf("dsfsdf")).isEqualTo(PostType.STRUGGLE);
    }
}
