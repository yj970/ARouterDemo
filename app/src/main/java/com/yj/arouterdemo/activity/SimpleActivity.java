package com.yj.arouterdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.yj.arouterdemo.R;
import com.yj.arouterdemo.bean.TestObject;
import com.yj.arouterdemo.util.L;

// 这里的path值自定义
@Route(path = "/com/simpleActivity")
public class SimpleActivity extends Activity{
    @Autowired
    public String name;
    @Autowired(name = "object")
    public TestObject testObject;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        // 2种方式，获取从上一个界面传递过来的数据
        //1.getIntent
        getDataByGetIntent();
       // 2/通过注解@Autowired
        getDataByInject();
    }

    private void getDataByGetIntent() {
        if (getIntent().hasExtra("name")) {
            String name = getIntent().getStringExtra("name");
            L.d("name = "+name);
        }
        if (getIntent().hasExtra("object")) {
            TestObject testObject = (TestObject) getIntent().getSerializableExtra("object");
            L.d("key = "+testObject.getKey());
        }
    }

    // 通过阿里路由注入的方式获取数据
    public void getDataByInject() {
        ARouter.getInstance().inject(this);
        if (name != null) {
            L.d("name = " + name);
        }
        if (testObject != null) {
            L.d("key = " + testObject.getKey());
        }
    }
}
