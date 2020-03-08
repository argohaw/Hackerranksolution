import java.io.*;
import java.util.*;

public class Solution {
        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        System.out.print(convert(x));
    }
    public static String convert(String post) {
        checkPerfect(post); 
        return convertInner(post);
    }

    private static String convertInner(String post) {
        int len = post.length();
        if (len == 1) return post; 

        String left = post.substring(0, len >> 1); 
        String right = post.substring(len >> 1, len - 1);
        char root = post.charAt(len - 1);

        return convertInner(left) + root + convertInner(right);
    }

    private static void checkPerfect(String tree) {
        if (!isPerfect(tree)) throw new IllegalArgumentException("input is not perfect tree, size: " + tree.length());
    }

    private static boolean isPerfect(String tree) {
        int len = tree.length();
        if (len < 1) return false;

        while (len != 0) {
            if ((len & 1) == 0) return false;
            len >>= 1;
        }

        return true;
    }

}
