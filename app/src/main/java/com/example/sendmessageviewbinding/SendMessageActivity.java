package com.example.sendmessageviewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.example.sendmessageviewbinding.databinding.ActivitySendMessageBinding;
import com.example.sendmessageviewbinding.model.data.Message;
import com.example.sendmessageviewbinding.model.data.Person;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/**
 * @author Carlos Bocka López
 * @version 1.0
 * Clase que representa la actividad principal de nuestra aplicación
 * <p>Incluye lo siguiente:</p>
 * <ol>
 *     <li>Métodos callback para estudiar el ciclo de vida de una actividad</li>
 *     <li>Implementación de un menú de opciones presente en el fichero main_menu.xml</li>
 *     <li>Método propio sendMessage() que envía un mensaje a otra actividad mediante un intent explícito</li>
 * </ol>
 */
public class SendMessageActivity extends AppCompatActivity {

    private ActivitySendMessageBinding binding;
    public final static String TAG = "SendMessageActivity";

    //region métodos callback ciclo de vida

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySendMessageBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        binding.fab.setOnClickListener(v -> {
            sendMessage();
        }
        );

        Log.d(TAG, "SendMessageActivity -> onCreate()");
    }

    @Override
    protected void onDestroy() {  //Lo que creo en onCreate() lo destruyo en onDestroy()
        super.onDestroy();
        binding = null;
        Log.d(TAG, "SendMessageActivity -> onDestroy()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "SendMessageActivity -> onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "SendMessageActivity -> onStop()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "SendMessageActivity -> onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "SendMessageActivity -> onPause()");
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

    /**
     * Método propio que envía un mensaje
     */
    public void sendMessage() {
        Intent intent = new Intent(this, ViewActivity.class);
        Bundle bundle = new Bundle();

        Person personE = new Person("Carlos", "Bocka López", "74895567F");
        Person personD = new Person("Jennifer", "Lawrence", "67543409G");

        Message message = new Message(1, binding.edMessage.getText().toString(), personE, personD);

        bundle.putParcelable(Message.KEY, message);

        intent.putExtras(bundle);
        startActivity(intent);
    }
}
