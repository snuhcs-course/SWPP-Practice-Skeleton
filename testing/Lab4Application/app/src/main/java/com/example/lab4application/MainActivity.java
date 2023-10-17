package com.example.lab4application;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Data Source
        NumRollDataSource numRollDataSource = new NumRollDataSource(MainActivity.this);

        // Repository
        NumRollRepository numRollRepository = new NumRollRepository(numRollDataSource);

        // Utils
        RollDiceUtils rollDiceUtils = new RollDiceUtils();
        // Use Case
        RollDiceUseCase rollDiceUseCase = new RollDiceUseCase(numRollRepository, rollDiceUtils);

        // View Model
        DiceRollViewModel diceRollViewModel = new ViewModelProvider(this).get(DiceRollViewModel.class);

        // UI elements
        MainUI mainUi = new MainUI(
                (TextView) findViewById(R.id.firstDiceTextView),
                (TextView) findViewById(R.id.secondDiceTextView),
                (TextView) findViewById(R.id.numRolledTextView),
                (TextView) findViewById(R.id.primeNumbersTextView),
                (Button) findViewById(R.id.rollButton));
        Button resetButton = (Button) findViewById(R.id.resetButton);

        // ViewModel tracks data changes
        diceRollViewModel.getUiState().observe(this, newDiceRollUiState -> {
            mainUi.updateUI(newDiceRollUiState);
        });

        // "Dice Roll" button triggers dice roll event
        mainUi.getRollButton().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diceRollViewModel.notifyRoll(rollDiceUseCase);
                diceRollViewModel.getData(rollDiceUseCase);
            }
        });

        // initialize 'NumRolled" from locally stored data
        diceRollViewModel.setNumRoll(rollDiceUseCase);

        // "Reset" button should make "# Rolled" to 0
        //// IMPLEMENT HERE ////

        ////////////////////////
    }
}