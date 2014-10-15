package com.lw.table;

import net.sf.jasperreports.data.cache.ColumnValues;
import net.sf.jasperreports.data.cache.ColumnValuesIterator;
import net.sf.jasperreports.data.cache.DataSnapshotException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.JRRewindableDataSource;
import net.sf.jasperreports.engine.data.IndexedDataSource;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author wei.Li by 14/10/14.
 */
public class JREmptyDataSourceImpl implements JRRewindableDataSource, IndexedDataSource {


    protected static Object[][] data =
            {
                    {"Berne", "22", "Bill Ott", "250 - 20th Ave."},
                    {"Berne", "9", "James Schneider", "277 Seventh Av."},
                    {"Boston", "32", "Michael Ott", "339 College Av."},
                    {"Boston", "23", "Julia Heiniger", "358 College Av."},
            };

    private int size;
    private int iteratorIndex;
    private Map<String, ColumnValuesIterator> iterators;

    public JREmptyDataSourceImpl(String[] fieldNames, int size, ColumnValues[] values) {
        if (fieldNames == null || values == null || fieldNames.length != values.length) {
            throw new IllegalArgumentException();
        }

        iterators = new LinkedHashMap<String, ColumnValuesIterator>();

        this.size = size;
        for (int i = 0; i < fieldNames.length; i++) {
            if (size != values[i].size()) {
                throw new IllegalArgumentException();
            }

            iterators.put(fieldNames[i], values[i].iterator());
        }

        iteratorIndex = 0;
    }

    public boolean next() throws JRException {
        if (iteratorIndex >= size) {
            return false;
        }

        ++iteratorIndex;
        for (ColumnValuesIterator iterator : iterators.values()) {
            iterator.next();
        }

        return true;
    }

    public Object getFieldValue(JRField field) throws DataSnapshotException {
        ColumnValuesIterator iterator = iterators.get(field.getName());
        if (iterator == null) {
            throw new DataSnapshotException("Field " + field.getName() + " not present in data snapshot");
        }

        Object value = iterator.get();

        if (value != null && !field.getValueClass().isInstance(value)) {
            throw new DataSnapshotException("Field " + field.getName() + " of type " + field.getValueClassName()
                    + " has snapshot value of type " + value.getClass().getName());
        }

        return value;
    }

    public void moveFirst() {
        iteratorIndex = 0;
        for (ColumnValuesIterator iterator : iterators.values()) {
            iterator.moveFirst();
        }
    }

    public int getRecordIndex() {
        return iteratorIndex - 1;
    }
}
