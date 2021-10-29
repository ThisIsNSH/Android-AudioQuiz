package com.jahnvi.recog.activity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.jahnvi.recog.R;
import com.jahnvi.recog.model.Question;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;

public class QuizActivity extends AppCompatActivity {

    TextView number, correct, question, option1, option2, option3, option4;
    final List<Question> questions = new ArrayList<>();
    int no = 0;
    RequestQueue requestQueue;
    int cor = 0;
    private MediaPlayer mediaPlayer = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        requestQueue = Volley.newRequestQueue(this);

        number = findViewById(R.id.number);
        correct = findViewById(R.id.correct);
        question = findViewById(R.id.question);
        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        getQuestion(getIntent().getStringExtra("jj"));

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (option1.getText().equals(questions.get(no).getCorrect())) {
                    cor += 1;
                    correct.setText("Correct Answer: " + cor + "/10");
                    no += 1;
                    if (no > 9) {
                        Toast.makeText(QuizActivity.this, "Quiz Completed. Correct Answer: " + cor + "/10", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(QuizActivity.this, MainActivity.class));
                        return;
                    }
                    question.setText(questions.get(no).getQuestion());
                    option1.setText(questions.get(no).getOption1());
                    option2.setText(questions.get(no).getOption2());
                    option3.setText(questions.get(no).getOption3());
                    option4.setText(questions.get(no).getOption4());

                    playAudio(questions.get(no).getQuestion() + ". options are. " + questions.get(no).getOption1() +". " + questions.get(no).getOption2() +". " + questions.get(no).getOption3() +". or. " + questions.get(no).getOption4() );

                    number.setText("Question " + (no + 1));
                } else {
                    correct.setText("Correct Answer: " + cor + "/10");
                    no += 1;
                    if (no > 9) {
                        Toast.makeText(QuizActivity.this, "Quiz Completed. Correct Answer: " + cor + "/10", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(QuizActivity.this, MainActivity.class));
                        return;
                    }
                    question.setText(questions.get(no).getQuestion());
                    option1.setText(questions.get(no).getOption1());
                    option2.setText(questions.get(no).getOption2());
                    option3.setText(questions.get(no).getOption3());
                    option4.setText(questions.get(no).getOption4());
                    playAudio(questions.get(no).getQuestion() + ". options are. " + questions.get(no).getOption1() +". " + questions.get(no).getOption2() +". " + questions.get(no).getOption3() +". or. " + questions.get(no).getOption4() );
                    number.setText("Question " + (no + 1));
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (option2.getText().equals(questions.get(no).getCorrect())) {
                    cor += 1;
                    correct.setText("Correct Answer: " + cor + "/10");
                    no += 1;
                    if (no > 9) {
                        Toast.makeText(QuizActivity.this, "Quiz Completed. Correct Answer: " + cor + "/10", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(QuizActivity.this, MainActivity.class));
                        return;
                    }
                    question.setText(questions.get(no).getQuestion());
                    option1.setText(questions.get(no).getOption1());
                    option2.setText(questions.get(no).getOption2());
                    option3.setText(questions.get(no).getOption3());
                    option4.setText(questions.get(no).getOption4());
                    playAudio(questions.get(no).getQuestion() + ". options are. " + questions.get(no).getOption1() +". " + questions.get(no).getOption2() +". " + questions.get(no).getOption3() +". or. " + questions.get(no).getOption4() );
                    number.setText("Question " + (no + 1));
                } else {
                    correct.setText("Correct Answer: " + cor + "/10");
                    no += 1;
                    if (no > 9) {
                        Toast.makeText(QuizActivity.this, "Quiz Completed. Correct Answer: " + cor + "/10", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(QuizActivity.this, MainActivity.class));
                        return;
                    }
                    question.setText(questions.get(no).getQuestion());
                    option1.setText(questions.get(no).getOption1());
                    option2.setText(questions.get(no).getOption2());
                    option3.setText(questions.get(no).getOption3());
                    option4.setText(questions.get(no).getOption4());
                    playAudio(questions.get(no).getQuestion() + ". options are. " + questions.get(no).getOption1() +". " + questions.get(no).getOption2() +". " + questions.get(no).getOption3() +". or. " + questions.get(no).getOption4() );
                    number.setText("Question " + (no + 1));
                }

            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (option3.getText().equals(questions.get(no).getCorrect())) {
                    cor += 1;
                    correct.setText("Correct Answer: " + cor + "/10");
                    no += 1;
                    if (no > 9) {
                        Toast.makeText(QuizActivity.this, "Quiz Completed. Correct Answer: " + cor + "/10", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(QuizActivity.this, MainActivity.class));
                        return;
                    }
                    question.setText(questions.get(no).getQuestion());
                    option1.setText(questions.get(no).getOption1());
                    option2.setText(questions.get(no).getOption2());
                    option3.setText(questions.get(no).getOption3());
                    option4.setText(questions.get(no).getOption4());
                    playAudio(questions.get(no).getQuestion() + ". options are. " + questions.get(no).getOption1() +". " + questions.get(no).getOption2() +". " + questions.get(no).getOption3() +". or. " + questions.get(no).getOption4() );
                    number.setText("Question " + (no + 1));
                } else {
                    correct.setText("Correct Answer: " + cor + "/10");
                    no += 1;
                    if (no > 9) {
                        Toast.makeText(QuizActivity.this, "Quiz Completed. Correct Answer: " + cor + "/10", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(QuizActivity.this, MainActivity.class));
                        return;
                    }
                    question.setText(questions.get(no).getQuestion());
                    option1.setText(questions.get(no).getOption1());
                    option2.setText(questions.get(no).getOption2());
                    option3.setText(questions.get(no).getOption3());
                    option4.setText(questions.get(no).getOption4());
                    playAudio(questions.get(no).getQuestion() + ". options are. " + questions.get(no).getOption1() +". " + questions.get(no).getOption2() +". " + questions.get(no).getOption3() +". or. " + questions.get(no).getOption4() );
                    number.setText("Question " + (no + 1));
                }

            }
        });

        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (option4.getText().equals(questions.get(no).getCorrect())) {
                    cor += 1;
                    correct.setText("Correct Answer: " + cor + "/10");
                    no += 1;
                    if (no > 9) {
                        Toast.makeText(QuizActivity.this, "Quiz Completed. Correct Answer: " + cor + "/10", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(QuizActivity.this, MainActivity.class));
                        return;
                    }
                    question.setText(questions.get(no).getQuestion());
                    option1.setText(questions.get(no).getOption1());
                    option2.setText(questions.get(no).getOption2());
                    option3.setText(questions.get(no).getOption3());
                    option4.setText(questions.get(no).getOption4());
                    playAudio(questions.get(no).getQuestion() + ". options are. " + questions.get(no).getOption1() +". " + questions.get(no).getOption2() +". " + questions.get(no).getOption3() +". or. " + questions.get(no).getOption4() );
                    number.setText("Question " + (no + 1));
                } else {
                    correct.setText("Correct Answer: " + cor + "/10");
                    no += 1;
                    if (no > 9) {
                        Toast.makeText(QuizActivity.this, "Quiz Completed. Correct Answer: " + cor + "/10", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(QuizActivity.this, MainActivity.class));
                        return;
                    }
                    question.setText(questions.get(no).getQuestion());
                    option1.setText(questions.get(no).getOption1());
                    option2.setText(questions.get(no).getOption2());
                    option3.setText(questions.get(no).getOption3());
                    option4.setText(questions.get(no).getOption4());
                    playAudio(questions.get(no).getQuestion() + ". options are. " + questions.get(no).getOption1() +". " + questions.get(no).getOption2() +". " + questions.get(no).getOption3() +". or. " + questions.get(no).getOption4() );
                    number.setText("Question " + (no + 1));
                }

            }
        });
    }

    public void playAudio(String text) {

        OkHttpClient client = new OkHttpClient();

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"input\": {\"text\": \"" + text + "\"},\"voice\": {\"languageCode\": \"en-US\",\"ssmlGender\": \"FEMALE\"},\"audioConfig\": {\"audioEncoding\": \"MP3\",\"speakingRate\": 1}}");
        okhttp3.Request request = new okhttp3.Request.Builder()
                .url("https://texttospeech.googleapis.com/v1/text:synthesize?key=AIzaSyBO1McQTDOfXHUJ2XAvfFizazH_RM9Zf8s")
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, okhttp3.Response response) throws IOException {
                try {
                    String response1 = response.body().string();
                    JSONObject jsonObject = new JSONObject(response1);
                    System.out.println(jsonObject);

                    byte[] data = android.util.Base64.decode(jsonObject.getString("audioContent"), android.util.Base64.DEFAULT);

                    File tempMp3 = File.createTempFile("asd", "mp3", getCacheDir());
                    tempMp3.deleteOnExit();
                    FileOutputStream fos = new FileOutputStream(tempMp3);
                    fos.write(data);
                    fos.close();

                    mediaPlayer.reset();

                    FileInputStream fis = new FileInputStream(tempMp3);
                    mediaPlayer.setDataSource(fis.getFD());

                    mediaPlayer.prepare();
                    mediaPlayer.start();

                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException ex) {
                    String s = ex.toString();
                    ex.printStackTrace();
                }

            }
        });

    }

    public void getQuestion(String category) {

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, "https://opentdb.com/api.php?amount=10&encode=base64&category=" + category + "&type=multiple", null,

        new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("results");
                    System.out.println(jsonArray);

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                        JSONArray strings = (JSONArray) jsonObject.get("incorrect_answers");



                        ArrayList<String> arrayList = new ArrayList<>();

                        arrayList.add(jsonObject.getString("correct_answer"));
                        arrayList.add(strings.getString(0));
                        arrayList.add(strings.getString(1));
                        arrayList.add(strings.getString(2));


                        Collections.shuffle(arrayList);

                        questions.add(new Question(new String(Base64.getMimeDecoder().decode(jsonObject.getString("question"))), new String(Base64.getMimeDecoder().decode(jsonObject.getString("correct_answer"))), new String(Base64.getMimeDecoder().decode(arrayList.get(0))), new String(Base64.getMimeDecoder().decode(arrayList.get(1))), new String(Base64.getMimeDecoder().decode(arrayList.get(2))), new String(Base64.getMimeDecoder().decode(arrayList.get(3)))));

                    }

                    question.setText(questions.get(no).getQuestion());

                    option1.setText(questions.get(no).getOption1());
                    option2.setText(questions.get(no).getOption2());
                    option3.setText(questions.get(no).getOption3());
                    option4.setText(questions.get(no).getOption4());

                    playAudio(questions.get(no).getQuestion() + ". options are. " + questions.get(no).getOption1() +". " + questions.get(no).getOption2() +". " + questions.get(no).getOption3() +". or. " + questions.get(no).getOption4() );

                    number.setText("Question " + (no + 1));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);


    }

}
