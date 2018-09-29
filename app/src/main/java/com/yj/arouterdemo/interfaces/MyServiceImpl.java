package com.yj.arouterdemo.interfaces;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/com/myService")
public class MyServiceImpl implements MyService {
    private Context context;
    @Override
    public void say() {
        Toast.makeText(context,"hello~",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void init(Context context) {
        this.context = context;
    }
}
