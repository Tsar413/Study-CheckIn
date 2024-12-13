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

    public static final String CHECK_CHECK_IN_STUDENTS_SQL1 = "select student_id from `";

    public static final String CHECK_CHECK_IN_STUDENTS_SQL2 = "`where student_id = '";

    public static final String CHECK_CHECK_IN_STUDENTS_SQL3 = "' && student_name = '";

    public static final String CHECK_CHECK_IN_STUDENTS_SQL4 = "';";

    public static final String CHECK_CHECK_IN_STUDENTS_SQL5 = "update `";

    public static final String CHECK_CHECK_IN_STUDENTS_SQL6 = "` set `";

    public static final String CHECK_CHECK_IN_STUDENTS_SQL7 = "` = 1 where student_id = '";

    public static final String CHECK_CHECK_IN_STUDENTS_SQL8 = "select count(*) from `";

    public static final String CHECK_CHECK_IN_STUDENTS_SQL9 = "`;";

    public static final String CHECK_CHECK_IN_STUDENTS_SQL10 = "` where `";

    public static final String CHECK_CHECK_IN_STUDENTS_SQL11 = "` = 1;";

    public static final String CHECK_CHECK_IN_STUDENTS_SQL12 = "` = 0;";

    public static final String CHECK_CHECK_IN_STUDENTS_SQL13 = "select student_id, student_name from `";
}
