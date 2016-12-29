package myproject.test.com.mytestviewproject.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import myproject.test.com.mytestviewproject.R;


/**
 * Created by T32E on 16/12/27.
 */

public class RadarView extends View{

    private Paint mPaint;
    private DisplayMetrics mDisplayMetrics;

    //定义屏幕的宽度和高度 圆心
    private int radius;

    private int screenhight,screenWidth;
    protected  Context mContext;

    public RadarView(Context context) {
        this(context, null);
    }

    public RadarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RadarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        init();
    }

    private void init() {
        mDisplayMetrics = new DisplayMetrics();
        mPaint = new Paint();
        mPaint.setColor(mContext.getResources().getColor(R.color.circlecolor));
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(screenWidth/2,screenhight/2,radius,mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
