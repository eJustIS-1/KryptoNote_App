package ca.yorku.eecs.kryptonote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class KryptoNoteActivity extends AppCompatActivity
{
    CipherModel cp;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_krypto_note);
    }





//    try{
        public void onEncrypt (View v){
            EditText keyView = (EditText) findViewById(R.id.inputKey);
            String key = keyView.getText().toString();

            EditText dataView = (EditText) findViewById(R.id.inputData);
            String data = dataView.getText().toString();

            try{
            cp = new CipherModel(key);
            String s=cp.encrypt(data);
            ((EditText) findViewById(R.id.inputData)).setText(s);
            }catch (Exception e){
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
    }
        public void onDecrypt (View v){
            EditText keyView = (EditText) findViewById(R.id.inputKey);
            String key = keyView.getText().toString();

            EditText dataView = (EditText) findViewById(R.id.inputData);
            String data = dataView.getText().toString();

            try
            {
                cp = new CipherModel(key);
                String s = cp.decrypt(data);
                ((EditText) findViewById(R.id.inputData)).setText(s);
            }catch (Exception e){
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
    }
        public void onSave (View v){

            try
            {
                String name = ((EditText) findViewById(R.id.inputFName)).getText().toString();
                File dir = this.getFilesDir();
                File file = new File(dir, name);
                FileWriter fw = new FileWriter(file);
                fw.write(((EditText) findViewById(R.id.inputData)).getText().toString());
                fw.close();
                Toast.makeText(this, "Note Saved", Toast.LENGTH_LONG).show();

            }
            catch (Exception e){
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }

        }
        public void onLoad (View v){


            try
            {
                String name = ((EditText) findViewById(R.id.inputFName)).getText().toString();
                File dir = this.getFilesDir();
                File file = new File(dir, name);
                FileReader fr = new FileReader(file);
                String show ="";
                for(int c = fr.read(); c != -1; c= fr.read()){
                    show += (char) c;
                }
                fr.close();
                ((EditText) findViewById(R.id.inputData)).setText(show);
            } catch (Exception e)
            {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }




        }
//    }catch (Exception e){
//
//    Toast label = Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT);
//    label.show();
//}


//    try
//    {
//
//    }

}
