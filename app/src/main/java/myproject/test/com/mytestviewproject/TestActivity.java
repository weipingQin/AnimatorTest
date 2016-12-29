package myproject.test.com.mytestviewproject;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by T32E on 16/12/28.
 */

public class TestActivity extends AppCompatActivity {

    private Handler mHandler;
    private Animation animation, alphaAnimation;
    private AnimationSet animationset;
    private Timer mTimer;

    private TextView mCircle;
    private ImageView mWifiImage;

    public static final int REFRESH_UI = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        init();
    }

    /*
        初始化组件
     */
    private void init() {
        mCircle = (TextView) findViewById(R.id.circleview);
        mWifiImage = (ImageView) findViewById(R.id.wifi_image);
        mWifiImage.setImageResource(R.drawable.wifi_animationlist);
        AnimationDrawable animationDrawable = (AnimationDrawable) mWifiImage.getDrawable();
        animationDrawable.start();
        mHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                switch (message.what) {
                    case REFRESH_UI:
                        mCircle.setAnimation(animationset);
                        mCircle.startAnimation(animation);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
        initAnima();
        mTimer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = REFRESH_UI;
                mHandler.sendMessage(message);
            }
        };
        mTimer.schedule(timerTask, 0, 3000);
    }

    /**
     * 初始化缩放动画
     * 设置动画为加速动画
     */
    private void initAnima() {
        animation = AnimationUtils.loadAnimation(this, R.anim.enlarganim);
        alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha_out);
        animationset = new AnimationSet(true);
        animationset.setInterpolator(new AccelerateInterpolator());
        animationset.addAnimation(alphaAnimation);
        animationset.addAnimation(animation);
        animation.reset();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTimer.cancel();
    }
}
