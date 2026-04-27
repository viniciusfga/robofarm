package robofarm.util;

import java.text.DecimalFormat;

public final class Formatador {

    private static final DecimalFormat DINHEIRO = new DecimalFormat("R$ #,##0.00");
    private static final DecimalFormat PESO = new DecimalFormat("#,##0.00 kg");

    private Formatador() {
    }

    public static String formatarDinheiro(double valor) {
        return DINHEIRO.format(valor);
    }

    public static String formatarKg(double valor) {
        return PESO.format(valor);
    }
}