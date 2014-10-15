package com.lw.datasource;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 * @author wei.Li by 14/10/13.
 */
public class CustomDataSource implements JRDataSource {

    private Object[][] data =
            {
                    {"Berne", 22, "Bill Ott", "250 - 20th Ave."},
                    {"Berne", 9, "James Schneider", "277 Seventh Av."},
                    {"Boston", 32, "Michael Ott", "339 College Av."},
                    {"Boston", 23, "Julia Heiniger", "358 College Av."},
                    {"Chicago", 39, "Mary Karsen", "202 College Av."},
                    {"Chicago", 35, "George Karsen", "412 College Av."},
                    {"Chicago", 11, "Julia White", "412 Upland Pl."},
                    {"Dallas", 47, "Janet Fuller", "445 Upland Pl."},
                    {"Dallas", 43, "Susanne Smith", "2 Upland Pl."},
                    {"Dallas", 40, "Susanne Miller", "440 - 20th Ave."},
                    {"Dallas", 36, "John Steel", "276 Upland Pl."},
                    {"Dallas", 37, "Michael Clancy", "19 Seventh Av."},
                    {"Dallas", 19, "Susanne Heiniger", "86 - 20th Ave."},
                    {"Dallas", 10, "Anne Fuller", "135 Upland Pl."},
                    {"Dallas", 4, "Sylvia Ringer", "365 College Av."},
                    {"Dallas", 0, "Laura Steel", "429 Seventh Av."},
                    {"Lyon", 38, "Andrew Heiniger", "347 College Av."},
                    {"Lyon", 28, "Susanne White", "74 - 20th Ave."},
                    {"Lyon", 17, "Laura Ott", "443 Seventh Av."},
                    {"Lyon", 2, "Anne Miller", "20 Upland Pl."},
                    {"New York", 46, "Andrew May", "172 Seventh Av."},
                    {"New York", 44, "Sylvia Ott", "361 College Av."},
                    {"New York", 41, "Bill King", "546 College Av."},
                    {"Oslo", 45, "Janet May", "396 Seventh Av."},
                    {"Oslo", 42, "Robert Ott", "503 Seventh Av."},
                    {"Paris", 25, "Sylvia Steel", "269 College Av."},
                    {"Paris", 18, "Sylvia Fuller", "158 - 20th Ave."},
                    {"Paris", 5, "Laura Miller", "294 Seventh Av."},
                    {"San Francisco", 48, "Robert White", "549 Seventh Av."},
                    {"San Francisco", 7, "James Peterson", "231 Upland Pl."},

                    {"Berne", 22, "Bill Ott", "250 - 20th Ave."},
                    {"Berne", 9, "James Schneider", "277 Seventh Av."},
                    {"Boston", 32, "Michael Ott", "339 College Av."},
                    {"Boston", 23, "Julia Heiniger", "358 College Av."},
                    {"Chicago", 39, "Mary Karsen", "202 College Av."},
                    {"Chicago", 35, "George Karsen", "412 College Av."},
                    {"Chicago", 11, "Julia White", "412 Upland Pl."},
                    {"Dallas", 47, "Janet Fuller", "445 Upland Pl."},
                    {"Dallas", 43, "Susanne Smith", "2 Upland Pl."},
                    {"Dallas", 40, "Susanne Miller", "440 - 20th Ave."},
                    {"Dallas", 36, "John Steel", "276 Upland Pl."},
                    {"Dallas", 37, "Michael Clancy", "19 Seventh Av."},
                    {"Dallas", 19, "Susanne Heiniger", "86 - 20th Ave."},
                    {"Dallas", 10, "Anne Fuller", "135 Upland Pl."},
                    {"Dallas", 4, "Sylvia Ringer", "365 College Av."},
                    {"Dallas", 0, "Laura Steel", "429 Seventh Av."},
                    {"Lyon", 38, "Andrew Heiniger", "347 College Av."},
                    {"Lyon", 28, "Susanne White", "74 - 20th Ave."},
                    {"Lyon", 17, "Laura Ott", "443 Seventh Av."},
                    {"Lyon", 2, "Anne Miller", "20 Upland Pl."},
                    {"New York", 46, "Andrew May", "172 Seventh Av."},
                    {"New York", 44, "Sylvia Ott", "361 College Av."},
                    {"New York", 41, "Bill King", "546 College Av."},
                    {"Oslo", 45, "Janet May", "396 Seventh Av."},
                    {"Oslo", 42, "Robert Ott", "503 Seventh Av."},
                    {"Paris", 25, "Sylvia Steel", "269 College Av."},
                    {"Paris", 18, "Sylvia Fuller", "158 - 20th Ave."},
                    {"Paris", 5, "Laura Miller", "294 Seventh Av."},
                    {"San Francisco", 48, "Robert White", "549 Seventh Av."},
                    {"San Francisco", 7, "James Peterson", "231 Upland Pl."},

                    {"Berne", 22, "Bill Ott", "250 - 20th Ave."},
                    {"Berne", 9, "James Schneider", "277 Seventh Av."},
                    {"Boston", 32, "Michael Ott", "339 College Av."},
                    {"Boston", 23, "Julia Heiniger", "358 College Av."},
                    {"Chicago", 39, "Mary Karsen", "202 College Av."},
                    {"Chicago", 35, "George Karsen", "412 College Av."},
                    {"Chicago", 11, "Julia White", "412 Upland Pl."},
                    {"Dallas", 47, "Janet Fuller", "445 Upland Pl."},
                    {"Dallas", 43, "Susanne Smith", "2 Upland Pl."},
                    {"Dallas", 40, "Susanne Miller", "440 - 20th Ave."},
                    {"Dallas", 36, "John Steel", "276 Upland Pl."},
                    {"Dallas", 37, "Michael Clancy", "19 Seventh Av."},
                    {"Dallas", 19, "Susanne Heiniger", "86 - 20th Ave."},
                    {"Dallas", 10, "Anne Fuller", "135 Upland Pl."},
                    {"Dallas", 4, "Sylvia Ringer", "365 College Av."},
                    {"Dallas", 0, "Laura Steel", "429 Seventh Av."},
                    {"Lyon", 38, "Andrew Heiniger", "347 College Av."},
                    {"Lyon", 28, "Susanne White", "74 - 20th Ave."},
                    {"Lyon", 17, "Laura Ott", "443 Seventh Av."},
                    {"Lyon", 2, "Anne Miller", "20 Upland Pl."},
                    {"New York", 46, "Andrew May", "172 Seventh Av."},
                    {"New York", 44, "Sylvia Ott", "361 College Av."},
                    {"New York", 41, "Bill King", "546 College Av."},
                    {"Oslo", 45, "Janet May", "396 Seventh Av."},
                    {"Oslo", 42, "Robert Ott", "503 Seventh Av."},
                    {"Paris", 25, "Sylvia Steel", "269 College Av."},
                    {"Paris", 18, "Sylvia Fuller", "158 - 20th Ave."},
                    {"Paris", 5, "Laura Miller", "294 Seventh Av."},
                    {"San Francisco", 48, "Robert White", "549 Seventh Av."},
                    {"San Francisco", 7, "James Peterson", "231 Upland Pl."}
            };

    private int index = -1;

    public CustomDataSource() {
    }

    public boolean next() throws JRException {
        index++;
        return (index < data.length);
    }

    public Object getFieldValue(JRField field) throws JRException {
        Object value = null;

        String fieldName = field.getName();

        if ("city".equals(fieldName)) {
            value = data[index][0];
        } else if ("id".equals(fieldName)) {
            value = data[index][1];
        } else if ("name".equals(fieldName)) {
            value = data[index][2];
        } else if ("street".equals(fieldName)) {
            value = data[index][3];
        }
        return value;
    }
}
