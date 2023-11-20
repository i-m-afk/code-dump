package BitManupulation;

class MinFlips {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        String bin = Integer.toBinaryString(a | b);
        String c_bin = Integer.toBinaryString(3);
        int count = 0;
        System.out.println(bin + " " + c_bin);
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) != c_bin.charAt(i)) {
                if (c_bin.charAt(i) == '0')
                    count++;
                count++;
            }
        }
        System.out.println(count);
    }
}