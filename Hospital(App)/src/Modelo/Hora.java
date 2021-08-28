/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Calendar;

/**
 *
 * @author David
 */
public class Hora {
    private  int hh,mm,ss;
    private String ampm; 
    public Hora(int hh, int mm, int ss,String ampm) {
        this.hh = hh;
        this.mm = mm;
        this.ss = ss;
        this.ampm=ampm;
    }
    
    public Hora() {
        Calendar hora=Calendar.getInstance() ;
        this.hh = hora.get(Calendar.HOUR);
        this.mm = hora.get(Calendar.MINUTE);
        this.ss = hora.get(Calendar.SECOND);
        this.ampm = null;
        if (hora.get(Calendar.AM_PM) == Calendar.AM) {
            ampm="a.m.";
        }else{
            ampm="p.m.";
        }
        
    }

    public int getHh() {
        return hh;
    }

    public void setHh(int hh) {
        this.hh = hh;
    }

    public int getMm() {
        return mm;
    }

    public void setMm(int mm) {
        this.mm = mm;
    }

    public int getSs() {
        return ss;
    }

    public void setSs(int ss) {
        this.ss = ss;
    }
    public void incSS(){
         if(this.ss<59){
             ss++;
             
         }
         else if(this.mm<59)
        {
           ss=0;
            mm++;
        }
         else if(this.hh<12){
         
         mm=0;
         ss=0;
         hh++;
         }
    }
    
    @Override
    public String toString() {
       String minuto=""+mm,segundo=""+ss;
        if(mm<10){
            minuto="0"+mm;
        }
        if(ss<10){
            segundo="0"+ss;
        }
        return hh+":"+minuto+":"+segundo+" "+ampm;
    }
}
