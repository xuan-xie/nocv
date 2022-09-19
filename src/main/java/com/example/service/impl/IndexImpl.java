package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dao.IndexMapper;
import com.example.entity.NocvData;
import com.example.service.IndexService;
import org.springframework.stereotype.Service;

@Service
public class IndexImpl extends ServiceImpl<IndexMapper, NocvData> implements IndexService {
}
