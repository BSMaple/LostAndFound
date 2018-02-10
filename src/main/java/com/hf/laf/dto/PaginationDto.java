package com.hf.laf.dto;

import java.util.List;

public class PaginationDto {
    private List rows  ;
    private int  total ;

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
