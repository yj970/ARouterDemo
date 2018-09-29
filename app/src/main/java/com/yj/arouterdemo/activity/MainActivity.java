package com.yj.arouterdemo.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.yj.arouterdemo.R;
import com.yj.arouterdemo.activity.TestFragmentActivity;
import com.yj.arouterdemo.activity.WebViewActivity;
import com.yj.arouterdemo.bean.TestObject;
import com.yj.arouterdemo.util.L;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    // 最简单跳转
    public void click1(View view) {
        ARouter.getInstance().build("/com/simpleActivity").navigation();
    }

    // 携带数据
    public void click2(View view) {
        ARouter.getInstance().build("/com/simpleActivity").withString("name", "yangjie").withSerializable("object", new TestObject("123")).navigation();
    }

    //  带回调函数；navigation有多个重写方法，支持回调、requestCode等入参
    public void click3(View view) {
        ARouter.getInstance().build("/com/simpleActivity").navigation(this, new NavigationCallback(){
            @Override
            public void onFound(Postcard postcard) {
                L.d("找到了");
            }

            @Override
            public void onLost(Postcard postcard) {
                L.d("找不到");
            }

            @Override
            public void onArrival(Postcard postcard) {
                L.d("跳转成功");
            }

            @Override
            public void onInterrupt(Postcard postcard) {
                L.d("被拦截");
            }
        });
    }

    // 在webview里面利用ARouter进行页面跳转
    // 需要新建中转站URLReceiverActivity,然后在AndroidManifest配置scheme和host，用于匹配路由
    public void click4(View view) {
        startActivity(new Intent(this, WebViewActivity.class));
    }

    // 利用路由获取Fragment
    public void click5(View view) {
        startActivity(new Intent(this, TestFragmentActivity.class));
    }

    // 暴露服务( 实际上就跟dagger2一样，利用注入，免去了new 对象的操作)
    public void click6(View view) {
        startActivity(new Intent(this, TestIProviderActivity.class));
    }
}
