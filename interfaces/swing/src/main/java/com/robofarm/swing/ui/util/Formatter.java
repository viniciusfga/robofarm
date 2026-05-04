package com.robofarm.swing.ui.util;

import java.text.DecimalFormat;

public final class Formatter {

    private static final DecimalFormat MONEY = new DecimalFormat("R$ #,##0.00");
    private static final DecimalFormat WEIGHT = new DecimalFormat("#,##0.00 kg");

    private Formatter() {
    }

    public static String formatMoney(double value) {
        return MONEY.format(value);
    }

    public static String formatKg(double value) {
        return WEIGHT.format(value);
    }
}