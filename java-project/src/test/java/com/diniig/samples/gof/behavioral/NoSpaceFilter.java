package com.diniig.samples.gof.behavioral;

public class NoSpaceFilter implements TextFilter {

    private TextFilter tf;

    public NoSpaceFilter(TextFilter tf) {
        this.tf = tf;
    }

    @Override
    public String doFilter(String s) {
        String newS = s.replace(" ", "");
        if (tf != null) {
            return tf.doFilter(newS);
        }
        return newS;
    }
}
