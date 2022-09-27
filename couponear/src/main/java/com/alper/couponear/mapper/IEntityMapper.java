package com.alper.couponear.mapper;

public interface IEntityMapper <E, D> {
    D toDTO(E e);
    E toEntity(D d);
}
