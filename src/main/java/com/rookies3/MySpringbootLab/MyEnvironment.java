package com.rookies3.MySpringbootLab;

public class MyEnvironment {

    private String mode;

    // 생성자
    public MyEnvironment(String mode) {
        this.mode = mode;
    }

    // getter
    public String getMode() {
        return mode;
    }

    // setter
    public void setMode(String mode) {
        this.mode = mode;
    }
}
