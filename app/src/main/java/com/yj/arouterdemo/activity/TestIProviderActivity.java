package com.yj.arouterdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.yj.arouterdemo.R;
import com.yj.arouterdemo.interfaces.MyServiceImpl;

public class TestIProviderActivity extends Activity{
    @Autowired(name = "/com/myService")
    MyServiceImpl myService;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_iprovider);

        ARouter.getInstance().inject(this);
        myService.say();
    }
}
