package com.soecode.lyf.service;

import java.util.List;

import com.soecode.lyf.entity.Transaction;

public interface TransactionService {

    void addTransaction(int oid,int uid);
    List<Transaction> queryTransactionById(int uid, String type );
}
