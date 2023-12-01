package org.example;

import java.io.Serializable;

public class DTO implements Serializable {
    int a;
    int b;

    public DTO(int a, int b) {
        this.a = a;
        this.b=b;
    }
}
