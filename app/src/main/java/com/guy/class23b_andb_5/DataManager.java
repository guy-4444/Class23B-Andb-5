package com.guy.class23b_andb_5;

import java.util.ArrayList;

public class DataManager {


    public static ArrayList<Shift> generateMockData() {
        ArrayList<Shift> shifts = new ArrayList<>();


        shifts.add(new Shift()
                .setKey("S1")
                .setWorkplace("Afeka")
                .setStartTime(System.currentTimeMillis() - (1000l*60*60*24*1) - (1000l*60*60*9))
                .setEndTime(System.currentTimeMillis() - (1000l*60*60*24*1))
                .setSalary(300.0)
                .setNightShift(false)
                .setComments("Good Shift"));

        shifts.add(new Shift()
                .setKey("S2")
                .setWorkplace("Afeka")
                .setStartTime(System.currentTimeMillis() - (1000l*60*60*24*4) - (1000l*60*60*9))
                .setEndTime(System.currentTimeMillis() - (1000l*60*60*24*4))
                .setSalary(1600.0)
                .setNightShift(false)
                .setComments("Vie amusante à Afeka"));

        shifts.add(new Shift()
                .setKey("S2B")
                .setWorkplace("Afeka")
                .setStartTime(System.currentTimeMillis() - (1000l*60*60*24*4) - (1000l*60*60*9))
                .setEndTime(System.currentTimeMillis() - (1000l*60*60*24*4))
                .setSalary(1600.1234)
                .setNightShift(false)
                .setComments("Vita divertente lavorando ad Afeka"));

        shifts.add(new Shift()
                .setKey("S3")
                .setWorkplace("TAU")
                .setStartTime(System.currentTimeMillis() - (1000l*60*60*24*4) - (1000l*60*60*9))
                .setEndTime(System.currentTimeMillis() - (1000l*60*60*24*4))
                .setSalary(2400.0)
                .setNightShift(false)
                .setComments("Good Shift, Very tired"));

        shifts.add(new Shift()
                .setKey("S4")
                .setWorkplace("TAU")
                .setStartTime(System.currentTimeMillis() - (1000l*60*60*24*5) - (1000l*60*60*9))
                .setEndTime(System.currentTimeMillis() - (1000l*60*60*24*5))
                .setSalary(300.0)
                .setNightShift(true)
                .setComments("משמרת מעניינת"));

        shifts.add(new Shift()
                .setKey("S5")
                .setWorkplace("TAU")
                .setStartTime(System.currentTimeMillis() - (1000l*60*60*24*5) - (1000l*60*60*9))
                .setEndTime(System.currentTimeMillis() - (1000l*60*60*24*5))
                .setSalary(3.1234567)
                .setNightShift(true)
                .setComments("משמרת מעניינת"));

        shifts.add(new Shift()
                .setKey("S6")
                .setWorkplace("Afeka")
                .setStartTime(System.currentTimeMillis() - (1000l*60*60*24*6) - (1000l*60*60*9))
                .setEndTime(System.currentTimeMillis() - (1000l*60*60*24*6))
                .setSalary(300.0)
                .setNightShift(true)
                .setComments("משמרת מבאסת, להחליף עבודה במידי"));


        shifts.add(new Shift()
                .setKey("S7")
                .setWorkplace("Afeka")
                .setStartTime(System.currentTimeMillis() - (1000l*60*60*24*9) - (1000l*60*60*13))
                .setEndTime(System.currentTimeMillis() - (1000l*60*60*24*9))
                .setSalary(300.0)
                .setNightShift(true)
                .setComments("א\u200Bגכעגכ\u200Bגכ"));



        return shifts;
    }
}