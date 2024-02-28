package unipiloto.edu.co;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import java.util.ArrayList;
import android.widget.Button;

public class ReceiveMessageActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);


        Intent intent = getIntent();
        if (intent != null) {
            String message = intent.getStringExtra("MESSAGE_KEY");


            TextView textView = findViewById(R.id.textView1);
            textView.setText(message);
        }


        showPreviousMessages();


        Button btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para volver a MainActivity
                finish();
            }
        });
    }

    private void showPreviousMessages() {
        MainActivity mainActivity = new MainActivity();
        ArrayList<String> messageList = mainActivity.getMessageList();

        TextView previousMessagesTextView = findViewById(R.id.prueba);
        StringBuilder previousMessages = new StringBuilder();

        for (String message : messageList) {
            previousMessages.append(message).append("\n");
        }

        previousMessagesTextView.setText(previousMessages.toString());
    }
}