package com.example.exemplohelloworld;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	private EditText edtNome;
	private TextView lblSaudacaoResultado;
	private String saudacao;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		this.edtNome = (EditText) findViewById(R.id.edtNome);
		this.lblSaudacaoResultado = (TextView) findViewById(R.id.lblSaudacaoResultado);
		this.saudacao = getResources().getString(R.string.saudacao);
	}
	
	public void surpreenderUsuario(View v) {
		Editable texto = this.edtNome.getText();
		String textoSaudacao = this.saudacao + " " + texto + "!";
		this.lblSaudacaoResultado.setText(textoSaudacao);
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
