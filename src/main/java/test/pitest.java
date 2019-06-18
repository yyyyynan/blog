package test;

/**
 * Created by nan on 2019/5/28
 */
public class pitest {
    public static void main(String[] args) {
        System.out.println(Math.PI);
    }
    //无穷级数计算 1 - 1/3 + 1/5 -1/7+.....
    public static void wuqiongjishu() {
        double p1 = 1, p2 = 0;
        double i = 1;
        double flag = 1;
        double diff = Math.pow(0.1, 9);
        while (Math.abs(p1 - p2) >= diff) {
            i += 2;
            flag = -flag;
            p2 = p1;
            p1 = p1 + flag / i;
        }
        System.out.println(p1 * 4);
    }

    public static void gailv() {
        int N = (int)Math.pow(2,25);
        double a[] = new double[N];
        double b[] = new double[N];
        for (int i = 0; i < N; i++) {
            a[i] = Math.random();
            b[i] = Math.random();
        }
        int  cnt = 0;
        for (int i=0;i<N;i++){
            double c = a[i] * a[i] + b[i]*b[i];
            if (c<=1){
                cnt ++;
            }
        }
        System.out.println(4.0*cnt/N);
    }
}
