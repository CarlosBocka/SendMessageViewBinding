package com.example.sendmessageviewbinding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sendmessageviewbinding.databinding.ActivityViewBinding;
import com.example.sendmessageviewbinding.model.data.Message;

/**
 * @author Carlos Bocka López
 * @version 1.0
 * Clase que representa una actividad de nuestra aplicación
 * <p>Incluye lo siguiente:</p>
 * <ol>
 *     <li>Métodos callback para estudiar el ciclo de vida de una actividad</li>
 *     <li>Implementación del menú de opciones también presente en la actividad principal</li>
 *     <li>Método propio initializeView() que inicializa el contenido texto de las vistas usando información recibida desde la actividad principal</li>
 * </ol>
 */
public class ViewActivity extends AppCompatActivity {
    public final static String TAG = "ViewActivity";
    private ActivityViewBinding binding;
    private Message message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Bundle bundle = getIntent().getExtras();
        message = bundle.getParcelable(Message.KEY);

        initialiceView();
    }

    /**
     * Método propio que inicializa todas las vistas o widgets de la interfaz
     */
    private void initialiceView() {
        binding.tvUserInfo.setText(getResources().getString(R.string.tvUserInfo_output, message.getSender().getName(),
                message.getSender().getSurname(), message.getSender().getDni()));
        binding.tvMessage.setText(message.getContent());
    }

    //region métodos callback ciclo de vida

    @Override
    protected void onDestroy() {  //Lo que creo en onCreate() lo destruyo en onDestroy()
        super.onDestroy();
        binding = null;
        Log.d(TAG, "ViewActivity -> onDestroy()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "ViewActivity -> onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "ViewActivity -> onStop()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "ViewActivity -> onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "ViewActivity -> onPause()");
    }

    //endregion

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        if (item.getItemId() == R.id.miMenu) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}