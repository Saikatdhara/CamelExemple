package com.digi.billgenerate.model.servicea;

public class CustomerBill {
    public String id;
    public String name;

    @Override
    public String toString() {
        return "CustomerBill{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
