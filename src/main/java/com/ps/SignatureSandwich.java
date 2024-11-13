package com.ps;

public class SignatureSandwich extends Sandwich {
    private String templateName;

    public SignatureSandwich(String templateName, int size, String bread, boolean toasted) {
        super(size, bread, toasted);
        this.templateName = templateName;
    }

    @Override
    public String toString() {
        return "Signature " + templateName + " " + super.toString();
    }
}

