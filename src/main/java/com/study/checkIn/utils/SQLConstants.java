package com.study.checkIn.utils;

public class SQLConstants {
    public static final String GET_CHECK_IN_COLUMN_SQL1 = "select \n" +
            "a.COLUMN_NAME from  information_schema.columns a\n" +
            "join information_schema.TABLES b on a.table_name = b.TABLE_NAME\n" +
            "where a.table_schema = 'student_check_in'\n" +
            "and a.table_name = '";

    public static final String GET_CHECK_IN_COLUMN_SQL2 = "' and a.COLUMN_NAME != 'id' \n" +
            "and a.COLUMN_NAME != 'student_id' \n" +
            "and a.COLUMN_NAME != 'student_name';";
}
