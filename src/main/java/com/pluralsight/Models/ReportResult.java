package com.pluralsight.Models;

import java.util.LinkedHashMap;
import java.util.Map;

public class ReportResult {

    private Map<String, Object> data;

    public ReportResult() {
        this.data = new LinkedHashMap<>(); // Maintains insertion order
    }


    public void addColumn(String columnName, Object value) {
        data.put(columnName, value);
    }


    public Object get(String columnName) {
        return data.get(columnName);
    }


    public String getString(String columnName) {
        Object value = data.get(columnName);
        return value != null ? value.toString() : "";
    }

    public Integer getInt(String columnName) {
        Object value = data.get(columnName);
        if (value instanceof Number) {
            return ((Number) value).intValue();
        }
        return null;
    }


    public Double getDouble(String columnName) {
        Object value = data.get(columnName);
        if (value instanceof Number) {
            return ((Number) value).doubleValue();
        }
        return null;
    }


    public String[] getColumnNames() {
        return data.keySet().toArray(new String[0]);
    }


    public Object[] getValues() {
        return data.values().toArray();
    }


    public Map<String, Object> getData() {
        return data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            sb.append(entry.getKey()).append(": ").append(entry.getValue()).append(", ");
        }
        return sb.toString();
    }
}
