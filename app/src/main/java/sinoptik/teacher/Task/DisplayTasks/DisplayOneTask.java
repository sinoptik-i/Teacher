package sinoptik.teacher.Task.DisplayTasks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.widget.TextView;

import sinoptik.teacher.R;
import sinoptik.teacher.Task.BasicTasks.Equation2_ab;

public class DisplayOneTask extends AppCompatActivity {
    String TAG ="DisplayOneTask";

  //  WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_one_task);


       // webView = findViewById(R.id.webView);
        // включаем поддержку JavaScript
       // webView.getSettings().setJavaScriptEnabled(true);
        // указываем страницу загрузки
        Equation2_ab equation2_ab=new Equation2_ab();
        String eq= "<meta charset=\"utf-8\"><html><body><p>";
        //String eq= "";
        eq+=equation2_ab.getTask();
        eq+="</p></body></html>";
        Log.e(TAG," "+ eq);

        //String htmlAsString = eq;

        Spanned htmlAsSpanned = Html.fromHtml(eq); // used by TextView

        TextView textView = findViewById(R.id.textView);
        textView.setText(htmlAsSpanned);




//        webView.loadUrl(eq);
    }
}
