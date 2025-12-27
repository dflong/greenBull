package com.dflong.greenbull.service;

import com.dflong.greenbull.entity.ContractInfo;
import com.dflong.greenbull.mapper.ContractMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {

    @Autowired
    ContractMapper contractMapper;

    public ContractInfo getContractInfo(String unionId) {
        return contractMapper.getByUserId(unionId);
    }

    public List<ContractInfo> list() {
        return contractMapper.list();
    }
}
