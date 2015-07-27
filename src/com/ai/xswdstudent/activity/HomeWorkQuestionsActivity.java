package com.ai.xswdstudent.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.baseactivity.BaseActivity;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;

public class HomeWorkQuestionsActivity extends BaseActivity{

    @ViewInject(R.id.txtbase_top_left)
    private TextView txtbase_top_left;
    
	@ViewInject(R.id.llayoutcamera)
	private LinearLayout llayoutcamera;
	
	@ViewInject(R.id.imgquestionpic1)	
	private ImageView imgquestionpic1;
	
	@ViewInject(R.id.imgquestionpic2)	
	private ImageView imgquestionpic2;
	
	@ViewInject(R.id.imgquestionpic3)	
	private ImageView imgquestionpic3;
	
	@ViewInject(R.id.imgquestionpic4)	
	private ImageView imgquestionpic4;	
	
	public static final int MEDIA_TYPE_IMAGE = 1;
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;

    private Uri fileUri;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_homeworkquestions);
		ViewUtils.inject(this); //xutils必须加的
	
		setTitle("提问");
		
		initView();
	}

	private void initView()
	{
		
	}
	
	
	
	@OnClick({R.id.llayoutcamera,R.id.imgquestionpic1,R.id.imgquestionpic2,R.id.imgquestionpic3,R.id.imgquestionpic4})
	public void onLLayoutCameraClick(View v)
	{
	    // 利用系统自带的相机应用:拍照
	    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
	    int requestCode;
		switch (v.getId()) {
		
		case R.id.llayoutcamera:
			
            requestCode = 0;  
            startActivityForResult(intent, requestCode);  
			
			break;
		case R.id.imgquestionpic1:
            requestCode = 1;  
            startActivityForResult(intent, requestCode);  
			
			break;
		case R.id.imgquestionpic2:
            requestCode = 2;  
            startActivityForResult(intent, requestCode);  
			
			break;
		case R.id.imgquestionpic3:
            requestCode = 3;  
            startActivityForResult(intent, requestCode);  
			
			break;
		case R.id.imgquestionpic4:
			
            requestCode = 4;  
            startActivityForResult(intent, requestCode);  
			break;
		default:
			break;
		}
//		
//		
//
//	    startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        
		System.out.println("-----"+requestCode+"----"+resultCode+"------");
		
		Bundle extras = data.getExtras();  
        Bitmap mImageBitmap = (Bitmap) extras.get("data");  
        
        switch (requestCode) {
		case 0:
			
			break;
		case 1:
	        imgquestionpic1.setImageBitmap(mImageBitmap);  	
			break;
		case 2:
	        imgquestionpic2.setImageBitmap(mImageBitmap);  
			break;
		case 3:
	        imgquestionpic3.setImageBitmap(mImageBitmap);  
			break;
		case 4:
	        imgquestionpic4.setImageBitmap(mImageBitmap);  
			break;										
		default:
			break;
		}

	}
    @OnClick(R.id.txtbase_top_left)
    public void onBaseTopLeft(View v)
    {
        finish();
    }	
}
