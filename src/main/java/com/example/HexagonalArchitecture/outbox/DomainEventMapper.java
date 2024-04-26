package com.example.HexagonalArchitecture.outbox;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DomainEventMapper {
    void insert(DomainEvent event);

    List<DomainEvent> findAll();

    void delete(@Param("id") String id);

}
