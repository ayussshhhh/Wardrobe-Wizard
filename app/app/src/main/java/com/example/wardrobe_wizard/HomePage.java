//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.wardrobe_wizard;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.wardrobe_wizard.R.id;
import com.example.wardrobe_wizard.R.layout;

public class HomePage extends AppCompatActivity {
    public static final String NAME = "NAME";
    private TextView nameText;
    private String name;

    public HomePage() {
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(layout.activity_home_page);
        this.nameText = (TextView)this.findViewById(id.welcome_text);
        Intent i = this.getIntent();
        this.name = i.getStringExtra("NAME");
        this.nameText.setText(String.format("Welcome! %s", this.name));
    }
}
