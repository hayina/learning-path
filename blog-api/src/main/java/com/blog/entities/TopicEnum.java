package com.blog.entities;

public enum TopicEnum {

    JAVA(1),

    SPRING(100),
    SPRING_BOOT(101),
    SPRING_MVC(102),
    SPRING_DATA(103),
    SPRING_SECURITY(104),
    SPRING_CLOUD(105),
    SPRING_BATCH(106),

    JPA(50),
    HIBERNATE(51),

    MAVEN(150),

    JUNIT(200),
    MOCKITO(201),

    GIT(220),
    DOCKER(230),
    KUBERNETES(240),
    JENKINS(250),

    MICROSERVICES(300),
    EVENT_DRIVEN_ARCHITECTURE(350),

    AWS(400),

    KAFKA(500),
    KINESIS(600),

    OAUTH2_OIDC(700),

    ANSIBLE(1000),
    SWAGGER(1020),
    JHIPSTER(1030),


    GRAPHQL(2000),
    ;

    private Integer value;

    private TopicEnum(Integer value){
        this.value = value;
    }
}
