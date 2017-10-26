package com.cszjo.tiffany.client;

import com.cszjo.tiffany.api.SampleService;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * Created by hansiming on 2017/10/26.
 */
public class Caller {

    @Resource()
    @Qualifier("sampleService")
    private SampleService sampleService;

    public String echo() {
        return sampleService.echo("bbb");
    }
}
