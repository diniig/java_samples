package com.diniig.samples.gof.behavioral;

public class NoCapitalCharFilter implements TextFilter {

    private TextFilter tf;

    public NoCapitalCharFilter(TextFilter tf) {
        this.tf = tf;
    }

    @Override
    public String doFilter(String s) {
        String newS = s.toLowerCase();
        if (tf != null) {
            return tf.doFilter(newS);
        }
        return newS;
    }

}
