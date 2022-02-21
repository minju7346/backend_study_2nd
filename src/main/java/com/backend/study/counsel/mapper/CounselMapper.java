package com.backend.study.counsel.mapper;

import com.backend.study.counsel.model.CounselDTO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface CounselMapper {
    void insert(CounselDTO counselDTO);
    void insertHistory(long id);
}