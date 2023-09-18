/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oltpbenchmark.multitenancy;

import java.util.Comparator;

import com.oltpbenchmark.multitenancy.sla.Penalty;


class SortbyTime implements Comparator<Penalty> {
    @Override
    public int compare(Penalty a, Penalty b) {
        return (int) (a.getTime() - b.getTime());
    }
}