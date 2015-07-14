package com.study.apptimer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Administrator on 2015-07-09.
 */
public class GalleryActivity extends Activity {
    GalleryView galleryView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        galleryView=(GalleryView)findViewById(R.id.galleryview);
    }
    public void next(){
        //GalleryView가 보유한 index 변수의 값을 1증가 시킨후 다시 그리기
        int index=galleryView.getIndex();
        index++;
        galleryView.setIndex(index);
        galleryView.invalidate();
    };

    public void btnClick(View view){
        next();
    }
}
