package com.example.herve.materialvideo.view.customviews;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LayoutAnimationController;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.herve.materialvideo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Herve on 2016/5/17.
 */
public class CustomMenuView extends LinearLayout {
    public String TAG = getClass().getSimpleName();

    /*内容声明*/
    private Context mContext;
    /*控件*/
    private View root;
    private LinearLayout rl_blur_layout;
    private LinearLayout ll_make_new_film_btn;
    private GridView gridView;
    //    private Button btn_start_make;
    private LinearLayout ll_make_new_film_btn_bg_mask;
    private RelativeLayout rl_make_new_film_btn_root_mask;
    private TextView tv_start_to_make;
    private ImageView iv_make_new_film_btn_center;

    /*数据&适配器*/
    private MenuCustomAdapter customAdapter;
    private int menuState = 2;
    private final int MENU_STATE_DOING = 0;
    private final int MENU_STATE_OPED = 1;
    private final int MENU_STATE_CLOSED = 2;
    private List<MakeFilmMenuBean> menuBeen;

    public DisplayMetrics dm;

    private int dmW;
    private int dmH;
    /*动画*/
    LayoutAnimationController layoutAnimationUP;
    LayoutAnimationController layoutAnimationDown;
    RotateAnimation rotateAnimation_rota_to_45;
    RotateAnimation rotateAnimation_rota_to_0;

    /*外部可变变量*/

    private int numColumns = 2;

    /*属性变量*/
    private Animation animation;
    private AnimationSet set;
    private LayoutAnimationController controllerUP;
    private LayoutAnimationController controllerDown;
    private int position = 0;

    public CustomMenuView(Context context) {
        super(context);
        this.mContext = context;
        initView();

    }

    public CustomMenuView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initView();

    }

    public CustomMenuView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;

        initView();
    }

    private void initView() {

        DisplayMetrics dm = getResources().getDisplayMetrics();
        dmW = dm.widthPixels;
        dmH = dm.heightPixels;

        initUI();

        initData();

        initAnim();

        initListener();

    }

    private void initUI() {
        root = LayoutInflater.from(mContext).inflate(R.layout.make_film_layout, null);
        rl_blur_layout = (LinearLayout) root.findViewById(R.id.rl_blur_layout);
        ll_make_new_film_btn = (LinearLayout) root.findViewById(R.id.ll_make_new_film_btn);
        tv_start_to_make = (TextView) root.findViewById(R.id.tv_start_to_make);
        ll_make_new_film_btn_bg_mask = (LinearLayout) root.findViewById(R.id.ll_make_new_film_btn_bg_mask);
        rl_make_new_film_btn_root_mask = (RelativeLayout) root.findViewById(R.id.rl_make_new_film_btn_root_mask);
        iv_make_new_film_btn_center = (ImageView) root.findViewById(R.id.iv_make_new_film_btn_center);
        gridView = (GridView) root.findViewById(R.id.herve_gv_make);

//        String SCREEN_HW_TYPE = AppGlobal.getScreenHWType(dmW, dmH);

//        int marTOP = 30;
//        if (SCREEN_HW_TYPE.equals(AppConstant.SCREEN_HW_12_15)) {
//            marTOP = 10;
//        } else if (SCREEN_HW_TYPE.equals(AppConstant.SCREEN_HW_15_18)) {
//            marTOP = 60;
//        }

        /*布局设置*/
//        ll_make_new_film_btn.setLayoutParams(UI.getLinearLayoutPararmW2B(false, dmW, dmH, 100, 0));
//        ll_make_new_film_btn_bg_mask.setLayoutParams(UI.getLinearLayoutPararmH(dmW, dmH, 120));
//        iv_make_new_film_btn_center.setLayoutParams(UI.getLinearLayoutPararmW2B(false, dmW, dmH, 30, 0));
//
//        gridView.setLayoutParams(UI.getRelativeLayoutPararmWT(dmW, 400, marTOP));
//
        /**/
        addView(root);

        rl_blur_layout.setVisibility(GONE);
    }

    private void initData() {

        menuBeen = new ArrayList<>();

        MakeFilmMenuBean videoAlbumBean = new MakeFilmMenuBean(R.drawable.make_moive_album, R.string.film_type_video_album);
        MakeFilmMenuBean wechatBean = new MakeFilmMenuBean(R.drawable.make_moive_wechat_moments, R.string.film_type_wechat_moments);
        MakeFilmMenuBean openingBean = new MakeFilmMenuBean(R.drawable.make_moive_opening, R.string.film_type_opening);
        MakeFilmMenuBean filmBean = new MakeFilmMenuBean(R.drawable.make_moive_film, R.string.film_type_film);
        MakeFilmMenuBean adsBean = new MakeFilmMenuBean(R.drawable.make_moive_ads, R.string.film_type_ads);
        MakeFilmMenuBean mediaBean = new MakeFilmMenuBean(R.drawable.make_moive_media, R.string.film_type_media);

        MakeFilmMenuBean customClipBean = new MakeFilmMenuBean(R.drawable.make_moive_clip, R.string.film_type_custom_clip);
        MakeFilmMenuBean myMarkBean = new MakeFilmMenuBean(R.drawable.make_moive_mark, R.string.film_type_my_mark);

        menuBeen.add(videoAlbumBean);
        menuBeen.add(wechatBean);
        menuBeen.add(openingBean);
        menuBeen.add(filmBean);
        menuBeen.add(adsBean);
        menuBeen.add(mediaBean);
        menuBeen.add(customClipBean);
        menuBeen.add(myMarkBean);

        gridView.setNumColumns(numColumns);
        gridView.setSelector(new ColorDrawable(Color.TRANSPARENT));

        customAdapter = new MenuCustomAdapter(mContext, menuBeen, dmW, dmH);
        gridView.setAdapter(customAdapter);
    }

    private void initAnim() {
        rotateAnimation_rota_to_45 = new RotateAnimation(0, 135, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation_rota_to_45.setDuration(300);
        rotateAnimation_rota_to_45.setFillAfter(true);
        rotateAnimation_rota_to_45.setInterpolator(new AccelerateDecelerateInterpolator());

        rotateAnimation_rota_to_0 = new RotateAnimation(135, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation_rota_to_0.setDuration(300);
        rotateAnimation_rota_to_0.setFillAfter(true);
        rotateAnimation_rota_to_0.setInterpolator(new AccelerateDecelerateInterpolator());

        layoutAnimationUP = getAnimationControllerUP();
        layoutAnimationDown = getAnimationControllerDown();

    }

    private void initListener() {

        ll_make_new_film_btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                startAnimation();

            }
        });

        rl_blur_layout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
//                Log.e(TAG, "onClick: 点击了背景");

            }
        });
    }

    //展示动画
    public void startAnimation() {

        if (menuState == MENU_STATE_CLOSED) {

            openMenu();

        } else if (menuState == MENU_STATE_OPED) {

            closeMenu();

        }

    }

    public void showMakeMenu() {

        rl_make_new_film_btn_root_mask.setVisibility(VISIBLE);
    }

    public void closeMakeMenuALL() {
        rl_blur_layout.setVisibility(GONE);
        rl_make_new_film_btn_root_mask.setVisibility(GONE);
        closeMenu();
    }

    //打开
    public void openMenu() {

        if (menuState == MENU_STATE_CLOSED) {

            menuState = MENU_STATE_DOING;
            ll_make_new_film_btn.setClickable(false);

            rl_blur_layout.setVisibility(VISIBLE);
            tv_start_to_make.setText(mContext.getString(R.string.close));

            ll_make_new_film_btn.startAnimation(rotateAnimation_rota_to_45);

            customAdapter.notifyDataSetChanged();
            gridView.setLayoutAnimation(layoutAnimationUP);
            gridView.startLayoutAnimation();

        } else {
            //不处理
        }
    }

    //关闭
    public void closeMenu() {
        if (menuState == MENU_STATE_OPED) {

            menuState = MENU_STATE_DOING;
            ll_make_new_film_btn.setClickable(false);

            tv_start_to_make.setText(mContext.getString(R.string.start_to_make));

            ll_make_new_film_btn.startAnimation(rotateAnimation_rota_to_0);

            gridView.setLayoutAnimation(layoutAnimationDown);
            gridView.startLayoutAnimation();

        } else {
            //不处理

        }

    }

    //设置监听
    public void setOnItemClikListener(AdapterView.OnItemClickListener onItemClikListener) {
        gridView.setOnItemClickListener(onItemClikListener);

    }

    //向下的动画
    protected LayoutAnimationController getAnimationControllerDown() {
        int duration = 200;
        set = new AnimationSet(true);

        controllerDown = new LayoutAnimationController(set, 0.5f);
        animation = new TranslateAnimation(0, 0, 0, 1500);
        animation.setFillAfter(false);
        controllerDown.setOrder(LayoutAnimationController.ORDER_REVERSE);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                gridView.getChildAt(position--).layout(0, -1500, 0, 0);
                if (position == -1) {
                    position = 0;
                    menuState = MENU_STATE_CLOSED;
                    ll_make_new_film_btn.setClickable(true);
                    rl_blur_layout.setVisibility(GONE);
                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animation.setDuration(duration);
        set.addAnimation(animation);

        return controllerDown;
    }

    //向上的动画
    protected LayoutAnimationController getAnimationControllerUP() {
        int duration = 200;
        set = new AnimationSet(true);

        controllerUP = new LayoutAnimationController(set, 0.5f);

        animation = new TranslateAnimation(0, 0, 1550, -30);
        animation.setFillAfter(false);
        controllerUP.setOrder(LayoutAnimationController.ORDER_NORMAL);

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                position++;
                if (position == menuBeen.size()) {
                    position = menuBeen.size() - 1;
                    menuState = MENU_STATE_OPED;
                    ll_make_new_film_btn.setClickable(true);

                }

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        animation.setDuration(duration);
        set.addAnimation(animation);

        return controllerUP;
    }
}