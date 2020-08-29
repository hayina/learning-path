package com.blog.services;

import com.blog.entities.Post;
import com.blog.models.PostDto;
import com.blog.repositories.PostRepo;
import com.blog.utils.InitMode;
import com.blog.utils.PostUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.*;



@ExtendWith(MockitoExtension.class)
@DisplayName("Blog Service")
class BlogServiceTest {

    BlogService blogService;
    @Mock private PostRepo postRepo;

    @BeforeEach
    void init(){
        blogService = new BlogService(postRepo);
    }


    @ParameterizedTest
    @DisplayName("Save Post")
    @MethodSource("savePostMethodSource")
    void savePost(PostDto postDto) {


        Integer id=1000;
        boolean editMode=(postDto.getId() != null), newMode=!editMode;

        // init dto

        var anyPost = any(Post.class);

        when(postRepo.save(anyPost)).thenAnswer((invocation) -> {
            Post transientPost = invocation.getArgument(0, Post.class);
            transientPost.setId(id);
            return transientPost;
        });

        Post returnedPostEntity= blogService.savePost(postDto);


        /**
         * assert required fields
         */
        assertAll(
                () -> assertThat(returnedPostEntity).isNotNull(),
                () -> assertThat(returnedPostEntity.getId()).isNotNull(),
                () -> assertThat(returnedPostEntity.getTitle()).isEqualTo(postDto.getTitle()),
                () -> assertThat(returnedPostEntity.getType()).isEqualTo(postDto.getType()),
                () -> assertThat(returnedPostEntity.getCreatedAt()).isNotNull()
        );

        /**
         * assert optional fields
         */


        // description
        assertThat(returnedPostEntity.getDescription()).isEqualTo(postDto.getDescription());

        // live
        assertThat(returnedPostEntity.isLive()).isEqualTo(postDto.isLive());
        if(postDto.isLive()) { assertThat(returnedPostEntity.getLiveAt()).isNotNull(); }
        else { assertThat(returnedPostEntity.getLiveAt()).isNull(); }


        if(newMode) {
            assertThat(returnedPostEntity.getLastModifiedAt()).isNull();
        }
        else {
            assertThat(returnedPostEntity.getLastModifiedAt()).isNotNull();
        }

    }


    static public Stream<Arguments> savePostMethodSource(){



        return Stream.of(

                /**
                 * testing all fields
                 * when saving new post
                 */
                Arguments.of(PostUtils.dtoInit(InitMode.FULL))      ,

                /**
                 * testing only required fields to check if the entity returned's optional fields are empty (usefull in edit mode)
                 * when saving new post
                 */
                Arguments.of(PostUtils.dtoInit(InitMode.REQUIRED_ONLY))


        );
    }
}