package com.example.exemplomediastore;

import java.io.File;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//setContentView(R.layout.activity_main);
		
		File dir1 = new File("/sdcard");
		File dir2 = null;
		Log.d("Teste",  "Dir 1 existe?"+dir1.exists());
		if (dir1.exists()) {
			dir2 = new File(dir1,"LivroDeAndroid");
		}
		
		Log.d("Teste",  "Dir 1 possui permissão de escrita?"+dir1.canWrite());
		
		if (dir2 != null) {
			Log.d("Teste",  "Dir 2 existe?"+dir2.exists());
			if (dir2.exists() == false) {
				boolean result = dir2.mkdirs();
				Log.d("Teste",  "Dir2 foi criado?"+result);
			}
			Log.d("Teste",  "Dir 2 já existe?"+dir2.exists());
			
			if (dir2.exists()) {
				File file = new File(dir2, "hello_camera.jpg");
				Log.d("Teste",  "Arquivo já existe?"+file.exists());
				Uri uri = Uri.fromFile(file);
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
				startActivity(intent);
				Log.d("Teste",  "Arquivo foi criado?"+file.exists());
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
