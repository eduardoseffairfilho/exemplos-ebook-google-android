package com.example.exemplomediastore;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;

public class MainActivity extends Activity {

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
}
