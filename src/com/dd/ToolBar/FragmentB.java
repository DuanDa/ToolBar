package com.dd.ToolBar;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentB extends Fragment {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.fragment_b, null);
		return root;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);

		MyActivity activity = (MyActivity) getActivity();
		//activity.getToolbar().setNavigationIcon(R.drawable.back_arrow);
		//activity.getToolbar().setNavigationOnClickListener(new View.OnClickListener() {
		//	@Override
		//	public void onClick(View v) {
		//		System.out.println("---> hehehe");
		//	}
		//});
	}
}
