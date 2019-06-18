package test.ThreadTask;

import com.yitu2.demo.service.MainService;

import javax.annotation.Resource;

/**
 * Created by nan on 2019/5/14
 *
 * @author Administrator
 */
public class mainThreadtest implements Runnable {

    public int sum = 0;

    @Resource
    private MainService mainService;

    public mainThreadtest(MainService mainService) {
        this.mainService = mainService;
        System.out.println("新建1");
    }

    @Override
    public synchronized void run() {

        int num = mainService.selvaltest();
        sum = num;
        System.out.println("运行");

    }
}
