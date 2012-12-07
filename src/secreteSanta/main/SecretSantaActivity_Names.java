package secreteSanta.main;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;

public class SecretSantaActivity_Names extends Activity implements OnClickListener, OnTouchListener{
	SecretSantaList sl = new SecretSantaList();
	String temp;
	String temp2;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.names);
	
		final Context context = this;
		
		if(super.getIntent().hasExtra("List")){
			sl = super.getIntent().getExtras().getParcelable("List");
		}
	
		View names = findViewById(R.id.NextPerson);
		View getList = findViewById(R.id.getList);
		findViewById(R.id.getList).setVisibility(View.GONE);
		
		names.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
					EditText e = (EditText) findViewById(R.id.personName);
					temp = e.getText().toString();
					e = (EditText) findViewById(R.id.partnerName);
					temp2 = e.getText().toString();
					sl.addP(temp, temp2);
					
					temp = "";
					temp2 = "";
					
					//reset fields to blank
					e = (EditText) findViewById(R.id.personName);
					e.setText(temp);
					e = (EditText) findViewById(R.id.partnerName);
					e.setText(temp2);
					
					//if list full, set next person invisible and enable continue
					
					if(sl.getPersonList().size() == (sl.getPeople()-1)){
						findViewById(R.id.NextPerson).setVisibility(View.GONE);
						findViewById(R.id.getList).setVisibility(View.VISIBLE);
					}
			}
		});
		
		getList.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				sl.generateSecretSantaList();
				Parcelable parc = (Parcelable) sl;
				Intent j = new Intent(context, SecretSantaActivity_SantaList.class);
				j.putExtra("List", parc);
				startActivity(j);	
				
			}
		});
	
	}
	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return false;
	}
}
