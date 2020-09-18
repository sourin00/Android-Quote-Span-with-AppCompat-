package com.example.quotespanusingparcel

import android.os.Bundle
import android.os.Parcel
import android.text.SpannableString
import android.text.Spanned
import android.text.style.QuoteSpan
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ************************ Kotlin CODE **********************
        val parcel = Parcel.obtain()
        parcel.writeInt(getColor(R.color.colorAccent)) // quote span stripe color .. adjust this as per your liking
        parcel.writeInt(10) // quote span stripe width .. adjust this as per your liking
        parcel.writeInt(10) // quote span gap with .. adjust this as per your liking
        parcel.setDataPosition(0)
        val string = SpannableString(getString(R.string.top_review))
        val quoteSpan = QuoteSpan(parcel)
        string.setSpan(quoteSpan, 0, string.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        findViewById<TextView>(R.id.quoteSpan).text = string
        parcel.recycle() // put the parcel object back in the pool

        // ************************ Use Alternative JAVA CODE **********************
        /*Parcel parcel = Parcel.obtain();
        parcel.writeInt(getColor(R.color.colorAccent)); // quote span stripe color .. adjust this as per your liking
        parcel.writeInt(10); // quote span stripe width .. adjust this as per your liking
        parcel.writeInt(10); // quote span gap with .. adjust this as per your liking
        parcel.setDataPosition(0);
        SpannableString string = new SpannableString(getString(R.string.top_review));
        QuoteSpan quoteSpan = new QuoteSpan(parcel);
        string.setSpan(quoteSpan, 0, string.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ((TextView) findViewById(R.id.quoteSpan)).setText(string);
        parcel.recycle();*/
    }
}