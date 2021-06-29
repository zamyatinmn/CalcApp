package com.example.calc;

public class Presenter implements IPresenter {
    private final String OPERATION_PLUS = "+";
    private final String OPERATION_MINUS = "-";
    private final String OPERATION_MULTIPLY = "*";
    private final String OPERATION_DIVISION = "/";
    private final String OPERATION_MODULUS = "%";
    private final String OPERATION_RESULT = "=";

    private double val1 = Double.NaN;
    private double val2 = Double.NaN;
    private final IMainActivity a;
    private String memory = null;

    public Presenter(IMainActivity activity) {
        this.a = activity;
    }

    @Override
    public void b1Clicked() {
        firstStep();
        a.setBot(a.getBot().concat("1"));
    }

    @Override
    public void b2Clicked() {
        firstStep();
        a.setBot(a.getBot().concat("2"));
    }

    @Override
    public void b3Clicked() {
        firstStep();
        a.setBot(a.getBot().concat("3"));
    }

    @Override
    public void b4Clicked() {
        firstStep();
        a.setBot(a.getBot().concat("4"));
    }

    @Override
    public void b5Clicked() {
        firstStep();
        a.setBot(a.getBot().concat("5"));
    }

    @Override
    public void b6Clicked() {
        firstStep();
        a.setBot(a.getBot().concat("6"));
    }

    @Override
    public void b7Clicked() {
        firstStep();
        a.setBot(a.getBot().concat("7"));
    }

    @Override
    public void b8Clicked() {
        firstStep();
        a.setBot(a.getBot().concat("8"));
    }

    @Override
    public void b9Clicked() {
        firstStep();
        a.setBot(a.getBot().concat("9"));
    }

    @Override
    public void b0Clicked() {
        firstStep();
        a.setBot(a.getBot().concat("0"));
    }

    @Override
    public void dotClicked() {
        if (isDecimal()) {
            a.setBot(a.getBot().concat("."));
        }
    }

    @Override
    public void resultClicked() {
        operation(OPERATION_RESULT);
    }

    @Override
    public void plusClicked() {
        if (memory != null){
            operation(memory);
        }
        operation(OPERATION_PLUS);
    }

    @Override
    public void minusClicked() {
        if (memory != null){
            operation(memory);
        }
        operation(OPERATION_MINUS);
    }

    @Override
    public void divClicked() {
        if (memory != null){
            operation(memory);
        }
        memory = OPERATION_DIVISION;
        a.setTop(String.valueOf(val1).concat(memory));
    }

    @Override
    public void mulClicked() {
        if (memory != null){
            operation(memory);
        }
        memory = OPERATION_MULTIPLY;
        a.setTop(String.valueOf(val1).concat(memory));
    }

    @Override
    public void percentClicked() {
        if (memory != null){
            operation(memory);
        }
        memory = OPERATION_MODULUS;
        a.setTop(String.valueOf(val1).concat(memory));
    }

    @Override
    public void delClicked() {
        if (a.getBot().length() > 0) {
            a.setBot(a.getBot().substring(0, a.getBot().length() - 1));
            if (a.getBot().length() == 0){
                a.setBot("0");
            }
        }
    }

    @Override
    public void clearClicked() {
        a.setBot("0");
        a.setTop("...");
        val1 = Double.NaN;
        val2 = Double.NaN;
    }

    @Override
    public Double getVal1() {
        return val1;
    }

    @Override
    public Double getVal2() {
        return val2;
    }

    @Override
    public void setValues(Double val1, Double val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    private void firstStep() {
        int index = a.getBot().indexOf("0");
        if (index == 0 && isDecimal()) {
            a.setBot("");
        }
    }

    private boolean isDecimal() {
        int index = a.getBot().indexOf(".");
        return index == -1;
    }

    private void operation(String operation) {
        if (!Double.isNaN(val1)) {
            if (a.getBot().charAt(0) == '-') {
                val1 = (-1) * val1;
            }
            val2 = Double.parseDouble(a.getBot());
            switch (operation) {
                case OPERATION_PLUS:
                    val1 += val2;
                    break;
                case OPERATION_MINUS:
                    val1 -= val2;
                    break;
                case OPERATION_MULTIPLY:
                    val1 *= val2;
                    break;
                case OPERATION_DIVISION:
                    val1 /= val2;
                    break;
                case OPERATION_MODULUS:
                    val1 %= val2;
                    break;
                case OPERATION_RESULT:
                    if (memory != null)
                        if (!memory.equals(OPERATION_RESULT)) {
                            operation(memory);
                        }
                    break;
            }
        } else {
            val1 = Double.parseDouble(a.getBot());
        }
        memory = operation;
        a.setTop(String.valueOf(val1).concat(operation));
        a.setBot("0");
    }
}
