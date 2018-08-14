package my.edu.utem.guessnumber;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int computerNum, guessNumber, count;
    EditText number;
    TextView answer;
    Button guessButton, resetButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = findViewById(R.id.number_editText);
        answer = findViewById(R.id.answer_textView);
        guessButton = findViewById(R.id.guess_button);
        resetButton = findViewById(R.id.reset_button);
        initialize();

    }

    public void guess(View view) {
        if(number.getText().toString().equals("")){
            Toast.makeText(MainActivity.this, "Please enter your answer.",Toast.LENGTH_LONG).show();
        }

        else {
            guessNumber = Integer.parseInt(number.getText().toString());
            if (guessNumber == computerNum) {
                answer.setText("Congratulation!!!");
            } else if (guessNumber < computerNum) {
                count--;
                Toast.makeText(MainActivity.this, "The Number is Too Low", Toast.LENGTH_LONG).show();
                number.getText().clear();
                if (count != 0) {
                    answer.setText("You have " + count + " more chances");
                } else {
                    gameOver();
                }
            } else {
                count--;
                Toast.makeText(MainActivity.this, "The Number is Too High", Toast.LENGTH_LONG).show();
                number.getText().clear();
                if (count != 0) {
                    answer.setText("You have " + count + " more chances");
                } else {
                    gameOver();
                }
            }
        }
    }

    private void gameOver() {
        answer.setText("The answer is " + computerNum);
        guessButton.setVisibility(View.GONE);
        resetButton.setVisibility(View.VISIBLE);
    }

    public void reset(View view) {
        initialize();
    }

    private void initialize(){
        count = 3;
        computerNum = (int)(Math.random() * 100);
        guessButton.setVisibility(View.VISIBLE);
        resetButton.setVisibility(View.GONE);
        answer.setText("Good Luck!!!");
    }
}
