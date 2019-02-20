package jesse.dynamicviewpagerdemo;

import android.support.annotation.Px;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import jesse.dynamicviewpagerdemo.adapter.ConcreteAdapter;
import jesse.dynamicviewpagerdemo.entity.FruitEntity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private static String[] fruits = {"apple", "banana", "orange", "peach", "watermelon", "grape"};
    private List<FruitEntity> list;
    private ViewPager mViewPager;
    private ConcreteAdapter mPagerAdapter;

    private Button mBtnDelete;
    private Button mBtnAdd;

    private int currentIndex;//当前index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initViews() {
        mBtnDelete = findViewById(R.id.btn_main);
        mBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(list.get(currentIndex));
                mPagerAdapter.setData(list);
            }
        });

        mBtnAdd = findViewById(R.id.btn_main_add);
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.add(new FruitEntity(String.valueOf(System.currentTimeMillis())));
                mPagerAdapter.setData(list);
            }
        });

        mViewPager = findViewById(R.id.vp_main);
        mPagerAdapter = new ConcreteAdapter(getSupportFragmentManager());

        list = new ArrayList<>();

        for (String s :
                fruits) {
            FruitEntity entity = new FruitEntity(s);
            list.add(entity);
        }

        mPagerAdapter.setData(list);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, @Px int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                Log.d(TAG, "onPageSelected: " + i);
                currentIndex = i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        mViewPager.setAdapter(mPagerAdapter);

        currentIndex = 0;
    }
}
