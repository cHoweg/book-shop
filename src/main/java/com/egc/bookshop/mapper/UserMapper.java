package com.egc.bookshop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.egc.bookshop.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}