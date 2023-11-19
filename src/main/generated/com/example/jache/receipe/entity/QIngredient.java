package com.example.jache.receipe.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QIngredient is a Querydsl query type for Ingredient
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QIngredient extends EntityPathBase<Ingredient> {

    private static final long serialVersionUID = -685819199L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QIngredient ingredient = new QIngredient("ingredient");

    public final com.example.jache.constant.entity.QBaseEntity _super = new com.example.jache.constant.entity.QBaseEntity(this);

    //inherited
    public final DatePath<java.time.LocalDate> createDate = _super.createDate;

    public final NumberPath<Long> ingredientId = createNumber("ingredientId", Long.class);

    public final StringPath ingredientName = createString("ingredientName");

    //inherited
    public final DatePath<java.time.LocalDate> modifyDate = _super.modifyDate;

    public final QReceipe receipe;

    public final StringPath weight = createString("weight");

    public QIngredient(String variable) {
        this(Ingredient.class, forVariable(variable), INITS);
    }

    public QIngredient(Path<? extends Ingredient> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QIngredient(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QIngredient(PathMetadata metadata, PathInits inits) {
        this(Ingredient.class, metadata, inits);
    }

    public QIngredient(Class<? extends Ingredient> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.receipe = inits.isInitialized("receipe") ? new QReceipe(forProperty("receipe"), inits.get("receipe")) : null;
    }

}

