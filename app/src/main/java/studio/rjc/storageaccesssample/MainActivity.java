package studio.rjc.storageaccesssample;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "StorageAccessSample";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnGetExtDirs = (Button) findViewById(R.id.btnGetExtDirs);
        btnGetExtDirs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) findViewById(R.id.text);
                tv.setText(getExternalDirs(getBaseContext()));
            }
        });
    }


    private String getExternalDirs(Context context) {
        StringBuilder sb = new StringBuilder();
        File[] files;
        sb.append("context.getExternalFiles(Type):\n");
        files = context.getExternalFilesDirs(null);
        for(File f:files){
            sb.append(f.getAbsolutePath()).append("\n");
        }
        sb.append("\n\ncontext.getExternalMediaDirs()\n");
        files = context.getExternalMediaDirs();
        for(File f:files) {
            sb.append(f.getAbsolutePath()).append("\n");
        }
        return sb.toString();
    }

}
