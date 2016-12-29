package myproject.test.com.mytestviewproject;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        mImageView = (ImageView) findViewById(R.id.activity_main_iv);
        mImageView.setImageLevel(1);
        mHandler = new Handler();
    }
}
