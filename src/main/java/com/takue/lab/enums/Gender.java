package com.takue.lab.enums;

import lombok.Getter;

@Getter
public enum Gender {
    MALE("male"), FEMALE("female");

  public final  String label;


    Gender(String label) {
        this.label = label;
    }

    public static Gender valueOfLabel(String label){
        for (Gender g : values()){
            if(g.label.equals(label)){
                return g;
            }
        }
        return null;
    }
}
