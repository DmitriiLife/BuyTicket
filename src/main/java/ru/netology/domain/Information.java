package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Information implements Comparable<Information> {

    private int id;
    private int price;
    private String to;
    private String from;
    private int travelTime;

    @Override
    public int compareTo(Information o) {
        return this.price - o.price;
    }
}

