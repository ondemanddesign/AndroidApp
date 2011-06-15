package com.AndroidApp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.ToggleButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class AndroidApp 
extends Activity 
{
	public String toggleText;
	public ToggleButton myToggle1;
	public TextView LEDState;
	public SeekBar ledBrightness;
    /** Called when the activity is first created. */
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        LEDState = (TextView) this.findViewById(R.id.LED_State);
        ledBrightness = (SeekBar) this.findViewById(R.id.ledBrightness1);
        ledBrightness.setMax(255);
        myToggle1 = (ToggleButton) this.findViewById(R.id.toggleButton1);
        myToggle1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	checkToggle();
            }
        });
        ledBrightness.setOnSeekBarChangeListener(new OnSeekBarChangeListener(){
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				seekChange();
			}

			public void onStartTrackingTouch(SeekBar seekBar) {
				
			}

			public void onStopTrackingTouch(SeekBar seekBar) {
				
			}
        });
    }
    public void checkToggle(){
    	toggleText = (myToggle1.isChecked()) ? "checked" : "not checked";
    }
    public void seekChange(){
    	Log.v("Slider", "" + ledBrightness.getProgress());
    }
}