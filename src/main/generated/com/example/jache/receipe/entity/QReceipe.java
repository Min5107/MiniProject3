package com.example.jache.receipe.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReceipe is a Querydsl query type for Receipe
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReceipe extends EntityPathBase<Receipe> {

    private static final long serialVersionUID = 868470585L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReceipe receipe = new QReceipe("receipe");

    public final com.example.jache.constant.entity.QBaseEntity _super = new com.example.jache.constant.entity.QBaseEntity(this);

    public final com.example.jache.user.entity.QChef chef;

    //inherited
    public final DatePath<java.time.LocalDate> createDate = _super.createDate;

    public final ListPath<Ingredient, QIngredient> ingredients = this.<Ingredient, QIngredient>createList("ingredients", Ingredient.class, QIngredient.class, PathInits.DIRECT2);

    public final StringPath introduce = createString("introduce");

    public final NumberPath<Integer> loveCount = createNumber("loveCount", Integer.class);

    //inherited
    public final DatePath<java.time.LocalDate> modifyDate = _super.modifyDate;

    public final ListPath<Orders, QOrders> orders = this.<Orders, QOrders>createList("orders", Orders.class, QOrders.class, PathInits.DIRECT2);

    public final NumberPath<Long> receipeId = createNumber("receipeId", Long.class);

    public final StringPath receipeImgUrl = createString("receipeImgUrl");

    public final StringPath theme = createString("theme");

    public final StringPath title = createString("title");

    public QReceipe(String variable) {
        this(Receipe.class, forVariable(variable), INITS);
    }

    public QReceipe(Path<? extends Receipe> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReceipe(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReceipe(PathMetadata metadata, PathInits inits) {
        this(Receipe.class, metadata, inits);
    }

    public QReceipe(Class<? extends Receipe> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.chef = inits.isInitialized("chef") ? new com.example.jache.user.entity.QChef(forProperty("chef")) : null;
    }

}

