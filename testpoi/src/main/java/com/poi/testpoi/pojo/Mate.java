package com.poi.testpoi.pojo;

/**
 * @ClassName mata
 * @Deacription TODO
 * @Author QianZ
 * @Date 2019/10/26 23:13
 * @Version 1.0
 **/
public class Mate implements Comparable<Mate>{

    public String name;
    public int chosenTimes=0;

    public Mate(String name){
        this.name=name;
    }

    @Override
    public int compareTo(Mate o) {

        if(this.chosenTimes<o.chosenTimes)
            return -1;
        else
            return 1;

    }
}
