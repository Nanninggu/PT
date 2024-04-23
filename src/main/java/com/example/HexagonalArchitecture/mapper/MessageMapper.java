package com.example.HexagonalArchitecture.mapper;

import com.example.HexagonalArchitecture.dto.MessageDTO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageMapper {
    void insertMessage(@Param("message") MessageDTO message);

}
