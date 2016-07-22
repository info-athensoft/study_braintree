package com.athensoft.util.date;

import java.util.*;
import java.text.*;

public class DateDemo {
   public static void main(String args[]) {

      Date dNow = new Date( );
      SimpleDateFormat ft = 
//      new SimpleDateFormat ("E yyyy-MM-dd ' ' hh:mm:ss a zzz");
      new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss a zzz");

      System.out.println("Current Date: " + ft.format(dNow));
      
      String s = ft.format(dNow);
      System.out.println(s);
   }
}
