package com.example.jache.receipe.repository.Impl;

import com.example.jache.receipe.entity.Love;
import com.example.jache.receipe.entity.QLove;
import com.example.jache.receipe.entity.QReceipe;
import com.example.jache.receipe.entity.Receipe;
import com.example.jache.receipe.repository.LoveRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@RequiredArgsConstructor
public class LoveRepositoryImpl implements LoveRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QLove love = new QLove("love");


    @Override
    public Love findLoveByReceipeIdAndChefName(Long receipeId, String chefName) {
        return jpaQueryFactory.selectFrom(love)
                .where(love.receipe.receipeId.eq(receipeId),love.chef.chefName.eq(chefName))
                .fetchOne();
    }
}
