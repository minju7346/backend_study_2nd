package com.backend.study.service;

import com.backend.study.dto.CategoryDTO;
import com.backend.study.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public class UserService{

    @Autowired
    UserMapper userMapper;

    public List<CategoryDTO> findLowCategory(BigInteger pickParentId) {
        return userMapper.findLowCategory(pickParentId);
    }
    public List<CategoryDTO> lookCategory() {
        return userMapper.lookCategory();
    }
}