package com.ai.xswdstudent.fragment;

import com.ai.xswdstudent.R;
import com.lidroid.xutils.ViewUtils;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MsgFragment extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View view=inflater.inflate(R.layout.fragment_msg, null);
		ViewUtils.inject(this, view); //xutils����ӵ�
		return view;
	}

}
