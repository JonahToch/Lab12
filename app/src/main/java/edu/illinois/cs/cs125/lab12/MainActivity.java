package edu.illinois.cs.cs125.lab12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import java.io.*;

/**
 * Main class for our UI design lab.
 */
public final class MainActivity extends AppCompatActivity {
    /**
     * Default logging tag for messages from the main activity.
     */
    private static final String TAG = "MP7";

    /**
     * Request queue for our API requests.
     */
    private static RequestQueue requestQueue;

    /**
     * Run when this activity comes to the foreground.
     *
     * @param savedInstanceState unused
     */
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set up the queue for our API requests
        requestQueue = Volley.newRequestQueue(this);

        setContentView(R.layout.activity_main);
        try {
            startAPICall();
        } catch (FileNotFoundException e) {
            ;
        }

        final Button startAPICall = findViewById(R.id.answerC);
        startAPICall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "Grab the JSON and store it");
            }
        });

        final TextView chooseQuestion = findViewById(R.id.question);
        JsonParser parser = new JsonParser();
        // JsonObject results = parser.parse("triviatext").getAsJsonObject();
        // JsonArray questions = results.getAsJsonArray("question");
        // String questionString = questions.get(0).getAsJsonObject().getAsString();


        final Button chooseAnswerA = findViewById(R.id.answerA);
        startAPICall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "Answer A selected");
            }
        });
        final Button chooseAnswerB = findViewById(R.id.answerB);
        startAPICall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "Answer B selected");
            }
        });

        final Button chooseAnswerD = findViewById(R.id.answerD);
        startAPICall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Log.d(TAG, "Answer D selected");
            }
        });
    }

    /**
     * Run when this activity is no longer visible.
     */
    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     * Make a call to the weather API.
     * @throws FileNotFoundException lol
     */
    void startAPICall() throws FileNotFoundException {
        JsonParser parser = new JsonParser();
        JsonObject triviaTextArray = (JsonObject) parser.parse(new FileReader("C:\\Users\\Brand2ss\\Downloads"));
        JsonObject triviaResults = triviaTextArray.getAsJsonArray("results").get(0).getAsJsonObject();
        JsonObject triviaQuestion = triviaResults.getAsJsonObject("question");
        String question = triviaQuestion.getAsString();

        setContentView(R.layout.activity_main);
        final TextView helloTextView = (TextView) findViewById(R.id.question);
        helloTextView.setText(question);
    }
}
