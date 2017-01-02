package myproject.test.com.mytestviewproject;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mCompleteImageView;
    // private Animation enlargeAnimation, unenlargeAnimation,alphaAnimation;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCompleteImageView = (ImageView) findViewById(R.id.complete_btn_ok_iv_iv);
        mCompleteImageView.setImageResource(R.drawable.complete_icon_ok);

        final AnimatorSet animatorSet = new AnimatorSet();
        final ObjectAnimator animator1 = ObjectAnimator.ofFloat(mCompleteImageView, "scaleX", 0.6f, 1.2f);
        final ObjectAnimator animator2 = ObjectAnimator.ofFloat(mCompleteImageView, "scaleY", 0.6f, 1.2f);

        final ObjectAnimator animator3 = ObjectAnimator.ofFloat(mCompleteImageView, "scaleX", 1.2f, 1f);
        final ObjectAnimator animator4 = ObjectAnimator.ofFloat(mCompleteImageView, "scaleY", 1.2f, 1f);

        //animatorSet.playTogether(animator1,animator2);
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(animator3).with(animator4);
                animatorSet.setDuration(1000);
                animatorSet.start();
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });


        animatorSet.play(animator1).with(animator2);
        animatorSet.setDuration(700);
        animatorSet.start();

    }

}
