package com.cis440.constant.converter;

import com.cis440.constant.SortOrder;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SortOrderConverter implements Converter <String, SortOrder> {
    @Override
    public SortOrder convert(String source) {
        return SortOrder.valueOf(source.toUpperCase());
    }
}