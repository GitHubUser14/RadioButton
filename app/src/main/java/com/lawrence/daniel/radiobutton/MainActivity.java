package com.lawrence.daniel.radiobutton;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String[] choices = {
            "Yes",
            "No",
            "Maybe"
    };

    private static final String[] parties = {
            "Republican",
            "Democratic",
            "Independent"
    };

    private TextView selection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        selection = (TextView) findViewById(R.id.selection);

        final RadioButton radioButton[] = {
                (RadioButton) findViewById(R.id.yes_radio),
                (RadioButton) findViewById(R.id.no_radio),
                (RadioButton) findViewById(R.id.maybe_radio)
        };

        radioButton[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((RadioButton) v).isChecked()) {
                    selection.setText("You selected:\nYes");
                }
            }
        });

        radioButton[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((RadioButton) v).isChecked()) {
                    selection.setText("You selected:\nNo");
                }
            }
        });

        radioButton[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((RadioButton) v).isChecked()) {
                    selection.setText("You selected:\nMaybe");
                }
            }
        });

        Spinner spinnerChoices = (Spinner) findViewById(R.id.choice_spinner);
        Spinner spinnerParties = (Spinner) findViewById(R.id.political_party_spinner);

        ArrayAdapter<String> mAdapter = new
                ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, choices);
        mAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerChoices.setAdapter(mAdapter);

        ArrayAdapter<String> partyAdapter = new
                ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, parties);
        partyAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinnerParties.setAdapter(partyAdapter);
    }
}
