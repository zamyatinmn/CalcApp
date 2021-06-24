package com.example.calc;

public interface IPresenter {
    void b1Clicked();

    void b2Clicked();

    void b3Clicked();

    void b4Clicked();

    void b5Clicked();

    void b6Clicked();

    void b7Clicked();

    void b8Clicked();

    void b9Clicked();

    void b0Clicked();

    void dotClicked();

    void resultClicked();

    void plusClicked();

    void minusClicked();

    void divClicked();

    void mulClicked();

    void percentClicked();

    void delClicked();

    void clearClicked();

    Double getVal1();

    Double getVal2();

    void setValues(Double val1, Double val2);
}
