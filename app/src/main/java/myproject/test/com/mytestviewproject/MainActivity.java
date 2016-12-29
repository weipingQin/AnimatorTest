package myproject.test.com.mytestviewproject;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mCompleteImageView;
    private Animation mAnimation;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        mCompleteImageView = (ImageView) findViewById(R.id.complete_btn_ok_iv_iv);
        mCompleteImageView.setImageResource(R.drawable.complete_icon_ok);
        mAnimation = AnimationUtils.loadAnimation(this,R.anim.enlarge_complete);
        mCompleteImageView.startAnimation(mAnimation);
    }
}
