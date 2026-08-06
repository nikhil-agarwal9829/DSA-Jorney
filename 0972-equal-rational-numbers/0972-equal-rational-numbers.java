class Solution {

    private double convert(String s) {

        if (!s.contains("("))
            return Double.parseDouble(s);

        int dot = s.indexOf('.');
        int open = s.indexOf('(');
        int close = s.indexOf(')');

        String integer = s.substring(0, dot + 1);
        String nonRepeat = s.substring(dot + 1, open);
        String repeat = s.substring(open + 1, close);

        StringBuilder sb = new StringBuilder();

        sb.append(integer);
        sb.append(nonRepeat);

        for (int i = 0; i < 20; i++)
            sb.append(repeat);

        return Double.parseDouble(sb.toString());
    }

    public boolean isRationalEqual(String s, String t) {

        return Math.abs(convert(s) - convert(t)) < 1e-12;
    }
}