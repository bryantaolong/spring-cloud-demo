package com.bryan.storage.service.impl;

import com.bryan.storage.mapper.StorageTblMapper;
import com.bryan.storage.service.StorageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StorageServiceImpl implements StorageService {

    private final StorageTblMapper storageTblMapper;

    @Transactional
    @Override
    public void deduct(String commodityCode, int count) {
        storageTblMapper.deduct(commodityCode, count);
    }
}
