package pers.caijx.leetcode;

/**
 You are given a string representing an attendance record for a student.
 The record only contains the following three characters:
 'A' : Absent.
 'L' : Late.
 'P' : Present.
 A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).

 You need to return whether the student could be rewarded according to his attendance record.
 * Created by Administrator on 2018/1/14/014.
 */
public class StudentAttendanceRecord {


    public static boolean checkRecord(String s) {
        return !s.matches(".*LLL.*|.*A.*A.*");  //匹配任何字符：点号(.)
    }

    public static void main(String[] args) {
        System.out.println(checkRecord("PPALLL"));
    }
}
