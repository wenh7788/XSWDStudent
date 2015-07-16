package com.ai.xswdstudent.city;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ai.xswdstudent.R;
import com.ai.xswdstudent.city.MyLetterListView.OnTouchingLetterChangedListener;
import com.ai.xswdstudent.db.DBManager;

/**
 * �����б�
 * 
 * @author sy
 * 
 */
public class CityList extends Activity
{
	private BaseAdapter adapter;
	private EditText city;
	private ListView mCityLit;
	private TextView overlay;
	private MyLetterListView letterListView;
	private HashMap<String, Integer> alphaIndexer;// ��Ŵ��ڵĺ���ƴ������ĸ����֮��Ӧ���б�λ��
	private String[] sections;// ��Ŵ��ڵĺ���ƴ������ĸ
	private Handler handler;
	private OverlayThread overlayThread;
	private SQLiteDatabase database;
	private ArrayList<CityModel> mCityNames;
	
	private String citys;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.city_list);

		mCityLit = (ListView) findViewById(R.id.city_list);
		city = (EditText) findViewById(R.id.et_city);
		letterListView = (MyLetterListView) findViewById(R.id.cityLetterListView);
		DBManager dbManager = new DBManager(this);
		dbManager.openDateBase();
		dbManager.closeDatabase();
		database = SQLiteDatabase.openOrCreateDatabase(DBManager.DB_PATH + "/" + DBManager.DB_NAME, null);
		mCityNames = getCityNames();
		database.close();
		letterListView.setOnTouchingLetterChangedListener(new LetterListViewListener());
		alphaIndexer = new HashMap<String, Integer>();
		handler = new Handler();
		overlayThread = new OverlayThread();
		initOverlay();
		setAdapter(mCityNames);
		mCityLit.setOnItemClickListener(new CityListOnItemClick());

	}
	
	

	/**
	 * �����ݿ��ȡ��������
	 * 
	 * @return
	 */
	private ArrayList<CityModel> getCityNames()
	{
		ArrayList<CityModel> names = new ArrayList<CityModel>();
		Cursor cursor = database.rawQuery("SELECT * FROM T_City ORDER BY NameSort", null);
		for (int i = 0; i < cursor.getCount(); i++)
		{
			cursor.moveToPosition(i);
			CityModel cityModel = new CityModel();
			cityModel.setCityName(cursor.getString(cursor.getColumnIndex("CityName")));
			cityModel.setNameSort(cursor.getString(cursor.getColumnIndex("NameSort")));
			names.add(cityModel);
		}
		return names;
	}

	/**
	 * �����б����¼�
	 * 
	 * @author sy
	 * 
	 */
	class CityListOnItemClick implements OnItemClickListener
	{

		@Override
		public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long arg3)
		{
			CityModel cityModel = (CityModel) mCityLit.getAdapter().getItem(pos);
			Toast.makeText(CityList.this, cityModel.getCityName(), Toast.LENGTH_SHORT).show();
			citys=cityModel.getCityName();
			city.setText(citys);
			
		}

	}

	/**
	 * ΪListView����������
	 * 
	 * @param list
	 */
	private void setAdapter(List<CityModel> list)
	{
		if (list != null)
		{
			adapter = new ListAdapter(this, list);
			mCityLit.setAdapter(adapter);
		}

	}

	/**
	 * ListViewAdapter
	 * 
	 * @author sy
	 * 
	 */
	private class ListAdapter extends BaseAdapter
	{
		private LayoutInflater inflater;
		private List<CityModel> list;

		public ListAdapter(Context context, List<CityModel> list)
		{

			this.inflater = LayoutInflater.from(context);
			this.list = list;
			alphaIndexer = new HashMap<String, Integer>();
			sections = new String[list.size()];

			for (int i = 0; i < list.size(); i++)
			{
				// ��ǰ����ƴ������ĸ
				// getAlpha(list.get(i));
				String currentStr = list.get(i).getNameSort();
				// ��һ������ƴ������ĸ�����������Ϊ�� ��
				String previewStr = (i - 1) >= 0 ? list.get(i - 1).getNameSort() : " ";
				if (!previewStr.equals(currentStr))
				{
					String name = list.get(i).getNameSort();
					alphaIndexer.put(name, i);
					sections[i] = name;
				}
			}

		}

		@Override
		public int getCount()
		{
			return list.size();
		}

		@Override
		public Object getItem(int position)
		{
			return list.get(position);
		}

		@Override
		public long getItemId(int position)
		{
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent)
		{
			ViewHolder holder;
			if (convertView == null)
			{
				convertView = inflater.inflate(R.layout.list_item, null);
				
				holder = new ViewHolder();
				holder.alpha = (TextView) convertView.findViewById(R.id.alpha);
				holder.name = (TextView) convertView.findViewById(R.id.name);
				
				convertView.setTag(holder);
			} else
			{
				holder = (ViewHolder) convertView.getTag();
			}

			holder.name.setText(list.get(position).getCityName());
			String currentStr = list.get(position).getNameSort();
			String previewStr = (position - 1) >= 0 ? list.get(position - 1).getNameSort() : " ";
			if (!previewStr.equals(currentStr))
			{
				holder.alpha.setVisibility(View.VISIBLE);
				holder.alpha.setText(currentStr);
			} else
			{
				holder.alpha.setVisibility(View.GONE);
			}
			return convertView;
		}

		private class ViewHolder
		{
			TextView alpha;
			TextView name;
			
			
		}

	}

	// ��ʼ������ƴ������ĸ������ʾ��
	private void initOverlay()
	{
		LayoutInflater inflater = LayoutInflater.from(this);
		overlay = (TextView) inflater.inflate(R.layout.overlay, null);
		overlay.setVisibility(View.INVISIBLE);
		WindowManager.LayoutParams lp = new WindowManager.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT,
				WindowManager.LayoutParams.TYPE_APPLICATION, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
				PixelFormat.TRANSLUCENT);
		WindowManager windowManager = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
		windowManager.addView(overlay, lp);
	}

	private class LetterListViewListener implements OnTouchingLetterChangedListener
	{

		@Override
		public void onTouchingLetterChanged(final String s)
		{
			if (alphaIndexer.get(s) != null)
			{
				int position = alphaIndexer.get(s);
				mCityLit.setSelection(position);
				overlay.setText(sections[position]);
				overlay.setVisibility(View.VISIBLE);
				handler.removeCallbacks(overlayThread);
				// �ӳ�һ���ִ�У���overlayΪ���ɼ�
				handler.postDelayed(overlayThread, 1500);
			}
		}

	}

	// ����overlay���ɼ�
	private class OverlayThread implements Runnable
	{

		@Override
		public void run()
		{
			overlay.setVisibility(View.GONE);
		}

	}

}