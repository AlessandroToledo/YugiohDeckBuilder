package com.yugioh.YugiohDeckBuilder.Pojos;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.Entity;

@Entity
//@JsonInclude(JsonInclude.Include.NON_NULL)

public class Card {

    private String name;

    private int atk;

    private int def;

    private int level;

    public Card() {
    }

    public Card(String name, int atk, int def, int level) {
        this.name = name;
        this.atk = atk;
        this.def = def;
        this.level = level;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAtk() {
        return this.atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}