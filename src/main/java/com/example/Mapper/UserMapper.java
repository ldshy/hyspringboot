package com.example.Mapper;

import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    @Select("select * from hy_spring where username=#{name}")
    public List<Map<String ,Object>> findName(String name);

    @Select("select * from hy_spring where userage=#{imgname}")
    public List<Map<String ,Object>>  addimg(String imgname);
}
