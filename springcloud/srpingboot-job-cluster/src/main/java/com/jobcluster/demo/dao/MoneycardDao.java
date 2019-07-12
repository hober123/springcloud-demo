package com.jobcluster.demo.dao;

import com.jobcluster.demo.model.Moneycard;

public interface MoneycardDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Moneycard record);

    int insertSelective(Moneycard record);

    MoneycardDao selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Moneycard record);

    int updateByPrimaryKey(Moneycard record);
}