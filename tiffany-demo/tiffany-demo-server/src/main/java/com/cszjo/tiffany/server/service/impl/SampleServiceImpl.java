package com.cszjo.tiffany.server.service.impl;

import com.cszjo.tiffany.api.SampleService;
import org.springframework.stereotype.Service;

/**
 * Created by hansiming on 2017/10/20.
 */
@Service("sampleService")
public class SampleServiceImpl implements SampleService {

    public String echo(String value) {
        return value;
    }
}
