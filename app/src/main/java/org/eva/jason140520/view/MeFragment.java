package org.eva.jason140520.view;/**
 * Copyright (C), 2020, Jason
 * Author: JiangLin
 * Date: 2020/1/2 23:10
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import org.eva.jason140520.R;

/**
 * @ClassName: MeFragment
 * @Description:
 * @Author: JiangLin
 * @Date: 2020/1/2 23:10
 */
public class MeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_me,container,false);
        ImageView me_ImageView = view.findViewById(R.id.me_image_view);
        RecyclerView me_recyclerView = view.findViewById(R.id.me_recycler_view);
        return view;
    }
}
