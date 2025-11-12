package ro.pub.cs.systems.eim.practicaltest01var08;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PracticalTest01Var08MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button play;
    private EditText riddle;
    private EditText answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_main);

        play = findViewById(R.id.play_button);
        riddle = findViewById(R.id.riddle);
        answer = findViewById(R.id.answer);

        play.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        int riddleContent = riddle.getText().length();
        int answerContent = answer.getText().length();

        if (riddleContent > 0 && answerContent > 0) {
            Intent intent = new Intent(PracticalTest01Var08MainActivity.this, PracticalTest01Var08PlayActivity.class);
            intent.putExtra(Constants.RIDDLE, riddle.getText().toString());
            intent.putExtra(Constants.ANSWER, answer.getText().toString());
            startActivityForResult(intent, 1);


        }
    }
}