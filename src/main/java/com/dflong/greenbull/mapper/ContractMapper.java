package com.dflong.greenbull.mapper;

import com.dflong.greenbull.entity.ContractInfo;
import com.dflong.greenbull.entity.User;

import java.util.List;

//@Mapper
public interface ContractMapper {

    public ContractInfo getByUserId(String unionId);

    List<ContractInfo> list();
}
