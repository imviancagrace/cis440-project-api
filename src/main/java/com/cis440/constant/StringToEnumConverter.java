package com.cis440.constant;

import org.springframework.core.convert.converter.Converter;

public class StringToEnumConverter implements Converter <String, SortOrder> {
    @Override
    public SortOrder convert(String source) {
        return SortOrder.valueOf(source.toUpperCase());
    }
}
