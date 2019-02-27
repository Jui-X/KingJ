package com.tyrantx.kingj.Utils;

import org.springframework.stereotype.Component;

@Component
public interface TokenGenerator {

    public String tokenGenerate(String... strings);
}
