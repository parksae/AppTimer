//뷰를 상속받아 그림을 내가 주도하자!!

package com.study.apptimer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2015-07-09.
 */
public class GalleryView extends View{
    private int[] img=new int[7];
    private int index;//현재보여주고 있는 배열의 인덱스
    public GalleryView(Context context) {
        super(context);
        init();
    }

    public GalleryView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init(){
        img[0]=R.drawable.cho;
        img[1]=R.drawable.cho_c;
        img[2]=R.drawable.cook;
        img[3]=R.drawable.cook_c;
        img[4]=R.drawable.knife;
        img[5]=R.drawable.knife_c;
        img[6]=R.drawable.onepiece;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //비트맵 그림을 그린다

        Bitmap bitmp=BitmapFactory.decodeResource(getResources(),img[index]);
         canvas.drawBitmap(bitmp,0,0,null);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
