package com.example.herve.materialvideo.ui.home.fragments.squareListFragment.fragments.bilibilifragment.presenter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.example.herve.materialvideo.core.AppContant;
import com.example.herve.materialvideo.data.bean.bjxbean.BJXTabBean;
import com.example.herve.materialvideo.data.bean.bjxbean.SquareListData;
import com.example.herve.materialvideo.utils.fastjson.FastJsonParser;
import com.okhttplib.HttpInfo;
import com.okhttplib.OkHttpUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created           :Herve on 2016/8/15.
 *
 * @ Author          :Herve
 * @ e-mail          :lijianyou.herve@gmail.com
 * @ LastEdit        :2016/8/15
 * @ projectName     :MaterialVideo
 * @ version
 */
public class BiliBiliPrsenter implements BiliBiliContract.Presenter {


    private BiliBiliContract.PresenterView presenterView;

    private Context mContext;

    private Handler mHandler;


    private String TAG = getClass().getSimpleName();

    public BiliBiliPrsenter(BiliBiliContract.PresenterView presenterView, Context mContext) {
        this.presenterView = presenterView;
        this.mContext = mContext;
        mHandler = new Handler(Looper.getMainLooper());
    }


    @Override
    public void start() {


        new Thread(new Runnable() {
            @Override
            public void run() {
                BJXTabBean bean = GetExample();
                GetFilm(bean);

            }
        }).start();


    }

    private void GetFilm(BJXTabBean bjxTabBean) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("m", "square");
        map.put("c", "api");
        map.put("a", "getSquareCategoryContentData");
        map.put("APPVer", AppContant.APPVERSION);
        map.put("APPOS", AppContant.OS_VERSION);
        map.put("token", "");
        map.put("currentUserId", AppContant.USER_ID);
        /*--------------------*/
        map.put("squareTypeId", "2");
        map.put("orderId", "0");

        HttpInfo info = HttpInfo.Builder().addParams(map).setUrl(AppContant.SQUARE_BANNER_URL).build();
        OkHttpUtil.getDefault(mContext).doGetSync(info);

        if (info.isSuccessful()) {
            final String result = info.getRetDetail();

            final SquareListData bean = FastJsonParser.getInstance().fromJson(result, SquareListData.class);
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    presenterView.refreshBanner(bean.getSquareBanner());
                    presenterView.refreshPartitions(bean.getSquareTypeGroup());
                }
            });
        }
    }

    public BJXTabBean GetExample() {
        BJXTabBean bean = null;
        Map<String, String> okRequestParams = new HashMap<String, String>();
        okRequestParams.put("m", "square");
        okRequestParams.put("c", "api");
        okRequestParams.put("a", "getSquareCategoryData");
        okRequestParams.put("APPVer", AppContant.APPVERSION);
        okRequestParams.put("APPOS", AppContant.OS_VERSION);
        okRequestParams.put("token", "");
        okRequestParams.put("currentUserId", AppContant.USER_ID);

        HttpInfo info = HttpInfo.Builder().addParams(okRequestParams).setUrl(AppContant.SQUARE_BANNER_URL).build();
        OkHttpUtil.getDefault(mContext).doGetSync(info);

        if (info.isSuccessful()) {
            final String result = info.getRetDetail();

            bean = FastJsonParser.getInstance().fromJson(result, BJXTabBean.class);
            Log.e(TAG, "run: " + bean.toString());
        }

        return bean;
    }

    @Override
    public void stop() {

    }


}