package unipiloto.edu.co;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends Activity {

    private ArrayList<String> messageList = new ArrayList<>();
    private static final String PREF_NAME = "MessagePreferences";
    private static final String MESSAGE_SET_KEY = "messageSet";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onSendMessage(View view){
        EditText editText = findViewById(R.id.editText);
        String message = editText.getText().toString();
        messageList.add(message);

        Intent intent = new Intent(this, ReceiveMessageActivity.class);
        intent.putExtra("MESSAGE_KEY", message);
        startActivity(intent);
    }
    public ArrayList<String> getMessageList() {
        return messageList;
    }

    private void saveMessageList() {
        SharedPreferences preferences = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        Set<String> messageSet = new HashSet<>(messageList);
        editor.putStringSet(MESSAGE_SET_KEY, messageSet);

        editor.apply();
    }
}