package org.eva.jason140520.view

import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import org.eva.jason140520.R

/**
 * @ClassName:      MainActivity
 * @Description:     java类作用描述
 * @Author:         JiangLin
 * @CreateDate:     2019/12/30 23:39
 * @UpdateUser:     JiangLin
 * @UpdateDate:     2019/12/30 23:39
 * @UpdateRemark:   新建类
 * @Version:        1.0
 */
class LaunchActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //supportActionBar?.hide()//隐藏ActionBar
        setContentView(R.layout.activity_launch)
    }
}