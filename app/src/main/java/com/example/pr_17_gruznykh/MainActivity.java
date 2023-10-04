package com.example.pr_17_gruznykh;
import static androidx.core.content.ContextCompat.getSystemService;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText animalNameEditText;
    private EditText nameEditText;
    private EditText sizeEditText;
    private EditText weightEditText;
    private Button button;
    private SQLiteDatabase db;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация элементов интерфейса
        animalNameEditText = findViewById(R.id.editTextTextPersonName2);
        nameEditText = findViewById(R.id.editTextTextPersonName3);
        sizeEditText = findViewById(R.id.editTextTextPersonName5);
        weightEditText = findViewById(R.id.editTextTextPersonName4);
        button = findViewById(R.id.button);

        // Установка обработчика нажатия на кнопку
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Получение текста из полей ввода
                String animalName = animalNameEditText.getText().toString();
                String name = nameEditText.getText().toString();
                String size = sizeEditText.getText().toString();
                String weight = weightEditText.getText().toString();

                // Дальнейшая обработка данных, например, вывод на экран
                String result = "Animal: " + animalName + "\nName: " + name + "\nSize: " + size + "\nWeight: " + weight;
                TextView resultTextView = findViewById(R.id.textView);
                resultTextView.setText(result);
            }
        });

        // Создание базы данных и таблицы
        db = openOrCreateDatabase("mydatabase", MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS mytable (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, email TEXT)");
    }
}