package secreteSanta.main;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class SecretSantaActivity extends Activity implements OnClickListener {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // cick-handler for Welcome button
        View welcome_button = findViewById(R.id.Welcome);
		welcome_button.setOnClickListener(this);
		welcome_button.getBackground().setColorFilter(0xFF00FF00, PorterDuff.Mode.MULTIPLY);
		
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        
        
    }

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.Welcome:
			Intent i = new Intent(this, SecretSantaActivity_Select.class);
			startActivity(i);
			break;
		}
	}
}