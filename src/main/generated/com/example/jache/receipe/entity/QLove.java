package com.example.jache.receipe.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLove is a Querydsl query type for Love
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLove extends EntityPathBase<Love> {

    private static final long serialVersionUID = 56951906L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLove love = new QLove("love");

    public final com.example.jache.constant.entity.QBaseEntity _super = new com.example.jache.constant.entity.QBaseEntity(this);

    public final com.example.jache.user.entity.QChef chef;

    //inherited
    public final DatePath<java.time.LocalDate> createDate = _super.createDate;

    public final NumberPath<Long> loveId = createNumber("loveId", Long.class);

    //inherited
    public final DatePath<java.time.LocalDate> modifyDate = _super.modifyDate;

    public final QReceipe receipe;

    public final StringPath status = createString("status");

    public QLove(String variable) {
        this(Love.class, forVariable(variable), INITS);
    }

    public QLove(Path<? extends Love> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLove(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLove(PathMetadata metadata, PathInits inits) {
        this(Love.class, metadata, inits);
    }

    public QLove(Class<? extends Love> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.chef = inits.isInitialized("chef") ? new com.example.jache.user.entity.QChef(forProperty("chef")) : null;
        this.receipe = inits.isInitialized("receipe") ? new QReceipe(forProperty("receipe"), inits.get("receipe")) : null;
    }

}

