package com.easylights;

import java.io.IOException;

import com.hoho.android.usbserial.driver.UsbSerialDriver;
import com.hoho.android.usbserial.driver.UsbSerialProber;

import android.hardware.usb.UsbManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static Boolean[] arrButtons = {false, false, false};
	private static final int leftBtn = 0;
	private static final int rightBtn = 1;
	private static final int stopBtn = 2;
	private static UsbManager manager;
	private static UsbSerialDriver driver;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = (UsbManager) getSystemService(Context.USB_SERVICE);
        driver = UsbSerialProber.acquire(manager);
        if (driver != null) {
        	try {
        		driver.open();
            	driver.setBaudRate(57600);
        	}        	
        	catch(IOException e) {
        		Toast.makeText(this, "Error opening serial driver", Toast.LENGTH_LONG).show();
        	}
        	
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    public void Left_btnHandler(View view) {
    	arrButtons[leftBtn] = !arrButtons[leftBtn];  
    	Toast.makeText(this, "Left_btnHandler", Toast.LENGTH_SHORT).show();
		while (arrButtons[leftBtn]) {
			
		}
    }
    
    public void Right_btnHandler(View view) {
    	arrButtons[rightBtn] = !arrButtons[rightBtn];
    	Toast.makeText(this, "Right_btnHandler", Toast.LENGTH_SHORT).show();
		while (arrButtons[leftBtn]) {
			
		}
    }
    
    public void Stop_btnHandler(View view) {
    	arrButtons[stopBtn] = !arrButtons[stopBtn];
    	Toast.makeText(this, "Stop_btnHandler", Toast.LENGTH_SHORT).show();
    	byte buffer[] = new byte[49];    	
    	try {
			driver.write(buffer, 1000);
		} catch (IOException e) {
			Toast.makeText(this, "Error writing serial data", Toast.LENGTH_LONG).show();
		}
    }    
}
