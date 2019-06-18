package test.ThreadTask;

import java.io.File;

/**
 * 堆 栈测试
 * @author Administrator
 */
public class stackOrHeapTest {
    public static void main(String[] args){
        int a = 3;
        int b = a;
        File c = new File("a");
        System.out.println(c.hashCode());
        File d = c;
        System.out.println(c.hashCode()+" "+d.hashCode());
    }
}
