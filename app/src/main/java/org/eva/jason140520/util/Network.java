package org.eva.jason140520.util;/**
 * Copyright (C), 2020, Jason
 * Author: JiangLin
 * Date: 2020/1/2 23:35
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * @ClassName: Network
 * @Description: 网络请求工具类
 * @Author: JiangLin
 * @Date: 2020/1/2 23:35
 */
public final class Network {
    public static final MediaType JSON = MediaType.get("application/json;charset=utf-8");
    private final OkHttpClient okHttpClient;

    public Network() throws Exception {
        //配置超时时间
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .writeTimeout(5,TimeUnit.SECONDS)
                .readTimeout(5,TimeUnit.SECONDS)
                .callTimeout(5,TimeUnit.SECONDS)
                .callTimeout(10, TimeUnit.SECONDS)
                .build();
    }
     /**
      * @method:  异步get请求方法
      * @description: 用于应用的异步get请求
      * @date: 2020/1/2 23:47
      * @author: Jason
      * @param:  url 请求的url
      * @return: 返回字符串类型
      */
     void AsynchronousGet(String url) throws Exception {
         Request request = new Request.Builder().url(url).build();

         okHttpClient.newCall(request).enqueue(new Callback() {
             //请求失败处理
             @Override
             public void onFailure(@NotNull Call call, @NotNull IOException e) {
                 e.printStackTrace();
             }

             @Override
             public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                 try (ResponseBody responseBody = response.body()) {
                     if (!response.isSuccessful()) throw new IOException("Unexpected code"+ response);

                     Headers responseHeaders = response.headers();
                     for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                         //遍历header
                     }
                     System.out.println(responseBody.string());
                 }
             }
         });
     }

      /**
       * @method:  同步get请求方法
       * @description: 用于应用的同步get请求
       * @date: 2020/1/3 0:35
       * @author:
       * @param:  url 请求的url
       * @return:
       */
     String SynchronousGet(String url) throws Exception {
         Request request = new Request.Builder()
                 .url(url)
                 .build();
         try (Response response = okHttpClient.newCall(request).execute()) {
             if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

             Headers responseHeaders = response.headers();
             for (int i = 0; i < responseHeaders.size(); i++) {
                 System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
             }
             return response.body().string();
         }
     }

      /**
       * @method:  post请求方法
       * @description: 描述一下方法的作用
       * @date: 2020/1/2 23:51
       * @author: Jason
       * @param:  url 请求的url连接，json json格式请求参数
       * @return: 返回字符串类型
       */
      String postMethod(String url, String json) throws IOException {
          RequestBody body = RequestBody.create(json,JSON);
          Request request = new Request.Builder()
                  .url(url)
                  .post(body)
                  .build();
          try (Response response = okHttpClient.newCall(request).execute()) {
              return response.body().string();
          }
      }


}
