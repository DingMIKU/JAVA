package com.my;
import  java.util.Scanner;
public class Calendar {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入年和月份：");
        int year = in.nextInt();
        int month = in.nextInt();
        printCalendar(year,month);
    }

    public static void printCalendar(int year,int month)//这是打印日历全部格式的代码
    {
        printTitle(year,month);
        printBody(year,month);
    }

    public static void printTitle(int year,int month)//打印日历头部格式
    {
        System.out.println("      "+year+"年"+month+"月"+"    ");
        System.out.println("--------------------");
        System.out.println(" 日　一 二　三 四　五　六");
    }

    public static void printBody(int year, int month)//打印日历中间的格式
    {
        int days =  daysInMonth(year,month);
        int startDay = getStartDay(year,month);
        for(int i = 0;i<startDay;i++){
            System.out.print("   ");
        }
        for(int i=1;i<=days;i++){
                System.out.print(" "+String.format("%02d",i));
            if((i+startDay)%7==0)
                System.out.println();
        }
        System.out.println();
    }

    public static int daysInMonth(int year,int month)//获取一个月有几天
    {
        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
            return 31;
        if(month==4||month==6||month==9||month==11)
            return 30;
        if(month==2)
            return isLeapYear(year)?29:28;
        return 0;
    }

    public static int getStartDay(int year, int month)//获取一个月的第一天（因为1759年4月少了11天，所以我写的是从1800年开始算）
    {
        int star1800 = 3;
        int total = 0;
        for(int i =1800;i<year;i++){
            if(isLeapYear(i))
                total=total+366;
            else
            total=total+365;
        }
        for(int i=1;i<month;i++) {
            total=total+daysInMonth(year,i);
        }
        return (total+star1800)%7;
    }

    public static  boolean isLeapYear(int year)//判断是不是闰年
    {
        return year%400==0||(year%4==0&&year%100!=0);
    }
}
