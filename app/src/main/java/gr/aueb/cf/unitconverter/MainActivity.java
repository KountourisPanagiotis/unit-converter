package gr.aueb.cf.unitconverter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The MainActivity class represents the main activity of the Unit Converter application.
 * It allows the user to convert kilograms to pounds.
 *
 * @Author Kountouris Panagiotis
 */
public class MainActivity extends AppCompatActivity {
    private Button button1;
    private EditText inputET;
    private TextView outputTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        inputET = findViewById(R.id.inputET);
        outputTV = findViewById(R.id.outputTV);
        outputTV.setVisibility(View.INVISIBLE);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kilograms = inputET.getText().toString().trim();
                double pounds;
                String message = "Please enter a valid value";
                final double KILOGRAMS_TO_POUNDS_RATIO = 2.20462;

                // Regular Expression για να σιγουρεψουμε πως ο χρήστης θα δώσει :
                // χαρακτήρες ψηφία από το 0 μέχρι το 9 , (+) μία η περισσότερες φορές
                // δεν μπορεί να δώσει αρνητικές τιμές διότι δεν έχουμε βάλει το (-)
                if(kilograms.isEmpty() || !kilograms.matches("[0-9.]+")) {
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                }else{
                    pounds = Double.parseDouble(kilograms) * KILOGRAMS_TO_POUNDS_RATIO;
                    outputTV.setText(String.valueOf(pounds));
                    outputTV.setVisibility(View.VISIBLE); // Εμφανίζουμε το textView με το αποτέλεσμα
                }
            }
        });
    }
}