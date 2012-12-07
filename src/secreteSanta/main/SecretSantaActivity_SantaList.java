package secreteSanta.main;

import java.util.ArrayList;
import java.util.Iterator;
//import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.database.DataSetObserver;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.AdapterView;
import android.widget.TextView;
//import android.widget.Toast;

public class SecretSantaActivity_SantaList extends Activity implements OnClickListener, OnTouchListener{

	Spinner spinner;
	ArrayList<ListObj> person = new ArrayList<ListObj>();
	SecretSantaList sl = null;
	String temp;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.santa_list);
		
		if(super.getIntent().hasExtra("List")){
			sl = super.getIntent().getExtras().getParcelable("List");
		}
	
		Iterator it = sl.getPersonList().iterator();
		
		while(it.hasNext()){
			person.add((ListObj) it.next());
		}
		
		final Context context = this;
		
		spinner = (Spinner) findViewById(R.id.nameSpinner);
		MyAdapter adapter = new MyAdapter(person);
		
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
				ListObj l = (ListObj) parent.getItemAtPosition(pos);
				//Toast.makeText(getApplicationContext(), l.getShop_for(), Toast.LENGTH_LONG).show();
				temp = l.getShop_for();
				EditText e = (EditText) findViewById(R.id.ShopFor);
				char[] temp2 = temp.toCharArray();
				e.setText(temp2, 0, temp2.length);
				
			}
			
			public void onNothingSelected(AdapterView parent){
				// do nothing
			}
		});
	}
	
	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	
	private class MyAdapter implements SpinnerAdapter{

        /**
         * The internal data (the ArrayList with the Objects).
         */
        ArrayList<ListObj> data;

        public MyAdapter(ArrayList<ListObj> data){
            this.data = data;
        }

        /**
         * Returns the Size of the ArrayList
         */
        @Override
        public int getCount() {
            return data.size();
        }

        /**
         * Returns one Element of the ArrayList
         * at the specified position.
         */
        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getItemViewType(int position) {
            return android.R.layout.simple_spinner_dropdown_item;
        }

        /**
         * Returns the View that is shown when a element was
         * selected.
         */
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView v = new TextView(getApplicationContext());
            v.setTextColor(Color.BLACK);
            v.setText(data.get(position).getPerson());
            return v;
        }

        @Override
        public int getViewTypeCount() {
            return 1;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public void registerDataSetObserver(DataSetObserver observer) {
            // TODO Auto-generated method stub

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver observer) {
            // TODO Auto-generated method stub

        }

        /**
         * The Views which are shown in when the arrow is clicked
         * (In this case, I used the same as for the "getView"-method.
         */
        @Override
        public View getDropDownView(int position, View convertView,
                ViewGroup parent) {
            return this.getView(position, convertView, parent);
        }

    }


}


