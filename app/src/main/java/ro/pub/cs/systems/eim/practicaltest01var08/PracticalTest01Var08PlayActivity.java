package ro.pub.cs.systems.eim.practicaltest01var08;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PracticalTest01Var08PlayActivity extends AppCompatActivity {

    Button check;
    Button back;
    TextView riddle;
    EditText answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_play);

        EdgeToEdge.enable(this);
        check = findViewById(R.id.check_button);
        back = findViewById(R.id.back_button);
        riddle = findViewById(R.id.riddle);
        answer = findViewById(R.id.user_answer);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey(Constants.RIDDLE) && intent.getExtras().containsKey(Constants.ANSWER)) {
            String riddleText = intent.getStringExtra(Constants.RIDDLE);
            riddle.setText(riddleText);

            if (check != null) {
                check.setOnClickListener(view -> {
                    String userAnswer = answer.getText().toString();
                    String correctAnswer = intent.getStringExtra(Constants.ANSWER);
                    if (userAnswer.equals(correctAnswer)) {
                        setResult(RESULT_OK, null);
                        Log.println(Log.INFO, "ANSWER", "Correct answer");
                    } else {
                        setResult(RESULT_CANCELED, null);
                        Log.println(Log.INFO, "ANSWER", "Incorrect answer");
                    }
                    finish();
                });
            }
        }

        if (back != null) {
            back.setOnClickListener(view -> {
                finish();
            });


        }
    }
}