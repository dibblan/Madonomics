package nu.douhan.madonomics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SkuldkvotActivity extends AppCompatActivity {

    private EditText edtSkuldkvotIncome,edtSkuldkvotTotalDebt;
    private Button btnSkuldkvotSubmit;
    private TextView txtSkuldkvotResultPercent,txtSkuldkvotResultKvot,txtSkuldkvotExplanation,txtSkuldkvotExplanation02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skuldkvot);

        edtSkuldkvotIncome = (EditText) findViewById(R.id.edtSkuldkvotIncome);
        edtSkuldkvotTotalDebt = (EditText) findViewById(R.id.edtSkuldkvotTotalDebt);
        btnSkuldkvotSubmit = (Button) findViewById(R.id.btnSkuldkvotSubmit);
        txtSkuldkvotResultPercent = (TextView) findViewById(R.id.txtSkuldkvotResultPercent);
        txtSkuldkvotResultKvot = (TextView) findViewById(R.id.txtSkuldkvotResultKvot);
        txtSkuldkvotExplanation = (TextView) findViewById(R.id.txtSkuldkvotExplanation);
        txtSkuldkvotExplanation02 = (TextView) findViewById(R.id.txtSkuldkvotExplanation02);


        btnSkuldkvotSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                try {
                    String SkuldkvotIncome = edtSkuldkvotIncome.getText().toString().trim();
                    String SkuldkvotTotalDebt = edtSkuldkvotTotalDebt.getText().toString().trim();
                    double a = Double.parseDouble(SkuldkvotIncome);
                    double b = Double.parseDouble(SkuldkvotTotalDebt);

                    double sumKvot = b / (a*12);
                    double sumPercent = sumKvot * 100;

                    txtSkuldkvotResultPercent.setText(getString(R.string.txtSkuldkvotResultText) + " " + String.format("%.0f", sumPercent) +  "%");
                    txtSkuldkvotResultKvot.setText(getString(R.string.txtSkuldkvotResultKvotText) + " " +  String.format("%.2f", sumKvot) );
                    txtSkuldkvotExplanation.setText(getString(R.string.txtSkuldkvotExplanationText));
                    txtSkuldkvotExplanation02.setText(getString(R.string.txtSkuldkvotExplanationText02));

                } catch (Exception e) {

                }

            }


        });
    }
}
