package org.eva.jason140520.view;/**
 * Copyright (C), 2020, Jason
 * Author: JiangLin
 * Date: 2020/1/2 23:00
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.eva.jason140520.R;

/**
 * @ClassName: LaunchActivity
 * @Description: app启动页Activity
 * @Author: JiangLin
 * @Date: 2020/1/2 23:00
 */
public class LaunchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
    }
}
