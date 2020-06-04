package com.haijuny.summer.genertor.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GeneratorMapper {

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);

}
