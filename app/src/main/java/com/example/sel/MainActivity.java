package com.example.sel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.CheckBox;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton selectedRadioButton;
    Button buttonSubmit;
    CheckBox cb1, cb2, cb3, cb4,cb5,cb6;
    private RadioButton vegBtn;
    private RadioButton nonVegBtn;
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;

    private Context mContext;
    private Activity mActivity;
    private RadioGroup mRelativeLayout;
    private ImageView mTextView;
    TextView t9;

    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t9= (TextView) findViewById(R.id.textView9);
        //t3= (TextView) findViewById(R.id.textView3);
        Intent i = getIntent();

        name=i.getStringExtra("name_key");
        //dept=i.getStringExtra("dept_key");
        t9.setText(name);
        //t3.setText(dept);
        mContext = getApplicationContext();
        // Get the activity
        mActivity = MainActivity.this;

//        // Change the action bar color
//        getSupportActionBar().setBackgroundDrawable(
//                new ColorDrawable(Color.parseColor("#FFFF0004"))
//        );
        mRelativeLayout = (RadioGroup) findViewById(R.id.r1);
        mTextView = (ImageView) findViewById(R.id.image1);
        registerForContextMenu(mTextView);

        buttonSubmit = (Button) findViewById(R.id.btnSubmit);
        //radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        cb1 = (CheckBox) findViewById(R.id.cb1);
        cb2 = (CheckBox) findViewById(R.id.cb2);
        cb3 = (CheckBox) findViewById(R.id.cb3);


        cb1.setOnClickListener(new View.OnClickListener() {
                                   public void onClick(View v) {
                                       //Creating the instance of PopupMenu
                                       PopupMenu popup = new PopupMenu(MainActivity.this, cb1);
                                       //PopupMenu popup = new PopupMenu(MainActivity.this, cb2);
                                       //Inflating the Popup using xml file
                                       popup.getMenuInflater().inflate(R.layout.activity_main3, popup.getMenu());

                                       //registering popup with OnMenuItemClickListener
                                       popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                           public boolean onMenuItemClick(MenuItem item) {
                                               Toast.makeText(MainActivity.this, "" + item.getTitle()+" item added", Toast.LENGTH_SHORT).show();
                                               return true;
                                           }
                                       });

                                       popup.show();//showing popup menu
                                   }
                               });
        vegBtn = findViewById(R.id.rb1);
        nonVegBtn = findViewById(R.id.rb2);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);

        vegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cb1.setText("Kheer           50/-");
                cb2.setText("Mix Sabji       40/-");
                cb3.setText("Paneer          10/-");
                image1.setImageResource(R.drawable.download);
                image2.setImageResource(R.drawable.pan);
                image3.setImageResource(R.drawable.veg);
            }
        });
        nonVegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cb1.setText("Mutton Curry   250/-");
                cb2.setText("Chicken Chilli   200/-");
                cb3.setText("Shahi Chicken  210/-");
                image1.setImageResource(R.drawable.images);
                image2.setImageResource(R.drawable.ck);
                image3.setImageResource(R.drawable.non);
            }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //selectedRadioButton = (RadioButton) findViewById(radioGroup.getCheckedRadioButtonId());

                //String yourVote = selectedRadioButton.getText().toString();
                String checkBoxChoices = "";
                Integer s = 0;
                Integer total=s;
                if (vegBtn.isChecked() == true) {
                    if (cb1.isChecked()) {
                        checkBoxChoices += cb1.getText().toString() + "             50\n";
                        s = s + 50;
                    } else {
                        checkBoxChoices += cb1.getText().toString() + "             \t0 \n";

                    }

                    if (cb2.isChecked()) {
                        checkBoxChoices += cb2.getText().toString() + "             40\n";
                        s = s + 40;

                    } else {
                        checkBoxChoices += cb2.getText().toString() + "             \t0\n";
                    }

                    if (cb3.isChecked()) {
                        checkBoxChoices += cb3.getText().toString() + "             10\n";
                        s = s + 10;
                    } else {
                        checkBoxChoices += cb3.getText().toString() + "             \t0\n";
                    }
                    Intent i = new Intent(MainActivity.this, Main2Activity.class);

                    Toast.makeText(MainActivity.this, "\n--- Your Order --- \n " + checkBoxChoices +
                            "\n TOTAL:" + s, Toast.LENGTH_SHORT).show();


                    i.putExtra("name_key", checkBoxChoices);

                    i.putExtra("name_total", String.valueOf(s));


                    startActivity(i);
                } else {
                    if (cb1.isChecked()) {
                        checkBoxChoices += cb1.getText().toString() + "     250\n";
                        s = s + 250;
                    } else {
                        checkBoxChoices += cb1.getText().toString() + "      \t0 \n";

                    }

                    if (cb2.isChecked()) {
                        checkBoxChoices += cb2.getText().toString() + "     200\n";
                        s = s + 200;

                    } else {
                        checkBoxChoices += cb2.getText().toString() + "      \t0\n";
                    }

                    if (cb3.isChecked()) {
                        checkBoxChoices += cb3.getText().toString() + "     210\n";
                        s = s + 210;
                    } else {
                        checkBoxChoices += cb3.getText().toString() + "       \t0\n";
                    }

                    Intent i = new Intent(MainActivity.this, Main2Activity.class);

//                    Toast.makeText(MainActivity.this, "\n--- Your Order --- \n " + checkBoxChoices +
//                            "\n TOTAL:" + s, Toast.LENGTH_SHORT).show();


                    i.putExtra("name_key", checkBoxChoices);

                    i.putExtra("name1_key", s);

                    startActivity(i);
                }


            }
        });
    }
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu, menu);
            return true;
        }

        public boolean onOptionsItemSelected(MenuItem item) {
            Toast.makeText(this, "Selected Item: " +item.getTitle(), Toast.LENGTH_SHORT).show();
            switch (item.getItemId()) {
                case R.id.search_item:
                    // do your code

                    return true;
                case R.id.rate_item:
                    // do your code

                    return true;
                case R.id.copy_item:
                    // do your code
                    Uri uri=Uri.parse("tel:9122607316");
                    Intent intent=new Intent(Intent.ACTION_DIAL,uri);
                    startActivity(intent);
                    return true;
                case R.id.print_item:
                    // do your code
                    return true;
                case R.id.share_item:
                    // do your code
                    //public void openMail(View view)
                {

                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setData(Uri.parse("email"));
                    String[] s={"kundansingh912260@gmail.com",""};
                    i.putExtra(Intent.EXTRA_EMAIL,s);
                    i.putExtra(Intent.EXTRA_SUBJECT,"Sharing a Item");
                    i.putExtra(Intent.EXTRA_TEXT,"");
                    i.setType("message/rfc822");//setting MIME Email Multipurpose Internet Mail Extensions
                    Intent chooser = Intent.createChooser(i,"Launch Email");
                    startActivity(chooser);

                }
                    return true;
                case R.id.bookmark_item:
                    // do your code
                    return true;
                default:
                    return super.onOptionsItemSelected(item);

            }
    }
    @SuppressLint("ResourceType")
    public void onCreateContextMenu(
            ContextMenu menu,
            View v,
            ContextMenu.ContextMenuInfo menuInfo
    ) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.layout.activity_main4, menu);
        menu.setHeaderTitle("Select an option");
    }
    public boolean onContextItemSelected(MenuItem item) {
        // Handle the menu item selection
        switch (item.getItemId()) {
            case R.id.red:

                //mTextView.setTextColor(Color.RED);
                Toast.makeText(mContext, "Spicy Selected", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.green:
                //mTextView.setTextColor(Color.GREEN);
                Toast.makeText(mContext, "Normal Selected", Toast.LENGTH_SHORT).show();
                return true;


            default:
                return super.onContextItemSelected(item);
        }
    };
}

