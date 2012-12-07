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

public class SecretSantaActivity_Select extends Activity implements OnClickListener, OnTouchListener{

	SecretSantaList sl = new SecretSantaList();
	int i = 1;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select);
	
		final Context context = this;
	
		View n = findViewById(R.id.enter_number_continue);
		
		n.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View v) {
	
				EditText e = (EditText) findViewById(R.id.number_of_people);
				i = Integer.parseInt(e.getText().toString());
				sl = new SecretSantaList(i);
				
				Parcelable parc = (Parcelable) sl;
				Intent j = new Intent(context, SecretSantaActivity_Names.class);
				j.putExtra("List", parc);
				startActivity(j);	
			}
			
		});
	
	}

	
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean onTouch(View arg0, MotionEvent arg1) {
		// TODO Auto-generated method stub
		return false;
	}

}

