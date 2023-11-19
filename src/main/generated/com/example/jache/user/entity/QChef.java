package com.example.jache.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChef is a Querydsl query type for Chef
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QChef extends EntityPathBase<Chef> {

    private static final long serialVersionUID = -1454658620L;

    public static final QChef chef = new QChef("chef");

    public final com.example.jache.constant.entity.QBaseEntity _super = new com.example.jache.constant.entity.QBaseEntity(this);

    public final StringPath chefDetail = createString("chefDetail");

    public final NumberPath<Long> chefId = createNumber("chefId", Long.class);

    public final StringPath chefImgUrl = createString("chefImgUrl");

    public final StringPath chefName = createString("chefName");

    //inherited
    public final DatePath<java.time.LocalDate> createDate = _super.createDate;

    public final StringPath email = createString("email");

    //inherited
    public final DatePath<java.time.LocalDate> modifyDate = _super.modifyDate;

    public final StringPath password = createString("password");

    public final StringPath phone = createString("phone");

    public final ListPath<com.example.jache.receipe.entity.Receipe, com.example.jache.receipe.entity.QReceipe> receipes = this.<com.example.jache.receipe.entity.Receipe, com.example.jache.receipe.entity.QReceipe>createList("receipes", com.example.jache.receipe.entity.Receipe.class, com.example.jache.receipe.entity.QReceipe.class, PathInits.DIRECT2);

    public final StringPath refreshToken = createString("refreshToken");

    public final EnumPath<com.example.jache.user.entity.enums.Role> role = createEnum("role", com.example.jache.user.entity.enums.Role.class);

    public QChef(String variable) {
        super(Chef.class, forVariable(variable));
    }

    public QChef(Path<? extends Chef> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChef(PathMetadata metadata) {
        super(Chef.class, metadata);
    }

}

